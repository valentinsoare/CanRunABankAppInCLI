package org.clibankinjava.components.credentials;

import java.util.*;

public final class CheckUserAndPassword {
    private final Deque<UserName> usersRegistered;
    private final Map<UserName, Password> hashedPasswords;

    public CheckUserAndPassword() {
        this.usersRegistered = new LinkedList<>();
        this.hashedPasswords = new HashMap<>();
    }
}
