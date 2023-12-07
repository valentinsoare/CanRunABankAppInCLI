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

@Setter
@Getter
@Embeddable
public class BankTellerResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "cash_checks")
    @Basic(fetch = FetchType.LAZY)
    private boolean cashChecks;

    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "withdraw_money")
    @Basic(fetch = FetchType.LAZY)
    private boolean withdrawMoney;

    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "move_transactions")
    @Basic(fetch = FetchType.LAZY)
    private boolean moveTransactions;

    @LazyGroup("FOURTH_WAVE_RESPONSIBILITIES")
    @Column(name = "create_checking_accounts")
    @Basic(fetch = FetchType.LAZY)
    private boolean createCheckingAccounts;

    @LazyGroup("FIFTH_WAVE_RESPONSIBILITIES")
    @Column(name = "create_savings_accounts")
    @Basic(fetch = FetchType.LAZY)
    private boolean createSavingsAccounts;

    @LazyGroup("FIFTH_WAVE_RESPONSIBILITIES")
    @Column(name = "provide_checks")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideChecks;

    @LazyGroup("FIFTH_WAVE_RESPONSIBILITIES")
    @Column(name = "provide_checks")
    @Basic(fetch = FetchType.LAZY)
    private boolean informClientsOfDifferentBankOfferings;

    @LazyGroup("FIFTH_WAVE_RESPONSIBILITIES")
    @Column(name = "maintaining_confidentiality_with_all_transactions")
    @Basic(fetch = FetchType.LAZY)
    private boolean maintainingConfidentialityWithAllTransactions;

    @LazyGroup("SIXTH_WAVE_RESPONSIBILITIES")
    @Column(name = "records_daily_transactions")
    @Basic(fetch = FetchType.LAZY)
    private boolean recordsDailyTransactions;

    @LazyGroup("SIXTH_WAVE_RESPONSIBILITIES")
    @Column(name = "compile_with_bank_secrecy_act")
    @Basic(fetch = FetchType.LAZY)
    private boolean compileWithBankSecrecyAct;

    @LazyGroup("SIXTH_WAVE_RESPONSIBILITIES")
    @Column(name = "ensureQuality_services_to_customers")
    @Basic(fetch = FetchType.LAZY)
    private boolean ensureQualityServicesToCustomers;

    @LazyGroup("SIXTH_WAVE_RESPONSIBILITIES")
    @Column(name = "accepting_deposits_and_withdrawals")
    @Basic(fetch = FetchType.LAZY)
    private boolean acceptingDepositsAndWithdrawals;

    @LazyGroup("SEVENTH_WAVE_RESPONSIBILITIES")
    @Column(name = "identify_and_resolve_customer_needs")
    @Basic(fetch = FetchType.LAZY)
    private boolean identifyAndResolveCustomerNeeds;

    @LazyGroup("SEVENTH_WAVE_RESPONSIBILITIES")
    @Column(name = "make_sales_referrals")
    @Basic(fetch = FetchType.LAZY)
    private boolean makeSalesReferrals;

    @LazyGroup("SEVENTH_WAVE_RESPONSIBILITIES")
    @Column(name = "process_cash_withdrawals")
    @Basic(fetch = FetchType.LAZY)
    private boolean processCashWithdrawals;

    @LazyGroup("SEVENTH_WAVE_RESPONSIBILITIES")
    @Column(name = "serves_customers_by_completing_account_transactions")
    @Basic(fetch = FetchType.LAZY)
    private boolean servesCustomersByCompletingAccountTransactions;

    @LazyGroup("SEVENTH_WAVE_RESPONSIBILITIES")
    @Column(name = "answering_customer_questions")
    @Basic(fetch = FetchType.LAZY)
    private boolean answeringCustomerQuestions;

    public BankTellerResponsibilities() {
        super();

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);

//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("cashChecks", cashChecks),
//                entry("withdrawMoney", withdrawMoney),
//                entry("moveTransactions", moveTransactions),
//                entry("createCheckingAccounts", createCheckingAccounts),
//                entry("createSavingsAccounts", createSavingsAccounts),
//                entry("provideChecks", provideChecks),
//                entry("informClientsOfDifferentBankOfferings", informClientsOfDifferentBankOfferings),
//                entry("maintainingConfidentialityWithAllTransactions", maintainingConfidentialityWithAllTransactions),
//                entry("recordsDailyTransactions", recordsDailyTransactions),
//                entry("compileWithBankSecrecyAct", compileWithBankSecrecyAct),
//                entry("ensureQualityServicesToCustomers", ensureQualityServicesToCustomers),
//                entry("acceptingDepositsAndWithdrawals", acceptingDepositsAndWithdrawals),
//                entry("identifyAndResolveCustomerNeeds", identifyAndResolveCustomerNeeds),
//                entry("makeSalesReferrals", makeSalesReferrals),
//                entry("processCashWithdrawals", processCashWithdrawals),
//                entry("servesCustomersByCompletingAccountTransactions", servesCustomersByCompletingAccountTransactions),
//                entry("answeringCustomerQuestions", answeringCustomerQuestions)
//        )));

        super.setResponsibilities(m);
    }
}
