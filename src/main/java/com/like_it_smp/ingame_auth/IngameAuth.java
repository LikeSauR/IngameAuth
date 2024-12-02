package com.like_it_smp.ingame_auth;

import com.like_it_smp.ingame_auth.player_processes.*;
import org.bukkit.plugin.java.*;

import static com.google.common.base.Preconditions.*;

public final class IngameAuth extends JavaPlugin {
    private static IngameAuth pluginInstance;
    private byte initProcessDirection;

    @Override
    public void onEnable() {
        checkState(pluginInstance == null);
        pluginInstance = this;

        initProcessDirection = 1;
        initializeSubPlugins();
        initProcessDirection = 0;
    }

    private void initializeSubPlugins() {
        AuthProcessInitiator.initialize();
    }

    @Override
    public void onDisable() {
        checkState(pluginInstance == this);

        initProcessDirection = -1;
        uninitializeSubPlugins();
        initProcessDirection = 0;

        pluginInstance = null;
    }

    private static void uninitializeSubPlugins() {
        AuthProcessInitiator.uninitialize();
    }

    public static IngameAuth plugin() {
        return pluginInstance;
    }

    public static boolean isInitializing() {
        return pluginInstance != null && pluginInstance.initProcessDirection == 1;
    }

    public static boolean isUninitializing() {
        return pluginInstance != null && pluginInstance.initProcessDirection == -1;
    }
}
