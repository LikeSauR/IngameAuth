package com.like_it_smp.ingame_auth;

import com.like_it_smp.ingame_auth.player_processes.*;
import org.bukkit.plugin.java.JavaPlugin;

import static com.google.common.base.Preconditions.*;

public final class IngameAuth extends JavaPlugin {
    private static IngameAuth pluginInstance;

    @Override
    public void onEnable() {
        checkState(pluginInstance == null);
        pluginInstance = this;

        AuthProcessInitiator.initialize();
    }

    @Override
    public void onDisable() {
        checkState(pluginInstance == this);
        pluginInstance = null;

        AuthProcessInitiator.uninitialize();
    }

    public static IngameAuth plugin() {
        return pluginInstance;
    }
}
