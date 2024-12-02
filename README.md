# IngameAuth
is a Paper Plugin for Minecraft Java 1.21.1
which aims to protect players of pirated minecraft servers from identity theft.

The pirated servers
have `online-mode=false` in their `server.properties`,
and therefore are identifying the players simply by their names,
without verifying them with their licenses.
That allows for an exploit,
where pirate-players change the nickname to another person's in their launcher before booting the game,
and when they join the server,
it thinks of them as those people whose names have just been "stolen".

If people had individual passwords they have to enter when joining the server,
it would prevent others from exploiting that feature of pirated servers.
