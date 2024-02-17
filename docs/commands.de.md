Hier findest du alle Commands ausführlich aufgelistet, die du auf dem Server benutzen kannst.
Variablen, die mit <> markiert sind, werden benötigt, mit [] markierte Attribute sind optional.

## 1 - Allgemeine Befehle
Diese Befehle sind global nutzbar und stehen dir jederzeit zur Verfügung.

| Befehl | Funktion |
| ------ | -------- |
| `/achievements`, `/ach`         | Listet eine Übersicht aller Achievements auf |
| `/bannotify`                    | Deaktiviere Benachrichtigungen zu deinen Banntagen |
| `/discord unverify`             | Trennt die Verifikation sowie Verbindung zwischen deinem Minecraft und Discord Account |
| `/games`                        | Teleportiert dich zu den Games-Servern |
| `/help`                         | Zeigt dir die wichtigsten Infos zu Timolia |
| `/hub`, `/lobby`                | Teleportiert dich in die Lobby |
| `/joinme`                       | Öffne das JoinMe-Menu, z.B. um einen JoinMe zu erstellen |
| `/jointeam <Team-Farbe>`, `/team`| Betritt ein Team in Castles, Brainbow und Mineception |
| `/lang <Sprache>`               | Ändere deine Sprache |
| `/lookup <Spieler>`, `/lu`      | Zeigt dir LogIn-Informationen über einen Spieler |
| `/msg`                          | Erlaubt MSGs mit Freunden, keinem oder allen |
| `/msg <Spieler>`, `/m`          | Schreibe mit einem Spieler im Privatchat |
| `/present <Spieler> <Betrag> [Nachricht]`, `/gift`, `/donate` | Ermöglicht es dir, in der Weihnachtszeit Pixel zu verschenken |
| `/quickjoin <Spielmodus>`       | Betritt einen Spielmodus per Befehl |
| `/rank`                         | Zeigt deinen aktuellen Ingame-Rang und wie lange er läuft |
| `/register <E-Mail>`            | Registriert dich für die Webseite |
| `/stats [1,3,30,all]`           | Zeigt dir deine Stats in den meisten Modi |
| `/teamspeak`, `/ts`             | Zeigt die TS-IP, ermöglicht die Verifizierung und lässt dich deine Identität verwalten |
| `/top`                          | Zeigt dir die Top 10 Spieler der letzten 30 Tage in einem Spielmodus an |
| `/tutorial`                     | Starte ein Tutorial (nicht in allen Modi verfügbar) |
| `/vote <Zahl>`                  | Votet für eine Map in einem Spielmodus |
**[Premium](/ranks/premium/) only**:
| `/togglerank`, `/tr`            | Werde in allen Spielmodi als normaler Spieler angezeigt |
**[<span class='pro'>Pro+</span>](/ranks/premium/) only**:
| `/ptime <day/night/midnight/sunrise/noon/afternoon/sunset/reset/hh:mm>` | Zeit für sich selbst umstellen |
| `/pweather <sun/rain/reset>`    | Wetter für sich selbst umstellen |
**[<span class='expert'>Expert</span>](/ranks/premium/) only**:
| `/giftpremium <Spieler>`        | Verschenke 3 Tage Pro an einen Spieler (alle 30 Tage) |
**[<span class='mvp'>VIP</span>](/ranks/youtube/) only**:
| `/nick`                         | Ermöglicht es dir, dich zu nicken |
| `/unnick`                       | Ermöglicht es dir, dich zu entnicken |
**[<span class='youtuber'>YouTuber</span>](/ranks/youtube/) only**:
| `/forcemap`                     | Erzwinge bei einem Spiel mit Voting-System eine bestimmte Map |
| `/giftpremium <Spieler>`        | Verschenke dreimal am Tag jeweils 3 Tage Pro an einen Spieler |
| `/nick`                         | Ermöglicht es dir, dich zu nicken |
| `/startgame`                    | Starte ein Spiel |
| `/unnick`                       | Ermöglicht es dir, dich zu entnicken |
| `/vanish`, `/v`                 | Ermöglicht es dir, dich in 1vs1, Jumpworld und in den Lobbies unsichtbar zu machen |


### Reportsystem

