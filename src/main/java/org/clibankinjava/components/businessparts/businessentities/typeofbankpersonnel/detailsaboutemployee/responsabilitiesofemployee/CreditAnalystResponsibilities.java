package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.OperationsOnMap;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Getter
@Setter
@Embeddable
public class CreditAnalystResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "reviewing_financial_history")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewingFinancialHistory;

    @LazyGroup("FIRST_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "reviewing_credit_score")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewingCreditScore;

    @LazyGroup("FIRST_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "provide_recommendation_for_approving")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideRecommendationForApproving;

    @LazyGroup("FIRST_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "gathers_and_analyzes_loan_applicants_financial_data_to_evaluate_risk")
    @Basic(fetch = FetchType.LAZY)
    private boolean gathersAndAnalyzesLoanApplicantsFinancialDataToEvaluateRisk;

    @LazyGroup("SECOND_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "gathering_information_about_clients")
    @Basic(fetch = FetchType.LAZY)
    private boolean gatheringInformationAboutClients;

    @LazyGroup("SECOND_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "undertaking_risk_analysis_by_usingSpecialist_software")
    @Basic(fetch = FetchType.LAZY)
    private boolean undertakingRiskAnalysisByUsingSpecialistSoftware;

    @LazyGroup("SECOND_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "developing_statistical_models")
    @Basic(fetch = FetchType.LAZY)
    private boolean developingStatisticalModels;

    @LazyGroup("SECOND_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "assessing_financial_information")
    @Basic(fetch = FetchType.LAZY)
    private boolean assessingFinancialInformation;

    @LazyGroup("SECOND_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "analysing_financial_information")
    @Basic(fetch = FetchType.LAZY)
    private boolean analysingFinancialInformation;

    @LazyGroup("THIRD_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "building_and_maintaining_client_relationships")
    @Basic(fetch = FetchType.LAZY)
    private boolean buildingAndMaintainingClientRelationships;

    @LazyGroup("THIRD_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "creating_and_delivering_presentations")
    @Basic(fetch = FetchType.LAZY)
    private boolean creatingAndDeliveringPresentations;

    @LazyGroup("THIRD_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "creating_financial_reports")
    @Basic(fetch = FetchType.LAZY)
    private boolean creatingFinancialReports;

    @LazyGroup("THIRD_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "using_credit_scoringSystems_for_credit_amounts")
    @Basic(fetch = FetchType.LAZY)
    private boolean usingCreditScoringSystemsForCreditAmounts;

    @LazyGroup("THIRD_WAVE_CREDIT_ANALYST_RESPONSIBILITIES")
    @Column(name = "helping_to_enhance_quality_ff_credit_applications")
    @Basic(fetch = FetchType.LAZY)
    private boolean helpingToEnhanceQualityOfCreditApplications;

    public CreditAnalystResponsibilities() {
        super();

        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
                entry("reviewingFinancialHistory", reviewingFinancialHistory),
                entry("reviewingCreditScore", reviewingCreditScore),
                entry("provideRecommendationForApproving", provideRecommendationForApproving),
                entry("gathersAndAnalyzesLoanApplicantsFinancialDataToEvaluateRisk", gathersAndAnalyzesLoanApplicantsFinancialDataToEvaluateRisk),
                entry("gatheringInformationAboutClients", gatheringInformationAboutClients),
                entry("undertakingRiskAnalysisByUsingSpecialistSoftware", undertakingRiskAnalysisByUsingSpecialistSoftware),
                entry("developingStatisticalModels", developingStatisticalModels),
                entry("assessingFinancialInformation", assessingFinancialInformation),
                entry("analysingFinancialInformation", analysingFinancialInformation),
                entry("buildingAndMaintainingClientRelationships", buildingAndMaintainingClientRelationships),
                entry("creatingAndDeliveringPresentations", creatingAndDeliveringPresentations),
                entry("creatingFinancialReports", creatingFinancialReports),
                entry("usingCreditScoringSystemsForCreditAmounts", usingCreditScoringSystemsForCreditAmounts),
                entry("helpingToEnhanceQualityOfCreditApplications", helpingToEnhanceQualityOfCreditApplications)
        )));

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);
    }
}
