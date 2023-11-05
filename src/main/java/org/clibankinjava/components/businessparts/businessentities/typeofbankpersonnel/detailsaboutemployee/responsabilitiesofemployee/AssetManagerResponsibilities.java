package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Getter
@Setter
@Embeddable
public class AssetManagerResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("SECOND_WAVE_RESPONSIBILITIES")
    @Column(name = "running_and_analysing_inventories_of_all_assets")
    @Basic(fetch = FetchType.LAZY)
    private boolean runningAndAnalysingInventoriesOfAllAssets;

    @LazyGroup("SECOND_WAVE_RESPONSIBILITIES")
    @Column(name = "liaising_with_suppliers_to_obtain_the_best_price_for_assets")
    @Basic(fetch = FetchType.LAZY)
    private boolean liaisingWithSuppliersToObtainTheBestPriceForAssets;

    @LazyGroup("SECOND_WAVE_RESPONSIBILITIES")
    @Column(name = "investing_money_for_upcoming_projects")
    @Basic(fetch = FetchType.LAZY)
    private boolean investingMoneyForUpcomingProjects;

    @LazyGroup("SECOND_WAVE_RESPONSIBILITIES")
    @Column(name = "working_with_asset_management_systems_and_tracking_technologies")
    @Basic(fetch = FetchType.LAZY)
    private boolean workingWithAssetManagementSystemsAndTrackingTechnologies;

    @LazyGroup("THIRD_WAVE_RESPONSIBILITIES")
    @Column(name = "working_with_asset_management_systems_and_tracking_technologies")
    @Basic(fetch = FetchType.LAZY)
    private boolean ensuringFinancialRecordsAreUpToDateAndAccurate;

    @LazyGroup("THIRD_WAVE_RESPONSIBILITIES")
    @Column(name = "monitoring_materials_workforce_tools_equipment_and_supplies")
    @Basic(fetch = FetchType.LAZY)
    private boolean monitoringMaterialsWorkforceToolsEquipmentAndSupplies;

    @LazyGroup("THIRD_WAVE_RESPONSIBILITIES")
    @Column(name = "reporting_on_finance_and_forecasting_budgets")
    @Basic(fetch = FetchType.LAZY)
    private boolean reportingOnFinanceAndForecastingBudgets;

    @LazyGroup("THIRD_WAVE_RESPONSIBILITIES")
    @Column(name = "reviewing_client_financial_portfolio")
    @Basic(fetch = FetchType.LAZY)
    private boolean reviewingClientFinancialPortfolio;

    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "monitoring_stock_market")
    @Basic(fetch = FetchType.LAZY)
    private boolean monitoringStockMarket;

    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "determine_best_invest_decision_for_client")
    @Basic(fetch = FetchType.LAZY)
    private boolean determineBestInvestDecisionForClient;

    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "invest_in_stocks_and_other_assets")
    @Basic(fetch = FetchType.LAZY)
    private boolean investInStocksAndOtherAssets;

    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "makeInformed_decisions_potential_investments")
    @Basic(fetch = FetchType.LAZY)
    private boolean makeInformedDecisionsPotentialInvestments;

    public AssetManagerResponsibilities() {
        super();

        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
                entry("runningAndAnalysingInventoriesOfAllAssets", runningAndAnalysingInventoriesOfAllAssets),
                entry("liaisingWithSuppliersToObtainTheBestPriceForAssets", liaisingWithSuppliersToObtainTheBestPriceForAssets),
                entry("investingMoneyForUpcomingProjects", investingMoneyForUpcomingProjects),
                entry("workingWithAssetManagementSystemsAndTrackingTechnologies", workingWithAssetManagementSystemsAndTrackingTechnologies),
                entry("ensuringFinancialRecordsAreUpToDateAndAccurate", ensuringFinancialRecordsAreUpToDateAndAccurate),
                entry("monitoringMaterialsWorkforceToolsEquipmentAndSupplies", monitoringMaterialsWorkforceToolsEquipmentAndSupplies),
                entry("reportingOnFinanceAndForecastingBudgets", reportingOnFinanceAndForecastingBudgets),
                entry("reviewingClientFinancialPortfolio", reviewingClientFinancialPortfolio),
                entry("monitoringStockMarket", monitoringStockMarket),
                entry("determineBestInvestDecisionForClient", determineBestInvestDecisionForClient),
                entry("investInStocksAndOtherAssets", investInStocksAndOtherAssets),
                entry("makeInformedDecisionsPotentialInvestments", makeInformedDecisionsPotentialInvestments)
        )));
    }
}
