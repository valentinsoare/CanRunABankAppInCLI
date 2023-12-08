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
public class EconomicDetailsForIndividualClient implements Comparable<EconomicDetailsForIndividualClient> {
    @LazyGroup("FIRST_WAVE_ECONOMIC_DETAILS")
    @Column(name = "current_employer")
    @Basic(fetch = FetchType.LAZY)
    private String currentEmployer;

    @LazyGroup("FIRST_WAVE_ECONOMIC_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "estimated_monthly_revenue")
    private BigDecimal estimatedMonthlyRevenue;

    @LazyGroup("FIRST_WAVE_ECONOMIC_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "hasBeen_fired_in_his_career")
    private boolean hasBeenFiredInHisCareer;

    @LazyGroup("FIRST_WAVE_ECONOMIC_DETAILS")
    @Column(name = "bureau_of_credit_current_score")
    @Basic(fetch = FetchType.LAZY)
    private long bureauOfCreditCurrentScore;


    @LazyGroup("SECOND_WAVE_ECONOMIC_DETAILS")
    @Column(name = "central_credit_risk_current_score")
    @Basic(fetch = FetchType.LAZY)
    private long centralCreditRiskCurrentScore;

    @LazyGroup("SECOND_WAVE_ECONOMIC_DETAILS")
    @Column(name = "registered_in_the_bureau_of_credit")
    @Basic(fetch = FetchType.LAZY)
    private boolean registeredInTheBureauOfCredit;

    @LazyGroup("SECOND_WAVE_ECONOMIC_DETAILS")
    @Column(name = "registered_in_central_credit_risk")
    @Basic(fetch = FetchType.LAZY)
    private boolean registeredInCentralCreditRisk;


    @LazyGroup("THIRD_WAVE_ECONOMIC_DETAILS")
    @Column(name = "value_of_the_last_credit_taken")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal valueOfTheLastCreditTaken;

    @LazyGroup("THIRD_WAVE_ECONOMIC_DETAILS")
    @Column(name = "is_paid")
    @Basic(fetch = FetchType.LAZY)
    private boolean isPaid;

    @LazyGroup("THIRD_WAVE_ECONOMIC_DETAILS")
    @Column(name = "home_owner")
    @Basic(fetch = FetchType.LAZY)
    private boolean homeOwner;

    @LazyGroup("THIRD_WAVE_ECONOMIC_DETAILS")
    @Column(name = "car_owner")
    @Basic(fetch = FetchType.LAZY)
    private boolean carOwner;

    public EconomicDetailsForIndividualClient() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EconomicDetailsForIndividualClient that)) return false;

        if ((that.bureauOfCreditCurrentScore != this.bureauOfCreditCurrentScore) ||
            (that.centralCreditRiskCurrentScore != this.centralCreditRiskCurrentScore) ||
            (!that.currentEmployer.equals(this.currentEmployer))) {
            return false;
        }

        return estimatedMonthlyRevenue.equals(that.estimatedMonthlyRevenue);
    }

    @Override
    public int hashCode() {
        int result = currentEmployer.hashCode();

        result = 31 * result + estimatedMonthlyRevenue.hashCode();
        result = 31 * result + (int) (bureauOfCreditCurrentScore ^ (bureauOfCreditCurrentScore >>> 32));
        result = 31 * result + (int) (centralCreditRiskCurrentScore ^ (centralCreditRiskCurrentScore >>> 32));

        return result;
    }

    @Override
    public int compareTo(@NotNull EconomicDetailsForIndividualClient o) {
        int numericValueToBeReturned = o.currentEmployer.compareTo(this.currentEmployer);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = o.estimatedMonthlyRevenue.compareTo(this.estimatedMonthlyRevenue);

            if (numericValueToBeReturned == 0) {
                numericValueToBeReturned = Long.compare(o.bureauOfCreditCurrentScore, this.bureauOfCreditCurrentScore);

                if (numericValueToBeReturned == 0) {
                    return Long.compare(o.centralCreditRiskCurrentScore, this.centralCreditRiskCurrentScore);
                }
            }
        }

        return numericValueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("currentEmployer", currentEmployer),
//                entry("estimatedMonthlyRevenue", estimatedMonthlyRevenue.toString()),
//                entry("hasBeenFiredInHisCareer", String.valueOf(hasBeenFiredInHisCareer)),
//                entry("bureauOfCreditCurrentScore", String.valueOf(bureauOfCreditCurrentScore)),
//                entry("centralCreditRiskCurrentScore", String.valueOf(centralCreditRiskCurrentScore)),
//                entry("registeredInTheBureauOfCredit", String.valueOf(registeredInTheBureauOfCredit)),
//                entry("registeredInCentralCreditRisk", String.valueOf(registeredInCentralCreditRisk)),
//                entry("valueOfTheLastCreditTaken", valueOfTheLastCreditTaken.toString()),
//                entry("isPaid", String.valueOf(isPaid)),
//                entry("homeOwner", String.valueOf(homeOwner)),
//                entry("carOwner", String.valueOf(carOwner))
//        ));

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "[");
    }
}
