package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.*;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Getter
@Setter
@Embeddable
public class RelationshipWithEmployeesDetails {
    @LazyGroup("ASSET_MANAGER")
    @Column(name = "have_an_asset_manager")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveAnAssetManager;

    @LazyGroup("ASSET_MANAGER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "asset_manager_id")
    private AssetManager assetManager;

    @LazyGroup("FINANCIAL_ADVISOR")
    @Column(name = "have_a_financial_advisor")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveAFinancialAdvisor;

    @LazyGroup("FINANCIAL_ADVISER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "financial_advisor_id")
    private FinancialAdvisor financialAdvisor;

    @LazyGroup("BANKER")
    @Column(name = "have_a_banker")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveABanker;

    @LazyGroup("BANKER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "banker_id")
    private FinancialAdvisor banker;

    @LazyGroup("INVESTMENT_BANKER")
    @Column(name = "have_an_investment_banker")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveAnInvestmentBanker;

    @LazyGroup("INVESTMENT_BANKER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "investment_banker_id")
    private InvestmentBanker investmentBanker;

    @LazyGroup("INVESTMENT_REPRESENTATIVE")
    @Column(name = "have_an_investment_representative")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveAnInvestmentRepresentative;

    @LazyGroup("INVESTMENT_REPRESENTATIVE")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "investment_representative_id")
    private InvestmentRepresentative investmentRepresentative;

    @LazyGroup("LOAN_OFFICER")
    @Column(name = "have_a_loan_officer")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveALoanOfficer;

    @LazyGroup("LOAN_OFFICER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "loan_officer_id")
    private LoanOfficer loanOfficer;

    @LazyGroup("CREDIT_ANALYST")
    @Column(name = "have_a_credit_analyst")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveACreditAnalyst;

    @LazyGroup("CREDIT_ANALYST")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "credit_analyst_id")
    private CreditAnalyst creditAnalyst;

    @LazyGroup("LOAN_PROCESSOR")
    @Column(name = "have_a_loan_processor")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveALoanProcessor;

    @LazyGroup("LOAN_PROCESSOR")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "loan_processor_id")
    private LoanProcessor loanProcessor;

    @LazyGroup("MORTGAGE_CONSULTANT")
    @Column(name = "mortgage_consultant")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveAMortgageConsultant;

    @LazyGroup("MORTGAGE_CONSULTANT")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "mortgage_consultant_id")
    private MortgageConsultant mortgageConsultant;

    @LazyGroup("RELATIONSHIP_MANAGER")
    @Column(name = "relationship_manager")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveARelationshipManager;

    @LazyGroup("RELATIONSHIP_MANGER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "relationship_manager_id")
    private RelationshipManager relationshipManager;

    @LazyGroup("UNDERWRITER")
    @Column(name = "underwriter")
    @Basic(fetch = FetchType.LAZY)
    private boolean haveAnUnderwriter;

    @LazyGroup("UNDERWRITER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "underwriter_id")
    private Underwriter underwriter;

    public RelationshipWithEmployeesDetails() {}

    @Override
    public String toString() {
        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
                entry("haveAnAssetManager", String.valueOf(haveAnAssetManager)),
                entry("assetManager", assetManager.getEmail()),
                entry("haveAFinancialAdvisor", String.valueOf(haveAFinancialAdvisor)),
                entry("financialAdvisor", financialAdvisor.getEmail()),
                entry("haveABanker", String.valueOf(haveABanker)),
                entry("banker", banker.getEmail()),
                entry("haveAnInvestmentBanker", String.valueOf(haveAnInvestmentBanker)),
                entry("investmentBanker", investmentBanker.getEmail()),
                entry("haveAnInvestmentRepresentative", String.valueOf(haveAnInvestmentRepresentative)),
                entry("investmentRepresentative", investmentRepresentative.getEmail()),
                entry("haveALoanOfficer", String.valueOf(haveALoanOfficer)),
                entry("loanOfficer", loanOfficer.getEmail()),
                entry("haveACreditAnalyst", String.valueOf(haveACreditAnalyst)),
                entry("creditAnalyst", creditAnalyst.getEmail()),
                entry("haveALoanProcessor", String.valueOf(haveALoanProcessor)),
                entry("loanProcessor", loanProcessor.getEmail()),
                entry("haveAMortgageConsultant", String.valueOf(haveAMortgageConsultant)),
                entry("mortgageConsultant", mortgageConsultant.getEmail()),
                entry("haveARelationshipManager", String.valueOf(haveARelationshipManager)),
                entry("relationshipManager", relationshipManager.getEmail()),
                entry("haveAnUnderwriter", String.valueOf(haveAnUnderwriter)),
                entry("underwriter", underwriter.getEmail())
        ));

        return CustomPrinting.of(characteristics, "[");
    }
}
