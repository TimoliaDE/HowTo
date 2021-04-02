package de.timolia.howto;

import de.timolia.howto.models.Language;
import de.timolia.howto.models.LanguageString;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LanguageUtil {

    public static String translate(Language language, String s) {
        for(LanguageString languageString : getTranslations().stream().filter(languageString -> languageString.getLanguage().equals(language)).collect(Collectors.toList())) {
            s = s.replaceAll("%" + languageString.getKey() + "%", languageString.getValue());
        }
        return s;
    }

    private static ArrayList<LanguageString> getTranslations() {
        return new ArrayList<>() {{
            add(new LanguageString(Language.DE, "rank.builder.description", "Das Bauteam kreiert neue Maps und Lobbys für alle Gelegenheiten und Spielmodi auf Timolia. \n" +
                    "Sie betreuen die architektonische Gestaltung neuer Modi und betreuen externe Mapeinsendungen."));
            add(new LanguageString(Language.EN, "rank.builder.description", "The builder team creates new maps and lobbies for all occasions and game modes on Timolia. \n" +
                    "They supervise the architectural design of new game modes and manage external map submissions."));
            add(new LanguageString(Language.DE, "rank.builder_plus.description", "Builder+ übernehmen zusätzliche organisatorische Verantwortung durch ihre hohe Erfahrung sowohl im Level Design als auch im Team. \n" +
                    "So leiten sie beispielsweise Projekte oder sind Ansprechpartner für neue Builder."));
            add(new LanguageString(Language.EN, "rank.builder_plus.description", "Builder+ take on additional organizational responsibility through their high level of experience in both level design and the team. \n" +
                    "For example, they manage projects or are the contact person for new builders."));
            add(new LanguageString(Language.DE, "rank.creator.description", "Als kreative Ader sind sie für die verschiedensten Belange von Grafikdesign bis Übersetzung zuständig."));
            add(new LanguageString(Language.EN, "rank.creator.description", "As a creative streak, they are responsible for a wide range of interests from graphic design to translation."));
            add(new LanguageString(Language.DE, "rank.developer.description", "Developer kümmern sich um die Timolia Plugins, entwickeln neue Features und Spielmodi und kümmern sich um die Bugs, pardon, Features auf Timolia."));
            add(new LanguageString(Language.EN, "rank.developer.description", "Developers take care of Timolia plugins, develop new features and game modes and fix bugs (oh sorry, we really mean features) features on Timolia."));
            add(new LanguageString(Language.DE, "rank.developer_plus.description", "Sie verfügen über langjährige Erfahrung als Entwickler auf Timolia und stehen bei internen Fragen zum Development zur Verfügung. \n" +
                    "Auch kümmern sie sich um Timolia Plugins, entwickeln neue Features und Spielmodi und beheben mögliche Spielfehler."));
            add(new LanguageString(Language.EN, "rank.developer_plus.description", "They have many years of experience as a developer on Timolia and are available to answer internal questions about development. \n" +
                    "They also take care of Timolia plugins, develop new features and game modes and fix possible bugs in games."));
            add(new LanguageString(Language.DE, "rank.head_builder.description", "Sie leiten und organisieren das Bauteam und dienen als erste Ansprechpartner für alle Builder. \n" +
                    "Außerdem kümmern sie sich um die Auswahl und Einarbeitung neuer Builder und sind die Schnittstelle zwischen dem Bauteam und der allgemeinen Projektorganisation."));
            add(new LanguageString(Language.EN, "rank.head_builder.description", "They lead and organize the builder team and act as the first point of contact for all builders. \n" +
                    "Moreover, they take care of the selection and training of new builders and are the link between the builder team and the general project organization."));
            add(new LanguageString(Language.DE, "rank.management.description", "Diese Teamler bilden die Leitung Timolias. " +
                    "Sie kümmern sich um die Verwaltung, Organisation und die Teamleitung."));
            add(new LanguageString(Language.EN, "rank.management.description", "These team members form the leadership of Timolia. " +
                    "They take care of administration, organization and team management."));
            add(new LanguageString(Language.DE, "rank.moderator.description", "Moderatoren sind langjährige und besonders erfahrene Teamler, die einzigartige Expertise in ihrem jeweiligen Fachgebiet aufweisen. \n" +
                    "Sie dienen als interne Ansprechpartner bei Fragen und koordinieren häufig einzelne Aufgabengebiete."));
            add(new LanguageString(Language.EN, "rank.moderator.description", "Moderators are long-term and outstandingly experienced team members who have unique knowledge in their respective fields. \n" +
                    "They serve as internal contacts for questions and often coordinate individual areas of responsibility."));
            add(new LanguageString(Language.DE, "rank.supporter.description", "Supporter stehen für alle grundlegenden Fragen und Reports zur Verfügung und sind die ersten, an die sich Spieler mit ihren Anliegen wenden können. "));
            add(new LanguageString(Language.EN, "rank.supporter.description", "Supporters are available for all basic questions and reports and \n" +
                    "are the first to whom players can address their concerns."));
            add(new LanguageString(Language.DE, "rank.supporter_plus.description", "Sie verfügen über ein umfassendes Fachwissen und stehen für alle Fragen und Reports zur Verfügung. \n" +
                    "Sie sind die ersten, an die sich Spieler mit ihren Anliegen wenden können."));
            add(new LanguageString(Language.EN, "rank.supporter_plus.description", "They have comprehensive specialized knowledge and are available for all questions and reports. \n" +
                    "They are the first to whom players can turn with their concerns."));
            add(new LanguageString(Language.DE, "rank.sysadmin.description", "Systemadministratoren planen, installieren, konfigurieren und warten die technischen Systeme Timolias. \n" +
                    "Sie führen Updates durch und sorgen für ein reibungsloses Spielerlebnis im Alltag."));
            add(new LanguageString(Language.EN, "rank.sysadmin.description", "System administrators plan, install, configure and maintain Timolia's technical systems. \n" +
                    "They carry out updates and ensure a smooth gaming experience in everyday life."));

            add(new LanguageString(Language.DE, "page.rank-change.first", "Hier werden alle Aus- und Eintritte bzw. Beförderungen und Degradierungen aufgelistet."));
            add(new LanguageString(Language.EN, "page.rank-change.first", "Here, all team entries and resignations as well as promotions and demotions are listed."));
            add(new LanguageString(Language.DE, "player", "Spieler"));
            add(new LanguageString(Language.EN, "player", "Name"));
            add(new LanguageString(Language.DE, "page.rank-change.rank-previous", "Vorheriger Rang"));
            add(new LanguageString(Language.EN, "page.rank-change.rank-previous", "Previous rank"));
            add(new LanguageString(Language.DE, "page.rank-change.rank-new", "Jetziger Rang"));
            add(new LanguageString(Language.EN, "page.rank-change.rank-new", "Current Rank"));
            add(new LanguageString(Language.DE, "date", "Datum"));
            add(new LanguageString(Language.EN, "date", "Date"));

            add(new LanguageString(Language.DE, "page.members.first-1", "Das Timolia-Team besteht aktuell aus "));
            add(new LanguageString(Language.EN, "page.members.first-1", "The Timolia team currently consists of "));
            add(new LanguageString(Language.DE, "page.members.first-2", " Mitgliedern und ist in die Ränge "));
            add(new LanguageString(Language.EN, "page.members.first-2", " team members and is divided into the ranks"));
            add(new LanguageString(Language.DE, "and", "und"));
            add(new LanguageString(Language.EN, "and", "and"));
            add(new LanguageString(Language.DE, "page.members.first-3", " aufgeteilt."));
            add(new LanguageString(Language.EN, "page.members.first-3", "."));
            add(new LanguageString(Language.DE, "page.members.first-4", "Nachfolgend findet ihr eine Liste aller Teammitglieder von Timolia sowie deren Aufgabenbereiche und Verantwortlichkeiten. Diese Zuteilung heißt nicht, dass ausschießlich diese Teamler in diesem Bereich aktiv sind. \n" +
                    "Die Planung und Entwicklung von neuen Modi, Updates, Events und Ähnlichem liegt ausdrücklich nicht bei einem festen Teammitglied oder einer festen Gruppe von Teammitgliedern sondern unterscheidet sich von Projekt zu Projekt oder ändert sich zum Teil im Laufe des Projekts."));
            add(new LanguageString(Language.EN, "page.members.first-4", "Below you will find a list of all team members of Timolia and their responsibilities aswell as their fields of operation. This does not mean that these team members alone are active in that specific field. \n" +
                    "Planning and developing new game modes, updates and events is not assigned to one specific team member or a specific group of team members. It rather differs from one project to another and may change during the course of the project."));
            add(new LanguageString(Language.DE, "page.members.first-5", "Die Ränge auf Timolia"));
            add(new LanguageString(Language.EN, "page.members.first-5", "The ranks on Timolia"));
            add(new LanguageString(Language.DE, "page.members.rank-ingame", "Rang (ingame)"));
            add(new LanguageString(Language.EN, "page.members.rank-ingame", "Rang (ingame)"));
            add(new LanguageString(Language.DE, "page.members.hv", "Hauptverantwortlich"));
            add(new LanguageString(Language.EN, "page.members.hv", "Main responsibilities"));
            add(new LanguageString(Language.DE, "page.members.nv", "Nebenverantwortlich"));
            add(new LanguageString(Language.EN, "page.members.nv", "Secondary responsibilities"));
            add(new LanguageString(Language.DE, "page.members.fields", "Bereiche"));
            add(new LanguageString(Language.EN, "page.members.fields", "Fields"));

            add(new LanguageString(Language.DE, "page.responsibilities.forum", "Forum"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum", "Forums"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.forumorganisation", "Forenorganisation"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.forumorganisation", "Forum organization"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.forumorganisation.desc", "Die Verantwortlichen für die Forenorganisation kümmern sich sowohl um den Aufbau des Forums als auch um Probleme, welche im Forum auftreten."));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.forumorganisation.desc", "Those responsible for the forum organization take care of both the structure of the forums and problems that arise in the forums."));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.anregvorschl", "Anregungen und Vorschläge"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.anregvorschl", "Ideas and suggestions"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.qa", "Fragen und Antworten"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.qa", "Q&A"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.feedback", "Feedback"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.feedback", "Feedback"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.maps", "Map-Einsendungen"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.maps", "Map submissions"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.player-reports", "Spieler melden"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.player-reports", "Reports"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.bug-reports", "Bug melden"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.bug-reports", "Report bugs"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.ea", "Entschuldigungen"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.ea", "Appeals"));
            add(new LanguageString(Language.DE, "page.responsibilities.forum.zug", "Zu Unrecht gebannt"));
            add(new LanguageString(Language.EN, "page.responsibilities.forum.zug", "Falsely banned"));
            add(new LanguageString(Language.DE, "page.responsibilities.sa", "Sonstige Aufgaben"));
            add(new LanguageString(Language.EN, "page.responsibilities.sa", "Other tasks"));
            add(new LanguageString(Language.DE, "page.responsibilities.ac", "Anti-Cheat"));
            add(new LanguageString(Language.EN, "page.responsibilities.ac", "Anti-Cheat"));
            add(new LanguageString(Language.DE, "page.responsibilities.ac.desc", "Diese Teamler sorgen für einen fortlaufend reibungslosen Spielverlauf ohne Hacker."));
            add(new LanguageString(Language.EN, "page.responsibilities.ac.desc", "These team members ensure that the game continues to run smoothly without hackers."));
            add(new LanguageString(Language.DE, "page.responsibilities.bugs", "Bugs und Spielfehler"));
            add(new LanguageString(Language.EN, "page.responsibilities.bugs", "Bugs and game errors"));
            add(new LanguageString(Language.DE, "page.responsibilities.bugs.desc", "Bei jeglichen Fehlern in den Diensten von Timolia kümmert sich dieser Teamler darum, dass die Bugs an den jeweiligen Entwickler weitergetragen werden."));
            add(new LanguageString(Language.EN, "page.responsibilities.bugs.desc", "For any bugs in Timolia's services, this team member will ensure that the bugs are reported to the appropriate developer."));
            add(new LanguageString(Language.DE, "page.responsibilities.baufehler", "Baufehlerbehebung"));
            add(new LanguageString(Language.EN, "page.responsibilities.baufehler", "Correction of building flaws"));
            add(new LanguageString(Language.DE, "page.responsibilities.baufehler.desc", "Bei jeglichen Baufehlern auf den Maps von Timolia kümmern sich diese Teamler darum, dass die Bugs behoben werden."));
            add(new LanguageString(Language.EN, "page.responsibilities.baufehler.desc", "If there are any construction errors on the maps of Timolia, these team members ensure that the bugs are fixed."));
            add(new LanguageString(Language.DE, "page.responsibilities.supporterauswahl", "Supporterauswahl"));
            add(new LanguageString(Language.EN, "page.responsibilities.supporterauswahl", "Selection of supporters"));
            add(new LanguageString(Language.DE, "page.responsibilities.supporterauswahl.desc", "Wenn es wieder daran geht, neue Supporter in unsere Reihen zu holen, kümmern sich diese Verantwortlichen darum."));
            add(new LanguageString(Language.EN, "page.responsibilities.supporterauswahl.desc", "When it comes to recruiting new supporters, those team members will take care of it."));
            add(new LanguageString(Language.DE, "page.responsibilities.howto", "Timolia HowTo"));
            add(new LanguageString(Language.EN, "page.responsibilities.howto", "Timolia HowTo"));
            add(new LanguageString(Language.DE, "page.responsibilities.howto.desc", "Diese Teamler kümmern sich um's Aktualisieren und Erstellen des HowTos Timolias."));
            add(new LanguageString(Language.EN, "page.responsibilities.howto.desc", "These team members are responsible for updating and creating Timolia's HowTos."));
            add(new LanguageString(Language.DE, "page.responsibilities.sm", "Social-Media"));
            add(new LanguageString(Language.EN, "page.responsibilities.sm", "Social Media"));
            add(new LanguageString(Language.DE, "page.responsibilities.sm.desc", "Für einen ständigen Support und Content auf Twitter und anderen sozialen Medien sorgen diese Teamler."));
            add(new LanguageString(Language.EN, "page.responsibilities.sm.desc", "These team members provide ongoing support and content on Twitter and other social media."));
            add(new LanguageString(Language.DE, "page.responsibilities.ts", "TeamSpeak"));
            add(new LanguageString(Language.EN, "page.responsibilities.ts", "TeamSpeak"));
            add(new LanguageString(Language.DE, "page.responsibilities.ts.desc", "Der TeamSpeak von Timolia ist unter `ts.timolia.de` zu erreichen. Er wird betreut von diesen Teamlern."));
            add(new LanguageString(Language.EN, "page.responsibilities.ts.desc", "The TeamSpeak of Timolia can be reached at `ts.timolia.de`. It is supervised by these team members."));
            add(new LanguageString(Language.DE, "page.responsibilities.cd", "Community-Discord"));
            add(new LanguageString(Language.EN, "page.responsibilities.cd", "Community-Discord"));
            add(new LanguageString(Language.DE, "page.responsibilities.cd.desc", "Der Community-Discord von Timolia ist unter [https://timolia.de/discord](https://timolia.de/discord) zu erreichen. Er wird betreut von diesen Teamlern."));
            add(new LanguageString(Language.EN, "page.responsibilities.cd.desc", "The Community-Discord of Timolia can be reached at [https://timolia.de/discord](https://timolia.de/discord). It is maintained by these team members."));
            add(new LanguageString(Language.DE, "page.responsibilities.turnier", "Timolia Turnier Organisation"));
            add(new LanguageString(Language.EN, "page.responsibilities.turnier", "Timolia Tournament Organization"));
            add(new LanguageString(Language.DE, "page.responsibilities.turnier.desc", "Dieses Team entscheidet über die Turniereinstellungen bei den Freitagsturnieren."));
            add(new LanguageString(Language.EN, "page.responsibilities.turnier.desc", "This team decides on the tournament settings for the Friday tournaments."));
            add(new LanguageString(Language.DE, "page.responsibilities.broadcasts", "Broadcasts"));
            add(new LanguageString(Language.EN, "page.responsibilities.broadcasts", "Broadcasts"));
            add(new LanguageString(Language.DE, "page.responsibilities.broadcasts.desc", "Um auch ingame immer auf dem neusten Stand zu bleiben, wird sich hier um Broadcast Mitteilungen gekümmert."));
            add(new LanguageString(Language.EN, "page.responsibilities.broadcasts.desc", "To always stay up to date in-game, here is it taken care of broadcast messages."));
            add(new LanguageString(Language.DE, "page.responsibilities.teamleader", "Team-Leiter"));
            add(new LanguageString(Language.EN, "page.responsibilities.teamleader", "Team Leader"));
            add(new LanguageString(Language.DE, "page.responsibilities.teamleader.desc", "Im Timolia Team gibt es kleinere Teams, welche unter anderem durch diese Verantwortlichen organisiert werden."));
            add(new LanguageString(Language.EN, "page.responsibilities.teamleader.desc", "In the Timolia team, there are smaller teams, which are organized among others by these responsible persons."));
            add(new LanguageString(Language.DE, "page.responsibilities.yter", "YouTuber-Ränge"));
            add(new LanguageString(Language.EN, "page.responsibilities.yter", "YouTuber Ranks"));
            add(new LanguageString(Language.DE, "page.responsibilities.yter.desc", "Wenn sich ein YouTuber für einen Rang auf Timolia interessiert, werden die Anfragen von diesem Team bearbeitet."));
            add(new LanguageString(Language.EN, "page.responsibilities.yter.desc", "If a YouTuber is interested in a rank on Timolia, the requests are processed by this team."));
            add(new LanguageString(Language.DE, "page.responsibilities.info", "Hier werden die verschiedenen Aufgabenbereiche der Timolia Teamler aufgelistet."));
            add(new LanguageString(Language.EN, "page.responsibilities.info", "The various areas of responsibility of the Timolia team members are listed here."));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.bug-reports.modsanddevs", "Moderatoren und Developer"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.bug-reports.modsanddevs", "Moderators and Developers"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.sm.title", "Projekte u. Verantwortungsgrad"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.sm.title", "Projects and level of responsibility"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.sm.twitter", "Twitter"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.sm.twitter", "Twitter"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.sm.twitter-builder", "Bauteam-Twitter"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.sm.twitter-builder", "Builder Team-Twitter"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.sm.twitter.hv", "Twitter HV"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.sm.twitter.hv", "Twitter MR"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.sm.twitter.nv", "Twitter NV"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.sm.twitter.nv", "Twitter SR"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.sm.twitter-builder.hv", "Bauteam-Twitter MR"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.sm.twitter-builder.hv", "Builder Team-Twitter MR"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.sm.twitter-builder.nv", "Bauteam-Twitter SR"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.sm.twitter-builder.nv", "Builder Team-Twitter SR"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.teamleader.title", "Zuständigkeit"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.teamleader.title", "Responsibility"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.teamleader.whole-team", "Management des gesamten Timolia-Teams"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.teamleader.whole-team", "Management of the entire Timolia team"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.teamleader.builder", "Management des Bau-Teams"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.teamleader.builder", "Management of the builder team"));
            add(new LanguageString(Language.DE, "page.responsibilities.custom.yter.title", "Zuständigkeit"));
            add(new LanguageString(Language.EN, "page.responsibilities.custom.yter.title", "Responsibility"));
            add(new LanguageString(Language.DE, "page.responsibilities.teamler", "Teamler"));
            add(new LanguageString(Language.EN, "page.responsibilities.teamler", "Team member"));
            add(new LanguageString(Language.DE, "page.responsibilities.responsib", "Verantwortungsgrad"));
            add(new LanguageString(Language.EN, "page.responsibilities.responsib", "Level of responsibility"));
            add(new LanguageString(Language.DE, "page.responsibilities.hv", "Hauptverantwortlich"));
            add(new LanguageString(Language.EN, "page.responsibilities.hv", "Main responsibility"));
            add(new LanguageString(Language.DE, "page.responsibilities.nv", "Nebenverantwortlich"));
            add(new LanguageString(Language.EN, "page.responsibilities.nv", "Secondary responsibility"));
        }};
    }

}
