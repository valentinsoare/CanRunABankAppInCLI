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
public class InvestmentBankerResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "conduct_strategic_research_and_due_diligence_investigations")
    private boolean conductStrategicResearchAndDueDiligenceInvestigations;

    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "issue_debt_and_sell_equity_to_raise_capital")
    private boolean issueDebtAndSellEquityToRaiseCapital;

    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "manage_ipo_and_private_equity_placements")
    private boolean manageIpoAndPrivateEquityPlacements;

    @LazyGroup("FIRST_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "discover_and_close_potential_investors")
    private boolean discoverAndClosePotentialInvestors;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "facilitate_mergers_and_acquisitions")
    private boolean facilitateMergersAndAcquisitions;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "assist_with_corporate_restructuring")
    private boolean assistWithCorporateRestructuring;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "analyze_risk_and_offer_financial_advice")
    private boolean analyzeRiskAndOfferFinancialAdvice;

    @LazyGroup("SECOND_WAVE_INVESTMENT_BANKER_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "prepare_reports_models_and_forecasts")
    private boolean prepareReportsModelsAndForecasts;

    public InvestmentBankerResponsibilities() {
        super();

        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
                entry("conductStrategicResearchAndDueDiligenceInvestigations", conductStrategicResearchAndDueDiligenceInvestigations),
                entry("issueDebtAndSellEquityToRaiseCapital", issueDebtAndSellEquityToRaiseCapital),
                entry("manageIpoAndPrivateEquityPlacements", manageIpoAndPrivateEquityPlacements),
                entry("discoverAndClosePotentialInvestors", discoverAndClosePotentialInvestors),
                entry("facilitateMergersAndAcquisitions", facilitateMergersAndAcquisitions),
                entry("assistWithCorporateRestructuring", assistWithCorporateRestructuring),
                entry("analyzeRiskAndOfferFinancialAdvice", analyzeRiskAndOfferFinancialAdvice),
                entry("prepareReportsModelsAndForecasts", prepareReportsModelsAndForecasts)
        )));
    }
}
