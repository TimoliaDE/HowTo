All commands which you can use on the server are listed below.
Variables that are marked with `<>` are needed, those marked with `[]` are optional.

## 1 - General commands
You can use these commands globally at any time.

| Command | Description |
| ------ | -------- |
| `/achievements`, `/ach`         | Lists an overview of all achievements |
| `/bannotify`                    | Deactivate notifications concerning your ban days |
| `/champ`, `/championship`       | Shows information about Timolia Champ |
| `/games`                        | Teleports you to the games servers |
| `/help`                         | Shows the most important information about Timolia |
| `/hub`, `/lobby`                | Teleports you back to the hub |
| `/joinme`                       | Opens the JoinMe-menu, e.g. to create a JoinMe |
| `/jointeam <Team-Farbe>`, `/team`| Joins a team in Castles, Brainbow and Mineception |
| `/lang <language>`              | Select your language |
| `/lookup <player>`, `/lu`       | Shows login information about a player |
| `/mail`                         | Opens the menu of your mails |
| `/msg`                          | Allows msg's from friends only, no one or everyone |
| `/msg <player>`, `/m`           | Schreibe mit einem Spieler im Privatchat |
| `/present <player> <Betrag> [Nachricht]`, `/gift`, `/donate` | Allows you to give away pixel during Christmastime |
| `/quickjoin <game mode>`        | Joins a game mode via command |
| `/rank`                         | Shows your current ingame rank and its duration |
| `/register <e-mail>`            | Register on our webseite |
| `/servername`                   | Shows your current server (alternatively: TAB) |
| `/stats [1,3,30,all]`           | Shows your stats in most of the game modes |
| `/teamspeak`, `/ts`             | Shows the TeamSpeak-IP and lets you verify and manage your identities |
| `/ticket <issue>`               | Creates a ticket |
| `/tickets`                      | Opens an overview of your tickets |
| `/top`                          | Shows the top 10 players of the past 30 days in a certain game mode |
| `/tutorial`                     | Stats a tutorial (not in all game modes available) |
| `/vote <number>`                | Vote for a map in a game mode |
**[Premium](/ranks/premium/) only**:
| `/togglerank`, `/tr`            | Be displayed as a usual player |
**[<span class='pro'>Pro+</span>](/ranks/premium/) only**:
| `/ptime <day/night/midnight/sunrise/noon/afternoon/sunset/reset/hh:mm>` | Switch the time for yourself |
| `/pweather <sun/rain/reset>`    | Switch the weather for yourself |
**[<span class= 'expert'>Expert</span>](/ranks/premium/) only**:
| `/giftpremium <player>`        | Give away 3 days of Pro to any player (every 30 days) |
**[<span class='mvp'>VIP</span>](/ranks/youtube/) only**:
| `/nick`                         | Allows you to nick yourself |
| `/unnick`                       | Allows you to unnick yourself |
**[<span class='youtuber'>YouTuber</span>](/ranks/youtube/) only**:
| `/forcemap`                     | Force a certain map during a game with a voting system |
| `/giftpremium <player>`         | Give away 3 days of Pro to any player (3 times per day) |
| `/nick`                         | Allows you to nick yourself |
| `/startgame`                    | Starts a game |
| `/unnick`                       | Allows you to unnick yourself |
| `/vanish`, `/v`                 | Allows you to vanish yourself in 1vs1, JumpWorld and in other lobbies |


### Report system

| Command | Description |
| ------ | -------- |
| `/report <player>`, `/rp`       | Lets you choose a category and creates a report |
| `/reportbugusing <player> <description>` | Creates a report about bugusing |
| `/reportevidence <player> <evidence>` | Creates a report with evidence |
| `/reportinfo <ID>`              | Shows all information about a report |
| `/reportjnr <ID>`               | Creates a report about a Jump and Run in JumpWorld |
| `/reports [page]`              | Opens an overview of your reports |
| `/reportstats`                  | Shows the success rate of all of your created reports |

