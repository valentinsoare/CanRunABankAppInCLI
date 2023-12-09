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
@Entity(name = "LoanProcessor")
@Table(name = "loan_processor", schema = "loan_processor")
@PrimaryKeyJoinColumn(name = "loan_processor_id", columnDefinition = "int default -1")
public class LoanProcessor extends Employee {

    @LazyGroup("USERS_CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @LazyGroup("USERS_MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @OrderBy
    @LazyGroup("CREDIT")
    @OneToMany(mappedBy = "loanProcessor", fetch = FetchType.LAZY)
    private Set<Credit> setOfCredits;

    @OrderBy
    @LazyGroup("CLIENT")
    @OneToMany(mappedBy = "relationshipWithEmployees.loanProcessor", fetch = FetchType.LAZY)
    private Set<Client> setOfClients;

    @Embedded
    private LoanOfficerResponsibilities responsibilities;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public LoanProcessor() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.setOfCredits = new TreeSet<>();
        this.setOfClients = new TreeSet<>();
    }

    @Override
    public String toString() {
        return String.format("LoanProcessor | %s, %s",
                super.toString(), responsibilities.toString());
    }
}
