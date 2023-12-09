package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.MortgageConsultantResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.mortgage.Mortgage;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "MortgageConsultant")
@Table(name = "mortgage_consultant", schema = "mortgage_consultant")
@PrimaryKeyJoinColumn(name = "mortgage_consultant_id", columnDefinition = "int default -1")
public class MortgageConsultant extends Employee {

    @LazyGroup("USERS_CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @LazyGroup("USERS_MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @OrderBy
    @LazyGroup("CLIENT")
    @OneToMany(mappedBy = "relationshipWithEmployees.mortgageConsultant", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;

    @OrderBy
    @LazyGroup("MORTGAGE")
    @OneToMany(mappedBy = "mortgageConsultant", fetch = FetchType.LAZY)
    private Set<Mortgage> listOfMortgages;


    @Embedded
    private MortgageConsultantResponsibilities responsibilities;


    @LazyGroup("FEES")
    @Column(name = "consultation_fee_per_hour_for_individuals")
    @Basic(fetch = FetchType.LAZY)
    private double consultationFeePerHourForIndividuals;

    @LazyGroup("FEES")
    @Column(name = "consultation_fee_per_hour_for_enterprise")
    @Basic(fetch = FetchType.LAZY)
    private double consultationFeePerHourForEnterprise;

    @LazyGroup("FEES")
    @Column(name = "commission_per_mortgage_for_individuals")
    @Basic(fetch = FetchType.LAZY)
    private double commissionPerMortgageForIndividuals;

    @LazyGroup("FEES")
    @Column(name = "commission_per_mortgage_for_enterprise")
    @Basic(fetch = FetchType.LAZY)
    private double commissionPerMortgageForEnterprise;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public MortgageConsultant() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
        this.listOfMortgages = new TreeSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MortgageConsultant that)) return false;
        if (!super.equals(o)) return false;

        if ((Double.compare(that.consultationFeePerHourForIndividuals, consultationFeePerHourForIndividuals) != 0) ||
                (Double.compare(that.consultationFeePerHourForEnterprise, consultationFeePerHourForEnterprise) != 0) ||
                (Double.compare(that.commissionPerMortgageForIndividuals, commissionPerMortgageForIndividuals) != 0)) {
            return false;
        }

        return Double.compare(that.commissionPerMortgageForEnterprise, commissionPerMortgageForEnterprise) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;

        temp = Double.doubleToLongBits(consultationFeePerHourForIndividuals);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(consultationFeePerHourForEnterprise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(commissionPerMortgageForIndividuals);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(commissionPerMortgageForEnterprise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("MortgageConsultant | %s, %s, consultationFeePerHourForIndividuals: %s, consultationFeePerHourForEnterprise: %s" +
                        "commissionPerMortgageForIndividuals: %s, commissionPerMortgageForEnterprise: %s",
                super.toString(), responsibilities.toString(), consultationFeePerHourForIndividuals,
                consultationFeePerHourForEnterprise, commissionPerMortgageForIndividuals, commissionPerMortgageForEnterprise);
    }
}
