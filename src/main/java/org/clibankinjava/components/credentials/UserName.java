package org.clibankinjava.components.credentials;


import org.clibankinjava.validation.SanityChecks;

import java.io.Console;

public class UserName extends LoginInformation {
    private String username;

    public UserName() {
        this.username = "none";
    }

    public String getUsernameAsString() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