### Lobby
| Command | Description |
| ------ | -------- |
| `/fixkickvalue`, `/fixkv`       | Resetz your kick value. Information about how the kick system works is available [<strong>here</strong>](/faq/#wie-funktioniert-das-kick-system) |
| `/myspawn`                      | Sets your own individual spawn point in the lobby |
| `/resetmyspawn`                 | Resets your own individual spawn point in the lobby |
| `/stats <player>`               | Shows the stats of a player |
| `/stats <player> <player>...`   | Allows you to compare the stats of multiple players |
| `/spawn`                        | Teleports you back to the spawn of the hub |
| `/sync {0, 1, 2...]`, `/armorsync` | Synchronizes the color switching armor from the PixelShop |

### Homes
| Command | Description |
| ------ | -------- |
| `/homes`                        | Shows a list of your homes |
| `/delhome <name>`               | Deletes a home |
| `/sethome <name>`               | Sets a home |
| `/sethome <name> -f`            | Overwrites an existing home |

### Friend system

Instead of `/friend` you can also use `/f`.

| Command | Description |
| ------ | -------- |
| `/friend <player>`, `/friend add` | Sends or accepts a friend request |
| `/friend broadcast <message>`     | Sends a broadcast to all currently online friends |
| `/friend deny <player>`           | Denies a friend request |
| `/friend ignore <player>`         | An ignored player cannot send you any friend requests |
| `/friend list, /friends`          | Shows a list of all your friends |
| `/friend remove <player>`, `/friend rem`, `/friend delete`, `/friend del` | Removes a player out of your friend list |
| `/friend requests`, `/friend req` | Lists open friend requests |
| `/friend teleport <player>`, `/friend tp` | Teleports you to a friend |
| `/friend toggle`                  | Shows an overview of all settings |
| `/friends online`                 | Shows all currently online friends |

### Party system

| Command | Description |
| ------ | -------- |
| `/party`                        | Creates a new party or opens the party management |
| `/party demote <player>`        | Demotes a moderator to player |
| `/party help`                   | Shows all commands of the party system |
| `/party invite <player>`        | Invites a player into your party |
| `/party join <player>`          | Joins a party |
| `/party leave`                  | Leave the current party |
| `/party promote <player>`       | Promotes a player to moderator |
| `/party togglechat`             | Switches between party chat and public chat |

### Two-factor authentication

With two-factor authentication, you can prevent third parties from accessing your account on Timolia.
When logging in, you are asked for a code which is regenerated every 30 seconds by your smartphone.
Therefore, only people who have physical access to your phone can verify.
In case you lose your phone, you can log in using backup codes, which you receive when settings up 2fa.

| Command | Description |
| ------ | -------- |
| `/2fa`                          | Shows all commands of the two-factor authentication |
| `/2fa buc`                      | Lists all unused backup codes |
| `/2fa disable`                  | Deactivates the two-factor authentication |
| `/2fa logout`                   | Kicks you from the network and logs you off securely |
| `/2fa setup`                    | Sets up the two-factor authentication |

### Community-Discord

The following list contains commands you can use with the <strong>Timolia Bot</strong>.

| Command | Channel | Description |
| ------ | -------------- | -------- |
| `/bug <description>` | Timolia Bot (private chat) and [#bug-melden](https://discordapp.com/channels/407554118887014402/413638656264503317) | Reports a bug to the Timolia Team |
| `/channel invite <@name>` or `/channel remove <@name>` | Timolia Bot (private chat) and private channel | Invites/removes a user to/from your private channel |
| `/help` | Timolia Bot (private chat) | Lists all available commands |
| `/help <command>` oder `/<command> help` | Timolia Bot (private chat) | Shows information about the provided command |
| `/idea <idea>` | Only in [#ideen](https://discordapp.com/channels/407554118887014402/413615776399097866) and [#discord-ideen](https://discordapp.com/channels/407554118887014402/569594169228656656) | The Bot posts your idea and adds a positive and a newgative reaction |
| `/lookup <@name>` | Timolia Bot (private chat) | Lists information about a user |
| `/quote <message ID>/<message URL>` | Only in channels | Quotes the provided message |
| `/rank` | Timolia Bot (private chat) and [#ranks](https://discordapp.com/channels/407554118887014402/548160287891783690) | Displays information about your rank |
| `/stats [@name]` | Timolia Bot (private chat) | Displays your or another users Discord stats |
| `/stats all` | Timolia Bot (private chat) | Displays server stats |
| `/support <description>` | Timolia Bot (private chat) and [#support](https://discordapp.com/channels/407554118887014402/413594798906408960) | Creates a support channel for you with the provided issue |
| `/top` | Timolia Bot (private chat) and [#ranks](https://discordapp.com/channels/407554118887014402/548160287891783690)| Displays the top 10 of all users |
| `/unverify` | Timolia Bot (private chat) | Remove the link of your Minecraft account with your Discord account |
| `/verify <in-game name>` | Timolia Bot (private chat) | Links your Discord account to your Minecraft account and verifies you |

## 2 - Commands of each game modes

### 1vs1

| Command | Description |
| ------ | -------- |
| `/challenge <player>`, `/c`     | Duel a player |
| `/compare <name> <name>`        | Shows stats of two players |
| `/endmatch`                     | The fight ends after one minute. The player closest to the middle for the longest time wins |
| `/importkit <number>`           | Imports one of your kits in the kit area |
| `/join <name>`                  | Joins a tournament |
| `/join <name> <password>`       | Joins a password protected tournament |
| `/kit`, `/k`                    | Opens the currently selected kit in your inventory |
| `/kit <name(:1/2/3/4/5)>`       | Selects the kit of another player |
| `/kitinfo`                      | Shows advanced information about the currently selected kit |
| `/kits`                         | Lists all kits created by Timolia |
| `/lastinv <player>`, `/inv`     | Shows the last inventory of a player |
| `/leave`, `/l`                  | Revoke a challenge |
| `/liveinv <player>`, `/liveinventory` | Shows the current inventory of a player |
| `/matchinfo`                    | Shows information about the current fight |
| `/queue`, `/q`                  | Adds you to the queue |
| `/rankinfo`, `/ranginfo`        | Shows information about your current rank |
| `/season [number]`              | Shows the kit of the current or provided season, leaderboards, your points and ranking |
| `/settings`                     | Opens the settings |
| `/spectate <player>`, `/spec`   | Spectate the fight of a player |
| `/stats`                        | Shows your stats |
| `/stats <name>`                 | Shows the stats of a player |
| `/statsmenu [name]`             | Opens the stats menu |
| `/surrender`                    | Kill yourself and end the match early |
| `/t`                            | Shows information about the tournament |
| `/team accept <name>`           | Joins a team |
| `/team invite <name>`           | Invites a player into your team |
| `/team kick <name>`             | Kicks a player out of your team |
| `/team leave <name>`            | Leaves a team |
| `/winstreak`, `/streak`         | Shows your current win streak |
| `/xp <Level>`                   | Sets an XP-level for your kit |
**[Premium](/ranks/premium/) only**:
| `/bestofx <Spieler> <Anzahl>`   | Duel a player (best of 3/5) |
| `/create [Passwort]`            | Creates a tournament (optionally with a password) |
| `/modify`                       | Creates the tournament settings |
| `/near <kit> [name]`            | Shows the distance to the next rank for each kit ranking |
| `/start [Zeit]`                 | Starts your tournament |
**[<span class='pro'>Pro+</span>](/ranks/premium/) only**:
| `/hat`                          | Sets the currently held item as the helmet of your kit |
| `/rankinfo`                     | Displays information about your current global rank |
| `/roadToKD <KD-Ziel>`, `/roadToWL <KD-Ziel>`  | Displays the number of games to win to reach the K/D |
| `/team setcolor`                | Dyes your name according to the provided color |

### Arcade

| Command | Description |
| ------ | -------- |
| `/join <player>`                | Joined a public tournament |
| `/last`                         | Shows the recently played game modes |
| `/leave`                        | Leaves a tournament |
| `/rot`                          | Shows the game rotation |
**[Premium](/ranks/premium/) only**:
| `/create`                       | Creates a tournament |
| `/invite <player>`              | Invites a player to your tournament |

### Bauwelt
| Command | Description |
| ------ | -------- |
| `/backup [page]`  | Lists all saved backups |
| `/bauwelt`        | Lists all commands of the Bauwelt |
| `/finish`         | Submit your finished plot |
| `/reset`          | Resets your plot |
| `/save`           | Saves your plot |
| `/spawn`          | Teleports you to the spawn of the Bauwelt |
| `/tutorial`       | Teleports you to the tutorial |

### Castles
| Command | Description |
| ------ | -------- |
| `/jointeam <team color>`, `/team` | Joins a team |
| `/kill`                           | Kills yourself |

### JumpWorld

| Command | Description |
| ------ | -------- |
| `/b`                                | Opens the build info menu |
| `/checkpoint`, `/fall`, `/kill`     | Teleports you back to the last checkpoint |
| `/duel accept <player>`             | Accept an invitation to a duel |
| `/duel invite <player>`             | Invites a player to a duel |
| `/duel kick <player>`               | Kicks a player out of the duel |
| `/duel leave <player>`              | Leaves the duel |
| `/enter <ID>`, `/e <ID>`            | Join a specific Jump and Run |
| `/join <player>`                    | Joins the Jump and Run which [player] is currently playing |
| `/jump`                             | Toggles between jump and build mode |
| `/kit`                              | Gives you thed efault items in build mode |
| `/leave`, `/l`                      | Leave the current Jump and Run |
| `/setblock`, `/sb`                  | Places the currently held block underneath you |
| `/setstart`                         | Sets the spawn point of your Jump and Run |
| `/top <ID>`                         | Shows the leaderboard of a specific Jump and Run (ordered by time) |
| `/top <ID> -f`                      | Shows the leaderboard of a specific Jump and Run (ordered by fails) |
**[Premium](/ranks/premium/) only**:
| `/multibuild <3,6>`,<br>`/mb <3,6>` | You can place up to 3 (<span class="pro">Pro</span> and higher) or up to 6 (<span class="mvp">MVP+</span> and higher) blocks at the same time |
**[<span class='mvp'>MVP</span>](/ranks/premium/) only**:
| `/skull [name]`                     | Gives you a player head |

### UHC
| Befehl | Funktion |
| ------ | -------- |
| `/backpack`, `/bp`                         | Opens the shared inventory in team UHCs |
| `/config`                                  | Lists the current configuration of the UHC |
| `/coordinates`, `/coords`                  | Sends a message to your team partners containing your coordinates |
| `/dragons <Spieler>`                       | With the Dragons scenario being active, the host of the UHC can spawn an end dragon at the players location |
| `/fix`                                     | This allows you to reload all players |
| `/helpop`                                  | With this you can always ask the team questions about the current UHC |
| `/invite <Spieler>`                        | With this you can invite players to your team at team UHCs |
| `/inviteaccept <Spieler>`                  | With this you accept team invitations at team UHCs |
| `/scenarios`, `/scn`, `/uhc`               | Shows you the active scenarios |
| `/showhealth <Spieler>`, `/h <Spieler>`    | Displays the lives of the specified player |
| `/topkills`, `/top`, `/tk`                 | Shows the player(s) with the most kills |
