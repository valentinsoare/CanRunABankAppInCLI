package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Embeddable
public class IdentificationForACompany implements Comparable<IdentificationForACompany> {
    @LazyGroup("FIRST_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "name_of_the_company")
    private String nameOfTheCompany;

    @LazyGroup("FIRST_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "cui")
    private String CUI;

    @LazyGroup("FIRST_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "vat_payer")
    private boolean vatPayer;

    @LazyGroup("FIRST_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "company_type")
    private TypeOfCompany companyType;


    @LazyGroup("SECOND_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "registration_number")
    private String registrationNumber;

    @LazyGroup("SECOND_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "euid")
    private String EUID;

    @LazyGroup("SECOND_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "date_of_registration")
    private LocalDate dateOfRegistration;

    @LazyGroup("SECOND_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "how_many_years_from_company_registration")
    private BigDecimal howManyYearsFromCompanyRegistration;

    @LazyGroup("SECOND_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "company_administrator_name")
    private String companyAdministratorName;


    @LazyGroup("THIRD_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "phone_number")
    private String phoneNumber;

    @LazyGroup("THIRD_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "email")
    private String email;

    @LazyGroup("THIRD_PHASE_IDENTIFICATION_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "web_address")
    private String webAddress;

    public IdentificationForACompany() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdentificationForACompany that)) return false;

        if ((!that.nameOfTheCompany.equals(this.nameOfTheCompany)) ||
             (!that.CUI.equals(this.CUI)) ||
             (!that.registrationNumber.equals(this.registrationNumber)) ||
             (!that.EUID.equals(this.EUID))) {
            return false;
        }

        return that.dateOfRegistration.equals(this.dateOfRegistration);
    }

    @Override
    public int hashCode() {
        int result = nameOfTheCompany.hashCode();

        result = 31 * result + CUI.hashCode();
        result = 31 * result + registrationNumber.hashCode();
        result = 31 * result + EUID.hashCode();
        result = 31 * result + dateOfRegistration.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull IdentificationForACompany o) {
        int numericValueToBeReturned = o.nameOfTheCompany.compareTo(this.nameOfTheCompany);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = o.CUI.compareTo(this.CUI);

            if (numericValueToBeReturned == 0) {
                numericValueToBeReturned = o.registrationNumber.compareTo(this.registrationNumber);

                if (numericValueToBeReturned == 0) {
                    numericValueToBeReturned = o.EUID.compareTo(this.EUID);

                    if (numericValueToBeReturned == 0) {
                        return o.dateOfRegistration.compareTo(this.dateOfRegistration);
                    }
                }
            }
        }

        return numericValueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("nameOfTheCompany", nameOfTheCompany),
//                entry("CUI", CUI),
//                entry("vatPayer", String.valueOf(vatPayer)),
//                entry("companyType", companyType.toString()),
//                entry("registrationNumber", registrationNumber),
//                entry("EUID", EUID),
//                entry("dateOfRegistration", dateOfRegistration.toString()),
//                entry("howManyYearsFromCompanyRegistration", howManyYearsFromCompanyRegistration.toString()),
//                entry("companyAdministratorName", companyAdministratorName),
//                entry("phoneNumber", phoneNumber),
//                entry("email", email),
//                entry("webAddress", webAddress)
//        ));

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "[");
    }
}
