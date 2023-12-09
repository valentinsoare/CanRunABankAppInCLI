package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.*;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@BatchSize(size=8)
@Entity(name = "Credit")
@Table(name = "credit", schema = "credit")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name = "type_of_credit"
)
@DiscriminatorValue("null")
public abstract class Credit implements Comparable<Credit> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("ECONOMIC_PHASE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "credit_registration_number")
    private String creditRegistrationNumber;

    @LazyGroup("CLIENT")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client client;

    @LazyGroup("ECONOMIC_PHASE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "type_of_credit")
    @Enumerated(EnumType.STRING)
    private TypeOfCredit typeOfCredit;

    @LazyGroup("ECONOMIC_PHASE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "valueOf_the_credit_without_the_interest_at_the_end_of_it")
    private BigDecimal valueOfTheCreditWithoutTheInterestAtTheEndOfIt;

    @LazyGroup("ECONOMIC_PHASE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "value_of_the_credit_at_the_end_of_it_with_interest")
    private BigDecimal valueOfTheCreditAtTheEndOfItWithInterest;

    @LazyGroup("ECONOMIC_PHASE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "value_of_the_interest_at_the_end_of_cedit")
    private BigDecimal valueOfTheInterestAtTheEndOfCredit;


    @LazyGroup("INTEREST_RATE_MONTHLY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fixed_interest_rate_monthly")
    private boolean fixedInterestRateMonthly;

    @LazyGroup("INTEREST_RATE_MONTHLY")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "interest_rate_monthly")
    private BigDecimal interestRateMonthly;

    @LazyGroup("TERM")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "term_in_months")
    private BigDecimal termInMonths;


    @LazyGroup("EAR")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fixed_effective_annual_rate")
    private boolean fixedEffectiveAnnualRate;

    @LazyGroup("EAR")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "effective_annual_rate")
    private BigDecimal effectiveAnnualRate;


    @LazyGroup("UNTIL_NOW")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "how_much_money_paid_until_now")
    private BigDecimal howMuchMoneyPaidUntilNow;


    @LazyGroup("COLLATERAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "collateral_needed")
    private boolean collateralNeeded;

    @LazyGroup("COLLATERAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "value_of_the_collateral_needed")
    private BigDecimal valueOfTheCollateralNeeded;


    @LazyGroup("ADMINISTRATION_FEE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "administration_fee_applied")
    private boolean administrationFeeApplied;

    @LazyGroup("ADMINISTRATION_FEE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "administration_fee_monthly")
    private BigDecimal administrationFeeMonthly;


    @LazyGroup("DOCUMENTS_FEE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "processing_documents_fee_applied")
    private boolean processingDocumentsFeeApplied;

    @LazyGroup("DOCUMENTS_FEE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "processing_documents_for_credit_fee_one_shot")
    private BigDecimal processingDocumentsForCreditFeeOneShot;


    @LazyGroup("ASSESSMENT_FEE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "assessment_fee_applied")
    private boolean assessmentFeeApplied;

    @LazyGroup("ASSESSMENT_FEE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "assessment_fee_one_shot")
    private BigDecimal assessmentFeeOneShot;


    @LazyGroup("PENALTIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "penalties_per_credit_monthly")
    private BigDecimal penaltiesPerCreditMonthly;

    @LazyGroup("PENALTIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "is_with_penalties")
    private boolean isWithPenalties;

    @LazyGroup("PENALTIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "percent_for_calculating_penalties_compound_from_monthly_payment")
    private BigDecimal percentForCalculatingPenaltiesCompoundFromMonthlyPayment;

    @LazyGroup("PENALTIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "paid_for_the_current_month")
    private boolean paidForTheCurrentMonth;

    @LazyGroup("PENALTIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "how_many_months_were_paid_in_advanced")
    private long howManyMonthsWerePaidInAdvanced;


    @LazyGroup("TIME")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "when_credit_was_taken")
    private LocalDate whenCreditWasTaken;

    @Embedded
    @LazyGroup("TIME")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "when_is_due_date_for_paying_monthly")
    private DueDateToPayingMonthly whenIsDueDateForPayingMonthly;

    @Transient
    @LazyGroup("DATE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "number_of_days_from_when_the_credit_was_taken")
    private BigDecimal numberOfDaysFromWhenTheCreditWasTaken;

    @Transient
    @LazyGroup("DATE")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfDaysUntilDueDateOfMonthlyPayment;

    @Transient
    @LazyGroup("DATE")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal numberOfDaysFromTheLastPayment;


    @LazyGroup("LOAN_OFFICER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "loan_officer_id")
    private LoanOfficer loanOfficer;

    @LazyGroup("CREDIT_PROCESSING")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "loan_processor_id")
    private LoanProcessor loanProcessor;

    @LazyGroup(("CREDIT_PROCESSING"))
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "credit_analyst_id")
    private CreditAnalyst creditAnalyst;

    @LazyGroup("UNDERWRITER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "underwriter_id")
    private Underwriter underwriter;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    protected Credit() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Credit credit)) return false;

        if ((credit.fixedEffectiveAnnualRate != this.fixedEffectiveAnnualRate) || (!credit.client.equals(this.client)) ||
             (!credit.interestRateMonthly.equals(this.interestRateMonthly)) || (!credit.termInMonths.equals(this.termInMonths))) {
            return false;
        }

        return credit.effectiveAnnualRate.equals(this.effectiveAnnualRate);
    }

    @Override
    public int hashCode() {
        int result = client.hashCode();

        result = 31 * result + interestRateMonthly.hashCode();
        result = 31 * result + termInMonths.hashCode();
        result = 31 * result + (fixedEffectiveAnnualRate ? 1 : 0);
        result = 31 * result + effectiveAnnualRate.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Credit o) {
        int valueToBeReturned = o.getClient().compareTo(this.getClient());

        if (valueToBeReturned == 0) {
            valueToBeReturned = o.interestRateMonthly.compareTo(this.interestRateMonthly);

            if (valueToBeReturned == 0) {
                valueToBeReturned = o.termInMonths.compareTo(this.termInMonths);

                if (valueToBeReturned == 0) {
                    valueToBeReturned = Boolean.compare(o.fixedEffectiveAnnualRate, this.fixedEffectiveAnnualRate);

                    if (valueToBeReturned == 0) {
                        return o.effectiveAnnualRate.compareTo(this.effectiveAnnualRate);
                    }
                }
            }
        }

        return valueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("client", String.format("%s", client.getClientRegistrationNumber())),
//                entry("typeOfCredit", typeOfCredit.toString()),
//                entry("valueOfTheCreditWithoutTheInterestAtTheEndOfIt", valueOfTheCreditWithoutTheInterestAtTheEndOfIt.toString()),
//                entry("valueOfTheCreditAtTheEndOfItWithInterest", valueOfTheCreditAtTheEndOfItWithInterest.toString()),
//                entry("valueOfTheInterestAtTheEndOfCredit", valueOfTheInterestAtTheEndOfCredit.toString()),
//                entry("fixedInterestRateMonthly", String.valueOf(fixedInterestRateMonthly)),
//                entry("interestRateMonthly", interestRateMonthly.toString()),
//                entry("termInMonths", termInMonths.toString()),
//                entry("fixedEffectiveAnnualRate", String.valueOf(fixedEffectiveAnnualRate)),
//                entry("effectiveAnnualRate", effectiveAnnualRate.toString()),
//                entry("howMuchMoneyPaidUntilNow", howMuchMoneyPaidUntilNow.toString()),
//                entry("collateralNeeded", String.valueOf(collateralNeeded)),
//                entry("valueOfTheCollateralNeeded", valueOfTheCollateralNeeded.toString()),
//                entry("administrationFeeApplied", String.valueOf(administrationFeeApplied)),
//                entry("administrationFeeMonthly", administrationFeeMonthly.toString()),
//                entry("processingDocumentsFeeApplied", String.valueOf(processingDocumentsFeeApplied)),
//                entry("processingDocumentsForCreditFeeOneShot", processingDocumentsForCreditFeeOneShot.toString()),
//                entry("assessmentFeeApplied", String.valueOf(assessmentFeeApplied)),
//                entry("assessmentFeeOneShot", assessmentFeeOneShot.toString()),
//                entry("penaltiesPerCreditMonthly", penaltiesPerCreditMonthly.toString()),
//                entry("isWithPenalties", String.valueOf(isWithPenalties)),
//                entry("percentForCalculatingPenaltiesCompoundFromMonthlyPayment", percentForCalculatingPenaltiesCompoundFromMonthlyPayment.toString()),
//                entry("paidForTheCurrentMonth", String.valueOf(paidForTheCurrentMonth)),
//                entry("howManyMonthsWerePaidInAdvanced", String.valueOf(howManyMonthsWerePaidInAdvanced)),
//                entry("whenCreditWasTaken", whenCreditWasTaken.toString()),
//                entry("whenIsDueDateForPayingMonthly", whenIsDueDateForPayingMonthly.toString()),
//                entry("numberOfDaysFromWhenTheCreditWasTaken", numberOfDaysFromWhenTheCreditWasTaken.toString()),
//                entry("numberOfDaysUntilDueDateOfMonthlyPayment", String.valueOf(numberOfDaysUntilDueDateOfMonthlyPayment)),
//                entry("numberOfDaysFromTheLastPayment", numberOfDaysFromTheLastPayment.toString()),
//                entry("loanOfficer", String.format("%s; %s; %s",
//                        loanOfficer.getFirstName(), loanOfficer.getLastName(), loanOfficer.getEmail())),
//                entry("loanProcessor", String.format("%s; %s; %s",
//                        loanProcessor.getFirstName(), loanProcessor.getLastName(), loanProcessor.getEmail())),
//                entry("creditAnalyst", String.format("%s; %s; %s",
//                        creditAnalyst.getFirstName(), creditAnalyst.getLastName(), creditAnalyst.getEmail())),
//                entry("underwriter", String.format("%s; %s; %s",
//                        underwriter.getFirstName(), underwriter.getLastName(), underwriter.getEmail()))
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, "Credit [");
    }
}
