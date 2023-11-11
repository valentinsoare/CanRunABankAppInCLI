package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.TypeOfTeam;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "TeamLeader")
@Table(name = "team_leader", schema = "team_leader")
public class TeamLeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "presentWorkDetails.leader", fetch = FetchType.LAZY)
    private Set<Employee> underlings;

    @LazyGroup("LEAD_TEAM")
    @Enumerated(EnumType.STRING)
    @Column(name = "typeofteamtolead")
    @Basic(fetch = FetchType.LAZY)
    private TypeOfTeam typeOfTeamToLead;

    @LazyGroup("NUMBER_OF_EMPLOYEES")
    @Column(name = "numberofemployeessmanaged")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfEmployeesManaged;

    @Version
    @LazyGroup("VERSION_FOR_USE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public TeamLeader() {
        this.numberOfEmployeesManaged = 0;
        this.underlings = new LinkedHashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamLeader that)) return false;

        if (numberOfEmployeesManaged != that.numberOfEmployeesManaged) return false;
        return typeOfTeamToLead == that.typeOfTeamToLead;
    }

    @Override
    public int hashCode() {
        int result = typeOfTeamToLead.hashCode();
        result = 31 * result + numberOfEmployeesManaged;

        return result;
    }

    @Override
    public String toString() {
        return String.format("TeamLeader [TypeOfTeamToLead: %s, NumbersOfEmployeesManaged: %s]",
                typeOfTeamToLead, numberOfEmployeesManaged);
    }
}
