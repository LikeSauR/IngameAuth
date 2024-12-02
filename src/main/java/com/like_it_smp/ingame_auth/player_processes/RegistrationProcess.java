package com.like_it_smp.ingame_auth.player_processes;

import com.like_it_smp.ingame_auth.*;
import com.like_it_smp.util.player_processes.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;

import static com.google.common.base.Preconditions.*;
import static net.kyori.adventure.text.Component.*;

public class RegistrationProcess extends PlayerBookInputProcess {
    private final User.Lock userLock;

    public RegistrationProcess(Player player) {
        super(player);
        checkState(User.from(player) == null);
        userLock = new User.Lock(player);
    }

    @Override
    protected void setupInputField(BookMeta inputField) {
        inputField.displayName(text("§2Create Your Password Here"));
    }

    @Override
    protected void onPlayerEnteredText(BookMeta inputField) {
        player.sendMessage("§2§bWelcome!  §r§7§oHopefully, you memorized your password.");
        userLock.unlock();
        endProcess();
    }

    @Override
    protected void onPlayerTriedCancellingThisProcess() { }
}
