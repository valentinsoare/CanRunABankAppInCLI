package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.transactionwithdetails.BankTransaction;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.Check;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.CreditCard;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.DebitCard;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.TypeOfClient;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

@Getter
@Setter
@Embeddable
public class EconomicCharacteristics implements Comparable<EconomicCharacteristics> {
    @LazyGroup("MAIN")
    @Column(name = "iban")
    @Basic(fetch = FetchType.LAZY)
    private String iban;

    @LazyGroup("MAIN")
    @Column(name = "bic")
    @Basic(fetch = FetchType.LAZY)
    private String bic;

    @LazyGroup("MAIN")
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    @Basic(fetch = FetchType.LAZY)
    private CurrencyOnAccount currency;


    @LazyGroup("MONEY")
    @Column(name = "balance")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal balance;

    @LazyGroup("MONEY")
    @Column(name = "required_minimum_balance")
    @Basic(fetch = FetchType.LAZY)
    private boolean requiredMinimumBalance;

    @LazyGroup("MONEY")
    @Column(name = "minimum_balance")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal minimumBalance;

    @LazyGroup("MONEY")
    @Column(name = "amount_last_debited")
    @Basic(fetch = FetchType.LAZY)
    private String lastDebitedTransaction;

    @LazyGroup("MONEY")
    @Column(name = "amount_last_credited")
    @Basic(fetch = FetchType.LAZY)
    private String lastCreditedTransaction;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<BankTransaction> transactions;


    @LazyGroup("CLIENT_TYPE")
    @Column(name = "type_of_client")
    @Basic(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private TypeOfClient typeOfClient;


    @LazyGroup("DETAILS")
    @Column(name = "internet_bank_service")
    @Basic(fetch = FetchType.LAZY)
    private boolean internetBankService;

    @LazyGroup("DETAILS")
    @Column(name = "mobile_check_deposit")
    @Basic(fetch = FetchType.LAZY)
    private boolean mobileCheckDeposit;

    @LazyGroup("DETAILS")
    @Column(name = "online_bill_pay")
    @Basic(fetch = FetchType.LAZY)
    private boolean onlineBillPay;

    @LazyGroup("DETAILS")
    @Column(name = "email_and_text_alerts")
    @Basic(fetch = FetchType.LAZY)
    private boolean emailAndTextAlerts;

    @LazyGroup("DETAILS")
    @Column(name = "debit_card_available")
    @Basic(fetch = FetchType.LAZY)
    private boolean debitCardAvailable;

    @LazyGroup("DETAILS")
    @Column(name = "possible_to_overdraft")
    @Basic(fetch = FetchType.LAZY)
    private boolean possibleToOverdraft;

    @LazyGroup("DEBIT_CARD")
    @Column(name = "debit_card_provided")
    @Basic(fetch = FetchType.LAZY)
    private boolean debitCardProvided;

    @LazyGroup("DEBIT_CARD")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "debit_card_id", unique = true, columnDefinition = "long default -1")
    private DebitCard debitCard;


    @LazyGroup("CREDIT_CARD")
    @Column(name = "credit_card_provided")
    @Basic(fetch = FetchType.LAZY)
    private boolean creditCardProvided;

    @LazyGroup("CREDIT_CARD")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id", unique = true, columnDefinition = "long default -1")
    private CreditCard creditCard;

    @LazyGroup("CHECK")
    @Column(name = "check_provided")
    @Basic(fetch = FetchType.LAZY)
    private boolean checkProvided;

    @OneToMany(mappedBy = "account")
    private Set<Check> checks;

    public EconomicCharacteristics() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EconomicCharacteristics that)) return false;

        if ((!that.iban.equals(iban)) || (!that.currency.equals(currency))) return false;
        return that.balance.equals(balance);
    }

    @Override
    public int hashCode() {
        int result = iban.hashCode();

        result = 31 * result + currency.hashCode();
        result = 31 * result + balance.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull EconomicCharacteristics o) {
        int valueToBeReturned = o.iban.compareTo(this.iban);

        if (valueToBeReturned == 0) {
            valueToBeReturned = o.currency.compareTo(this.currency);

            if (valueToBeReturned == 0) {
                return o.balance.compareTo(this.balance);
            }
        }

        return valueToBeReturned;
    }

    @Override
    public String toString() {
        Map<String, String> toPrintValues = new LinkedHashMap<>(Map.ofEntries(
            entry("iban", iban),
                entry("bic", bic),
                entry("currency", currency.toString()),
                entry("balance", balance.toString()),
                entry("lastDebitedTransaction", lastDebitedTransaction),
                entry("lastCreditedTransaction", lastCreditedTransaction),
                entry("requiredMinimumBalance", String.valueOf(requiredMinimumBalance)),
                entry("minimumBalance", minimumBalance.toString()),
                entry("typeOfClient", typeOfClient.toString()),
                entry("internetBankService", String.valueOf(internetBankService)),
                entry("mobileCheckDeposit", String.valueOf(mobileCheckDeposit)),
                entry("onlineBillPay", String.valueOf(onlineBillPay)),
                entry("emailAndTextAlerts", String.valueOf(emailAndTextAlerts)),
                entry("debitCardAvailable", String.valueOf(debitCardAvailable)),
                entry("possibleToOverdraft", String.valueOf(possibleToOverdraft))
        ));

        StringBuilder printingValues = new StringBuilder("EconomicCharacteristics [");

        int i = 0;
        for (Map.Entry<String, String> element : toPrintValues.entrySet()) {
            printingValues.append(String.format("%s: %s", element.getKey(), element.getValue()));

            if (i++ < toPrintValues.size() - 1) {
                printingValues.append(", ");
            }
        }

        printingValues.append("]");
        return printingValues.toString();
    }
}
