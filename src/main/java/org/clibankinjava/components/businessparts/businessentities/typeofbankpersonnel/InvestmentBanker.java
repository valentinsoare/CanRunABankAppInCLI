package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.InvestmentBankerResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "InvestmentBanker")
@Table(name = "investment_banker", schema = "investment_banker")
@PrimaryKeyJoinColumn(name = "investment_banker_id", columnDefinition = "int default -1")
public class InvestmentBanker extends Employee {

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
    @OneToMany(mappedBy = "relationshipWithEmployees.investmentBanker", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;


    @Embedded
    InvestmentBankerResponsibilities responsibilities;


    @LazyGroup("FEES")
    @Column(name = "consultation_fee_for_individuals")
    @Basic(fetch = FetchType.LAZY)
    private double consultationFeeForIndividuals;

    @LazyGroup("FEES")
    @Column(name = "consultation_fee_for_enterprise")
    @Basic(fetch = FetchType.LAZY)
    private double consultationFeeForEnterprise;

    @LazyGroup("FEES")
    @Column(name = "purchase_commission_for_individuals")
    @Basic(fetch = FetchType.LAZY)
    private double purchaseCommissionForIndividuals;

    @LazyGroup("FEES")
    @Column(name = "purchase_commission_for_enterprise")
    @Basic(fetch = FetchType.LAZY)
    private double purchaseCommissionForEnterprise;

    @LazyGroup("FEES")
    @Column(name = "employment_fee_per_hour_for_individuals")
    @Basic(fetch = FetchType.LAZY)
    private double employmentFeePerHourForIndividuals;

    @LazyGroup("FEES")
    @Column(name = "employment_fee_per_hour_for_enterprise")
    @Basic(fetch = FetchType.LAZY)
    private double employmentFeePerHourForEnterprise;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public InvestmentBanker() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvestmentBanker that)) return false;
        if (!super.equals(o)) return false;

        if ((Double.compare(that.consultationFeeForIndividuals, consultationFeeForIndividuals) != 0) ||
                (Double.compare(that.consultationFeeForEnterprise, consultationFeeForEnterprise) != 0) ||
                (Double.compare(that.purchaseCommissionForIndividuals, purchaseCommissionForIndividuals) != 0) ||
                (Double.compare(that.purchaseCommissionForEnterprise, purchaseCommissionForEnterprise) != 0) ||
                (Double.compare(that.employmentFeePerHourForIndividuals, employmentFeePerHourForIndividuals) != 0)) {
            return false;
        }

        return Double.compare(that.employmentFeePerHourForEnterprise, employmentFeePerHourForEnterprise) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;

        temp = Double.doubleToLongBits(consultationFeeForIndividuals);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(consultationFeeForEnterprise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(purchaseCommissionForIndividuals);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(purchaseCommissionForEnterprise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(employmentFeePerHourForIndividuals);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(employmentFeePerHourForEnterprise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("InvestmentBanker | %s, %s, consultationFeeForIndividuals: %s, consultationFeeForEnterprise: %s, " +
                "purchaseCommissionForIndividuals: %s, purchaseCommissionForEnterprise: %s, employmentFeePerHourForIndividuals: %s, " +
                "employmentFeePerHourForEnterprise: %s",
                super.toString(), responsibilities.toString(), consultationFeeForIndividuals, consultationFeeForEnterprise,
                purchaseCommissionForIndividuals, purchaseCommissionForEnterprise, employmentFeePerHourForIndividuals,
                employmentFeePerHourForEnterprise);
    }
}
