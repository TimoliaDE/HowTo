Hier findest du alle Commands ausführlich aufgelistet, die du auf dem Server benutzen kannst.
Variablen, die mit <> markiert sind werden benötigt, mit [] markierte Attribute sind optional.

## 1 - Allgemeine Befehle
Diese Befehle sind global nutzbar und stehen dir jederzeit zur Verfügung.

| Befehl | Funktion |
| ------ | -------- |
| `/hub`, `/lobby`   | Teleportiert dich in die Lobby |
| `/games` | Teleportiert dich zu den Games-Servern |
| `/city` | Teleportiert dich zu den CityBuild-Servern |
| `/lookup <Spieler>`, `/lu` | Zeigt dir LogIn-Informationen über einen Spieler |
| `/top` | Zeigt dir die Top 10 Spieler in einem Spielmodus an |
| `/vote <Zahl>` | Votet für eine Map in einem Spielmodus |
| `/stats <Spieler>` | Zeigt dir die Stats eines Spielers an |
| `/stats <Spieler> <Spieler>...` | Ermöglicht dir die Stats von mehreren Spielern zu vergleichen |
| `/spawn` | Teleportiert dich zurück zum Spawn vom Hub |
| `/register <EMail>` | Registrierte dich für die Website |
| `/lang <Sprache>` | Verändere deine Spracheinstellung |
<span style="color:#4C0B5F">YouTuber</span> only:
| `/nick` | Verwende das Nick-Tool (auch für <span style="color:#F99500">Pro+</span>) |
| `/forcemap` | Erzwinge bei einem Spiel mit Voting-System eine bestimmte Map |

### Reportsystem

| Befehl | Funktion |
| ------ | -------- |
| `/report <Spieler> <Beweislink>` | Erstellt einen Report mit Beweis |
| `/livereport <Spieler> <Grund>` | Erstellt einen Livereport |
| `/chatreport <Spieler> [Grund]` | Erstellt einen Chatreprt |
| `/reports [-c]` | Öffnet eine Übersicht über deine Reports |
| `/reportstats` | Zeigt dir deine Reportwahrscheinlichkeit an |

### Freundesystem

| Befehl | Funktion |
| ------ | -------- |
| `/friends` | Zeigt deine Freunde an |
| `/friend <Spieler>` | Sendet dem Spieler eine Freundschaftsanfrage |
| `/friend requests` | Zeigt deine offenen Anfragen an |
| `/friend delete <Spieler>` | Beendet die Freundschaft mit einem Spieler |
| `/friend deny <Spieler>` | Lehnt eine Freundschaftsanfrage ab |
| `/friend toggle` | Schaltet Freundschaftsanfragen aus |
| `/friend list` | Zeigt deine Freundesliste an |
| `/friends online` | Zeigt deine Freunde an, die gerade online sind |
| `/friend tp <Spieler>` | Teleportiert dich zu einem Freund |

### Partysystem

| Befehl | Funktion |
| ------ | -------- |
| `/party` | Erstellt eine neue Party oder öffnet die Partyverwaltung |
| `/party join <Spieler>` | Trete einer Party bei |
| `/party invite <Spieler>` | Lädt einen Spieler in deine Party ein |
| `/party leave` | Verlasse die aktuelle Party |
| `/party togglechat` | Schaltet zwischen Party-Chat und globalem Chat um |
| `/party promote <Spieler>` | Ernennt einen Spieler zum Moderator |
| `/party demote <Spieler>` | Degradiert einen Spieler zum Mitglied |

## 2 - Befehle der einzelnen Modi

### 1vs1

| Befehl | Funktion |
| ------ | -------- |
| `/kit`, `/k`   | Wählt dein Kit aus |
| `/kit <Name(:1/2/3/4/5)>` | Wählt das Kit eines anderen Spielers aus |
| `/kits` | Listet dir alle von Timolia erstellten Kits auf |
| `/team add <Name>` | Lädt einen Spieler in dein Team ein |
| `/team revoke <Name>` | Zieht eine Teameinladung zurück |
| `/team kick <Name>` | Kickt einen Spieler aus deinem Team |
| `/team setcolor <Farbe>` | Färbt euren Namen entsprechend der gewählten Farbe |
| `/colors` | Zeigt dir die verfügbaren Teamfarben an |
| `/challenge <Spieler>`, `/c` | Fordert einen Spieler zu einem Duell heraus |
| `/leave`, `/l` | Zieht eine Herausforderung zurück |
| `/endmatch`  | Der Kampf wird nach einer Minute mit Entscheidung durch die Mitte beendet |
| `/surrender` | Man tötet sich selbst und beendet den Kampf vorzeitig |
| `/spectate <Spieler>`, `/spec` | Lässt dich den Kampf eines Spieler beobachten |
| `/stats` | Zeigt dir deine Stats an |
| `/stats <Name>` | Zeigt dir die Stats eines Spielers an |
| `/join <Name>` | Tritt einem Turnier bei |
| `/join <Name> <Passwort>` | Tritt einem passwortgeschützten Turnier bei |
| `/t` | Zeigt die Turnier Informationen |
<span style="color:#F99500">Pro</span> und <span style="color:#00F9EC">Expert</span> only:
| `/create <Passwort>` | Erstellt ein Turnier (optional mit einem Passwort) |
| `/modify` | bearbeitet die Turniereinstellungen |
| `/start <1-60>` | Startet dein Turnier nach 1-60 Sekunden |

