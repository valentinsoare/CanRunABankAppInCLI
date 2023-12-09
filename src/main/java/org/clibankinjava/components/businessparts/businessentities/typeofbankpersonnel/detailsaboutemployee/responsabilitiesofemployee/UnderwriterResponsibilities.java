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


@Setter
@Getter
@Embeddable
public class UnderwriterResponsibilities extends EmployeeGenericResponsibilities {

    @LazyGroup("FIRST_WAVE_UNDERWRITER")
    @Column(name = "review_approved_loans_to_ensure_all_legal_regulations_are_met")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewApprovedLoansToEnsureAllLegalRegulationsAreMet;

    @LazyGroup("FIRST_WAVE_UNDERWRITER")
    @Column(name = "make_sure_all_company_policies_are_met")
    @Basic(fetch = FetchType.LAZY)
    private boolean makeSureAllCompanyPoliciesAreMet;

    @LazyGroup("FIRST_WAVE_UNDERWRITER")
    @Column(name = "research_all_areas_of_an_applicants_financial_background_and_make_sure_all_ok")
    @Basic(fetch = FetchType.LAZY)
    private boolean researchAllAreasOfAnApplicantsFinancialBackgroundAndMakeSureAllOk;

    @LazyGroup("FIRST_WAVE_UNDERWRITER")
    @Column(name = "check_employment_history")
    @Basic(fetch = FetchType.LAZY)
    private boolean checkEmploymentHistory;

    @LazyGroup("SECOND_WAVE_UNDERWRITER")
    @Column(name = "review_credit_reports")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewCreditReports;

    @LazyGroup("SECOND_WAVE_UNDERWRITER")
    @Column(name = "review_asset_information")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewAssetInformation;

    @LazyGroup("SECOND_WAVE_UNDERWRITER")
    @Column(name = "create_risk_assessment_reports_for_each_applicant")
    @Basic(fetch = FetchType.LAZY)
    private boolean createRiskAssessmentReportsForEachApplicant;

    @LazyGroup("SECOND_WAVE_UNDERWRITER")
    @Column(name = "analyze_financial_information")
    @Basic(fetch = FetchType.LAZY)
    private boolean analyzeFinancialInformation;

    @LazyGroup("THIRD_WAVE_UNDERWRITER")
    @Column(name = "advise_the_company_to_approve_or_not_the_loan_based_on_risk")
    @Basic(fetch = FetchType.LAZY)
    private boolean adviseTheCompanyToApproveOrNotTheLoanBasedOnRisk;

    @LazyGroup("THIRD_WAVE_UNDERWRITER")
    @Column(name = "credit_risk_assessment")
    @Basic(fetch = FetchType.LAZY)
    private boolean creditRiskAssessment;

    @LazyGroup("THIRD_WAVE_UNDERWRITER")
    @Column(name = "proofread_files_before_they_are_submitted_for_approval")
    @Basic(fetch = FetchType.LAZY)
    private boolean proofreadFilesBeforeTheyAreSubmittedForApproval;

    public UnderwriterResponsibilities() {
        super();

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);

//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("reviewApprovedLoansToEnsureAllLegalRegulationsAreMet", reviewApprovedLoansToEnsureAllLegalRegulationsAreMet),
//                entry("makeSureAllCompanyPoliciesAreMet", makeSureAllCompanyPoliciesAreMet),
//                entry("researchAllAreasOfAnApplicantsFinancialBackgroundAndMakeSureAllOk", researchAllAreasOfAnApplicantsFinancialBackgroundAndMakeSureAllOk),
//                entry("checkEmploymentHistory", checkEmploymentHistory),
//                entry("reviewCreditReports", reviewCreditReports),
//                entry("reviewAssetInformation", reviewAssetInformation),
//                entry("createRiskAssessmentReportsForEachApplicant", createRiskAssessmentReportsForEachApplicant),
//                entry("analyzeFinancialInformation", analyzeFinancialInformation),
//                entry("adviseTheCompanyToApproveOrNotTheLoanBasedOnRisk", adviseTheCompanyToApproveOrNotTheLoanBasedOnRisk),
//                entry("creditRiskAssessment", creditRiskAssessment),
//                entry("proofreadFilesBeforeTheyAreSubmittedForApproval", proofreadFilesBeforeTheyAreSubmittedForApproval)
//        )));

        super.setResponsibilities(m);
    }
}
