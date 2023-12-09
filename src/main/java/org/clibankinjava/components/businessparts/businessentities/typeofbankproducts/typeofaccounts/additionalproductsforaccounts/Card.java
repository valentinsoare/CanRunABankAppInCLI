package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "Card")
@Table(name = "card", schema = "card")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "card_type"
)
@DiscriminatorValue("null")
public abstract class Card implements Comparable<Card> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("FIRST_WAVE_CARD")
    @Column(name = "identification_number")
    @Basic(fetch = FetchType.LAZY)
    private String identificationNumber;

    @LazyGroup("FIRST_WAVE_CARD")
    @Column(name = "owner_first_name")
    @Basic(fetch = FetchType.LAZY)
    private String ownerFirstName;

    @LazyGroup("FIRST_WAVE_CARD")
    @Column(name = "owner_last_name")
    @Basic(fetch = FetchType.LAZY)
    private String ownerLastName;


    @LazyGroup("SECOND_WAVE_CARD")
    @Column(name = "expiration_date")
    @Basic(fetch = FetchType.LAZY)
    private LocalDateTime expirationDate;

    @LazyGroup("SECOND_WAVE_CARD")
    @Column(name = "security_code")
    @Basic(fetch = FetchType.LAZY)
    private String securityCode;

    @LazyGroup("SECOND_WAVE_CARD")
    @Enumerated(EnumType.STRING)
    @Column(name = "card_provider")
    @Basic(fetch = FetchType.LAZY)
    private CardProvider cardProvider;

    @Transient
    @LazyGroup("THIRD_WAVE_CARD")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal howManyDaysUntilExpiration;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    protected Card() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;

        if ((!card.identificationNumber.equals(this.identificationNumber)) ||
                (!card.expirationDate.equals(this.expirationDate))) {
            return false;
        }

        return card.securityCode.equals(this.securityCode);
    }

    @Override
    public int hashCode() {
        int result = identificationNumber.hashCode();

        result = 31 * result + expirationDate.hashCode();
        result = 31 * result + securityCode.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Card o) {
        int valueToBeReturned = o.identificationNumber.compareTo(this.identificationNumber);

        if (valueToBeReturned == 0) {
            valueToBeReturned = o.securityCode.compareTo(this.securityCode);

            if (valueToBeReturned == 0) {
                return o.expirationDate.compareTo(this.expirationDate);
            }
        }

        return valueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("identificationNumber", identificationNumber),
//                entry("ownerFirstName", ownerFirstName),
//                entry("ownerLastName", ownerLastName),
//                entry("expirationDate", expirationDate.toString()),
//                entry("securityCode", securityCode),
//                entry("cardProvider", cardProvider.toString()),
//                entry("howManyDaysUntilExpiration", howManyDaysUntilExpiration.toString())
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, "");
    }
}
