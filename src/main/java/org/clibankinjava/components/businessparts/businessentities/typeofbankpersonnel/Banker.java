package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.BankerResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;


import java.util.Set;
import java.util.TreeSet;

@Getter
@Entity(name = "Banker")
@BatchSize(size = 8)
@Table(name = "banker", schema = "banker")
@PrimaryKeyJoinColumn(name = "banker_id", columnDefinition = "int default -1")
public class Banker extends Employee {
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
    @OneToMany(mappedBy = "banker", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;


    @Embedded
    private BankerResponsibilities responsibilities;

    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "consultationfee")
    private double consultationFee;

    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "loanfee")
    private double loanFee;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public Banker() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public void setLoanFee(double loanFee) {
        this.loanFee = loanFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banker banker)) return false;
        if (!super.equals(o)) return false;

        if (Double.compare(consultationFee, banker.consultationFee) != 0) return false;
        return Double.compare(loanFee, banker.loanFee) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;

        temp = Double.doubleToLongBits(consultationFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(loanFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("Banker | %s, %s, loanFee: %.2f, consultationFee: %.2f",
                super.toString(), responsibilities.toString(), loanFee, consultationFee);
    }
}
