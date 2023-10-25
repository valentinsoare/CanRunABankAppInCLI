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
public class User implements LoginCredentials {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String city;
    private String country;
    private int zipCode;
    private String email;
    private String role;
    private String typeOfClient;

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s",
                id, username, firstName, lastName, dateOfBirth, address, city, country,
                zipCode, email, role, typeOfClient);
    }
}
