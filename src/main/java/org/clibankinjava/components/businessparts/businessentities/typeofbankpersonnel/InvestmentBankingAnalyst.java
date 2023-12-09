package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.InvestmentBankingAnalystResponsibilities;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "InvestmentBankingAnalyst")
@Table(name = "Investment_banking_analyst", schema = "Investment_banking_analyst")
@PrimaryKeyJoinColumn(name = "investment_banking_analyst_id", columnDefinition = "int default -1")
public class InvestmentBankingAnalyst extends Employee {

    @OrderBy
    @LazyGroup("CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @OrderBy
    @LazyGroup("MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @Embedded
    private InvestmentBankingAnalystResponsibilities responsibilities;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public InvestmentBankingAnalyst() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
    }

    @Override
    public String toString() {
        return String.format("InvestmentBankingAnalyst | %s, %s",
                super.toString(), responsibilities.toString());
    }
}
