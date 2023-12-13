package org.clibankinjava.components.credentials.credentialentities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.credentials.Credential;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity(name = "Password")
@BatchSize(size=8)
@Table(name = "password", schema = "password")
public class Password implements Credential, Comparable<Password> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("PASSWORD_INFO")
    @OneToOne(mappedBy = "password")
    private User userName;

    @Column(name = "hashedpassword")
    private String hashedPasswd;

    @LazyGroup("PASSWORD_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "numberOfDaysUntilPasswordExpires")
    private int numberOfDaysUntilPasswordExpires;


    @LazyGroup("TIME_AND_DATE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "creationdate")
    private LocalDate creationDate;

    @LazyGroup("TIME_AND_DATE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "lastmodificationdate")
    private LocalDate lastModificationDate;

    @LazyGroup("TIME_AND_DATE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "creationtime")
    private LocalTime creationTime;

    @LazyGroup("TIME_AND_DATE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "lastmodificationtime")
    private LocalTime lastModificationTime;


    @Transient
    @LazyGroup("TIME_PASSED")
    @Basic(fetch = FetchType.LAZY)
    private Long howMuchTimeFromCreation;

    @Transient
    @LazyGroup("TIME_PASSED")
    @Basic(fetch = FetchType.LAZY)
    private Long howMuchTimeFromModification;


    @Version
    @LazyGroup("VERS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public Password() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password password)) return false;

        if (!userName.equals(password.userName)) return false;
        return hashedPasswd.equals(password.hashedPasswd);
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 31 * result + hashedPasswd.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Password o) {
        int value = o.hashedPasswd.compareTo(this.hashedPasswd);

        if (value == 0) {
            return o.getUserName().getUsername().compareTo(this.getUserName().getUsername());
        }

        return value;
    }

    @Override
    public String toString() {
        return String.format("Password [HashedPassword: %s, NumberOfDaysUntilPasswordExpires: %s]",
                hashedPasswd, numberOfDaysUntilPasswordExpires);
    }
}
