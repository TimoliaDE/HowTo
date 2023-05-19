package de.timolia.howto.generator;

import de.timolia.howto.conversion.models.TeamlerRankChange;
import de.timolia.howto.models.Teamler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class PageRankChange {
    public static String generate(List<Teamler> teamlers) {
        ArrayList<TeamlerRankChange> rankChanges = new ArrayList<>();
        for (Teamler teamler : teamlers) {
            rankChanges.addAll(teamler.getRankChanges(false));
        }

        rankChanges.sort((t1, t2) -> {
            if (!t1.getDate().equals(t2.getDate())) {
                return t2.getDate().compareTo(t1.getDate());
            }
            if (!t1.getRankTo().equals(t2.getRankTo())) {
                Teamler teamler1 = teamlers.stream().filter(t -> t.getUuid().equals(t1.getUuid())).findFirst().orElse(null);
                Teamler teamler2 = teamlers.stream().filter(t -> t.getUuid().equals(t2.getUuid())).findFirst().orElse(null);
                return t1.getRankTo().getString(teamler1.getSex()).compareToIgnoreCase(t2.getRankTo().getString(teamler2.getSex()));
            }
            return t1.getName().compareToIgnoreCase(t2.getName());
        });

        StringBuilder sb = new StringBuilder();
        sb
                .append("%page.rank-change.first%")
                .append("\n")
                .append("\n");

        String lastYear = "";
        String lastMonth = "";
        for (TeamlerRankChange teamlerRankChange : rankChanges) {
            Teamler teamler = teamlers.stream().filter(t -> t.getUuid().equals(teamlerRankChange.getUuid())).findFirst().orElse(null);

            Calendar cal = Calendar.getInstance();
            cal.setTime(teamlerRankChange.getDate());
            String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMAN) + " " + cal.get(Calendar.YEAR);
            String year = String.valueOf(cal.get(Calendar.YEAR));

            if (!year.equals(lastYear)) {
                lastYear = year;
                sb.append("\n").append("\n").append("# ").append(year).append("\n");
            }
            if (!month.equals(lastMonth)) {
                lastMonth = month;
                sb.append("\n");
                sb.append("###  <strong>").append(month).append("</strong>").append("\n");
                sb.append("| %player% | %page.rank-change.rank-previous% | %page.rank-change.rank-new% | %date% |").append("\n");
                sb.append("| ------ | ------ | ------ | ------ |").append("\n");
            }

            sb
                    .append("| ")
                    .append(teamlerRankChange.getNameForMarkdown())
                    .append(" | ")
                    .append("<span class='").append(teamlerRankChange.getRankFrom().getCssClass()).append("'>").append(teamlerRankChange.getRankFrom().getString(teamler.getSex())).append("</span>")
                    .append(" | ")
                    .append("<span class='").append(teamlerRankChange.getRankTo().getCssClass()).append("'>").append(teamlerRankChange.getRankTo().getString(teamler.getSex())).append("</span>")
                    .append(" | ")
                    .append(teamlerRankChange.getReadableDate())
                    .append(" |")
                    .append("\n");
        }

        sb.append("\n");

        return sb.toString();
    }
}
