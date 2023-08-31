package org.clibankinjava.components.credentials;

import lombok.Getter;

@Getter
public class UserName extends LoginInformation {
    private String username;

    public UserName() {
        this.username = "none";
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
