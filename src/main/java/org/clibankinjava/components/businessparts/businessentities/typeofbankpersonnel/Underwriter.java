package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee.UnderwriterResponsibilities;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
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
@Entity(name = "Underwriter")
@Table(name = "underwriter", schema = "underwriter")
@PrimaryKeyJoinColumn(name = "underwriter_id", columnDefinition = "int default -1")
public class Underwriter extends Employee {

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
    @OneToMany(mappedBy = "underwriter", fetch = FetchType.LAZY)
    private Set<Credit> listOfCredits;

    @OrderBy
    @LazyGroup("CLIENT")
    @OneToMany(mappedBy = "relationshipWithEmployees.underwriter", fetch = FetchType.LAZY)
    private Set<Client> listOfClients;

    @Embedded
    private UnderwriterResponsibilities responsibilities;

    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "assessment_quality_score", columnDefinition = "long default 1000")
    private long assessmentQualityScore;

    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "number_of_approved_credits", columnDefinition = "long default 0")
    private int numberOfApprovedCredits;

    @LazyGroup("FEES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "assessment_quality_score", columnDefinition = "long default 0")
    private int numberOfDeniedCredits;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public Underwriter() {
        super();

        this.usersCreated = new TreeSet<>();
        this.usersLastModifiedBy = new TreeSet<>();
        this.listOfCredits = new TreeSet<>();
        this.listOfClients = new TreeSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Underwriter that)) return false;
        if (!super.equals(o)) return false;

        if ((assessmentQualityScore != that.assessmentQualityScore)
                || (numberOfApprovedCredits != that.numberOfApprovedCredits)) {
            return false;
        }

        return numberOfDeniedCredits == that.numberOfDeniedCredits;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (int) (assessmentQualityScore ^ (assessmentQualityScore >>> 32));
        result = 31 * result + numberOfApprovedCredits;
        result = 31 * result + numberOfDeniedCredits;

        return result;
    }

    @Override
    public String toString() {
        return String.format("Underwriter | %s, %s, assessmentQualityScore: %s, numberOfApprovedCredits: %s, numberOfDeniedCredits: %s",
                super.toString(), responsibilities.toString(), assessmentQualityScore, numberOfApprovedCredits, numberOfDeniedCredits);
    }
}
