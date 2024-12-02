package com.like_it_smp.ingame_auth.player_processes;

import com.like_it_smp.ingame_auth.*;
import com.like_it_smp.util.player_processes.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;

import static net.kyori.adventure.text.Component.*;

final class AuthProcess extends PlayerBookInputProcess {
    private final User user;
    private final User.Lock userLock;

    public AuthProcess(Player player) {
        super(player);
        user = User.from(player);
        userLock = user.enlock();
    }

    @Override
    protected void setupInputField(BookMeta inputField) {
        inputField.displayName(text("§2Verify Your Password Here"));
    }

    @Override
    protected void onPlayerEnteredText(BookMeta inputField) {
        if (user.passwordMatches(inputField)) {
            userLock.unlock();
            player.sendMessage("§2§lWelcome!");
            endProcess();
        }
        else {
            player.sendMessage("§4§lIncorrect password. §7§oYou may try again.");
        }
    }

    @Override
    protected void onPlayerTriedCancellingThisProcess() { }
}
