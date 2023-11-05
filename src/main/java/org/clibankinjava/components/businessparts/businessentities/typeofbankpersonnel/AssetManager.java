package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.AssetManagerResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.Account;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.Deposit;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@BatchSize(size = 8)
@Entity(name = "AssetManager")
@Table(name = "asset_manager", schema = "asset_manager")
@PrimaryKeyJoinColumn(name = "asset_manager_id", columnDefinition = "int default -1")
public class AssetManager extends Employee {
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
    @OneToMany(mappedBy = "assetManager", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;

    @OrderBy
    @LazyGroup("ACCOUNTS")
    @OneToMany(mappedBy = "assetManager", fetch = FetchType.LAZY)
    private Set<Account> listOfAccounts;

    @OrderBy
    @LazyGroup("DEPOSITS")
    @OneToMany(mappedBy = "assetManager", fetch = FetchType.LAZY)
    private Set<Deposit> listOfDeposits;



    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "consultationFee")
    private double consultationFee;

    @Embedded
    private AssetManagerResponsibilities responsibilities;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;


    public AssetManager() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
        this.listOfAccounts = new TreeSet<>();
        this.listOfDeposits = new TreeSet<>();
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetManager that)) return false;
        if (!super.equals(o)) return false;

        return Double.compare(consultationFee, that.consultationFee) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;

        temp = Double.doubleToLongBits(consultationFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("AssetManager | %s, %s, consultationFee: %.2f",
                super.toString(), responsibilities.toString(), consultationFee);
    }
}
