package com.like_it_smp.ingame_auth;

import org.bukkit.plugin.java.JavaPlugin;

import static com.google.common.base.Preconditions.*;

public final class IngameAuth extends JavaPlugin {
    private static IngameAuth pluginInstance;

    @Override
    public void onEnable() {
        checkState(pluginInstance == null);
        pluginInstance = this;
    }

    @Override
    public void onDisable() {
        checkState(pluginInstance == this);
        pluginInstance = null;
    }

    public static IngameAuth plugin() {
        return pluginInstance;
    }
}