| Befehl | Funktion |
| ------ | -------- |
| `/report <Spieler>`, `/rp`      | Erstellt nach Auswählen der Kategorie einen Report |
| `/reportbugusing <Spieler> <Beschreibung>` | Erstellt einen Bugusingreport |
| `/reportevidence <Spieler> <Beweis>` | Erstellt einen Report mit Beweis |
| `/reportinfo <ID>`              | Zeigt dir alle Infos über einen Report an |
| `/reportjnr <ID>`               | Erstellt einen Report über ein Jump and Run in Jump World |
| `/reports [Seite]`              | Öffnet eine Übersicht deiner Reports |
| `/reportstats`                  | Zeigt dir die Erfolgsquoten deiner erstellten Reports an |

### Lobby
| Befehl | Funktion |
| ------ | -------- |
| `/fixkickvalue`, `/fixkv`       | Setzt deine Kick-Value zurück. Wie das Kick-System funktioniert, kannst du [<strong>hier</strong> nachlesen](https://howto.timolia.de/faq/#wie-funktioniert-das-kick-system) |
| `/myspawn`                      | Setzt einen eigenen, individuellen Spawnpunkt in der Lobby |
| `/resetmyspawn`                 | Resettet den eigenen, individuellen Spawnpunkt in der Lobby |
| `/stats <Spieler>`              | Zeigt dir die Stats eines Spielers an |
| `/stats <Spieler> <Spieler>...` | Ermöglicht es dir, die Stats von mehreren Spielern zu vergleichen |
| `/spawn`                        | Teleportiert dich zurück zum Spawn vom Hub |
| `/sync {0, 1, 2...]`, `/armorsync` | Synchronisiert die farbwechselnde Rüstung aus dem PixelShop |

### Freundesystem

Anstatt `/friend` kann jeweils `/f` genutzt werden.

| Befehl | Funktion |
| ------ | -------- |
| `/friend <Spieler>`, `/friend add` | Schickt oder akzeptiert eine Freundschaftsanfrage |
| `/friend broadcast <Nachricht>`, `/f bc` | Schickt einen Broadcast an alle Freunde, die derzeit online sind |
| `/friend deny <Spieler>`        | Lehnt eine Freundschaftsanfrage ab |
| `/friend ignore <Spieler>`      | Der ignorierte Spieler kann dir keine Freundschaftsanfrage schicken |
| `/friend list, /friends`        | Zeigt eine Liste deiner Freunde an |
| `/friend remove <Spieler>`, `/friend rem`, `/friend delete`, `/friend del` | Entfernt einen Spieler aus deiner Freundesliste |
| `/friend requests`, `/friend req` | Listet unbeantwortete Freundschaftsanfragen auf |
| `/friend teleport <Spieler>`, `/friend tp` | Teleportiert dich zu einem Freund |
| `/friend toggle`                | Zeigt dir eine Übersicht anpassbarer Einstellungen an |
| `/friends online`               | Zeigt deine Freunde an, die gerade online sind |

### Partysystem

| Befehl | Funktion |
| ------ | -------- |
| `/party`                        | Erstellt eine neue Party oder öffnet die Partyverwaltung |
| `/party demote <Spieler>`       | Degradiert einen Spieler zum Mitglied |
| `/party help`                   | Zeigt alle Befehle des Partysystems |
| `/party invite <Spieler>`       | Lädt einen Spieler in deine Party ein |
| `/party join <Spieler>`         | Tritt einer Party bei |
| `/party leave`                  | Verlasse die aktuelle Party |
| `/party promote <Spieler>`      | Ernennt einen Spieler zum Moderator |
| `/party togglechat`             | Schaltet zwischen Party-Chat und normalem Chat um |

### Zwei-Faktor-Authentifizierung

Mit der Zwei-Faktor-Authentifizierung verhinderst du, dass Unbefugte mit deinem Account auf Timolia spielen. 
Du wirst beim Login nach einem Code gefragt, den dein Handy automatisch alle 30 Sekunden neu generiert. 
So können sich nur Personen verifizieren, die Zugriff auf dein Handy haben.
Solltest du dein Handy verlieren, kannst du dich weiterhin mit Backupcodes anmelden, die du beim Einrichten von 2fa erhältst und sicher verwahren solltest.

| Befehl | Funktion |
| ------ | -------- |
| `/2fa`                          | Zeigt dir die Hilfe für die Zwei-Faktor-Authentifizierung an |
| `/2fa buc`                      | Listet alle unbenutzten Backup-Codes auf |
| `/2fa disable`                  | Deaktiviert die Zwei-Faktor-Authentifizierung |
| `/2fa logout`                   | Kickt dich vom Netzwerk und loggt dich aus der Zwei-Faktor-Authentifizierung aus |
| `/2fa setup`                    | Richtet die Zwei-Faktor-Authentifizierung ein |

### Community-Discord

Der <strong>Timolia Bot</strong> verfügt über mehrere Commands, die ausgeführt werden können.

| Befehl | Channel | Funktion |
| ------ | -------------- | -------- |
| `/bug <Beschreibung>` | Timolia Bot (Privatchat) und [#bug-melden](https://discordapp.com/channels/407554118887014402/413638656264503317) | Meldet einen Bug an das Timolia Team |
| `/channel invite <@Name>` oder `/channel remove <@Name>` | Timolia Bot (Privatchat) und eigener Channel | Lädt einen User in einen privaten Chatchannel ein oder entfernt ihn |
| `/help` | Timolia Bot (Privatchat) | Listet alle verfügbaren Commands auf |
| `/help <command>` oder `/<command> help` | Timolia Bot (Privatchat) | Gibt Infos über den ausgewählten Command aus |
| `/idea <Idee>` | Nur in [#ideen](https://discordapp.com/channels/407554118887014402/413615776399097866) und [#discord-ideen](https://discordapp.com/channels/407554118887014402/569594169228656656) | Der Bot postet deine Idee und versieht sie mit einer positiven und einer negativen Reaction |
| `/lookup <@Name>` | Timolia Bot (Privatchat) | Gibt Informationen zu einem User aus |
| `/quote <NachrichtID>/<Nachricht Link>` | Nur in Channeln | Zitiert die angegebene Nachricht |
| `/rank` | Timolia Bot (Privatchat) und [#ranks](https://discordapp.com/channels/407554118887014402/548160287891783690) | Zeigt Informationen zu deinem Rang an |
| `/stats [@Name]` | Timolia Bot (Privatchat) | Gibt einige Discord Stats von dir oder anderen aus |
| `/stats all` | Timolia Bot (Privatchat) | Gibt die Serverstats aus |
| `/support <Beschreibung>` | Timolia Bot (Privatchat) und [#support](https://discordapp.com/channels/407554118887014402/413594798906408960) | Erstellt einen Supportchat für dich mit dem angegebenen Problem |
| `/top` | Timolia Bot (Privatchat) und [#ranks](https://discordapp.com/channels/407554118887014402/548160287891783690)| Zeigt die Top 10 der User an|
| `/register <Ingamename>` | Timolia Bot (Privatchat) | Verknüpft deinen Discord-Account mit deinem Minecraft-Account |

## 2 - Befehle der einzelnen Modi

### 1vs1
| Befehl | Funktion |
| ------ | -------- |
| `/challenge <Spieler>`, `/c`    | Fordert einen Spieler zu einem Duell heraus |
| `/compare <Name> <Name>`        | Zeigt die Kampfstatistik zweier Spieler |
| `/endmatch`                     | Der Kampf wird nach einer Minute mit Entscheidung durch die Mitte beendet |
| `/importkit <Zahl>`             | Importiere eines deiner Kits im Kitbereich |
| `/join <Name>`                  | Tritt einem Turnier bei |
| `/join <Name> <Passwort>`       | Tritt einem passwortgeschützten Turnier bei |
| `/kit`, `/k`                    | Öffnet das ausgewählte Kit in deinem Inventar |
| `/kit <Name(:1/2/3/4/5)>`       | Wählt das Kit eines anderen Spielers aus |
| `/kitinfo`                      | Zeigt Infos über das ausgewählte Kit |
| `/kits`                         | Listet dir alle von Timolia erstellten Kits auf |
| `/lastinv <Spieler>`, `/inv`    | Zeigt das letzte Inventar eines Spielers |
| `/leave`, `/l`                  | Verlässt ein Turnier bzw die Warteschlange |
| `/liveinv <Spieler>`, `/liveinventory` | Zeigt das aktuelle Inventar eines Spielers |
| `/matchinfo`                    | Zeigt Informationen über den aktuellen Kampf |
| `/queue`, `/q`                  | Fügt dich zur Warteschlange hinzu |
| `/rankinfo`, `/ranginfo`        | Zeigt Informationen zum aktuellen Rang |
| `/season [Nummer]`              | Zeigt das Kit der aktuellen oder angegebenen Season, Bestenlisten, deine Punkte und Platzierungen an |
| `/settings`                     | Öffnet die Einstellungen |
| `/spectate <Spieler>`, `/spec`  | Lässt dich den Kampf eines Spielers beobachten |
| `/stats`                        | Zeigt dir deine Stats an |
| `/stats <Name>`                 | Zeigt dir die Stats eines Spielers an |
| `/statsmenu [Name]`             | Öffnet das Statsmenü |
| `/surrender`                    | Man tötet sich selbst und beendet den Kampf vorzeitig |
| `/t`                            | Zeigt die Turnierinformationen |
| `/team accept <Name>`           | Tritt einem Team bei |
| `/team invite <Name>`           | Lädt einen Spieler in dein Team ein |
| `/team kick <Name>`             | Kickt einen Spieler aus deinem Team |
| `/team leave <Name>`            | Zieht eine Teameinladung zurück |
| `/winstreak`, `/streak`         | Zeigt deine aktuelle Winstreak |
| `/xp <Level>`                   | Setzt ein XP-Level für dein Kit |
**[Premium](/ranks/premium/) only**:
| `/bestofx <Spieler> <Anzahl>`   | Fordert einen Spieler zu einem Best of 3 oder Best of 5 heraus |
| `/create [Passwort]`            | Erstellt ein Turnier (optional mit einem Passwort) |
| `/modify`                       | Bearbeitet die Turniereinstellungen |
| `/near <kit> [name]`            | Zeigt für jede Kitrangliste die Entfernung zum nächsten Rang an |
| `/start [Zeit]`                 | Startet dein Turnier |
**[<span class='pro'>Pro+</span>](/ranks/premium/) only**:
| `/hat`                          | Setzt das Item in deiner Hand als den Helm deines Kits |
| `/rankinfo`                     | Gibt Informationen über deinen aktuellen global Rang aus |
| `/roadToKD <KD-Ziel>`, `/roadToWL <KD-Ziel>`  | Zeigt die Anzahl zu gewinnender Spiele an, um die K/D zu erreichen |
| `/team setcolor`                | Färbt euren Namen entsprechend der gewählten Farbe |

### Arcade
| Befehl | Funktion |
| ------ | -------- |
| `/join <Spieler>` | Betritt ein Turnier |
| `/last` | Zeigt die zuletzt gespielten Spiele |
| `/leave` | Verlasse ein Turnier |
| `/rot` | Zeigt die Spielrotation |
**[Premium](/ranks/premium/) only**:
| `/create`                       | Erstellt ein Turnier |
| `/invite <Spieler>`             | Lädt einen Spieler in dein Turnier ein |

### Castles
| Befehl | Funktion |
| ------ | -------- |
| `/jointeam <Teamfarbe>`, `/team` | Betritt ein Team |
| `/kill`                         | Tötet dich selbst |

### JumpWorld
| Befehl | Funktion |
| ------ | -------- |
| `/amboss`, `/crystals`, `/entities`, `/portals` | Öffnet das Menü zur Übersicht der Entities |
| `/b`                            | Öffnet das Bau-Info-Menü |
| `/buildspec`                    | Setzt dich im Bau-Modus in den Spectator-Modus |
| `/checkpoint`, `/fall`, `/kill` | Teleportiert dich zurück zum letzten Checkpoint |
| `/duel accept <Spieler>`        | Nimmt die Einladung in ein Duell an |
| `/duel invite <Spieler>`        | Lädt einen Spieler in ein Duell ein |
| `/duel kick <Spieler>`          | Kickt einen Spieler aus einem Duell |
| `/duel leave <Spieler>`         | Verlässt ein Duell |
| `/duel promote <Spieler>`       | Ernennt einen neuen Duell-Leiter |
| `/enter <ID>`, `/e <ID>`        | Betritt ein bestimmtes Jump 'n' Run |
| `/info`, `/jnr`                 | Gibt Informationen über das Jump 'n' Run aus |
| `/jnrsettings`                  | Zeigt die Einstellungen des Jump 'n' Runs an |
| `/join <Name>`                  | Betritt das Jump 'n' Run, auf dem sich [Spieler] gerade befindet |
| `/jump`                         | Wechselt zwischen Jump- und Bau-Modus |
| `/kit`                          | Gibt dir die Start-Items im Bau-Modus |
| `/leave`, `/l`                  | Verlässt das aktuelle Jump 'n' Run |
| `/resetjnr`                     | Startet das Jump 'n' Run neu |
| `/setblock`, `/sb`              | Platziert den Block in deiner Hand unter dir |
| `/setstart`                     | Setzt den Startpunkt deines Jump 'n' Runs |
| `/top <ID>`                     | Zeigt die Top-Zeiten des Jump 'n' Runs mit der ID [id] an |
| `/top <ID> -f`                  | Zeigt die wenigsten Fails des Jump 'n' Runs mit der ID [id] an |
| `/tpstart`                      | Setzt dich an den Start des Jump 'n' Runs zurück |
**[Premium](/ranks/premium/) only**:
| `/multibuild <3,6>`,<br>`/mb <3,6>` | Du kannst bis zu 3 (ab <span class="pro">Pro</span>) oder bis zu 6 (ab <span class="mvp">MVP+</span>) Blöcke auf einmal setzen |
| `/seticon`                      | Setzt ein eigenes Icon für dein Jump 'n' Run |
| `/reseticon`                    | Setzt das Icon des Jump 'n' Runs zurück |
**[<span class='mvp'>MVP</span>](/ranks/premium/) only**:
| `/skull [Name]`                 | Gibt dir einen Spielerkopf |

### Freebuild
| Befehl | Funktion |
| ------ | -------- |
| `/accepttpa <Spieler>`, `/accepttphere` | Akzeptiert und ermöglicht die Teleportation eines Spielers zu dir |
| `/backpack`, `/bp`, `/ec` | Öffnet dein persönliches Backpack |
| `/claim` | Beansprucht den Chunk in welchem du dich befindest |
| `/foodmenu` | Öffnet den Essens Shop |
| `/home` | Öffnet dir das Teleport Punkte Menü |
| `/missions`| Verschafft dir zugang und übersicht zu allen aktiven Missionen |
| `/removebinding` | Entfernt den Fluch der Bindung von sämtlichen Rüstungsteilen |
| `/settings`| Öffnet die Freebuild-Einstellungen |
| `/spawn` | Bringt dich direkt zum Spawn der Freebuild Welt |
| `/tpa <Spieler>`, `/tphere <Spieler>` | Sendet eine anfrage des Teleportes zu einem anderen Spieler |
| `/trade <Spieler>` | Eröffnet einen Handel mit einem anderem Spieler |
| `/tutorial` | Zeigt dir eine Freebuild Einführung an |
| `/unclaim` | Gibt deinen Chunk frei |
| `/workbench`, `/wb`, `/crafting` | Öffnet dir eine Werkbank |

### SecretGames
| Befehl | Funktion |
| ------ | -------- |
| `/cr lobby`           | Bringt euch zum Center zurück |
| `/cr stats <Spieler>` | Listet euch die Stats eines Spielers auf |
| `/hub`                | Bringt euch in die Hauptlobby zurück |

### UHC
| Befehl | Funktion |
| ------ | -------- |
| `/backpack`, `/bp`                         | Öffnet das gemeinsames Inventar in Team-UHCs |
| `/config`                                  | Listet die aktuelle Konfiguration des UHCs auf |
| `/coordinates`, `/coords`                  | Schickt eine Nachricht an deine Teampartner mit deinen Koordinaten |
| `/dragons <Spieler>`                       | Bei aktivem Szenario `Dragons` kann der Host des UHCs bei dem Spieler einen Enderdrachen spawnen |
| `/fix`                                     | Damit kannst du alle Spieler neu laden |
| `/helpop`                                  | Damit kannst du jederzeit Fragen bezüglich des UHCs an das Team stellen |
| `/invite <Spieler>`                        | Damit kannst du Spieler in dein Team bei Team-UHCs einladen |
| `/inviteaccept <Spieler>`                  | Damit nimmst du Teameinladungen bei Team-UHCs an |
| `/scenarios`, `/scn`, `/uhc`               | Zeigt dir die aktiven Szenarien an |
| `/showhealth <Spieler>`, `/h <Spieler>`    | Zeigt die Leben des angegebenen Spielers an |
| `/topkills`, `/top`, `/tk`                 | Zeigt den/die Spieler mit den meistens Kills an |
