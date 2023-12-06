package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Setter
@Getter
@Embeddable
public class FinancialAnalystResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Column(name = "gathering_data_and_information")
    @Basic(fetch = FetchType.LAZY)
    private boolean gatheringDataAndInformation;

    @LazyGroup("FIRST_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Column(name = "gathering_data_and_information")
    @Basic(fetch = FetchType.LAZY)
    private boolean organizeInformation;

    @LazyGroup("FIRST_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Column(name = "analyze_financial_results")
    @Basic(fetch = FetchType.LAZY)
    private boolean analyzeFinancialResults;

    @LazyGroup("FIRST_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "make_forecasts_and_projections")
    private boolean makeForecastsAndProjections;

    @LazyGroup("SECOND_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "develop_recommendations")
    private boolean developRecommendations;

    @LazyGroup("SECOND_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "build_excel_models")
    private boolean buildExcelModels;

    @LazyGroup("SECOND_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "make_presentations")
    private boolean makePresentations;

    @LazyGroup("SECOND_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "generate_reports")
    private boolean generateReports;

    @LazyGroup("THIRD_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "develop_financial_models")
    private boolean developFinancialModels;

    @LazyGroup("THIRD_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "identify_trends")
    private boolean identifyTrends;

    @LazyGroup("THIRD_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "reconcile_transactions")
    private boolean reconcileTransactions;

    @LazyGroup("THIRD_WAVE_FINANCIAL_ANALYST_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "provide_recommendations")
    private boolean provideRecommendations;

    public FinancialAnalystResponsibilities() {
        super();

        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
                entry("gatheringDataAndInformation", gatheringDataAndInformation),
                entry("organizeInformation", organizeInformation),
                entry("analyzeFinancialResults", analyzeFinancialResults),
                entry("makeForecastsAndProjections", makeForecastsAndProjections),
                entry("developRecommendations", developRecommendations),
                entry("buildExcelModels", buildExcelModels),
                entry("makePresentations", makePresentations),
                entry("generateReports", generateReports),
                entry("developFinancialModels", developFinancialModels),
                entry("identifyTrends", identifyTrends),
                entry("reconcileTransactions", reconcileTransactions),
                entry("provideRecommendations", provideRecommendations))
        ));
    }
}

