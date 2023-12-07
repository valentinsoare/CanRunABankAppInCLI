package org.clibankinjava.components.businessparts.businessentities
        .typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;

import java.util.Map;

@Getter
@Setter
@Embeddable
public abstract class EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_RESPONSIBILITIES")
    @Column(name = "able_to_create_user")
    @Basic(fetch = FetchType.LAZY)
    private boolean ableToCreateUser;

    @LazyGroup("FIRST_WAVE_RESPONSIBILITIES")
    @Column(name = "able_to_create_employee")
    @Basic(fetch = FetchType.LAZY)
    private boolean ableToCreateEmployee;

    @LazyGroup("FIRST_WAVE_RESPONSIBILITIES")
    @Column(name = "able_to_create_client")
    @Basic(fetch = FetchType.LAZY)
    private boolean ableToCreateClient;

    @LazyGroup("FIRST_WAVE_RESPONSIBILITIES")
    @Column(name = "able_to_create_bank_reports")
    @Basic(fetch = FetchType.LAZY)
    private boolean ableToCreateBankReports;

    @LazyGroup("FIRST_WAVE_RESPONSIBILITIES")
    @Column(name = "able_to_give_confidential_information")
    @Basic(fetch = FetchType.LAZY)
    private boolean ableToGiveConfidentialInformation;

    @Transient
    private Map<String, ?> responsibilities;

    protected EmployeeGenericResponsibilities() {}

    @Override
    public String toString() {
        StringBuilder printingResponsibilities = new StringBuilder("Responsibilities [");

        for (Map.Entry<String, ?> element : responsibilities.entrySet()) {
            printingResponsibilities.append(String.format("%s: %s, ", element.getKey(), element.getValue()));
        }

        printingResponsibilities
                .append(String.format("ableToCreateUser: %s, ableToCreateEmployee: %s, ableToCreateClient: %s, ableToCreateBankReports: %s," +
                                "ableToGiveConfidentialInformation: %s]",
                        ableToCreateUser, ableToCreateEmployee, ableToCreateClient, ableToCreateBankReports, ableToGiveConfidentialInformation));

        return printingResponsibilities.toString();
    }
}
