package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.mortgage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.MortgageConsultant;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails.Credit;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@BatchSize(size = 8)
@DiscriminatorValue("3")
@Entity(name = "Mortgage")
public class Mortgage extends Credit {

    @LazyGroup("FIRST_WAVE_MORTGAGE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "credit_value_is_insured")
    private boolean creditValueIsInsured;

    @LazyGroup("FIRST_WAVE_MORTGAGE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "possible_to_refinancing")
    private boolean possibleToRefinancing;

    @LazyGroup("FIRST_WAVE_MORTGAGE")
    @Column(name = "number_of_months_with_no_reimbursement_necessary")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfMonthsWithNoReimbursementNecessary;


    @LazyGroup("SECOND_WAVE_MORTGAGE")
    @Column(name = "is_co_signer_needed")
    @Basic(fetch = FetchType.LAZY)
    private boolean isCoSignerNeeded;

    @LazyGroup("SECOND_WAVE_MORTGAGE")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client coSigner;

    @LazyGroup("SECOND_WAVE_MORTGAGE")
    @Column(name = "minimum_number_of_term_in_months")
    @Basic(fetch = FetchType.LAZY)
    private long minimumNumberOfTermInMonths;

    @LazyGroup("SECOND_WAVE_MORTGAGE")
    @Column(name = "maximum_number_of_term_in_months")
    @Basic(fetch = FetchType.LAZY)
    private long maximumNumberOfTermInMonths;


    @LazyGroup("THIRD_WAVE_MORTGAGE")
    @Column(name = "maximum_amount_of_money_that_can_be_taken")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal maximumAmountOfMoneyThatCanBeTaken;

    @LazyGroup("THIRD_WAVE_MORTGAGE")
    @Column(name = "minimum_payment_for_current_month")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal minimumPaymentForCurrentMonth;

    @LazyGroup("THIRD_WAVE_MORTGAGE")
    @Column(name = "is_foreclosed")
    @Basic(fetch = FetchType.LAZY)
    private boolean isForeclosed;

    @LazyGroup("THIRD_WAVE_MORTGAGE")
    @Column(name = "is_repossessed")
    @Basic(fetch = FetchType.LAZY)
    private boolean isRepossessed;


    @LazyGroup("FOURTH_WAVE_MORTGAGE")
    @Column(name = "settlement_of_the_mortgage_deed")
    @Basic(fetch = FetchType.LAZY)
    private boolean settlementOfTheMortgageDeed;

    @LazyGroup("FOURTH_WAVE_MORTGAGE")
    @Column(name = "is_redeemed")
    @Basic(fetch = FetchType.LAZY)
    private boolean isRedeemed;

    @LazyGroup("FOURTH_WAVE_MORTGAGE")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "mortgage_consultant_id")
    private MortgageConsultant mortgageConsultant;

    public Mortgage() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mortgage mortgage)) return false;
        if (!super.equals(o)) return false;

        if ((mortgage.numberOfMonthsWithNoReimbursementNecessary != this.numberOfMonthsWithNoReimbursementNecessary) ||
                (mortgage.isCoSignerNeeded != this.isCoSignerNeeded) ||
                (mortgage.minimumNumberOfTermInMonths != this.minimumNumberOfTermInMonths) ||
                (!mortgage.coSigner.equals(this.coSigner))) {
            return false;
        }

        return mortgage.maximumAmountOfMoneyThatCanBeTaken.equals(this.maximumAmountOfMoneyThatCanBeTaken);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + numberOfMonthsWithNoReimbursementNecessary;
        result = 31 * result + (isCoSignerNeeded ? 1 : 0);
        result = 31 * result + coSigner.hashCode();
        result = 31 * result + (int) (minimumNumberOfTermInMonths ^ (minimumNumberOfTermInMonths >>> 32));
        result = 31 * result + maximumAmountOfMoneyThatCanBeTaken.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Credit o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("creditValueIsInsured", String.valueOf(creditValueIsInsured)),
//                entry("possibleToRefinancing", String.valueOf(possibleToRefinancing)),
//                entry("numberOfMonthsWithNoReimbursementNecessary", String.valueOf(numberOfMonthsWithNoReimbursementNecessary)),
//                entry("isCoSignerNeeded", String.valueOf(isCoSignerNeeded)),
//                entry("coSigner", String.format("%s", coSigner.getClientRegistrationNumber())),
//                entry("minimumNumberOfTermInMonths", String.valueOf(minimumNumberOfTermInMonths)),
//                entry("maximumNumberOfTermInMonths", String.valueOf(maximumNumberOfTermInMonths)),
//                entry("maximumAmountOfMoneyThatCanBeTaken", maximumAmountOfMoneyThatCanBeTaken.toString()),
//                entry("minimumPaymentForCurrentMonth", minimumPaymentForCurrentMonth.toString()),
//                entry("isForeclosed", String.valueOf(isForeclosed)),
//                entry("isRepossessed", String.valueOf(isRepossessed)),
//                entry("settlementOfTheMortgageDeed", String.valueOf(settlementOfTheMortgageDeed)),
//                entry("isRedeemed", String.valueOf(isRedeemed)),
//                entry("mortgageConsultant", String.format("%s; %s; %s;",
//                        mortgageConsultant.getFirstName(), mortgageConsultant.getLastName(), mortgageConsultant.getEmail()))
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, String.format("Mortgage [%s", super.toString()));
    }
}
