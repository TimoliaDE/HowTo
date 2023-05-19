package de.timolia.howto.generator;

import de.timolia.howto.Dapp;
import de.timolia.howto.responsibility.Responsibility;
import de.timolia.howto.responsibility.ResponsibilityType;
import de.timolia.howto.translate.Language;
import de.timolia.howto.models.Teamler;
import de.timolia.howto.translate.Translate;
import de.timolia.howto.translate.TranslationContext;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageResponsibilities {
    public static String generate(List<Teamler> teamlers) {
        LinkedHashMap<String, LinkedHashMap<String, String>> responsibilities = new LinkedHashMap<>() {{
            put("%page.responsibilities.project-team-orga%", new LinkedHashMap<>() {{
                put("%page.responsibilities.teamleader%", "%page.responsibilities.teamleader.desc%");
                put("%page.responsibilities.project-team-orga.apply.builder%", null);
                put("%page.responsibilities.project-team-orga.apply.development%", null);
                put("%page.responsibilities.project-team-orga.apply.support%", "%page.responsibilities.project-team-orga.apply.support.desc%");
                put("%page.responsibilities.project-team-orga.howto%", "%page.responsibilities.project-team-orga.howto.desc%");
                put("%page.responsibilities.project-team-orga.tournament%", "%page.responsibilities.project-team-orga.tournament.desc%");
                //put("%page.responsibilities.project-team-orga.uhc%", "%page.responsibilities.project-team-orga.uhc.desc%");
                put("%page.responsibilities.project-team-orga.youtuber%", "%page.responsibilities.project-team-orga.youtuber.desc%");
            }});
            put("%page.responsibilities.communication-platforms%", new LinkedHashMap<>() {{
                put("%page.responsibilities.communication-platforms.community-discord%", "%page.responsibilities.communication-platforms.community-discord.desc%");
                //put("%page.responsibilities.communication-platforms.bug-reports%", null);
                put("%page.responsibilities.communication-platforms.appeal%", null);
                put("%page.responsibilities.communication-platforms.falsely-banned%", null);
                put("%page.responsibilities.communication-platforms.socialmedia%", "%page.responsibilities.communication-platforms.socialmedia.desc%");
                put("%page.responsibilities.communication-platforms.teamspeak%", "%page.responsibilities.communication-platforms.teamspeak.desc%");
            }});
            put("%page.responsibilities.other-responsibilities%", new LinkedHashMap<>() {{
                put("%page.responsibilities.other-responsibilities.graphicdesign%", null);
                put("%page.responsibilities.other-responsibilities.map-submissions%", null);
                put("%page.responsibilities.other-responsibilities.monthly-winner%", null);
                //put("%page.responsibilities.other-responsibilities.translation%", null);
            }});
        }};

        StringBuilder sb = new StringBuilder();
        sb.append("%page.responsibilities.info%");

        for (Map.Entry<String, LinkedHashMap<String, String>> categories : responsibilities.entrySet()) {
            String categoryName = categories.getKey();
            LinkedHashMap<String, String> subcategories = categories.getValue();
            sb
                    .append("\n")
                    .append("\n").append("# ").append(categoryName);

            TranslationContext nameConverter = Dapp.translate.forLanguage(Language.DE);
            for (Map.Entry<String, String> e : subcategories.entrySet()) {
                String name = nameConverter.replaceAll(e.getKey());
                String description = e.getValue();
                sb
                        .append("\n")
                        .append("\n").append("### **").append(name).append("**");
                if (description != null) {
                    sb.append("\n").append(description).append("\n");
                }

                List<Teamler> hv = teamlers.stream()
                        .filter(teamler -> teamler.hasResponsibilityMain(name))
                        .sorted(Teamler::compare)
                        .collect(Collectors.toList());
                List<Teamler> nv = teamlers.stream()
                        .filter(teamler -> teamler.hasResponsibilitySecondary(name))
                        .sorted(Teamler::compare)
                        .collect(Collectors.toList());

                String titleCustom = null;

                LinkedList<Responsibility> hvCustom = new LinkedList<>();
                LinkedList<Responsibility> nvCustom = new LinkedList<>();

                // custom stuff
                switch (e.getKey()) {
                    case "%page.responsibilities.bug-reports%":
                        nvCustom.add(Responsibility.simple(ResponsibilityType.NV, "%page.responsibilities.custom.bug-reports.modsanddevs%"));
                        break;
                    case "%page.responsibilities.sm%":
                        titleCustom = "Projekte u. Verantwortungsgrad";
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Twitter")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter.hv%"));
                        }
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilitySecondary("Twitter")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter.nv%"));
                        }
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Bauteam-Twitter")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter-builder.hv%"));
                        }
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilitySecondary("Bauteam-Twitter")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter-builder.nv%"));
                        }
                        break;
                    case "%page.responsibilities.teamleader%":
                        titleCustom = "%page.responsibilities.custom.teamleader.title%";
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Management des Timolia-Teams")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.whole-team%"));
                        }
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Management des Bau-Teams")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.builder%"));
                        }
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Management des Content-Teams")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.content%"));
                        }
                        for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Management des Development-Teams")).sorted(Teamler::compare).collect(Collectors.toList())) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.development%"));
                        }
                        break;
                    case "%page.responsibilities.yter%":
                        titleCustom = "%page.responsibilities.custom.yter.title%";
                        break;
                }
                if (titleCustom == null) {
                    sb.append("\n").append("| %page.responsibilities.teamler% | %page.responsibilities.responsib% |");
                } else {
                    sb.append("\n").append("| %page.responsibilities.teamler% | ").append(titleCustom).append(" |");
                }
                sb.append("\n").append("| ------ | ------ |");
                if (hvCustom.isEmpty()) {
                    for (Teamler teamler : hv) {
                        hvCustom.add(Responsibility.concreteTeamster(ResponsibilityType.HV, teamler));
                    }
                }
                for (Responsibility hvEntry : hvCustom) {
                    sb.append("\n");
                    hvEntry.renderTo(sb);
                }
                if (!nv.isEmpty() || !nvCustom.isEmpty()) {
                    sb.append("\n").append("| | |");
                    if (nvCustom.isEmpty()) {
                        for (Teamler teamler : nv) {
                            hvCustom.add(Responsibility.concreteTeamster(ResponsibilityType.NV, teamler));
                        }
                    }
                    for (Responsibility nvEntry : nvCustom) {
                        sb.append("\n");
                        nvEntry.renderTo(sb);
                    }
                }
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
