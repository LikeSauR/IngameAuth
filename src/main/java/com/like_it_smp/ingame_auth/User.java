package com.like_it_smp.ingame_auth;

import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;

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

    public Lock enlock() {
        throw new UnsupportedOperationException();
    }

    public boolean passwordMatches(BookMeta inputField) {
        throw new UnsupportedOperationException();
    }

    public enum IpTrust {
        NEVER,
        UNVERIFIED,
        VERIFIED
    }

    public static final class Lock {
        public Lock(Player player) {
            throw new UnsupportedOperationException();
        }

        public void unlock() {
            throw new UnsupportedOperationException();
        }
    }
}
