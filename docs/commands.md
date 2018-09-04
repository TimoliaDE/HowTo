Hier findest du alle Commands ausführlich aufgelistet, die du auf dem Server benutzen kannst.
Variablen, die mit <> markiert sind, werden benötigt, mit [] markierte Attribute sind optional.

## 1 - Allgemeine Befehle
Diese Befehle sind global nutzbar und stehen dir jederzeit zur Verfügung.

| Befehl | Funktion |
| ------ | -------- |
| `/hub`, `/lobby`   | Teleportiert dich in die Lobby |
| `/games` | Teleportiert dich zu den Games-Servern |
| `/city` | Teleportiert dich zu den CityBuild-Servern |
| `/msg <Spieler>` | Schreibe mit einem Spieler im Privatchat |
| `/lookup <Spieler>`, `/lu` | Zeigt dir LogIn-Informationen über einen Spieler |
| `/pro`, `/expert` | Zeigt die restliche Premium-Zeit an |
| `/top` | Zeigt dir die Top 10 Spieler in einem Spielmodus an |
| `/achievements` | Listet eine Übersicht aller Achievements auf |
| `/vote <Zahl>` | Votet für eine Map in einem Spielmodus |
| `/stats <Spieler>` | Zeigt dir die Stats eines Spielers an |
| `/near` | Zeigt dir die Spieler, die sich direkt über und unter dir in der Punktewertung eines Modus befinden |
| `/stats <Spieler> <Spieler>...` | Ermöglicht es dir, die Stats von mehreren Spielern zu vergleichen |
| `/spawn` | Teleportiert dich zurück zum Spawn vom Hub |
| `/tutorial` | Starte ein Tutorial (nicht in allen Modi verfügbar) |
| `/register <E-Mail>` | Registriert dich für die Webseite |
| `/togglerank`, `/tr` | Werde in BrainBow, 4rena, Splun, DNA, InTime u. TSpiele als normaler Spieler angezeigt |
| `/lang <Sprache>` | Ändere deine Sprache |
| `/bannotify` | Deaktiviere Nofitikationen zu deinen Banntagen |
<span style="color:#4C0B5F">YouTuber</span> und <span style="color:#F99500">Pro+</span> only:
| `/forcemap` | Erzwinge bei einem Spiel mit Voting-System eine bestimmte Map |
| `/startgame [Sekunden]` | Starte ein Spiel |
| `/abortstart` | Brich den Start eines Spiels ab |

### Reportsystem

| Befehl | Funktion |
| ------ | -------- |
| `/report <Spieler>` | Erstellt nach Auswählen der Kategorie einen Report |
| `/reportjnr <ID>` | Erstellt einen Report über ein Jump and Run in Jump World |
| `/reportbugusing <Spieler> <Beschreibung>` | Erstellt einen Bugreport |
| `/reportevidence <Spieler> <Beweis>` | Erstellt einen Report mit Beweis |
| `/reportinfo <ID>` | Zeigt dir alle Infos über einen Report an |
| `/reports [Seite]` | Öffnet eine Übersicht über deine Reports |
| `/reportstats` | Zeigt dir die Erfolgsquoten deiner erstellten Reports an |

