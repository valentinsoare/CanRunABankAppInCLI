package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.type.SqlTypes;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Getter
@Setter
@Embeddable
public class EconomicDetailsForCompany implements Comparable<EconomicDetailsForCompany> {
    @LazyGroup("FIRST_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "caen")
    private String CAEN;

    @LazyGroup("FIRST_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "activity_type")
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @LazyGroup("FIRST_PHASE_ECONOMIC_COMPANY")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "activity_description")
    private String activityDescription;


    @LazyGroup("SECOND_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "is_privately_owned")
    private boolean isPrivatelyOwned;

    @LazyGroup("SECOND_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "market_capitalization_value")
    private BigDecimal marketCapitalizationValue;

    @LazyGroup("SECOND_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "company_on_stock_exchange")
    private boolean companyOnStockExchange;


    @LazyGroup("THIRD_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "current_stock_value")
    private BigDecimal currentStockValue;

    @LazyGroup("THIRD_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "average_salary")
    private BigDecimal averageSalary;

    @LazyGroup("THIRD_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "number_of_employees")
    private long numberOfEmployees;


    @LazyGroup("FOURTH_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "executive_officer")
    private String executiveOfficer;

    @LazyGroup("FOURTH_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "financial_officer")
    private String financialOfficer;

    @LazyGroup("FOURTH_PHASE_ECONOMIC_COMPANY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "operations_officer")
    private String operationsOfficer;

    public EconomicDetailsForCompany() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EconomicDetailsForCompany that)) return false;

        if ((that.isPrivatelyOwned != this.isPrivatelyOwned) ||
            (!that.CAEN.equals(this.CAEN))) {
            return false;
        }

        return that.activityType == this.activityType;
    }

    @Override
    public int hashCode() {
        int result = CAEN.hashCode();

        result = 31 * result + activityType.hashCode();
        result = 31 * result + (isPrivatelyOwned ? 1 : 0);

        return result;
    }

    @Override
    public int compareTo(@NotNull EconomicDetailsForCompany o) {
        int valueToReturned = o.CAEN.compareTo(this.CAEN);

        if (valueToReturned == 0) {
            valueToReturned = o.activityType.compareTo(this.activityType);

            if (valueToReturned == 0) {
                return Boolean.compare(o.isPrivatelyOwned, this.isPrivatelyOwned);
            }
        }

        return valueToReturned;
    }

    @Override
    public String toString() {
        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
                entry("CAEN", CAEN),
                entry("activityType", activityType.toString()),
                entry("activityDescription", activityDescription),
                entry("isPrivatelyOwned", String.valueOf(isPrivatelyOwned)),
                entry("marketCapitalizationValue", marketCapitalizationValue.toString()),
                entry("companyOnStockExchange", String.valueOf(companyOnStockExchange)),
                entry("currentStockValue", currentStockValue.toString()),
                entry("averageSalary", averageSalary.toString()),
                entry("numberOfEmployees", String.valueOf(numberOfEmployees)),
                entry("executiveOfficer", executiveOfficer),
                entry("financialOfficer", financialOfficer),
                entry("operationsOfficer", operationsOfficer)
        ));

        return CustomPrinting.of(characteristics, "[");
    }
}
