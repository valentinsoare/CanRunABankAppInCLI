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

@Getter
@Setter
@Embeddable
public class InvestmentBankingAnalystResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "meeting_with_clients_or_bank_representatives_to_understand_financial_needs_and_goals")
    @Basic(fetch = FetchType.LAZY)
    private boolean meetingWithClientsOrBankRepresentativesToUnderstandFinancialNeedsAndGoals;

    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "servingAs_an_intermediary_between_investors_and_corporations_looking_for_capital")
    @Basic(fetch = FetchType.LAZY)
    private boolean servingAsAnIntermediaryBetweenInvestorsAndCorporationsLookingForCapital;

    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "using_financial_models")
    @Basic(fetch = FetchType.LAZY)
    private boolean usingFinancialModels;

    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "developing_new_financial_models")
    @Basic(fetch = FetchType.LAZY)
    private boolean developingNewFinancialModels;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "researching_the_historical_and_current_performance_of_financial_products")
    @Basic(fetch = FetchType.LAZY)
    private boolean researchingTheHistoricalAndCurrentPerformanceOfFinancialProducts;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "collecting_and_analyzing_financial_data_to_review_portfolios_and_opportunities")
    @Basic(fetch = FetchType.LAZY)
    private boolean collectingAndAnalyzingFinancialDataToReviewPortfoliosAndOpportunities;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "creating_new_financial_offerings")
    @Basic(fetch = FetchType.LAZY)
    private boolean creatingNewFinancialOfferings;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "compiling_reports_on_portfolios_transactions_and_projections")
    @Basic(fetch = FetchType.LAZY)
    private boolean compilingReportsOnPortfoliosTransactionsAndProjections;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKING_ANALYST")
    @Column(name = "performing_administrative_duties_when_needed")
    @Basic(fetch = FetchType.LAZY)
    private boolean performingAdministrativeDutiesWhenNeeded;

    public InvestmentBankingAnalystResponsibilities() {
        super();

        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
                entry("meetingWithClientsOrBankRepresentativesToUnderstandFinancialNeedsAndGoals", meetingWithClientsOrBankRepresentativesToUnderstandFinancialNeedsAndGoals),
                entry("servingAsAnIntermediaryBetweenInvestorsAndCorporationsLookingForCapital", servingAsAnIntermediaryBetweenInvestorsAndCorporationsLookingForCapital),
                entry("usingFinancialModels", usingFinancialModels),
                entry("developingNewFinancialModels", developingNewFinancialModels),
                entry("researchingTheHistoricalAndCurrentPerformanceOfFinancialProducts", researchingTheHistoricalAndCurrentPerformanceOfFinancialProducts),
                entry("collectingAndAnalyzingFinancialDataToReviewPortfoliosAndOpportunities", collectingAndAnalyzingFinancialDataToReviewPortfoliosAndOpportunities),
                entry("creatingNewFinancialOfferings", creatingNewFinancialOfferings),
                entry("compilingReportsOnPortfoliosTransactionsAndProjections", compilingReportsOnPortfoliosTransactionsAndProjections),
                entry("performingAdministrativeDutiesWhenNeeded", performingAdministrativeDutiesWhenNeeded)
        )));
    }
}
