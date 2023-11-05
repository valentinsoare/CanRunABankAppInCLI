package org.clibankinjava.components.credentials.credentialentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.credentials.LoginCredentials;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "User")
@Table(name = "user", schema = "user")
public class User implements LoginCredentials, Comparable<User> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @LazyGroup("USER_PASSWORD")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH},
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "password_id", unique = true)
    private Password password;


    @LazyGroup("NAME_DOB")
    @Column(name = "firstname")
    @Basic(fetch = FetchType.LAZY)
    private String firstName;

    @LazyGroup("NAME_DOB")
    @Column(name = "lastname")
    @Basic(fetch = FetchType.LAZY)
    private String lastName;

    @LazyGroup("NAME_DOB")
    @Column(name = "dateofbirth")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate dateOfBirth;


    @LazyGroup("USER_ADDRESS")
    @Column(name = "street")
    @Basic(fetch = FetchType.LAZY)
    private String street;

    @LazyGroup("USER_ADDRESS")
    @Column(name = "city")
    @Basic(fetch = FetchType.LAZY)
    private String city;

    @LazyGroup("USER_ADDRESS")
    @Column(name = "country")
    @Basic(fetch = FetchType.LAZY)
    private String country;

    @LazyGroup("USER_ADDRESS")
    @Column(name = "zipcode")
    @Basic(fetch = FetchType.LAZY)
    private int zipCode;


    @LazyGroup("USER_INFO")
    @Column(name = "typeofuser")
    @Basic(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private TypeOfUser typeOfUser;

    @LazyGroup("USER_INFO")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "created_by_id")
    private Employee createdBy;

    @LazyGroup("USER_INFO")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "last_modify_by_id")
    private Employee lastModifyBy;

    @LazyGroup("USER_INFO")
    @Column(name = "ismadeforemployee")
    private boolean isMadeForEmployee;

    @OneToOne(mappedBy = "employeeBusinessInformation.user")
    private Employee employee;

    @OneToMany(mappedBy = "employeeBusinessInformation.createdBy")
    private Set<Employee> employeeAccountsCreated;

    @OneToMany(mappedBy = "employeeBusinessInformation.lastModifiedBy")
    private Set<Employee> employeeAccountsLastModifyBy;


    @LazyGroup("DATE_AND_TIME")
    @Column(name = "creationdate")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate creationDate;

    @LazyGroup("DATE_AND_TIME")
    @Column(name = "lastmodificationdate")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate lastModificationDate;

    @LazyGroup("DATE_AND_TIME")
    @Column(name = "creationtime")
    @Basic(fetch = FetchType.LAZY)
    private LocalTime creationTime;

    @LazyGroup("DATE_AND_TIME")
    @Column(name = "lastmodificationtime")
    @Basic(fetch = FetchType.LAZY)
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
    @LazyGroup("VERSIONING")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public User() {
        this.employeeAccountsCreated = new TreeSet<>();
        this.employeeAccountsLastModifyBy = new TreeSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return user.username.equals(this.username);
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 31 * result + username.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull User o) {
        return o.username.compareTo(this.username);
    }

    @Override
    public String toString() {
        return String.format("User [UserName: %s, Email: %s, %s]",
                username, email, password);
    }
}
