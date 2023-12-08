package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.hibernate.annotations.LazyGroup;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class BankerResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("BANKER_RESPONSIBILITIES_FIRST_WAVE")
    @Column(name = "signing_new_clients")
    @Basic(fetch = FetchType.LAZY)
    private boolean signingNewClients;

    @LazyGroup("BANKER_RESPONSIBILITIES_FIRST_WAVE")
    @Column(name = "help_with_onboarding_process")
    @Basic(fetch = FetchType.LAZY)
    private boolean helpWithOnboardingProcess;

    @LazyGroup("BANKER_RESPONSIBILITIES_FIRST_WAVE")
    @Column(name = "advise_customer_on_bank_services")
    @Basic(fetch = FetchType.LAZY)
    private boolean adviseCustomerOnBankServices;

    @LazyGroup("BANKER_RESPONSIBILITIES_FIRST_WAVE")
    @Column(name = "resolve_issues_with_banking_services_and_accounts")
    @Basic(fetch = FetchType.LAZY)
    private boolean resolveIssuesWithBankingServicesAndAccounts;

    @LazyGroup("BANKER_RESPONSIBILITIES_FIRST_WAVE")
    @Column(name = "resolve_issues_with_banking_services_and_accounts")
    @Basic(fetch = FetchType.LAZY)
    private boolean referClientsToInHouseFinancialExperts;

    @LazyGroup("BANKER_RESPONSIBILITIES_SECOND_WAVE")
    @Column(name = "present_financial_products_and_services_to_existing_and_prospective_customers")
    @Basic(fetch = FetchType.LAZY)
    private boolean presentFinancialProductsAndServicesToExistingAndProspectiveCustomers;

    @LazyGroup("BANKER_RESPONSIBILITIES_SECOND_WAVE")
    @Column(name = "perform_administrative_duties")
    @Basic(fetch = FetchType.LAZY)
    private boolean performAdministrativeDuties;

    @LazyGroup("BANKER_RESPONSIBILITIES_SECOND_WAVE")
    @Column(name = "meetings_with_bank_members")
    @Basic(fetch = FetchType.LAZY)
    private boolean meetingsWithBankMembers;

    @LazyGroup("BANKER_RESPONSIBILITIES_SECOND_WAVE")
    @Column(name = "giving_help_acquiring_loans")
    @Basic(fetch = FetchType.LAZY)
    private boolean givingHelpAcquiringLoans;

    @LazyGroup("BANKER_RESPONSIBILITIES_SECOND_WAVE")
    @Column(name = "paid_consultation")
    @Basic(fetch = FetchType.LAZY)
    private boolean paidConsultation;

    public BankerResponsibilities() {
        super();

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);

//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("signingNewClients", signingNewClients),
//                entry("helpWithOnboardingProcess", helpWithOnboardingProcess),
//                entry("adviseCustomerOnBankServices", adviseCustomerOnBankServices),
//                entry("resolveIssuesWithBankingServicesAndAccounts", resolveIssuesWithBankingServicesAndAccounts),
//                entry("referClientsToInHouseFinancialExperts", referClientsToInHouseFinancialExperts),
//                entry("presentFinancialProductsAndServicesToExistingAndProspectiveCustomers", presentFinancialProductsAndServicesToExistingAndProspectiveCustomers),
//                entry("performAdministrativeDuties", performAdministrativeDuties),
//                entry("meetingsWithBankMembers", meetingsWithBankMembers),
//                entry("givingHelpAcquiringLoans", givingHelpAcquiringLoans),
//                entry("paidConsultation", paidConsultation)
//        )));

        super.setResponsibilities(m);
    }
}
