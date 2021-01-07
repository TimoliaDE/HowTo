package de.timolia.howto.generator;

import de.timolia.howto.LanguageUtil;
import de.timolia.howto.Utils;
import de.timolia.howto.models.Language;
import de.timolia.howto.models.Teamler;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageResponsibilities {

    public static String generate(List<Teamler> teamlers) {

        LinkedHashMap<String, LinkedHashMap<String, String>> responsibilities = new LinkedHashMap<>() {{
            put("%page.responsibilities.forum%", new LinkedHashMap<>() {{
                put("%page.responsibilities.forum.forumorganisation%", "%page.responsibilities.forum.forumorganisation.desc%");
                put("%page.responsibilities.forum.anregvorschl%", null);
                put("%page.responsibilities.forum.qa%", null);
                put("%page.responsibilities.forum.feedback%", null);
                put("%page.responsibilities.forum.maps%", null);
                put("%page.responsibilities.forum.player-reports%", null);
                put("%page.responsibilities.forum.bug-reports%", null);
                put("%page.responsibilities.forum.ea%", null);
                put("%page.responsibilities.forum.zug%", null);
            }});
            put("%page.responsibilities.sa%", new LinkedHashMap<>() {{
                put("%page.responsibilities.ac%", "%page.responsibilities.ac.desc%");
                put("%page.responsibilities.bugs%", "%page.responsibilities.bugs.desc%");
                put("%page.responsibilities.baufehler%", "%page.responsibilities.baufehler.desc%");
                put("%page.responsibilities.supporterauswahl%", "%page.responsibilities.supporterauswahl.desc%");
                put("%page.responsibilities.howto%", "%page.responsibilities.howto.desc%");
                put("%page.responsibilities.sm%", "%page.responsibilities.sm.desc%");
                put("%page.responsibilities.ts%", "%page.responsibilities.ts.desc%");
                put("%page.responsibilities.cd%", "%page.responsibilities.cd.desc%");
                put("%page.responsibilities.turnier%", "%page.responsibilities.turnier.desc%");
                put("%page.responsibilities.broadcasts%", "%page.responsibilities.broadcasts.desc%");
                put("%page.responsibilities.teamleader%", "%page.responsibilities.teamleader.desc%");
                put("%page.responsibilities.yter%", "%page.responsibilities.yter.desc%");
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

            for (Map.Entry<String, String> e : subcategories.entrySet()) {
                String name = LanguageUtil.translate(Language.DE, e.getKey());
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

                LinkedList<Utils.KeyValuePair<String, String>> hvCustom = new LinkedList<>();
                LinkedList<Utils.KeyValuePair<String, String>> nvCustom = new LinkedList<>();

                // custom stuff
                if (e.getKey().equals("%page.responsibilities.forum.bug-reports%")) {
                    nvCustom.add(new Utils.KeyValuePair<>("%page.responsibilities.custom.bug-reports.modsanddevs%", null));
                } else if (e.getKey().equals("%page.responsibilities.sm%")) {
                    titleCustom = "Projekte u. Verantwortungsgrad";
                    for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("%page.responsibilities.custom.sm.twitter%")).sorted(Teamler::compare).collect(Collectors.toList())) {
                        nvCustom.add(new Utils.KeyValuePair<>("|<span class='" + teamler.getRankCurrent().getCssClass() + "'>" + teamler.getNameForMarkdown() + "</span>", "%page.responsibilities.custom.sm.twitter.hv%"));
                    }
                    for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilitySecondary("%page.responsibilities.custom.sm.twitter%")).sorted(Teamler::compare).collect(Collectors.toList())) {
                        nvCustom.add(new Utils.KeyValuePair<>("|<span class='" + teamler.getRankCurrent().getCssClass() + "'>" + teamler.getNameForMarkdown() + "</span>", "%page.responsibilities.custom.sm.twitter.nv%"));
                    }
                    for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("%page.responsibilities.custom.sm.twitter-builder%")).sorted(Teamler::compare).collect(Collectors.toList())) {
                        nvCustom.add(new Utils.KeyValuePair<>("|<span class='" + teamler.getRankCurrent().getCssClass() + "'>" + teamler.getNameForMarkdown() + "</span>", "%page.responsibilities.custom.sm.twitter-builder.hv%"));
                    }
                    for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilitySecondary("%page.responsibilities.custom.sm.twitter-builder%")).sorted(Teamler::compare).collect(Collectors.toList())) {
                        nvCustom.add(new Utils.KeyValuePair<>("|<span class='" + teamler.getRankCurrent().getCssClass() + "'>" + teamler.getNameForMarkdown() + "</span>", "%page.responsibilities.custom.sm.twitter-builder.nv%"));
                    }
                } else if (e.getKey().equals("%page.responsibilities.teamleader%")) {
                    titleCustom = "%page.responsibilities.custom.teamleader.title%";
                    // |<span class='management'>Lascona</span>    | Management des gesamten Timolia-Teams |
                    // |<span class='headbuilder'>Jukplays</span>  | Management des Bau-Teams |
                    for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Management des gesamten Timolia-Teams")).sorted(Teamler::compare).collect(Collectors.toList())) {
                        hvCustom.add(new Utils.KeyValuePair<>("|<span class='" + teamler.getRankCurrent().getCssClass() + "'>" + teamler.getNameForMarkdown() + "</span>", "%page.responsibilities.custom.teamleader.whole-team%"));
                    }
                    for (Teamler teamler : teamlers.stream().filter(teamler -> teamler.hasResponsibilityMain("Management des Bau-Teams")).sorted(Teamler::compare).collect(Collectors.toList())) {
                        hvCustom.add(new Utils.KeyValuePair<>("|<span class='" + teamler.getRankCurrent().getCssClass() + "'>" + teamler.getNameForMarkdown() + "</span>", "%page.responsibilities.custom.teamleader.builder%"));
                    }
                } else if (e.getKey().equals("%page.responsibilities.yter%")) {
                    titleCustom = "%page.responsibilities.custom.yter.title%";
                }


                if (titleCustom == null) {
                    sb.append("\n").append("| %page.responsibilities.teamler% | %page.responsibilities.responsib% |");
                } else {
                    sb.append("\n").append("| %page.responsibilities.teamler% | ").append(titleCustom).append(" |");
                }

                sb.append("\n").append("| ------ | ------ |");

                if (hvCustom.isEmpty()) {
                    for (Teamler teamler : hv) {
                        sb.append("\n").append("|<span class='").append(teamler.getRankCurrent().getCssClass()).append("'>").append(teamler.getNameForMarkdown()).append("</span> | %page.responsibilities.hv% |");
                    }
                } else {
                    for (Utils.KeyValuePair<String, String> hvEntry : hvCustom) {
                        String k = hvEntry.getKey();
                        String v = hvEntry.getValue();
                        if (v == null) {
                            sb.append("\n").append(k).append(" | %page.responsibilities.hv% |");
                        } else {
                            sb.append("\n").append(k).append(" | ").append(v).append(" |");
                        }
                    }
                }

                if (!nv.isEmpty() || !nvCustom.isEmpty()) {
                    sb.append("\n").append("| | |");
                    if (nvCustom.isEmpty()) {
                        for (Teamler teamler : nv) {
                            sb.append("\n").append("|<span class='").append(teamler.getRankCurrent().getCssClass()).append("'>").append(teamler.getNameForMarkdown()).append("</span> | %page.responsibilities.nv% |");
                        }
                    } else {
                        for (Utils.KeyValuePair<String, String> nvEntry : nvCustom) {
                            String k = nvEntry.getKey();
                            String v = nvEntry.getValue();
                            if (v == null) {
                                sb.append("\n").append("|").append(k).append(" | %page.responsibilities.nv% |");
                            } else {
                                sb.append("\n").append(k).append(" | ").append(v).append(" |");
                            }
                        }
                    }
                }


            }
        }

        sb.append("\n");

        return sb.toString();
    }

}
