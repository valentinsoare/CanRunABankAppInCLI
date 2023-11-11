package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.CreditAnalystResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails.Credit;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "CreditAnalyst")
@Table(name = "credit_analyst", schema = "credit_analyst")
@PrimaryKeyJoinColumn(name = "credit_analyst_id", columnDefinition = "int default -1")
public class CreditAnalyst extends Employee {
    @OrderBy
    @LazyGroup("USERS_CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @OrderBy
    @LazyGroup("USERS_MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @OrderBy
    @LazyGroup("SET_OF_CREDITS")
    @OneToMany(mappedBy = "creditAnalyst", fetch = FetchType.LAZY)
    private Set<Credit> setOfCredits;

    @OrderBy
    @LazyGroup("SET_OF_CLIENTS")
    @OneToMany(mappedBy = "creditAnalyst", fetch = FetchType.LAZY)
    private Set<Client> setOfClients;

    @Embedded
    private CreditAnalystResponsibilities responsibilities;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public CreditAnalyst() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.setOfCredits = new TreeSet<>();
    }

    @Override
    public String toString() {
        return String.format("CreditAnalyst | %s, %s",
                super.toString(), responsibilities.toString());
    }
}
