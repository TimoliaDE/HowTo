package de.timolia.howto.generator;

import de.timolia.howto.models.Rank;
import de.timolia.howto.models.Teamler;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageTeamMembers {
    public static String generate(List<Teamler> teamlers) {
        teamlers = teamlers.stream().filter(teamler -> teamler.getRankCurrent().isInTeam()).collect(Collectors.toList());
        teamlers.sort(Teamler::compare);
        List<Rank> ranks = Arrays.stream(Rank.values()).filter(rank -> rank.getDescription() != null).sorted(Rank::compare).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("%page.members.first-1%").append(teamlers.size()).append("%page.members.first-2%\n");
        List<String> rankStrings = ranks.stream().map(rank -> "<span class='" + rank.getCssClass() + "'>" + rank.getMale() + "</span>").collect(Collectors.toList());
        for (int i = 0; i < rankStrings.size(); i++) {
            sb.append(rankStrings.get(i));
            if (i < rankStrings.size() - 2) {
                sb.append(", ");
            } else if (i == rankStrings.size() - 2) {
                sb.append(" %and% ");
            }
        }
        sb
                .append("%page.members.first-3%")
                .append("\n")
                .append("\n").append("%page.members.first-4%")
                .append("\n")
                .append("\n").append("![%page.members.first-5%](img/content-ranks.png)");

        for (Rank rank : ranks) {
            sb
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n").append("## ").append(rank.getMale())
                    .append("\n")
                    .append("\n").append(rank.getDescription())
                    .append("\n");

            for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.getRankCurrent().equals(rank)).collect(Collectors.toList())) {

                Validate.isTrue(teamler.getResponsibilitiesMain() == null || !teamler.getResponsibilitiesMain().contains(null), "Der Spieler '" + teamler.getName() + "' hat eine leere responsibilities_main, Komma zu viel?");
                Validate.isTrue(teamler.getResponsibilitiesMainHidden() == null || !teamler.getResponsibilitiesMainHidden().contains(null), "Der Spieler '" + teamler.getName() + "' hat eine leere responsibilities_main_hidden, Komma zu viel?");
                Validate.isTrue(teamler.getResponsibilitiesSecondary() == null || !teamler.getResponsibilitiesSecondary().contains(null), "Der Spieler '" + teamler.getName() + "' hat eine leere responsibilities_secondary, Komma zu viel?");
                Validate.isTrue(teamler.getResponsibilitiesSecondaryHidden() == null || !teamler.getResponsibilitiesSecondaryHidden().contains(null), "Der Spieler '" + teamler.getName() + "' hat eine leere responsibilities_secondary_hidden, Komma zu viel?");
                Validate.isTrue(teamler.getFields() == null || !teamler.getFields().contains(null), "Der Spieler '" + teamler.getName() + "' hat eine leere fields, Komma zu viel?");

                sb
                        .append("\n")
                        .append("\n")
                        .append("### <strong><span class='").append(rank.getCssClass()).append("'>").append(teamler.getNameForMarkdown()).append("</span></strong>")
                        .append("\n").append("- <u>%page.members.rank-ingame%:</u> ").append(rank.getString(teamler.getSex()));
                if (teamler.getResponsibilitiesMain() != null) {
                    sb
                            .append("\n")
                            .append("- <u>%page.members.hv%:</u> ").append(teamler.getResponsibilitiesMain().stream().sorted(String::compareToIgnoreCase).collect(Collectors.joining(", ")));
                }
                if (teamler.getResponsibilitiesSecondary() != null) {
                    sb
                            .append("\n")
                            .append("- <u>%page.members.nv%:</u> ").append(teamler.getResponsibilitiesSecondary().stream().sorted(String::compareToIgnoreCase).collect(Collectors.joining(", ")));
                }
                if (teamler.getFields() != null){
                    sb
                            .append("\n")
                            .append("- <u>%page.members.fields%:</u> ").append(teamler.getFields().stream().sorted(String::compareToIgnoreCase).collect(Collectors.joining(", ")));
                }
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
