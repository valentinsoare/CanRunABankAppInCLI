package org.clibankinjava.components.credentials.credentialentities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clibankinjava.components.credentials.LoginCredentials;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Password implements LoginCredentials {
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


