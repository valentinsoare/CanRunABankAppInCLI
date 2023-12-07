package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.shorttermcredit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails.Credit;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.customdatastructureandoperationsonthem.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@DiscriminatorValue("4")
@BatchSize(size = 16)
@Entity(name = "ShortTermCredit")
public class ShortTermCredit extends Credit {
    @LazyGroup("FIRST_WAVE_SHORT_TERM_CREDIT")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "credit_value_is_insured")
    private boolean creditValueIsInsured;

    @LazyGroup("FIRST_WAVE_SHORT_TERM_CREDIT")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "possible_to_refinancing")
    private boolean possibleToRefinancing;

    @LazyGroup("FIRST_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "is_co_signer_needed")
    @Basic(fetch = FetchType.LAZY)
    private boolean isCoSignerNeeded;

    @LazyGroup("FIRST_WAVE_SHORT_TERM_CREDIT")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client coSigner;


    @LazyGroup("SECOND_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "minimum_number_of_term_in_months")
    @Basic(fetch = FetchType.LAZY)
    private long minimumNumberOfTermInMonths;

    @LazyGroup("SECOND_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "maximum_number_of_term_in_months")
    @Basic(fetch = FetchType.LAZY)
    private long maximumNumberOfTermInMonths;

    @LazyGroup("SECOND_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "maximum_amount_of_money_that_can_be_taken")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal maximumAmountOfMoneyThatCanBeTaken;

    @LazyGroup("SECOND_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "minimum_payment_for_current_month")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal minimumPaymentForCurrentMonth;


    @LazyGroup("THIRD_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "automatic_payments_from_a_salary_account")
    @Basic(fetch = FetchType.LAZY)
    private boolean automaticPaymentsFromASalaryAccount;

    @LazyGroup("THIRD_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "iban_for_account_used_for_automatic_payment")
    @Basic(fetch = FetchType.LAZY)
    private String ibanForAccountUsedForAutomaticPayment;

    @LazyGroup("THIRD_WAVE_SHORT_TERM_CREDIT")
    @Column(name = "why_short_term_credit")
    @Basic(fetch = FetchType.LAZY)
    private WhyShortTermCredit whyShortTermCredit;

    public ShortTermCredit() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShortTermCredit that)) return false;
        if (!super.equals(o)) return false;

        if ((that.isCoSignerNeeded != this.isCoSignerNeeded) || (that.maximumNumberOfTermInMonths != this.maximumNumberOfTermInMonths) ||
            (!that.coSigner.equals(this.coSigner))) {
            return false;
        }

        return that.maximumAmountOfMoneyThatCanBeTaken.equals(this.maximumAmountOfMoneyThatCanBeTaken);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (isCoSignerNeeded ? 1 : 0);
        result = 31 * result + coSigner.hashCode();
        result = 31 * result + (int) (maximumNumberOfTermInMonths ^ (maximumNumberOfTermInMonths >>> 32));
        result = 31 * result + maximumAmountOfMoneyThatCanBeTaken.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Credit o) {
        if (o instanceof ShortTermCredit shortTermCredit) {
            int numericValueToReturned = super.compareTo(o);

            if (numericValueToReturned == 0) {
                numericValueToReturned = Boolean.compare(shortTermCredit.isCoSignerNeeded, this.isCoSignerNeeded);

                if (numericValueToReturned == 0) {
                    numericValueToReturned = shortTermCredit.coSigner.compareTo(this.coSigner);

                    if (numericValueToReturned == 0) {
                        numericValueToReturned = Long.compare(shortTermCredit.maximumNumberOfTermInMonths, this.maximumNumberOfTermInMonths);

                        if (numericValueToReturned == 0) {
                            return shortTermCredit.maximumAmountOfMoneyThatCanBeTaken.compareTo(this.maximumAmountOfMoneyThatCanBeTaken);
                        }
                    }
                }
            }

            return numericValueToReturned;
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("creditValueIsInsured", String.valueOf(creditValueIsInsured)),
//                entry("possibleToRefinancing", String.valueOf(possibleToRefinancing)),
//                entry("isCoSignerNeeded", String.valueOf(isCoSignerNeeded)),
//                entry("coSigner", String.format("%s", coSigner.getClientRegistrationNumber())),
//                entry("minimumNumberOfTermInMonths", String.valueOf(minimumNumberOfTermInMonths)),
//                entry("maximumNumberOfTermInMonths", String.valueOf(maximumNumberOfTermInMonths)),
//                entry("maximumAmountOfMoneyThatCanBeTaken", maximumAmountOfMoneyThatCanBeTaken.toString()),
//                entry("minimumPaymentForCurrentMonth", minimumPaymentForCurrentMonth.toString()),
//                entry("automaticPaymentsFromASalaryAccount", String.valueOf(automaticPaymentsFromASalaryAccount)),
//                entry("ibanForAccountUsedForAutomaticPayment", ibanForAccountUsedForAutomaticPayment),
//                entry("whyShortTermCredit", whyShortTermCredit.toString())
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, String.format("ShortTermCredit [%s", super.toString()));
    }
}
