package org.clibankinjava.components.credentials;

import lombok.Getter;

import java.io.Console;

@Getter
public class Password extends LoginInformation {
    private String password;

    public Password() {
        this.password = "default";
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
