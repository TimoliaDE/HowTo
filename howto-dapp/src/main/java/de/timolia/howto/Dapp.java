package de.timolia.howto;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.timolia.howto.conversion.JsonBuilder;
import de.timolia.howto.conversion.models.TeamlerRankChange;
import de.timolia.howto.conversion.models.TeamlerResponsibilities;
import de.timolia.howto.generator.PageRankChange;
import de.timolia.howto.generator.PageResponsibilities;
import de.timolia.howto.generator.PageTeamMembers;
import de.timolia.howto.models.Language;
import de.timolia.howto.models.Rank;
import de.timolia.howto.models.Sex;
import de.timolia.howto.models.Teamler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Dapp { // D. Application

    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public static boolean isDevEnv = false;
    public static String MYSQL_USER = null;
    public static String MYSQL_PASS = null;
    public static String MYSQL_CON_STR = null;

    public static void main(String[] args) {

        if (System.getenv("MYSQL_USER_LIVE") != null) {
            // live
            MYSQL_USER = System.getenv("MYSQL_USER_LIVE");
            MYSQL_PASS = System.getenv("MYSQL_PASS_LIVE");
            MYSQL_CON_STR = System.getenv("MYSQL_CON_STR_LIVE");
        } else {
            // dev
            isDevEnv = true;
            MYSQL_USER = System.getenv("MYSQL_USER_DEV");
            MYSQL_PASS = System.getenv("MYSQL_PASS_DEV");
            MYSQL_CON_STR = System.getenv("MYSQL_CON_STR_DEV");
        }


        try {

            String json = Files.readString(Path.of("docs", "team", "teamler.json"), Charset.defaultCharset());
            Teamler[] teamlers = gson.fromJson(json, Teamler[].class);
            List<Teamler> teamlerList = Arrays.asList(teamlers);

//            for(Teamler teamler : teamlerList) {
//                String name = SQLApi.getName(teamler.getUuid());
//                if(!name.equals(teamler.getName())) {
//                    System.out.println("!!! " + teamler.getName() + " -> " + name);
//                }
//            }

            String changesMD = PageRankChange.generate(teamlerList);
            String membersMD = PageTeamMembers.generate(teamlerList);
            String responsibilitiesMD = PageResponsibilities.generate(teamlerList);

            writeFile(Path.of("docs", "team", "changes.de.md"), LanguageUtil.translate(Language.DE, changesMD));
            writeFile(Path.of("docs", "team", "members.de.md"), LanguageUtil.translate(Language.DE, membersMD));
            writeFile(Path.of("docs", "team", "responsibilities.de.md"), LanguageUtil.translate(Language.DE, responsibilitiesMD));

            writeFile(Path.of("docs", "team", "changes.en.md"), LanguageUtil.translate(Language.EN, changesMD));
            writeFile(Path.of("docs", "team", "members.en.md"), LanguageUtil.translate(Language.EN, membersMD));
            writeFile(Path.of("docs", "team", "responsibilities.en.md"), LanguageUtil.translate(Language.EN, responsibilitiesMD));

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // used for initial conversion only
        //convert();


        System.exit(0);
    }

    private static void writeFile(Path path, String text) throws IOException {
        path.toFile().getParentFile().mkdirs();
        Files.writeString(path, text, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        System.out.println("Wrote file '" + path.toString() + "'");
    }

    private static void convert() throws IOException, ParseException {

        List<Teamler> teamlers = new ArrayList<>();
        List<TeamlerRankChange> teamlerRankChanges = JsonBuilder.getTeamlerRankChanges();


        teamlerRankChanges.stream().map(TeamlerRankChange::getUuid).sorted().distinct().forEach(uuid -> {
            List<TeamlerRankChange> changes = teamlerRankChanges.stream().filter(teamlerRankChange -> teamlerRankChange.getUuid().equals(uuid)).collect(Collectors.toList());

            HashMap<String, Rank> rankHistory = new HashMap<>();
            for (TeamlerRankChange teamlerRankChange : changes) {
                if (rankHistory.isEmpty()) {
                    rankHistory.put("initial", teamlerRankChange.getRankFrom());
                }
                rankHistory.put(teamlerRankChange.getReadableDate(), teamlerRankChange.getRankTo());
            }

            Teamler teamler = new Teamler(uuid, Sex.undefined, null, null, rankHistory);
            teamlers.add(teamler);
        });

        List<TeamlerResponsibilities> teamlerResponsibilitiesList = JsonBuilder.getTeamlerResponsibilities();
        teamlerResponsibilitiesList.forEach(teamlerResponsibilities -> {
            Teamler teamler = teamlers.stream().filter(teamler1 -> teamler1.getUuid().equals(teamlerResponsibilities.getUuid())).findFirst().orElse(null);

            if (teamler == null) {
                teamler = new Teamler(teamlerResponsibilities.getUuid(), Sex.undefined, null, null, null);
            }

            System.out.println("teamler: " + teamler);
            if (teamlerResponsibilities.getHv() != null) {
                System.out.println("teamlerResponsibilities.getHv(): " + teamlerResponsibilities.getHv());
                teamler.setResponsibilitiesMain(Arrays.asList(teamlerResponsibilities.getHv().split(", ")));
            }
            if (teamlerResponsibilities.getNv() != null) {
                teamler.setResponsibilitiesSecondary(Arrays.asList(teamlerResponsibilities.getNv().split(", ")));
            }
        });


        System.out.println(gson.toJson(teamlers));

    }

}
