package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.midtermcredit;

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
@DiscriminatorValue("2")
@Entity(name = "MidTermCredit")
public class MidTermCredit extends Credit {
    @LazyGroup("DETAILS_FIRST_PHASE")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "co_signer")
    private Client coSigner;

    @LazyGroup("DETAILS_FIRST_PHASE")
    @Column(name = "credit_is_ensured")
    @Basic(fetch = FetchType.LAZY)
    private boolean creditIsEnsured;

    @LazyGroup("DETAILS_FIRST_PHASE")
    @Column(name = "minimum_number_months_for_term_of_credit")
    @Basic(fetch = FetchType.LAZY)
    private long minimumNumberMonthsForTermOfCredit;

    @LazyGroup("DETAILS_FIRST_PHASE")
    @Column(name = "maximum_number_of_months_for_term_of_credit")
    @Basic(fetch = FetchType.LAZY)
    private long maximumNumberOfMonthsForTermOfCredit;


    @LazyGroup("DETAILS_SECOND_PHASE")
    @Column(name = "number_of_months_with_no_reimbursement_necessary")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfMonthsWithNoReimbursementNecessary;

    @LazyGroup("DETAILS_SECOND_PHASE")
    @Column(name = "why_mid_term_credit")
    @Basic(fetch = FetchType.LAZY)
    private WhyMidTermCredit whyMidTermCredit;

    @LazyGroup("DETAILS_SECOND_PHASE")
    @Column(name = "possible_to_refinancing")
    @Basic(fetch = FetchType.LAZY)
    private boolean possibleToRefinancing;

    @LazyGroup("DETAILS_SECOND_PHASE")
    @Column(name = "expediting_assessment_credit_fee")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal expeditingAssessmentCreditFee;

    public MidTermCredit() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MidTermCredit that)) return false;
        if (!super.equals(o)) return false;

        if ((that.minimumNumberMonthsForTermOfCredit != this.minimumNumberMonthsForTermOfCredit) ||
            (that.numberOfMonthsWithNoReimbursementNecessary != this.numberOfMonthsWithNoReimbursementNecessary)) {
            return false;
        }

        return that.coSigner.equals(this.coSigner);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + coSigner.hashCode();
        result = 31 * result + (int) (minimumNumberMonthsForTermOfCredit ^ (minimumNumberMonthsForTermOfCredit >>> 32));
        result = 31 * result + numberOfMonthsWithNoReimbursementNecessary;

        return result;
    }

    @Override
    public int compareTo(@NotNull Credit o) {
        if (o instanceof MidTermCredit midTermCredit) {
            int valueToBeReturned = super.compareTo(o);

            if (valueToBeReturned == 0) {
                valueToBeReturned = Long.compare(midTermCredit.minimumNumberMonthsForTermOfCredit,
                        this.minimumNumberMonthsForTermOfCredit);

                if (valueToBeReturned == 0) {
                    valueToBeReturned = Integer.compare(midTermCredit.numberOfMonthsWithNoReimbursementNecessary,
                            this.numberOfMonthsWithNoReimbursementNecessary);

                    if (valueToBeReturned == 0) {
                        return midTermCredit.coSigner.compareTo(this.coSigner);
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
//                entry("coSigner", String.format("%s", coSigner.getClientRegistrationNumber())),
//                entry("creditIsEnsured", String.valueOf(creditIsEnsured)),
//                entry("minimumNumberMonthsForTermOfCredit", String.valueOf(minimumNumberMonthsForTermOfCredit)),
//                entry("maximumNumberOfMonthsForTermOfCredit", String.valueOf(maximumNumberOfMonthsForTermOfCredit)),
//                entry("numberOfMonthsWithNoReimbursementNecessary", String.valueOf(numberOfMonthsWithNoReimbursementNecessary)),
//                entry("whyMidTermCredit", whyMidTermCredit.toString()),
//                entry("possibleToRefinancing", String.valueOf(possibleToRefinancing)),
//                entry("expeditingAssessmentCreditFee", expeditingAssessmentCreditFee.toString())
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, String.format("MidTermCredit [%s", super.toString()));
    }
}
