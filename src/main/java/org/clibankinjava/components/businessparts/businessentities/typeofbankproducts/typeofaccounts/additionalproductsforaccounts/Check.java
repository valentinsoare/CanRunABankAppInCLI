package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
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
@BatchSize(size = 8)
@Entity(name = "Check")
@Table(name = "check", schema = "check")
public class Check implements Comparable<Check> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("FIRST_WAVE_CHECK")
    @Column(name = "name")
    @Basic(fetch = FetchType.LAZY)
    private String name;

    @LazyGroup("FIRST_WAVE_CHECK")
    @Column(name = "address")
    @Basic(fetch = FetchType.LAZY)
    private String address;

    @LazyGroup("FIRST_WAVE_CHECK")
    @Column(name = "date")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate date;


    @LazyGroup("SECOND_WAVE_CHECK")
    @Column(name = "amount_to_pay")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal amountToPay;

    @LazyGroup("SECOND_WAVE_CHECK")
    @Column(name = "pay_to_the_order_of")
    @Basic(fetch = FetchType.LAZY)
    private String payToTheOrderOf;

    @LazyGroup("SECOND_WAVE_CHECK")
    @Column(name = "object_for_payment")
    @Basic(fetch = FetchType.LAZY)
    private String objectForPayment;

    @LazyGroup("SECOND_WAVE_CHECK")
    @Column(name = "account_number")
    @Basic(fetch = FetchType.LAZY)
    private String accountNumber;

    @LazyGroup("SECOND_WAVE_CHECK")
    @Column(name = "check_number")
    @Basic(fetch = FetchType.LAZY)
    private String checkNumber;


    @LazyGroup("ACCOUNT")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", columnDefinition = "long default -1")
    private Account account;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public Check() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Check check)) return false;

        if ((!check.amountToPay.equals(this.amountToPay)) || (!check.payToTheOrderOf.equals(this.payToTheOrderOf)) ||
            (!check.accountNumber.equals(this.accountNumber))) {
            return false;
        }

        return check.checkNumber.equals(this.checkNumber);
    }

    @Override
    public int hashCode() {
        int result = amountToPay.hashCode();

        result = 31 * result + payToTheOrderOf.hashCode();
        result = 31 * result + accountNumber.hashCode();
        result = 31 * result + checkNumber.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Check o) {
        int valueToReturn = o.amountToPay.compareTo(this.amountToPay);

        if (valueToReturn == 0) {
            valueToReturn = o.payToTheOrderOf.compareTo(this.payToTheOrderOf);

            if (valueToReturn == 0) {
                valueToReturn = o.accountNumber.compareTo(this.accountNumber);

                if (valueToReturn == 0) {
                    return o.checkNumber.compareTo(this.checkNumber);
                }
            }
        }

        return valueToReturn;
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("name", name),
//                entry("address", address),
//                entry("date", date.toString()),
//                entry("amountToPay", amountToPay.toString()),
//                entry("payToTheOrderOf", payToTheOrderOf),
//                entry("objectForPayment", objectForPayment),
//                entry("accountNumber", accountNumber),
//                entry("checkNumber", checkNumber)
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, "Check [");
    }
}
