package de.timolia.howto.conversion.models;

import de.timolia.howto.conversion.RankConversion;
import de.timolia.howto.conversion.SQLApi;
import de.timolia.howto.models.Rank;
import org.apache.commons.lang3.Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TeamlerRankChange {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private final String name;
    private final UUID uuid;
    private final Rank rankFrom;
    private final Rank rankTo;
    private final Date date;
    private final transient boolean hidden;

    public TeamlerRankChange(String name, String rankFrom, String rankTo, String date) throws ParseException {
        this.name = name;
        this.uuid = SQLApi.getUuid(name);
        this.rankFrom = RankConversion.getRank(rankFrom);
        this.rankTo = RankConversion.getRank(rankTo);
        this.date = simpleDateFormat.parse(date);
        this.hidden = false;

        Validate.notNull(this.rankFrom, "Der Rang von '" + name + "' ('" + rankFrom + "') existiert nicht");
        Validate.notNull(this.rankTo, "Der Rang von '" + name + "' ('" + rankTo + "') existiert nicht");
    }

    public TeamlerRankChange(String name, UUID uuid, Rank rankFrom, Rank rankTo, String date, boolean hidden) {
        this.name = SQLApi.getName(uuid, name);
        this.uuid = uuid;
        this.rankFrom = rankFrom;
        this.rankTo = rankTo;
        this.date = toDate(date);
        this.hidden = hidden;

        Validate.notNull(this.rankFrom, "Der Rang von '" + name + "' existiert nicht");
        Validate.notNull(this.rankTo, "Der Rang von '" + name + "' existiert nicht");
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

    public Rank getRankFrom() {
        return rankFrom;
    }

    public Rank getRankTo() {
        return rankTo;
    }

    public Date getDate() {
        return date;
    }

    public boolean isHidden() {
        return hidden;
    }

    public String getReadableDate() {
        return simpleDateFormat.format(date);
    }

    public static String toString(Date date) {
        if (date.equals(new Date(0))) {
            return "initial";
        }
        return simpleDateFormat.format(date);
    }

    public static Date toDate(String date) {
        if (date.equals("initial")) {
            return new Date(0);
        }

        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "TeamlerRankChange{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", rankFrom='" + rankFrom + '\'' +
                ", rankTo='" + rankTo + '\'' +
                ", date=" + simpleDateFormat.format(date) +
                '}';
    }

}
