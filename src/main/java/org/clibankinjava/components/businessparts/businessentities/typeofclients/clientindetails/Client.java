package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.*;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails.Credit;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.longtermcredit.LongTermCredit;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Getter
@Setter
@Entity(name = "Client")
@Table(name = "client", schema = "client")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Client implements Comparable<Client> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("FIRST_WAVE_CLIENT")
    @Column(name = "first_name")
    @Basic(fetch = FetchType.LAZY)
    private String firstName;

    @LazyGroup("FIRST_WAVE_CLIENT")
    @Column(name = "last_name")
    @Basic(fetch = FetchType.LAZY)
    private String lastName;

    @LazyGroup("FIRST_WAVE_CLIENT")
    @Column(name = "email")
    @Basic(fetch = FetchType.LAZY)
    private String email;


    @OrderBy
    @LazyGroup("CREDITS_CONTRACTED")
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Credit> setOfAllCreditsContracted;

    @OrderBy
    @LazyGroup("CREDITS_CONTRACTED")
    @OneToMany(mappedBy = "coSigner", fetch = FetchType.LAZY)
    private Set<LongTermCredit> setOfLongTermCreditsWithCoSigner;

    @LazyGroup("CREATED_BY_EMPLOYEE")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "created_by_employee_id")
    private Employee clientCreatedBy;


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

    @LazyGroup("ACCOUNTS_PER_CLIENT")
    @OneToMany(mappedBy = "ownerInformation.owner", fetch = FetchType.LAZY)
    private Set<Account> setOfAllAccounts;


    @LazyGroup("SALARY_ACCOUNT")
    @Column(name = "salary_account_available_at_this_bank")
    @Basic(fetch = FetchType.LAZY)
    private boolean salaryAccountAvailableAtThisBank;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    protected Client() {}

    @Override
    public int compareTo(@NotNull Client o) {
        return 0;
    }
}
