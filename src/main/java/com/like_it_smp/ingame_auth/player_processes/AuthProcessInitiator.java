package com.like_it_smp.ingame_auth.player_processes;

import com.like_it_smp.ingame_auth.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import java.net.*;

import static com.google.common.base.Preconditions.*;
import static java.util.Objects.*;
import static org.bukkit.Bukkit.*;
import static org.bukkit.event.EventPriority.*;

public final class AuthProcessInitiator implements Listener {
    private static AuthProcessInitiator instance;

    private AuthProcessInitiator() { }

    @EventHandler(priority = LOW)
    private void handle(PlayerJoinEvent event) {
        var player = event.getPlayer();
        var user = User.from(player);

        if (user == null) {
            new RegistrationProcess(player);
            return;
        }

        switch (user.trustToIp(ipOf(player))) {
            case null -> {
                IngameAuth.plugin().getLogger().warning(player.getName() + " tried to join from an unrecorded ip address. Prompting them for password.");
                if (user.automaticallyTrustsIps()) {
                    player.sendMessage("§7§oVerifying this ip as trusted and won't ask for password here again.");
                }

                new AuthProcess(player);
            }
            case NEVER -> {
                IngameAuth.plugin().getLogger().warning(player.getName() + " tried to join from an ip address they never trust. Obviously prompting them for password.");
                player.sendMessage("§7§oPrompting you for password because you commanded to never trust this ip.");

                new AuthProcess(player);
            }
            case VERIFIED -> {
                IngameAuth.plugin().getLogger().warning(player.getName() + " tried to join from an ip address they trust. Not prompting them for password.");
                player.sendMessage("§7§oNot prompting you for password because you commanded to trust this ip.");
                player.sendMessage("§2§lWelcome back!");
            }
            case UNVERIFIED -> {
                IngameAuth.plugin().getLogger().warning(player.getName() + " tried to join from an ip address they trust, but their password has changed since previous login from the ip. Prompting them for password.");
                player.sendMessage("§7§oYour password has changed after last time you logged in from this ip.\nRe-verify this ip again as trusted");

                new AuthProcess(player);
            }
        }
    }

    private static InetAddress ipOf(Player player) {
        var socket = player.getAddress();
        return requireNonNull(socket).getAddress();
    }

    public static void initialize() {
        checkState(instance == null);
        instance = new AuthProcessInitiator();
        getPluginManager().registerEvents(instance, IngameAuth.plugin());
    }

    public static void uninitialize() {
        checkState(instance != null);
        HandlerList.unregisterAll(instance);
        instance = null;
    }
}
