Hier findest du alle Commands ausführlich aufgelistet, die du auf dem Server benutzen kannst.
Variablen, die mit <> markiert sind, werden benötigt, mit [] markierte Attribute sind optional.

## 1 - Allgemeine Befehle
Diese Befehle sind global nutzbar und stehen dir jederzeit zur Verfügung.

| Befehl | Funktion |
| ------ | -------- |
| `/hub`, `/lobby`                | Teleportiert dich in die Lobby |
| `/games`                        | Teleportiert dich zu den Games-Servern |
| `/msg`                          | Erlaubt MSGs mit Freunden, keinem oder allen |
| `/msg <Spieler>`, `/m`          | Schreibe mit einem Spieler im Privatchat |
| `/lookup <Spieler>`, `/lu`      | Zeigt dir LogIn-Informationen über einen Spieler |
| `/top`                          | Zeigt dir die Top 10 Spieler der letzten 30 Tage in einem Spielmodus an |
| `/achievements`, `/ach`         | Listet eine Übersicht aller Achievements auf |
| `/vote <Zahl>`                  | Votet für eine Map in einem Spielmodus |
| `/stats [1,3,30,all]`           | Zeigt dir deine Stats in den meisten Modi |
| `/near`                         | Zeigt dir die Spieler, die sich direkt über und unter dir in der Punktewertung eines Modus befinden |
| `/tutorial`                     | Starte ein Tutorial (nicht in allen Modi verfügbar) |
| `/register <E-Mail>`            | Registriert dich für die Webseite |
| `/lang <Sprache>`               | Ändere deine Sprache |
| `/bannotify`                    | Deaktiviere Nofitikationen zu deinen Banntagen |
| `/champ`, `/championship`       | Zeigt Infos zu Timolia Champ |
| `/present <Spieler> <Betrag> [Nachricht]`, `/gift`, `/donate` | Ermöglicht es dir, in der Weihnachtszeit Pixel zu verschenken |
| `/help`                         | Zeigt dir die wichtigsten Infos zu Timolia |
| `/mail`                         | Öffnet das Menü deiner Mails |
| `/servername`                   | Zeigt dir wie auf Tab den aktuellen Server an |
| `/ticket <Anliegen>`            | Erstellt ein Ticket |
| `/tickets`                      | Öffnet eine Übersicht über deine Tickets |
| `/teamspeak`, `/ts`             | Zeigt die TS-IP, ermöglicht die Verifizierung und lässt dich deine Identität verwalten |
| `/jointeam <Team-Farbe>`, `/team`| Betrete ein Team in Castles, Brainbow und Mineception |
| `/rank`                         | Zeigt deinen aktuellen Ingame-Rang und wie lange er läuft |
| `/quickjoin <Spielmodus>`       | Betritt einen Spielmodus per Befehl |
**[Premium](/ranks/premium/) only**:
| `/togglerank`, `/tr`            | Werde in allen Spielmodi als normaler Spieler angezeigt |
| `/ptime <day/night/midnight/sunrise/noon/afternoon/sunset/reset/hh:mm>` | Zeit für sich selbst umstellen |
| `/pweather <sun/rain/reset>`    | Wetter für sich selbst umstellen |
| [<span style="color:#55FF55">VIP</span>](/ranks/youtube/) only: | |
| `/nick`                         | Ermöglicht es dir, dich zu nicken |
| `/unnick`                       | Ermöglicht es dir, dich zu entnicken |
| [<span style="color:#4C0B5F">YouTuber</span>](/ranks/youtube/) only: | |
| `/forcemap`                     | Erzwinge bei einem Spiel mit Voting-System eine bestimmte Map |
| `/startgame [Sekunden]`         | Starte ein Spiel |
| `/abortstart`                   | Brich den Start eines Spiels ab |
| `/nick`                         | Ermöglicht es dir, dich zu nicken |
| `/unnick`                       | Ermöglicht es dir, dich zu entnicken |
| `/vanish`, `/v`                 | Ermöglicht es dir, dich in 1vs1, Jumpworld und in den Lobbys unsichtbar zu machen |

### Reportsystem

| Befehl | Funktion |
| ------ | -------- |
| `/report <Spieler>`, `/rp`      | Erstellt nach Auswählen der Kategorie einen Report |
| `/reportjnr <ID>`               | Erstellt einen Report über ein Jump and Run in Jump World |
| `/reportbugusing <Spieler> <Beschreibung>` | Erstellt einen Bugusingreport |
| `/reportevidence <Spieler> <Beweis>` | Erstellt einen Report mit Beweis |
| `/reportinfo <ID>`              | Zeigt dir alle Infos über einen Report an |
| `/reports [Seite]`              | Öffnet eine Übersicht deiner Reports |
| `/reportstats`                  | Zeigt dir die Erfolgsquoten deiner erstellten Reports an |

