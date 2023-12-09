package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.InvestmentRepresentativeResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "InvestmentRepresentative")
@Table(name = "investment_representative", schema = "investment_representative")
@PrimaryKeyJoinColumn(name = "investment_representative_id", columnDefinition = "int default -1")
public class InvestmentRepresentative extends Employee {

    @OrderBy
    @LazyGroup("CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @OrderBy
    @LazyGroup("MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @OrderBy
    @LazyGroup("CLIENT")
    @OneToMany(mappedBy = "relationshipWithEmployees.investmentRepresentative", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;


    @Embedded
    private InvestmentRepresentativeResponsibilities responsibilities;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public InvestmentRepresentative() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
    }

    @Override
    public String toString() {
        return String.format("InvestmentRepresentative | %s, %s",
                super.toString(), responsibilities.toString());
    }
}
