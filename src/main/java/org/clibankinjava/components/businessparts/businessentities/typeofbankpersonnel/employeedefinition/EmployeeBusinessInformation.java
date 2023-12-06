package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition;

import jakarta.persistence.*;
import lombok.Getter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.SeniorityLevel;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.TypeOfTeam;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Embeddable
public class EmployeeBusinessInformation implements Comparable<EmployeeBusinessInformation> {
    @LazyGroup("EMPLOYEE_BUSINESS_INFO")
    @Column(name = "user_for_employee")
    @Basic(fetch = FetchType.LAZY)
    private boolean userForEmployee;

    @LazyGroup("EMPLOYEE_BUSINESS_INFO")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @LazyGroup("EMPLOYEE_BUSINESS_INFO")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    private User createdBy;

    @LazyGroup("EMPLOYEE_BUSINESS_INFO")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "last_modified_by_user_id")
    private User lastModifiedBy;

    @LazyGroup("EMPLOYEE_BUSINESS_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "current_team")
    private TypeOfTeam currentTeam;

    @LazyGroup("EMPLOYEE_BUSINESS_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "seniority_level")
    private SeniorityLevel seniorityLevel;

    public EmployeeBusinessInformation() {}

    public void setUserForEmployee(boolean userForEmployee) {
        this.userForEmployee = userForEmployee;
    }

    public void setCurrentTeam(TypeOfTeam currentTeam) {
        this.currentTeam = currentTeam;
    }

    public void setSeniorityLevel(SeniorityLevel seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBusinessInformation that)) return false;

        if ((userForEmployee != that.userForEmployee) || (!createdBy.equals(that.createdBy)) ||
            (!lastModifiedBy.equals(that.lastModifiedBy)) || (currentTeam != that.currentTeam)) return false;

        return seniorityLevel == that.seniorityLevel;
    }

    @Override
    public int hashCode() {
        int result = 13;

        result = 31 * result + user.hashCode();
        result = 31 * result + createdBy.hashCode();
        result = 31 * result + lastModifiedBy.hashCode();
        result = 31 * result + currentTeam.hashCode();
        result = 31 * result + seniorityLevel.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("EmployeeBusinessInformation [userWasMadeForEmployee: %s, user: %s, createdBy: %s, lastModifyBy: %s," +
                        " currentTeam: %s, seniorityLevel: %s]",
                userForEmployee, user.getUsername(), createdBy.getUsername(), lastModifiedBy.getUsername(), currentTeam, seniorityLevel);
    }

    @Override
    public int compareTo(@NotNull EmployeeBusinessInformation o) {
        List<Integer> comparisons = new ArrayList<>(Arrays.asList(
                Boolean.compare(o.isUserForEmployee(), this.isUserForEmployee()),
                o.getUser().compareTo(this.user),
                o.getCurrentTeam().compareTo(this.currentTeam),
                o.getSeniorityLevel().compareTo(this.seniorityLevel)
        ));

        int value = 0;
        for (Integer comparison : comparisons) {
            if (comparison != 0) {
                return comparison;
            }
        }

        return value;
    }
}
