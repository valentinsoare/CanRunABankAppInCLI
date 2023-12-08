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
public class LoanProcessorResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "risk_analysis")
    @Basic(fetch = FetchType.LAZY)
    private boolean riskAnalysis;

    @LazyGroup("FIRST_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "review_loan_applications")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewLoanApplications;

    @LazyGroup("FIRST_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "approve_applicants")
    @Basic(fetch = FetchType.LAZY)
    private boolean approveApplicants;

    @LazyGroup("FIRST_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "deny_applicants")
    @Basic(fetch = FetchType.LAZY)
    private boolean denyApplicants;

    @LazyGroup("SECOND_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "interview_applicants_and_evaluate_them")
    @Basic(fetch = FetchType.LAZY)
    private boolean interviewApplicantsAndEvaluateThem;

    @LazyGroup("SECOND_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "follow_up_with_clients")
    @Basic(fetch = FetchType.LAZY)
    private boolean followUpWithClients;

    @LazyGroup("SECOND_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "finalize_loan_contracts_and_keep_clients_informed")
    @Basic(fetch = FetchType.LAZY)
    private boolean finalizeLoanContractsAndKeepClientsInformed;

    @LazyGroup("SECOND_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "create_and_renew_records")
    @Basic(fetch = FetchType.LAZY)
    private boolean createAndRenewRecords;

    @LazyGroup("THIRD_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "identify_customer_needs")
    @Basic(fetch = FetchType.LAZY)
    private boolean identifyCustomerNeeds;

    @LazyGroup("THIRD_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "cultivate_trustworthy_referral_networks")
    @Basic(fetch = FetchType.LAZY)
    private boolean cultivateTrustworthyReferralNetworks;

    @LazyGroup("THIRD_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "forgeTrust_relationships")
    @Basic(fetch = FetchType.LAZY)
    private boolean forgeTrustRelationships;

    @LazyGroup("THIRD_WAVE_LOAN_PROCESSOR_RESPONSIBILITIES")
    @Column(name = "enhance_customer_dedication")
    @Basic(fetch = FetchType.LAZY)
    private boolean enhanceCustomerDedication;

    public LoanProcessorResponsibilities() {
        super();

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);
//
//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("riskAnalysis", riskAnalysis),
//                entry("reviewLoanApplications", reviewLoanApplications),
//                entry("approveApplicants", approveApplicants),
//                entry("denyApplicants", denyApplicants),
//                entry("interviewApplicantsAndEvaluateThem", interviewApplicantsAndEvaluateThem),
//                entry("followUpWithClients", followUpWithClients),
//                entry("finalizeLoanContractsAndKeepClientsInformed", finalizeLoanContractsAndKeepClientsInformed),
//                entry("createAndRenewRecords", createAndRenewRecords),
//                entry("identifyCustomerNeeds", identifyCustomerNeeds),
//                entry("cultivateTrustworthyReferralNetworks", cultivateTrustworthyReferralNetworks),
//                entry("forgeTrustRelationships", forgeTrustRelationships),
//                entry("enhanceCustomerDedication", enhanceCustomerDedication)
//        )));

        super.setResponsibilities(m);
    }
}
