package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.longtermcredit;

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
@BatchSize(size = 16)
@DiscriminatorValue("1")
@Entity(name = "LongTermCredit")
public class LongTermCredit extends Credit {
    @LazyGroup("FIRST_WAVE_DETAILS")
    @Column(name = "minimumNumber_of_months_for_credit_term_is_necessary")
    @Basic(fetch = FetchType.LAZY)
    private int minimumNumberOfMonthsForCreditTermIsNecessary;

    @LazyGroup("FIRST_WAVE_DETAILS")
    @Column(name = "number_of_months_with_no_reimbursement_necessary")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfMonthsWithNoReimbursementNecessary;

    @LazyGroup("FIRST_WAVE_DETAILS")
    @Column(name = "is_co_signer_needed")
    @Basic(fetch = FetchType.LAZY)
    private boolean isCoSignerNeeded;

    @LazyGroup("FIRST_WAVE_DETAILS")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client coSigner;


    @LazyGroup("SECOND_WAVE_DETAILS")
    @Enumerated(EnumType.STRING)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "why_long_term_credit")
    private WhyLongTermCredit whyLongTermCredit;

    @LazyGroup("SECOND_WAVE_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "credit_value_is_insured")
    private boolean creditValueIsInsured;

    @LazyGroup("SECOND_WAVE_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "possible_to_refinancing")
    private boolean possibleToRefinancing;


    @LazyGroup("THIRD_WAVE_DETAILS")
    @Column(name = "maximum_amount_of_money_that_can_be_taken")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal maximumAmountOfMoneyThatCanBeTaken;

    @LazyGroup("THIRD_WAVE_DETAILS")
    @Column(name = "minimum_payment_for_current_month")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal minimumPaymentForCurrentMonth;

    public LongTermCredit() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongTermCredit that)) return false;
        if (!super.equals(o)) return false;

        if ((that.minimumNumberOfMonthsForCreditTermIsNecessary != this.minimumNumberOfMonthsForCreditTermIsNecessary) ||
             (that.numberOfMonthsWithNoReimbursementNecessary != this.numberOfMonthsWithNoReimbursementNecessary) ||
             (that.isCoSignerNeeded != this.isCoSignerNeeded)) {
            return false;
        }

        return that.coSigner.equals(this.coSigner);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + minimumNumberOfMonthsForCreditTermIsNecessary;
        result = 31 * result + numberOfMonthsWithNoReimbursementNecessary;
        result = 31 * result + (isCoSignerNeeded ? 1 : 0);
        result = 31 * result + coSigner.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Credit o) {
        if (o instanceof LongTermCredit longTimeCredit) {
            int valueToBeReturned = super.compareTo(o);

            if (valueToBeReturned == 0) {
                valueToBeReturned = Integer.compare(longTimeCredit.minimumNumberOfMonthsForCreditTermIsNecessary,
                        this.minimumNumberOfMonthsForCreditTermIsNecessary);

                if (valueToBeReturned == 0) {
                    valueToBeReturned = Integer.compare(longTimeCredit.numberOfMonthsWithNoReimbursementNecessary,
                            this.numberOfMonthsWithNoReimbursementNecessary);

                    if (valueToBeReturned == 0) {
                        valueToBeReturned = Boolean.compare(longTimeCredit.isCoSignerNeeded, this.isCoSignerNeeded);

                        if (valueToBeReturned == 0) {
                            return longTimeCredit.coSigner.compareTo(this.coSigner);
                        }
                    }
                }
            }

            return valueToBeReturned;
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("minimumNumberOfMonthsForCreditTermIsNecessary", String.valueOf(minimumNumberOfMonthsForCreditTermIsNecessary)),
//                entry("numberOfMonthsWithNoReimbursementNecessary", String.valueOf(numberOfMonthsWithNoReimbursementNecessary)),
//                entry("isCoSignerNeeded", String.valueOf(isCoSignerNeeded)),
//                entry("coSigner", String.format("%s", coSigner.getClientRegistrationNumber())),
//                entry("whyLongTermCredit", whyLongTermCredit.toString()),
//                entry("creditValueIsInsured", String.valueOf(creditValueIsInsured)),
//                entry("maximumAmountOfMoneyThatCanBeTaken", maximumAmountOfMoneyThatCanBeTaken.toString()),
//                entry("minimumPaymentForCurrentMonth", minimumPaymentForCurrentMonth.toString())
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, String.format("LongTermCredit [%s", super.toString()));
    }
}
