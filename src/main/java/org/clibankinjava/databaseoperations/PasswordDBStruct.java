package org.clibankinjava.databaseoperations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PasswordDBStruct implements LoginCredentials {
    private int id;
    private String username;
    private String hashPasswd;
    private int expireIn;

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %d",
                id, username, hashPasswd, expireIn);
    }
}


