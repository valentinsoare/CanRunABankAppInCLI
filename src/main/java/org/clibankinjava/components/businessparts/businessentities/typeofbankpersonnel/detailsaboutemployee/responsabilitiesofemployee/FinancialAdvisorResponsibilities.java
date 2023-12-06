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
public class FinancialAdvisorResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "help_clients_determine_goals")
    @Basic(fetch = FetchType.LAZY)
    private boolean helpClientsDetermineGoals;

    @LazyGroup("FIRST_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "help_clients_achieve_goals")
    @Basic(fetch = FetchType.LAZY)
    private boolean helpClientsAchieveGoals;

    @LazyGroup("FIRST_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "trading_in_the_stock_market")
    @Basic(fetch = FetchType.LAZY)
    private boolean tradingInTheStockMarket;

    @LazyGroup("FIRST_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "reviewing_financial_history")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewingFinancialHistory;

    @LazyGroup("SECOND_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "provide_strategic_advice_for_debt_management")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideStrategicAdviceForDebtManagement;

    @LazyGroup("SECOND_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "provide_advice_for_cash_management")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideAdviceForCashManagement;

    @LazyGroup("SECOND_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "provide_strategic_advice_for_debt_insurance_coverage")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideStrategicAdviceForDebtInsuranceCoverage;

    @LazyGroup("SECOND_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "provide_advice_for_investments")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideAdviceForInvestments;

    @LazyGroup("SECOND_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "assess_client_overall_financial_situation")
    @Basic(fetch = FetchType.LAZY)
    private boolean assessClientOverallFinancialSituation;

    @LazyGroup("THIRD_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "develop_financial_plan")
    @Basic(fetch = FetchType.LAZY)
    private boolean developFinancialPlan;

    @LazyGroup("THIRD_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "cultivate_client_base_and_build_relationships")
    @Basic(fetch = FetchType.LAZY)
    private boolean cultivateClientBaseAndBuildRelationships;

    @LazyGroup("THIRD_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "generate_leads")
    @Basic(fetch = FetchType.LAZY)
    private boolean generateLeads;

    @LazyGroup("THIRD_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "sell_mutual_funds_stocks_and_bonds")
    @Basic(fetch = FetchType.LAZY)
    private boolean sellMutualFundsStocksAndBonds;

    @LazyGroup("THIRD_WAVE_FINANCIAL_RESPONSIBILITIES")
    @Column(name = "oversee_the_course_of_the_financial_plan")
    @Basic(fetch = FetchType.LAZY)
    private boolean overseeTheCourseOfTheFinancialPlan;

    public FinancialAdvisorResponsibilities() {
        super();

        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
                entry("helpClientsDetermineGoals", helpClientsDetermineGoals),
                entry("helpClientsAchieveGoals", helpClientsAchieveGoals),
                entry("tradingInTheStockMarket", tradingInTheStockMarket),
                entry("reviewingFinancialHistory", reviewingFinancialHistory),
                entry("provideStrategicAdviceForDebtManagement", provideStrategicAdviceForDebtManagement),
                entry("provideAdviceForCashManagement", provideAdviceForCashManagement),
                entry("provideStrategicAdviceForDebtInsuranceCoverage", provideStrategicAdviceForDebtInsuranceCoverage),
                entry("provideAdviceForInvestments", provideAdviceForInvestments),
                entry("assessClientOverallFinancialSituation", assessClientOverallFinancialSituation),
                entry("developFinancialPlan", developFinancialPlan),
                entry("cultivateClientBaseAndBuildRelationships", cultivateClientBaseAndBuildRelationships),
                entry("generateLeads", generateLeads),
                entry("sellMutualFundsStocksAndBonds", sellMutualFundsStocksAndBonds),
                entry("overseeTheCourseOfTheFinancialPlan", overseeTheCourseOfTheFinancialPlan)
        )));
    }
}
