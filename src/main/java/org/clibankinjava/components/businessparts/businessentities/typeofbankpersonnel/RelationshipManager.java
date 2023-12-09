package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.RelationshipManagerResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "RelationshipManager")
@Table(name = "relationship_manager", schema = "relationship_manager")
@PrimaryKeyJoinColumn(name = "relationship_manager_id", columnDefinition = "int default -1")
public class RelationshipManager extends Employee {

    @LazyGroup("USERS_CREATION")
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<User> usersCreated;

    @LazyGroup("USERS_MODIFICATION")
    @OneToMany(mappedBy = "lastModifyBy", fetch = FetchType.LAZY)
    private Set<User> usersLastModifiedBy;

    @OrderBy
    @LazyGroup("CLIENT")
    @OneToMany(mappedBy = "relationshipWithEmployees.relationshipManager", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;


    @Embedded
    private RelationshipManagerResponsibilities responsibilities;


    @LazyGroup("FEES")
    @Column(name = "consultation_fee_individual_clients")
    @Basic(fetch = FetchType.LAZY)
    private double consultationFeePerHourIndividualClients;

    @LazyGroup("FEES")
    @Column(name = "consultation_fee_per_hour_enterprise")
    @Basic(fetch = FetchType.LAZY)
    private double consultationFeePerHourEnterprise;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public RelationshipManager() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelationshipManager that)) return false;
        if (!super.equals(o)) return false;

        if (Double.compare(consultationFeePerHourIndividualClients, that.consultationFeePerHourIndividualClients) != 0)
            return false;

        return Double.compare(consultationFeePerHourEnterprise, that.consultationFeePerHourEnterprise) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;

        temp = Double.doubleToLongBits(consultationFeePerHourIndividualClients);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(consultationFeePerHourEnterprise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return String.format("RelationshipManager | %s, %s, consultationFeePerHourIndividualClients: %s, " +
                "consultationFeePerHourEnterprise: %s", super.toString(), responsibilities.toString(),
                consultationFeePerHourIndividualClients, consultationFeePerHourEnterprise);
    }
}