### Lobby
| Befehl | Funktion |
| ------ | -------- |
| `/sync {0, 1, 2...]`, `/armorsync` | Synchronisiert die farbwechselnde Rüstung aus dem PixelShop |
| `/fixkickvalue`, `/fixkv`       | Setzt deine Kick-Value zurück. Wie das Kick-System funktioniert, kannst du [<strong>hier</strong> nachlesen](https://howto.timolia.de/faq/#wie-funktioniert-das-kick-system) |
| `/stats <Spieler>`              | Zeigt dir die Stats eines Spielers an |
| `/stats <Spieler> <Spieler>...` | Ermöglicht es dir, die Stats von mehreren Spielern zu vergleichen |
| `/spawn`                        | Teleportiert dich zurück zum Spawn vom Hub |
| `/myspawn`                      | Setzt einen eigenen, individuellen Spawnpunkt in der Lobby |
| `/resetmyspawn`                 | Resettet den eigenen, individuellen Spawnpunkt in der Lobby |

### Homes
| Befehl | Funktion |
| ------ | -------- |
| `/homes`                        | Zeigt eine Liste deiner Homepunkte |
| `/sethome <Name>`               | Setzt ein Home |
| `/sethome <Name> -f`            | Überschreibt ein vorhandenes Home |
| `/delhome <Name>`               | Löscht ein Home |

### Freundesystem

Anstatt `/friend` kann jeweils `/f` genutzt werden.

| Befehl | Funktion |
| ------ | -------- |
| `/friend <Spieler>`, `/friend add` | Schickt oder akzeptiert eine Freundschaftsanfrage |
| `/friend deny <Spieler>`        | Lehnt eine Freundschaftsanfrage ab |
| `/friend remove <Spieler>`, `/friend rem`, `/friend delete`, `/friend del` | Entfernt einen Spieler aus deiner Freundesliste |
| `/friend ignore <Spieler>`      | Der ignorierte Spieler kann dir keine Freundschaftsanfrage schicken |
| `/friend list, /friends`        | Zeigt eine Liste deiner Freunde an |
| `/friends online`               | Zeigt deine Freunde an, die gerade online sind |
| `/friend requests`, `/friend req` | Listet unbeantwortete Freundschaftsanfragen auf |
| `/friend toggle`                | Zeigt dir die übersicht anpassbarer Einstellungen an |
| `/friend teleport <Spieler>`, `/friend tp` | Teleportiert dich zu einem Freund |
| `/friend broadcast <Nachricht>` | Schickt einen Broadcast an alle Freunde, die derzeit online sind |

### Partysystem

| Befehl | Funktion |
| ------ | -------- |
| `/party`                        | Erstellt eine neue Party oder öffnet die Partyverwaltung |
| `/party help`                   | Zeigt alle Befehle des Partysystems |
| `/party join <Spieler>`         | Tritt einer Party bei |
| `/party invite <Spieler>`       | Lädt einen Spieler in deine Party ein |
| `/party leave`                  | Verlasse die aktuelle Party |
| `/party togglechat`             | Schaltet zwischen Party-Chat und normalem Chat um |
| `/party promote <Spieler>`      | Ernennt einen Spieler zum Moderator |
| `/party demote <Spieler>`       | Degradiert einen Spieler zum Mitglied |

### Zwei-Faktor-Authentifizierung

Mit der Zwei-Faktor-Authentifizierung verhinderst du, dass Unbefugte mit deinem Account auf Timolia spielen. 
Du wirst beim Login nach einem Code gefragt, den dein Handy automatisch alle 30 Sekunden neu generiert. 
So können sich nur Personen verifizieren, die Zugriff auf dein Handy haben.
Solltest du dein Handy verlieren, kannst du dich weiterhin mit Backupcodes anmelden, die du beim Einrichten von 2fa erhältst und sicher verwahren solltest.

| Befehl | Funktion |
| ------ | -------- |
| `/2fa`                          | Zeigt dir die Hilfe für die Zwei-Faktor-Authentifizierung an |
| `/2fa setup`                    | Richtet die Zwei-Faktor-Authentifizierung ein |
| `/2fa disable`                  | Deaktiviert die Zwei-Faktor-Authentifizierung |
| `/2fa buc`                      | Listet alle unbenutzten Backupcodes auf |
| `/2fa logout`                   | Kickt dich vom Netzwerk und loggt dich aus der Zwei-Faktor-Authentifizierung aus |

### Community-Discord

Der <strong>Timolia Bot</strong> verfügt über mehrere Commands, die ausgeführt werden können.

| Befehl | Channel | Funktion |
| ------ | -------------- | -------- |
| `/help` | Timolia Bot (Privatchat) | Listet alle verfügbaren Commands auf |
| `/help <command>` oder `/<command> help` | Timolia Bot (Privatchat) | Gibt Infos über den ausgewählten Command aus |
| `/verify <Ingamename>` | Timolia Bot (Privatchat) | Verknüpft deinen Discord-Account mit deinem Minecraft-Account |
| `/unverify` | Timolia Bot (Privatchat) | Hebt die Verknüpfung deines Discord-Accounts mit deinem Minecraft-Account auf |
| `/stats [@Name]` | Timolia Bot (Privatchat) | Gibt einige Discord Stats von dir oder anderen aus |
| `/stats all` | Timolia Bot (Privatchat) | Gibt die Serverstats aus |
| `/lookup <@Name>` | Timolia Bot (Privatchat) | Gibt Informationen zu einem User aus |
| `/quote <NachrichtID>/<Nachricht Link>` | Nur in Channeln | Zitiert die angegebene Nachricht |
| `/top` | Timolia Bot (Privatchat) und [#ranks](https://discordapp.com/channels/407554118887014402/548160287891783690)| Zeigt die Top 10 der User an|
| `/rank` | Timolia Bot (Privatchat) und [#ranks](https://discordapp.com/channels/407554118887014402/548160287891783690) | Zeigt Informationen zu deinem Rang an |
| `/channel invite <@Name>` oder `/channel remove <@Name>` | Timolia Bot (Privatchat) und eigener Channel | Lädt einen User in einen privaten Chatchannel ein oder entfernt ihn |
| `/bug <Beschreibung>` | Timolia Bot (Privatchat) und [#bug-melden](https://discordapp.com/channels/407554118887014402/413638656264503317) | Meldet einen Bug an das Timolia Team |
| `/support <Beschreibung>` | Timolia Bot (Privatchat) und [#support](https://discordapp.com/channels/407554118887014402/413594798906408960) | Erstellt einen Supportchat für dich mit dem angegebenen Problem |
| `/idea <Idee>` | Nur in [#ideen](https://discordapp.com/channels/407554118887014402/413615776399097866) und [#discord-ideen](https://discordapp.com/channels/407554118887014402/569594169228656656) | Der Bot postet deine Idee und versieht sie mit einer positiven und einer negativen Reaction |

## 2 - Befehle der einzelnen Modi

### 1vs1

| Befehl | Funktion |
| ------ | -------- |
| `/kit`, `/k`                    | Wählt dein Kit aus |
| `/kit <Name(:1/2/3/4/5)>`       | Wählt das Kit eines anderen Spielers aus |
| `/kits`                         | Listet dir alle von Timolia erstellten Kits auf |
| `/importkit <Zahl>`             | Importiere eines deiner Kits im Kitbereich |
| `/kitinfo`                      | Zeigt Infos zum aktuellen Kit |
| `/team invite <Name>`           | Lädt einen Spieler in dein Team ein |
| `/team accept <Name>`           | Tritt einem Team bei |
| `/team kick <Name>`             | Kickt einen Spieler aus deinem Team |
| `/challenge <Spieler>`, `/c`    | Fordert einen Spieler zu einem Duell heraus |
| `/leave`, `/l`                  | Zieht eine Herausforderung zurück |
| `/endmatch`                     | Der Kampf wird nach einer Minute mit Entscheidung durch die Mitte beendet |
| `/surrender`                    | Man tötet sich selbst und beendet den Kampf vorzeitig |
| `/spectate <Spieler>`, `/spec`  | Lässt dich den Kampf eines Spieler beobachten |
| `/stats`                        | Zeigt dir deine Stats an |
| `/stats <Name>`                 | Zeigt dir die Stats eines Spielers an |
| `/statsmenu [Name]`             | Öffnet das Statsmenü |
| `/top <Kit>`                    | Zeigt die Rangliste eines Competitive-Kits an |
| `/winstreak`, `/streak`         | Zeigt deine aktuelle Winstreak |
| `/join <Name>`                  | Tritt einem Turnier bei |
| `/join <Name> <Passwort>`       | Tritt einem passwortgeschützten Turnier bei |
| `/t`                            | Zeigt die Turnier Informationen |
| `/xp <Level>`                   | Setzt ein XP-Level für dein Kit |
| `/matchinfo`                    | Zeigt Informationen über den aktuellen Kampf |
| `/queue`, `/q`                  | Fügt dich zur Warteschlange hinzu |
| `/compare <Name> <Name>`        | Zeigt die Kampfstatistik zweier Spieler |
| `/settings`                     | Öffnet die Einstellungen |
| `/lastinv <Spieler>`, `/inv`    | Zeigt das letzte Inventar eines Spielers |
| `/liveinv <Spieler>`, `/liveinventory` | Zeigt das aktuelle Inventar eines Spielers |
| `/rankinfo`, `/ranginfo`        | Zeigt Informationen zum aktuellen Rang |
**[Premium](/ranks/premium/) only**:
| `/bestofx <Spieler> <Anzahl>`   | Fordert einen Spieler zu einem Best of 3 oder Best of 5 heraus |
| `/hat`                          | Setzt das Item in deiner Hand als den Helm deines Kits |
| `/create [Passwort]`            | Erstellt ein Turnier (optional mit einem Passwort) |
| `/modify`                       | Bearbeitet die Turniereinstellungen |
| `/start [Zeit]`                 | Startet dein Turnier |
| `/team setcolor`                | Färbt euren Namen entsprechend der gewählten Farbe |

### Arcade

| Befehl | Funktion |
| ------ | -------- |
| `/rot`                          | Zeigt die Spielrotation |
| `/last`                         | Zeigt die zuletzt gespielten Spiele |
| `/join <Spieler>`               | Betrete ein öffentliches Turnier |
| `/leave`                        | Verlasse ein Turnier |
**[Premium](/ranks/premium/) only**:
| `/create`                       | Erstellt ein Turnier |
| `/invite <Spieler>`             | Lädt einen Spieler in dein Turnier ein |

### JumpWorld

| Befehl | Funktion |
| ------ | -------- |
| `/enter <ID>`, `/e <ID>`        | Betrete ein bestimmtes Jump 'n' Run |
| `/leave`, `/l`                  | Verlässt das aktuelle Jump 'n' Run |
| `/setstart`                     | Setzt den Startpunkt deines Jump 'n' Runs |
| `/checkpoint`, `/fall`, `/kill` | Teleportiert dich zurück zum letzten Checkpoint |
| `/duel invite <Spieler>`        | Lädt einen Spieler in ein Duell ein |
| `/duel accept <Spieler>`        | Nimmt die Einladung in ein Duell an |
| `/duel leave <Spieler>`         | Verlässt ein Duell |
| `/duel kick <Spieler>`          | Kickt einen Spieler aus einem Duell |
| `/setblock`, `/sb`              | Platziert den Block in deiner Hand unter dir |
| `/jump`                         | Wechselt zwischen Jump- und Bau-Modus |
| `/b`                            | Öffnet das Bau-Info-Menü |
| `/kit`                          | Gibt dir die Start-Items im Bau-Modus |
| `/join <Name>`                  | Betritt das Jump 'n' Run, auf dem sich [Spieler] gerade befindet |
| `/top <ID>`                     | Zeigt die Top-Zeiten des Jump 'n' Runs mit der ID [id] an |
| `/top <ID> -f`                  | Zeigt die wenigsten Fails des Jump 'n' Runs mit der ID [id] an |
**[Premium](/ranks/premium/) only**:
| `/skull [Name]`                 | Gibt dir einen Spielerkopf

### Castles
| Befehl | Funktion |
| ------ | -------- |
| `/kill`                         | Tötet dich selbst |
| `/jointeam <Team-Farbe>`, `/team` | Betrete ein Team |

### Bauwelt
| Befehl | Funktion |
| ------ | -------- |
| `/bauwelt` | Listet alle Befehle der Bauwelt auf |
| `/spawn` | Telportiert dich zum Spawn der Bauwelt |
| `/finish` | Gibt deinen fertigen Plot ab |
| `/save` | Speichert deinen Plot |
| `/backup [Seite]` | Ruft alle gespeicherten Backups auf |
| `/tutorial` | Teleportiert dich zum Tutorial |
| `/reset` | Resettet deinen Plot |
| `/hdb` | Öffnet die HeadDatabase |