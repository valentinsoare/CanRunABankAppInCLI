package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.OperationsOnMap;
import org.hibernate.annotations.LazyGroup;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class InvestmentRepresentativeResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "promote_investment_products_and_services")
    @Basic(fetch = FetchType.LAZY)
    private boolean promoteInvestmentProductsAndServices;

    @LazyGroup("FIRST_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "sellInvestment_products_and_services_to_final_customers")
    @Basic(fetch = FetchType.LAZY)
    private boolean sellInvestmentProductsAndServicesToFinalCustomers;

    @LazyGroup("FIRST_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "identify_sales_opportunities")
    @Basic(fetch = FetchType.LAZY)
    private boolean identifySalesOpportunities;

    @LazyGroup("FIRST_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "generate_sales_opportunities")
    @Basic(fetch = FetchType.LAZY)
    private boolean generateSalesOpportunities;

    @LazyGroup("SECOND_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "crossSell_all_investment_products_and_services")
    @Basic(fetch = FetchType.LAZY)
    private boolean crossSellAllInvestmentProductsAndServices;

    @LazyGroup("SECOND_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "participate_in_sales_program")
    @Basic(fetch = FetchType.LAZY)
    private boolean participateInSalesProgram;

    @LazyGroup("SECOND_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "monitoring_the_renewal_of_maturing_investments")
    @Basic(fetch = FetchType.LAZY)
    private boolean monitoringTheRenewalOfMaturingInvestments;

    @LazyGroup("SECOND_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "update_transactions_records")
    @Basic(fetch = FetchType.LAZY)
    private boolean updateTransactionsRecords;

    @LazyGroup("THIRD_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "process_transactions_documents")
    @Basic(fetch = FetchType.LAZY)
    private boolean processTransactionsDocuments;

    @LazyGroup("THIRD_WAVE_INVESTMENT_REPRESENTATIVE_RESPONSIBILITIES")
    @Column(name = "complete_mutual_fund_licensing_requirements")
    @Basic(fetch = FetchType.LAZY)
    private boolean completeMutualFundLicensingRequirements;

    public InvestmentRepresentativeResponsibilities() {
        super();

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);
//
//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("promoteInvestmentProductsAndServices", promoteInvestmentProductsAndServices),
//                entry("sellInvestmentProductsAndServicesToFinalCustomers", sellInvestmentProductsAndServicesToFinalCustomers),
//                entry("identifySalesOpportunities", identifySalesOpportunities),
//                entry("generateSalesOpportunities", generateSalesOpportunities),
//                entry("crossSellAllInvestmentProductsAndServices", crossSellAllInvestmentProductsAndServices),
//                entry("participateInSalesProgram", participateInSalesProgram),
//                entry("monitoringTheRenewalOfMaturingInvestments", monitoringTheRenewalOfMaturingInvestments),
//                entry("updateTransactionsRecords", updateTransactionsRecords),
//                entry("processTransactionsDocuments", processTransactionsDocuments),
//                entry("completeMutualFundLicensingRequirements", completeMutualFundLicensingRequirements)
//        )));

        super.setResponsibilities(m);
    }
}
