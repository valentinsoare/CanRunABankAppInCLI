package org.clibankinjava.components.credentials;

import java.io.Console;

public class Password extends LoginInformation {
    private String password;

    public Password() {
        this.password = "default";
    }

    public String getPasswordAsString() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
