package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.type.SqlTypes;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "JobDescription")
@Table(name = "job_description", schema = "job_description")
public class JobDescription implements Comparable<JobDescription> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("DESCRIPTION")
    @Enumerated(EnumType.STRING)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "job_role")
    private Role jobRole;

    @LazyGroup("DESCRIPTION")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "job_description")
    private String jobDescription;

    @OrderBy
    @LazyGroup("DESCRIPTION")
    @OneToMany(mappedBy = "presentWorkDetails.jobDescription", fetch = FetchType.LAZY)
    private Set<Employee> employeesWithASpecificJD;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public JobDescription() {
        this.employeesWithASpecificJD = new LinkedHashSet<>();
    }

    public JobDescription(Role jobRole) {
        this.jobRole = jobRole;
        this.jobDescription = jobRole.getJobDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobDescription that)) return false;

        if (jobRole != that.jobRole) return false;
        return jobDescription.equals(that.jobDescription);
    }

    @Override
    public int hashCode() {
        int result = jobRole.hashCode();
        result = 31 * result + jobDescription.hashCode();

        return result;
    }


    @Override
    public int compareTo(@NotNull JobDescription o) {
        return o.jobRole.compareTo(this.jobRole);
    }

    @Override
    public String toString() {
        return jobRole.toString();
    }
}
