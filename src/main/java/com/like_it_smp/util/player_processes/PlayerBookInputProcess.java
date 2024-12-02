package com.like_it_smp.util.player_processes;

import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;

public abstract class PlayerBookInputProcess {
    protected final Player player;

    public PlayerBookInputProcess(Player player) {
        throw new UnsupportedOperationException();
    }

    protected void endProcess() {
        throw new UnsupportedOperationException();
    }

    protected abstract void setupInputField(BookMeta inputField);

    protected abstract void onPlayerEnteredText(BookMeta inputField);

    protected abstract void onPlayerTriedCancellingThisProcess();
}
