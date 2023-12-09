package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.hibernate.annotations.LazyGroup;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class LoanOfficerResponsibilities extends EmployeeGenericResponsibilities {

    @LazyGroup("FIRST_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "process_loan_applications")
    @Basic(fetch = FetchType.LAZY)
    private boolean processLoanApplications;

    @LazyGroup("FIRST_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "evaluate_credit_worthiness")
    @Basic(fetch = FetchType.LAZY)
    private boolean evaluateCreditWorthiness;

    @LazyGroup("FIRST_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "interview_applicants_to_determine_financial_eligibility")
    @Basic(fetch = FetchType.LAZY)
    private boolean interviewApplicantsToDetermineFinancialEligibility;

    @LazyGroup("FIRST_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "setting_up_debt_payment_plans")
    @Basic(fetch = FetchType.LAZY)
    private boolean settingUpDebtPaymentPlans;

    @LazyGroup("SECOND_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "determine_all_applicable_ratios_and_metrics")
    @Basic(fetch = FetchType.LAZY)
    private boolean determineAllApplicableRatiosAndMetrics;

    @LazyGroup("SECOND_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "communicate_with_clients")
    @Basic(fetch = FetchType.LAZY)
    private boolean communicateWithClients;

    @LazyGroup("SECOND_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "justify_decisions_and_report_on_them")
    @Basic(fetch = FetchType.LAZY)
    private boolean justifyDecisionsAndReportOnThem;

    @LazyGroup("SECOND_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "complete_loan_contracts_and_counsel_clients_on_policies_and_restrictions")
    @Basic(fetch = FetchType.LAZY)
    private boolean completeLoanContractsAndCounselClientsOnPoliciesAndRestrictions;

    @LazyGroup("THIRD_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "maintain_and_update_account_records")
    @Basic(fetch = FetchType.LAZY)
    private boolean maintainAndUpdateAccountRecords;

    @LazyGroup("THIRD_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "assess_customer_needs_and_introduce_different_types_of_loans")
    @Basic(fetch = FetchType.LAZY)
    private boolean assessCustomerNeedsAndIntroduceDifferentTypesOfLoans;

    @LazyGroup("THIRD_WAVE_LOAN_OFFICER_RESPONSIBILITIES")
    @Column(name = "develop_referral_networks")
    @Basic(fetch = FetchType.LAZY)
    private boolean developReferralNetworks;

    public LoanOfficerResponsibilities() {
        super();

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);
//
//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("processLoanApplications", processLoanApplications),
//                entry("evaluateCreditWorthiness", evaluateCreditWorthiness),
//                entry("interviewApplicantsToDetermineFinancialEligibility", interviewApplicantsToDetermineFinancialEligibility),
//                entry("settingUpDebtPaymentPlans", settingUpDebtPaymentPlans),
//                entry("determineAllApplicableRatiosAndMetrics", determineAllApplicableRatiosAndMetrics),
//                entry("communicateWithClients", communicateWithClients),
//                entry("justifyDecisionsAndReportOnThem", justifyDecisionsAndReportOnThem),
//                entry("completeLoanContractsAndCounselClientsOnPoliciesAndRestrictions", completeLoanContractsAndCounselClientsOnPoliciesAndRestrictions),
//                entry("maintainAndUpdateAccountRecords", maintainAndUpdateAccountRecords),
//                entry("assessCustomerNeedsAndIntroduceDifferentTypesOfLoans", assessCustomerNeedsAndIntroduceDifferentTypesOfLoans),
//                entry("developReferralNetworks", developReferralNetworks)
//        )));

        super.setResponsibilities(m);
    }
}
