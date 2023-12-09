package org.clibankinjava.components.credentials;

import lombok.Getter;
import org.clibankinjava.components.credentials.credentialentities.Password;
import org.clibankinjava.components.credentials.credentialentities.User;

import java.util.*;

@Getter
public final class CheckUserAndPassword {

    private final Deque<User> usersRegistered;
    private final Map<User, Password> hashedPasswords;

    public CheckUserAndPassword() {
        this.usersRegistered = new LinkedList<>();
        this.hashedPasswords = new HashMap<>();
    }
}
