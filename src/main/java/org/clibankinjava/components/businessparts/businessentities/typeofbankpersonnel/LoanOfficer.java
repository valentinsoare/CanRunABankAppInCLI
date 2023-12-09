package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.LoanOfficerResponsibilities;
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
@Entity(name = "LoanOfficer")
@Table(name = "loan_officer", schema = "loan_officer")
@PrimaryKeyJoinColumn(name = "loan_officer_id", columnDefinition = "int default -1")
public class LoanOfficer extends Employee {

    @OrderBy
    @LazyGroup("CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @OrderBy
    @LazyGroup("MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @OrderBy
    @LazyGroup("CREDIT")
    @OneToMany(mappedBy = "loanOfficer", fetch = FetchType.LAZY)
    private Set<Credit> setOfCredits;

    @OrderBy
    @LazyGroup("CLIENT")
    @OneToMany(mappedBy = "relationshipWithEmployees.loanOfficer", fetch = FetchType.LAZY)
    private Set<Client> setOfClients;


    @Embedded
    private LoanOfficerResponsibilities responsibilities;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public LoanOfficer() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.setOfCredits = new TreeSet<>();
        this.setOfClients = new TreeSet<>();
    }

    @Override
    public String toString() {
        return String.format("LoanOfficer | %s, %s",
                super.toString(), responsibilities.toString());
    }
}