### Lobby
| Befehl | Funktion |
| ------ | -------- |
| `/sync {0, 1, 2...]` | Synchronisiert die farbwechselnde Rüstung aus dem PixelShop|
| `/fixkv` | Setzt deine Kick-Value zurück. Wie das Kick-System funktioniert, kannst du [<strong>hier</strong> nachlesen](https://howto.timolia.de/faq/#wie-funtkioniert-das-kick-system-bei-vollen-lobbys)


### Freundesystem

| Befehl | Funktion |
| ------ | -------- |
| `/friend` oder `/f` | Zeigt die Hilfe an |
| `/friends` | Zeigt deine Freunde an |
| `/friends online` | Zeigt deine Freunde an, die gerade online sind |
| `/friend <Spieler>` | Sendet dem Spieler eine Freundschaftsanfrage |
| `/friend add <Spieler>` | Sendet dem Spieler eine Freundschaftsanfrage |
| `/friend remove <Spieler>` | Beendet die Freundschaft mit einem Spieler |
| `/friend ignore <Spieler>` | Der ignorierte Spieler kann dir keine Freundschaftsanfrage mehr schicken |
| `/friend deny <Spieler>` | Lehnt eine Freundschaftsanfrage ab |
| `/friend list` | Zeigt deine Freundesliste an |
| `/friend requests` | Listet unbeantwortete Freundschaftsanfragen auf |
| `/friend toggle` | Schaltet Freundschaftsanfragen aus |
| `/friend tp <Spieler>` | Teleportiert dich zu einem Freund |
| `/friend broadcast <Nachricht>` | Schickt einen Broadcast an alle Freunde, die derzeit online sind |

### Partysystem

| Befehl | Funktion |
| ------ | -------- |
| `/party` | Erstellt eine neue Party oder öffnet die Partyverwaltung |
| `/party join <Spieler>` | Tritt einer Party bei |
| `/party invite <Spieler>` | Lädt einen Spieler in deine Party ein |
| `/party leave` | Verlasse die aktuelle Party |
| `/party togglechat` | Schaltet zwischen Party-Chat und normalem Chat um |
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
| `/challenge <Spieler>`, `/c` | Fordert einen Spieler zu einem Duell heraus |
| `/leave`, `/l` | Zieht eine Herausforderung zurück |
| `/endmatch`  | Der Kampf wird nach einer Minute mit Entscheidung durch die Mitte beendet |
| `/surrender` | Man tötet sich selbst und beendet den Kampf vorzeitig |
| `/spectate <Spieler>`, `/spec` | Lässt dich den Kampf eines Spieler beobachten |
| `/stats` | Zeigt dir deine Stats an |
| `/stats <Name>` | Zeigt dir die Stats eines Spielers an |
| `/top <Kit>` | Zeigt die Rangliste eines Competitive-Kits an |
| `/winstreak` | Zeigt deine aktuelle Winstreak |
| `/join <Name>` | Tritt einem Turnier bei |
| `/join <Name> <Passwort>` | Tritt einem passwortgeschützten Turnier bei |
| `/t` | Zeigt die Turnier Informationen |
| `/xp <Level>` | Setzt ein XP-Level für dein Kit |
| `/matchinfo` | Zeigt Informationen über den aktuellen Kampf |
| `/queue` | Fügt dich zur Warteschlange hinzu |
<span style="color:#F99500">Pro</span> und <span style="color:#00F9EC">Expert</span> only:
| `/hat` | Setzt das Item in deiner Hand als den Helm deines Kits |
| `/create <Passwort>` | Erstellt ein Turnier (optional mit einem Passwort) |
| `/modify` | bearbeitet die Turniereinstellungen |
| `/start [Zeit]` | Startet dein Turnier |
| `/team setcolor` | Färbt euren Namen entsprechend der gewählten Farbe |

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
| `/sb` | Öffnet das Menü des Scoreboards |
| `/rezepte` | Zeigt dir zu jedem Item das Craftingrezept an |
| `/timazon` oder `/tbay` | Öffnet ein Menü zum Items bestellen |
| `/firma` oder `/company` | Öffnet das Firmenmenü |
| `/suicide` | Tötet sich selbst |
| `/pay <Spieler> <Betrag>` | Überweist einem anderen Spieler Geld |
| `/money` | Zeigt deinen Kontostand |
| `/ticket <Anliegen>` | Erstellt ein Ticket |
| `/mails` | Öffnet das Menü deiner Mails |
| `/mail <read/send/clear>` | Mails lesen/senden/löschen |
| `$<Nachricht>` | Schreibe im Handelschat |
| `/ch join handel` | Wählt den Handelschat als Standardchannel aus |
| `/ch join global` | Wechselt in den default Citychannel |
| `/tickets` | Öffnet eine Übersicht über deine Tickets |
| `! <Nachricht>` | Schreibe im Firmenchat |
| `/trg` | Öffnet das Interface des Grundstücks |
| `/skins` | Öffnet eine Übersicht deiner Kostüme |
<span style="color:#F99500">Pro</span> und <span style="color:#00F9EC">Expert</span> only:
| `/ptime <day/night/midnight/sunrise/noon/afternoon/sunset/reset>` | Zeit für sich selbst umstellen |
| `/pweather <sun/rain/reset>` | Wetter für sich selbst umstellen |
| `/craft` od. `/workbench` | Craftingfeld aufrufen |
| `/hat` | Item in der Hand auf den Kopf setzen |
| `/enderchest` | Enderchest aufrufen |
| `/shulkerbox` od. `/box` | Öffnet die Shulkerbox, ohne sie abstellen zu müssen |


### Homes und Grundstücke

| Befehl | Funktion |
| ------ | -------- |
| `/homes`| Zeigt eine Liste deiner Homepunkte |
| `/sethome <Name>` | Setzt ein Home |
| `/sethome <Name> -f` | Überschreibt einen vorhandenen Home |
| `/delhome <Name>` | Löscht ein Home |

Um Member auf seinem Grundstück zu protecten oder Flags zu ändern, muss man auf das Regionsschild klicken.


### Teleportieren zu anderen Personen (Taxi / TPA) 

Mit dem Taxi kommst du direkt zu der gleichen Position wie dein Freund.
Für User kostet ein Taxi 100T, für Pros 75T und für Experts 50T

| Befehl | Funktion |
| ------ | -------- |
| `/tpa <Name>` | Stellt dem Spieler eine Anfrage |
| `/tpaccept <Name>` | Nimmt die Anfrage des Spielers an |
| `/tpa toggle` | Aktviert oder deaktiviert TPA-Anfragen für dich |