### Arcade

| Befehl | Funktion |
| ------ | -------- |
| `/rot` | Zeigt die Spielrotation |
| `/last` | Zeigt die zuletzt gespielten Spiele |
| `/join <Spieler>` | Betrete ein öffentliches Turnier |
<span style="color:#F99500">Pro</span> und <span style="color:#00F9EC">Expert</span> only:
| `/create` | Erstellt ein Turnier |
| `/invite <Spieler>` | Lädt einen Spieler in dein Turnier ein |

### JumpWorld

| Befehl | Funktion |
| ------ | -------- |
| `/enter <ID>`, `/e` | Betrete einen bestimmtes Jump 'n Run |
| `/editparcour`, `/edit [Slot]`| Editiert das Jump 'n Run auf einem bestimmten Slot |
| `/saveparcour` | Speichert dein aktuelles Jump 'n Run |
| `/leave`, `/l` | Verlässt das aktuelle Jump 'n Run |
| `/setstart` | Setzt den Startpunkt deines Jump 'n Runs |
| `/setend` | Setzt den Endpunkt deines Jump 'n Runs |
| `/checkpoint`, `/fall`, `/kill` | Teleportiert dich zurück zum letzten Checkpoint |
| `/duel <Spieler>` | Lädt einen Spieler in ein Duell ein |
| `/duel accept <Spieler>` | Nimmt die Einladung in ein Duell an |
| `/duel leave <Spieler>` | Verlässt ein Duell |
| `/setblock` | Platziert den Block in deiner Hand unter dir |
| `/jump` | Lässt dich dein Jump'n'Run testen |
| `/b` | Öffnet das Bau-Info-Menü |
| `/join <Name>` | Betritt das Jump'n'Run, auf dem sich [Spieler] gerade befindet |
| `/top <ID>` | Zeigt die Top-Zeiten des Jump'n'Runs mit der ID [id] an |
| `/top <ID> -f` | Zeigt die schlechtesten Zeiten für ein Jump'n'Run an |

## 3 - CityBuild

### Allgemeine Befehle

| Befehl | Funktion |
| ------ | -------- |
| `/infoboard` | Öffnet das MEnü des Scoreboards |
| `/suicude` | Tötet sich selbst |
| `/pay <Spieler> <Betrag>` | Überweist einem anderen Spieler Geld |
| `/money` od. `/balance` | Zeigt deinen Kontostand |
| `/ticket <Anliegen>` | Erstellt ein Ticket |
| `/mail <read/send/clear>` | Mails lesen/senden/löschen |
| `$<Nachricht>` | Schreibe im Handelschat |
| `/shoptp` | Teleportiert dich in unterschiedliche Shopwelten |
<span style="color:#F99500">Pro</span> und <span style="color:#00F9EC">Expert</span> only:
| `/ptime <day/night>` | Zeit für sich selbst umstellen |
| `/pweather <sun,rain>` | Wetter für sich selbst umstellen |
| `/craft` od. `/workbench` | Craftingfeld aufrufen |
| `/hat` | Item in der Hand auf den Kopf setzen |
| `/enderchest` | Enderchest aufrufen |
| `/recipe <ID>` | Craftingrezept aufrufen |

### Homes und Grundstücke

| Befehl | Funktion |
| ------ | -------- |
| `/homes` od. `/home` | Zeigt eine Liste deiner Homepunkte |
| `/sethome <Name>` | Setzt ein Home |
| `/delhome <Name>` | Löscht ein Home |
| `/rg` | Zeigt dir eine Übersicht aller Regionsbefehle |
| `/rg addmember <GS-ID> <Spieler>` | Füg ein Member auf dein Grundstück hinzu |
| `/rg removemember <GS-ID> <Spieler>` | Entfernt ein Member von deinem Grunstück |
| `/rg i` | Zeigt die ID deines Grunstücks |

### Farmwelt 

| Befehl | Funktion |
| ------ | -------- |
| `/TCBuyFarm` | Farmgrunstück kaufen |
| `/TCFarm buy` | Mobspawning kaufen |
| `/TCFarm on` | Mobspawning aktivieren |
| `/TCFarm off` | Mobspawning deaktivieren |
| `/TPFarm <ID> <accept/deny/toggle>` | Zum Farmgrundstück eines Spielers porten |