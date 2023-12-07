package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Embeddable
public class PersonalIdentificationForAnIndividualClient implements Comparable<PersonalIdentificationForAnIndividualClient> {
    @LazyGroup("FIRST_WAVE_IDENTIFICATION")
    @Column(name = "first_name")
    @Basic(fetch = FetchType.LAZY)
    private String firstName;

    @LazyGroup("FIRST_WAVE_IDENTIFICATION")
    @Column(name = "last_name")
    @Basic(fetch = FetchType.LAZY)
    private String lastName;

    @LazyGroup("FIRST_WAVE_IDENTIFICATION")
    @Column(name = "date_of_birth")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate dateOfBirth;

    @LazyGroup("FIRST_WAVE_IDENTIFICATION")
    @Column(name = "personal_identification_number")
    @Basic(fetch = FetchType.LAZY)
    private String personalIdentificationNumber;

    @LazyGroup("FIRST_WAVE_IDENTIFICATION")
    @Column(name = "expiration_date_for_id_card")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate expirationDateForIdCard;


    @LazyGroup("SECOND_WAVE_IDENTIFICATION")
    @Column(name = "mobile_phone_number")
    @Basic(fetch = FetchType.LAZY)
    private String mobilePhoneNumber;

    @LazyGroup("SECOND_WAVE_IDENTIFICATION")
    @Column(name = "email")
    @Basic(fetch = FetchType.LAZY)
    private String email;

    @LazyGroup("SECOND_WAVE_IDENTIFICATION")
    @Column(name = "name_of_the_father")
    @Basic(fetch = FetchType.LAZY)
    private String nameOfTheFather;

    @LazyGroup("SECOND_WAVE_IDENTIFICATION")
    @Column(name = "name_of_the_mother")
    @Basic(fetch = FetchType.LAZY)
    private String nameOfTheMother;

    @LazyGroup("SECOND_WAVE_IDENTIFICATION")
    @Column(name = "last_completed_education")
    @Basic(fetch = FetchType.LAZY)
    private String lastCompletedEducation;

    public PersonalIdentificationForAnIndividualClient() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalIdentificationForAnIndividualClient that)) return false;

        if ((!that.firstName.equals(this.firstName)) ||
            (!that.lastName.equals(this.lastName)) ||
            (!that.dateOfBirth.equals(this.dateOfBirth)) ||
            (!that.mobilePhoneNumber.equals(this.mobilePhoneNumber))) {
            return false;
        }

        return that.email.equals(this.email);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();

        result = 31 * result + lastName.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + mobilePhoneNumber.hashCode();
        result = 31 * result + email.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull PersonalIdentificationForAnIndividualClient o) {
        int numericValueToBeReturned = o.firstName.compareTo(this.firstName);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = o.lastName.compareTo(this.lastName);

            if (numericValueToBeReturned == 0) {
                numericValueToBeReturned = o.dateOfBirth.compareTo(this.dateOfBirth);

                if (numericValueToBeReturned == 0) {
                    numericValueToBeReturned = o.mobilePhoneNumber.compareTo(this.mobilePhoneNumber);

                    if (numericValueToBeReturned == 0) {
                        return o.email.compareTo(this.email);
                    }
                }
            }
        }

        return numericValueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("firstName", firstName),
//                entry("lastName", lastName),
//                entry("dateOfBirth", dateOfBirth.toString()),
//                entry("personalIdentificationNumber", personalIdentificationNumber),
//                entry("expirationDateForIdCard", expirationDateForIdCard.toString()),
//                entry("mobilePhoneNumber", mobilePhoneNumber),
//                entry("email", email),
//                entry("nameOfTheFather", nameOfTheFather),
//                entry("nameOfTheMother", nameOfTheMother),
//                entry("lastCompletedEducation", lastCompletedEducation)
//        ));

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "[");
    }
}
