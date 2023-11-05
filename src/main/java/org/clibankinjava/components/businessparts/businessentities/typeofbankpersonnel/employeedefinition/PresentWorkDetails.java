package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition;

import jakarta.persistence.*;
import lombok.Getter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.TeamLeader;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.duties.BankerPrimaryDuties;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.EmployeeStatus;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.JobDescription;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.type.SqlTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Getter
@Embeddable
public class PresentWorkDetails implements Comparable<PresentWorkDetails> {
    @LazyGroup("PRESENT_WORK_DETAILS")
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_status")
    @Basic(fetch = FetchType.LAZY)
    private EmployeeStatus employeeStatus;

    @LazyGroup("PRESENT_WORK_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "current_annual_salary")
    private double currentAnnualSalary;

    @Transient
    @LazyGroup("PRESENT_WORK_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    private Long howMuchTimeFromHiring;

    @LazyGroup("PRESENT_WORK_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "is_team_leader")
    private boolean isTeamLeader;

    @LazyGroup("PRESENT_WORK_DETAILS")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "team_leader_id")
    private TeamLeader leader;

    @LazyGroup("PRESENT_WORK_DETAILS")
    @Enumerated(EnumType.STRING)
    @Column(name = "primary_duties")
    @Basic(fetch = FetchType.LAZY)
    private Set<BankerPrimaryDuties> primaryDuties;

    @LazyGroup("PRESENT_WORK_DETAILS")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "job_description_id")
    private JobDescription jobDescription;

    @LazyGroup("PRESENT_WORK_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "employee_id")
    private Long employeeId;

    public PresentWorkDetails() {
        this.primaryDuties = new HashSet<>();
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void setCurrentAnnualSalary(double currentAnnualSalary) {
        this.currentAnnualSalary = currentAnnualSalary;
    }

    public void setHowMuchTimeFromHiring(Long howMuchTimeFromHiring) {
        this.howMuchTimeFromHiring = howMuchTimeFromHiring;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PresentWorkDetails that)) return false;

        if (employeeStatus != that.employeeStatus) return false;

        return employeeId.equals(that.employeeId);
    }

    @Override
    public int hashCode() {
        int result = employeeStatus.hashCode();
        result = 31 * result + employeeId.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("PresentWorkDetails [employeeStatus: %s, currentAnnualSalary: %s, howMuchTimeFromHiring: %s, isTeamLeader: %s" +
                        ", leader: %s, employeeId: %s]",
                employeeStatus, currentAnnualSalary, howMuchTimeFromHiring, isTeamLeader, leader, employeeId);
    }

    @Override
    public int compareTo(@NotNull PresentWorkDetails o) {
        int valueToBeReturned = o.employeeStatus.compareTo(this.employeeStatus);

        if (valueToBeReturned == 0) {
            return o.employeeId.compareTo(this.employeeId);
        }

        return valueToBeReturned;
    }
}
