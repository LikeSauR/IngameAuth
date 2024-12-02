package com.like_it_smp.ingame_auth;

import org.bukkit.entity.*;

import java.net.*;

public class User {
    public static User from(Player player) {
        throw new UnsupportedOperationException();
    }

    public IpTrust trustToIp(InetAddress inetAddress) {
        throw new UnsupportedOperationException();
    }

    public boolean automaticallyTrustsIps() {
        throw new UnsupportedOperationException();
    }

    public enum IpTrust {
        NEVER,
        UNVERIFIED,
        VERIFIED
    }
}
