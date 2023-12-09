package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.FinancialAdvisorResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "FinancialAdvisor")
@Table(name = "financial_advisor", schema = "financial_advisor")
@PrimaryKeyJoinColumn(name = "financial_advisor_id", columnDefinition = "int default -1")
public class FinancialAdvisor extends Employee {

    @OrderBy
    @LazyGroup("USERS_CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @OrderBy
    @LazyGroup("USERS_MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @OrderBy
    @LazyGroup("CLIENTS")
    @OneToMany(mappedBy = "relationshipWithEmployees.financialAdvisor", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;

    @Embedded
    private FinancialAdvisorResponsibilities responsibilities;


    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "consultation_fee")
    private double consultationFee;

    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "purchase_fee")
    private double purchaseFee;

    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "loan_fee")
    private double loanFee;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public FinancialAdvisor() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinancialAdvisor that)) return false;
        if (!super.equals(o)) return false;

        return ((Double.compare(consultationFee, that.consultationFee) != 0) ||
            (Double.compare(purchaseFee, that.purchaseFee) != 0) || (Double.compare(loanFee, that.loanFee) == 0));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;

        temp = Double.doubleToLongBits(consultationFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(purchaseFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(loanFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("FinancialAdvisor | %s, %s, consultationFee: %.2f, purchaseFee: %.2f, loanFee: %.2f",
                super.toString(), responsibilities.toString(), consultationFee, purchaseFee, loanFee);
    }
}
