package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Embeddable
public class StatisticDetails implements Comparable<StatisticDetails> {
    @LazyGroup("FIRST_WAVE_STATISTICS")
    @Column(name = "number_of_credits_contracted")
    @Basic(fetch = FetchType.LAZY)
    private long numberOfCreditsContracted;

    @LazyGroup("FIRST_WAVE_STATISTICS")
    @Column(name = "number_of_active_credits")
    @Basic(fetch = FetchType.LAZY)
    private long numberOfActiveCredits;

    @LazyGroup("FIRST_WAVE_STATISTICS")
    @Column(name = "number_of_closed_credits")
    @Basic(fetch = FetchType.LAZY)
    private long numberOfClosedCredits;


    @LazyGroup("SECOND_WAVE_STATISTICS")
    @Column(name = "isBehind_on_paying_interest_rate_for_any_credit_from_the_list")
    @Basic(fetch = FetchType.LAZY)
    private boolean isBehindOnPayingInterestRateForAnyCreditFromTheList;

    @LazyGroup("SECOND_WAVE_STATISTICS")
    @Column(name = "total_value_of_penalties_for_all_credits")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal totalValueOfPenaltiesForAllCredits;

    @LazyGroup("SECOND_WAVE_STATISTICS")
    @Column(name = "number_of_credits_were_penalties_are_present")
    @Basic(fetch = FetchType.LAZY)
    private long numberOfCreditsWerePenaltiesArePresent;

    @LazyGroup("SECOND_WAVE_STATISTICS")
    @Column(name = "client_internal_score")
    @Basic(fetch = FetchType.LAZY)
    private long clientInternalScore;

    public StatisticDetails() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatisticDetails that)) return false;

        if (that.numberOfCreditsContracted != this.numberOfCreditsContracted) return false;
        return that.clientInternalScore == this.clientInternalScore;
    }

    @Override
    public int hashCode() {
        int result = (int) (numberOfCreditsContracted ^ (numberOfCreditsContracted >>> 32));
        result = 31 * result + (int) (clientInternalScore ^ (clientInternalScore >>> 32));

        return result;
    }

    @Override
    public int compareTo(@NotNull StatisticDetails o) {
        int numericValueToBeReturned = Long.compare(o.numberOfCreditsContracted, this.numberOfCreditsContracted);

        if (numericValueToBeReturned == 0) {
            return Long.compare(o.clientInternalScore, this.clientInternalScore);
        }

        return numericValueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("numberOfCreditsContracted", String.valueOf(numberOfCreditsContracted)),
//                entry("numberOfActiveCredits", String.valueOf(numberOfActiveCredits)),
//                entry("numberOfClosedCredits", String.valueOf(numberOfClosedCredits)),
//                entry("isBehindOnPayingInterestRateForAnyCreditFromTheList", String.valueOf(isBehindOnPayingInterestRateForAnyCreditFromTheList)),
//                entry("totalValueOfPenaltiesForAllCredits", totalValueOfPenaltiesForAllCredits.toString()),
//                entry("numberOfCreditsWerePenaltiesArePresent", String.valueOf(numberOfCreditsWerePenaltiesArePresent)),
//                entry("clientInternalScore", String.valueOf(clientInternalScore))
//        ));
        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "[");
    }
}
