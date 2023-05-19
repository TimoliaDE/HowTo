package de.timolia.howto.models;

import de.timolia.howto.conversion.SQLApi;
import de.timolia.howto.conversion.models.TeamlerRankChange;
import org.apache.commons.lang3.Validate;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teamler {

    private String name;
    private final UUID uuid;
    private final Sex sex;
    private List<String> responsibilitiesMain;
    private final List<String> responsibilitiesMainHidden;
    private List<String> responsibilitiesSecondary;
    private final List<String> responsibilitiesSecondaryHidden;
    private final List<String> fields;
    private final LinkedHashMap<String, Rank> rankHistory;
    private transient Rank rankCurrent = null;

    public Teamler(UUID uuid, Sex sex, List<String> responsibilitiesMain, List<String> responsibilitiesSecondary, List<String> fields, LinkedHashMap<String, Rank> rankHistory) {
        this.name = SQLApi.getName(uuid);
        this.uuid = uuid;
        this.sex = sex;
        this.responsibilitiesMain = responsibilitiesMain;
        this.responsibilitiesMainHidden = null;
        this.responsibilitiesSecondary = responsibilitiesSecondary;
        this.responsibilitiesSecondaryHidden = null;
        this.fields = fields;
        this.rankHistory = rankHistory;
    }

    public String getName() {
        return name;
    }

    public String getNameForMarkdown() {
        return name.replaceAll("_", "\\\\_");
    }

    public UUID getUuid() {
        return uuid;
    }

    public Sex getSex() {
        return sex;
    }

    public List<String> getResponsibilitiesMain() {
        return responsibilitiesMain;
    }

    public void setResponsibilitiesMain(List<String> responsibilitiesMain) {
        this.responsibilitiesMain = responsibilitiesMain;
    }

    public List<String> getResponsibilitiesMainHidden() {
        return responsibilitiesMainHidden;
    }

    public List<String> getResponsibilitiesSecondary() {
        return responsibilitiesSecondary;
    }

    public void setResponsibilitiesSecondary(List<String> responsibilitiesSecondary) {
        this.responsibilitiesSecondary = responsibilitiesSecondary;
    }

    public List<String> getResponsibilitiesSecondaryHidden() {
        return responsibilitiesSecondaryHidden;
    }

    public List<String> getFields() {
        return fields;
    }

    public HashMap<String, Rank> getRankHistory() {
        return rankHistory;
    }

    public List<TeamlerRankChange> getRankChanges(boolean includeHidden) {
        List<TeamlerRankChange> rankChanges = new ArrayList<>();
        if (rankHistory == null || rankHistory.isEmpty()) {
            return rankChanges;
        }

        for (int i = 0; i < rankHistory.size(); i++) {
            Rank rank = (Rank) rankHistory.values().toArray()[i];
            Validate.notNull(rank, "Der " + (i + 1) + ". Rang von '" + name + "' existiert nicht");
        }

        List<Date> dates = rankHistory.keySet().stream().map(s -> s.replace("hidden-", "")).map(TeamlerRankChange::toDate).sorted().collect(Collectors.toList());
        for (int i = Math.min(1, dates.size() - 1); i < dates.size(); i++) {
            boolean hidden = false;
            String rankOldKey = TeamlerRankChange.toString(dates.get(Math.max(i - 1, 0)));
            if (!rankHistory.containsKey(rankOldKey) && rankHistory.containsKey("hidden-" + rankOldKey)) {
                rankOldKey = "hidden-" + rankOldKey;
            }
            Rank rank_old = rankHistory.get(rankOldKey);

            String rankNewKey = TeamlerRankChange.toString(dates.get(i));
            if (!rankHistory.containsKey(rankNewKey) && rankHistory.containsKey("hidden-" + rankNewKey)) {
                rankNewKey = "hidden-" + rankNewKey;
                hidden = true;
            }
            Rank rank_new = rankHistory.get(rankNewKey);
            if (includeHidden || !hidden && !rankNewKey.equals("initial")) {
                TeamlerRankChange teamlerRankChange = new TeamlerRankChange(name, uuid, rank_old, rank_new, TeamlerRankChange.toString(dates.get(i)), hidden);
                rankChanges.add(teamlerRankChange);
            }
        }
        return rankChanges;
    }

    public Rank getRankCurrent() {
        if (rankCurrent == null) {
            List<TeamlerRankChange> teamlerRankChanges = getRankChanges(true);
            TeamlerRankChange lastRankChange = teamlerRankChanges.get(teamlerRankChanges.size() - 1);
            rankCurrent = lastRankChange.getRankTo();
        }
        return rankCurrent;
    }

    public int compare(Teamler o) {
        if (!this.getRankCurrent().equals(o.getRankCurrent())) {
            // compare by rank
            return this.getRankCurrent().compare(o.getRankCurrent());
        }

        // compare by name
        String rules = "< '_'";
        try {
            RuleBasedCollator ruleBasedCollator = new RuleBasedCollator(rules);
            return ruleBasedCollator.compare(this.getName().toLowerCase(), o.getName().toLowerCase());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public boolean hasResponsibilityMain(String responsibility) {
        return hasResponsibility(responsibility, Stream.concat(responsibilitiesMain == null ? Stream.empty() : responsibilitiesMain.stream(), responsibilitiesMainHidden == null ? Stream.empty() : responsibilitiesMainHidden.stream()).collect(Collectors.toList()));
    }

    public boolean hasResponsibilitySecondary(String responsibility) {
        return hasResponsibility(responsibility, Stream.concat(responsibilitiesSecondary == null ? Stream.empty() : responsibilitiesSecondary.stream(), responsibilitiesSecondaryHidden == null ? Stream.empty() : responsibilitiesSecondaryHidden.stream()).collect(Collectors.toList()));
    }

    private boolean hasResponsibility(String responsibility, List<String> responsibilityList) {
        if (!getRankCurrent().isInTeam() && !responsibilityList.isEmpty()) {
            throw new RuntimeException("'" + name + "' has responsibilities but is not in team anymore");
        }

        return responsibilityList != null && (responsibilityList.contains(responsibility) || responsibilityList.contains(responsibility + " Forum"));
    }

    public void updateName() {
        this.name = SQLApi.getName(uuid, name);
    }

    @Override
    public String toString() {
        return "Teamler{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", sex=" + sex +
                ", responsibilitiesMain=" + responsibilitiesMain +
                ", responsibilitiesSecondary=" + responsibilitiesSecondary +
                ", rankHistory=" + rankHistory +
                '}';
    }
}
