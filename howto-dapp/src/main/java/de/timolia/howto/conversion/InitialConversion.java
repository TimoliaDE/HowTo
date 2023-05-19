package de.timolia.howto.conversion;

import de.timolia.howto.Dapp;
import de.timolia.howto.conversion.models.TeamlerRankChange;
import de.timolia.howto.conversion.models.TeamlerResponsibilities;
import de.timolia.howto.models.Rank;
import de.timolia.howto.models.Sex;
import de.timolia.howto.models.Teamler;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InitialConversion {
    public static void convert() throws IOException, ParseException {

        List<Teamler> teamlers = new ArrayList<>();
        List<TeamlerRankChange> teamlerRankChanges = JsonBuilder.getTeamlerRankChanges();


        teamlerRankChanges.stream().map(TeamlerRankChange::getUuid).sorted().distinct().forEach(uuid -> {
            List<TeamlerRankChange> changes = teamlerRankChanges.stream().filter(teamlerRankChange -> teamlerRankChange.getUuid().equals(uuid)).collect(Collectors.toList());

            LinkedHashMap<String, Rank> rankHistory = new LinkedHashMap<>();
            for (TeamlerRankChange teamlerRankChange : changes) {
                if (rankHistory.isEmpty()) {
                    rankHistory.put("initial", teamlerRankChange.getRankFrom());
                }
                rankHistory.put(teamlerRankChange.getReadableDate(), teamlerRankChange.getRankTo());
            }

            Teamler teamler = new Teamler(uuid, Sex.undefined, null, null, null, rankHistory);
            teamlers.add(teamler);
        });

        List<TeamlerResponsibilities> teamlerResponsibilitiesList = JsonBuilder.getTeamlerResponsibilities();
        teamlerResponsibilitiesList.forEach(teamlerResponsibilities -> {
            Teamler teamler = teamlers.stream().filter(teamler1 -> teamler1.getUuid().equals(teamlerResponsibilities.getUuid())).findFirst().orElse(null);

            if (teamler == null) {
                teamler = new Teamler(teamlerResponsibilities.getUuid(), Sex.undefined, null, null, null, null);
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


        System.out.println(Dapp.gson.toJson(teamlers));

    }
}
