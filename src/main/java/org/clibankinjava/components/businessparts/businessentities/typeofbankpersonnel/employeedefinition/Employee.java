package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "Employee")
@Table(name = "employee", schema = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee implements Comparable<Employee>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "first_name")
    private String firstName;

    @LazyGroup("USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "last_name")
    private String lastName;

    @LazyGroup("USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @LazyGroup("USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "numeric_personal_identification_number")
    private String numericPersonalIdentificationNumber;

    @LazyGroup("USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "phone_number")
    private int phoneNumber;

    @LazyGroup("USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "email")
    private String email;

    @Embedded
    private Address address;

    @Embedded
    private PastWorkDetails pastWorkDetails;

    @Embedded
    private PresentWorkDetails presentWorkDetails;

    @Embedded
    private TimeAndDateInformation timeAndDateInformation;

    @Embedded
    private EmployeeBusinessInformation employeeBusinessInformation;

    @Transient
    @LazyGroup("TIME_PASSING")
    @Basic(fetch = FetchType.LAZY)
    private Long howMuchTimeFromCreation;

    @Transient
    @LazyGroup("TIME_PASSING")
    @Basic(fetch = FetchType.LAZY)
    private Long howMuchTimeFromModification;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    protected Employee() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if ((!firstName.equals(employee.firstName)) || (!lastName.equals(employee.lastName)) ||
                (!email.equals(employee.email))) {
            return false;
        }

        return employee.presentWorkDetails.getEmployeeId().equals(this.presentWorkDetails.getEmployeeId());
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();

        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + presentWorkDetails.getEmployeeId().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("firstName: %s, lastName: %s, dateOfBirth: %s, numericPersonalIdentificationNumber: %s, phoneNumber: %s, email: %s",
                firstName, lastName, dateOfBirth, numericPersonalIdentificationNumber, phoneNumber, email);
    }

    @Override
    public int compareTo(@NotNull Employee o) {
        int numericValueToBeReturned = o.firstName.compareTo(this.firstName);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = o.lastName.compareTo(this.lastName);

            if (numericValueToBeReturned == 0) {
                return o.presentWorkDetails.getEmployeeId()
                        .compareTo(this.presentWorkDetails.getEmployeeId());
            }
        }

        return numericValueToBeReturned;
    }
}
