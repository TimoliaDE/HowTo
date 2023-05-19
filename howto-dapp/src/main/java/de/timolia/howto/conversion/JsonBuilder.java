package de.timolia.howto.conversion;

import de.timolia.howto.conversion.models.TeamlerRankChange;
import de.timolia.howto.conversion.models.TeamlerResponsibilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class JsonBuilder {

    public static List<TeamlerRankChange> getTeamlerRankChanges() throws IOException, ParseException {
        String content = Files.readString(Path.of("src/main/resources", "changes.md"), StandardCharsets.UTF_8);
        content = Pattern.compile("^([^|]|\\| ------|\\| Spieler).*$", Pattern.MULTILINE).matcher(content).replaceAll("");
        content = Pattern.compile("(\r\n)+", Pattern.MULTILINE).matcher(content).replaceAll("\n");
        content = Pattern.compile("[ \t]*\\|[ \t]*", Pattern.MULTILINE).matcher(content).replaceAll("|");
        content = Pattern.compile("</span>", Pattern.MULTILINE).matcher(content).replaceAll("");
        content = Pattern.compile("<span class='[\\w-]+'>", Pattern.MULTILINE).matcher(content).replaceAll("");

        List<TeamlerRankChange> teamlerRankChanges = new ArrayList<>();
        String[] lines = content.split("\n");
        for (int i = lines.length - 1; i >= 0; i--) {
            String line = lines[i];

            if (line.isEmpty()) {
                continue;
            }

            String[] split = line.split("\\|");
            String name = split[1].replaceAll("\\\\", "");
            String rankFrom = split[2];
            String rankTo = split[3];
            String date = split[4];

            TeamlerRankChange teamlerRankChange = new TeamlerRankChange(name, rankFrom, rankTo, date);
            teamlerRankChanges.add(teamlerRankChange);
            System.out.println(teamlerRankChange);
        }

        return teamlerRankChanges;
    }

    public static List<TeamlerResponsibilities> getTeamlerResponsibilities() throws IOException {
        String content = Files.readString(Path.of("src/main/resources", "members.md"), StandardCharsets.UTF_8);
        content = Pattern.compile("^(?!-|###).*$", Pattern.MULTILINE).matcher(content).replaceAll("");
        content = Pattern.compile("^- <u>Rang \\(ingame\\):.*$", Pattern.MULTILINE).matcher(content).replaceAll("");
        content = Pattern.compile("(\r\n)+", Pattern.MULTILINE).matcher(content).replaceAll("\n");

        List<TeamlerResponsibilities> teamlerResponsibilitiesList = new ArrayList<>();
        for (String s : content.split("###")) {
            if (s.isEmpty() || (!s.contains("Hauptverantwortlich") && !s.contains("Nebenverantwortlich"))) continue;

            s = s.substring(s.indexOf("'") + 1);
            s = s.substring(s.indexOf("'") + 2);

            String name = s.substring(0, s.indexOf("<")).replaceAll("\\\\_", "_");
            String hv = null;
            String nv = null;

            s = s.substring(s.indexOf("-"));

            if (s.contains("Hauptverantwortlich")) {
                hv = s.substring(s.indexOf("Hauptverantwortlich") + "Hauptverantwortlich".length() + 6, s.indexOf("\n"));
                s = s.substring(s.indexOf("Hauptverantwortlich") + "Hauptverantwortlich\n".length() + 6 + hv.length());
            }
            if (s.contains("Nebenverantwortlich")) {
                nv = s.substring(s.indexOf("Nebenverantwortlich") + "Nebenverantwortlich".length() + 6, s.indexOf("\n"));
            }

            System.out.println("name: " + name);
            System.out.println("hv:   " + hv);
            System.out.println("nv:   " + nv);

            TeamlerResponsibilities teamlerResponsibilities = new TeamlerResponsibilities(name, hv, nv);
            teamlerResponsibilitiesList.add(teamlerResponsibilities);
        }

        return teamlerResponsibilitiesList;
    }

}
