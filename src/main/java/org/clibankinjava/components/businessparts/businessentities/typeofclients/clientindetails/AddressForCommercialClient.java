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

import java.util.Map;

@Getter
@Setter
@Embeddable
public class AddressForCommercialClient implements Comparable<AddressForCommercialClient> {

    @LazyGroup("FIRST_PHASE_ADDRESS_COMMERCIAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "street")
    private String street;

    @LazyGroup("FIRST_PHASE_ADDRESS_COMMERCIAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "number")
    private String number;

    @LazyGroup("FIRST_PHASE_ADDRESS_COMMERCIAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "is_an_office_building")
    private boolean isAnOfficeBuilding;


    @LazyGroup("SECOND_PHASE_ADDRESS_COMMERCIAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "zip_code")
    private String zipCode;

    @LazyGroup("SECOND_PHASE_ADDRESS_COMMERCIAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "city")
    private String city;

    @LazyGroup("SECOND_PHASE_ADDRESS_COMMERCIAL")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "country")
    private String country;

    public AddressForCommercialClient() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressForCommercialClient that)) return false;

        if ((!that.street.equals(this.street)) || (!that.number.equals(this.number))) {
            return false;
        }

        return that.zipCode.equals(this.zipCode);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();

        result = 31 * result + number.hashCode();
        result = 31 * result + zipCode.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull AddressForCommercialClient o) {
        int numericValueToBeReturned = o.street.compareTo(this.street);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = o.number.compareTo(this.number);

            if (numericValueToBeReturned == 0) {
                return o.zipCode.compareTo(this.zipCode);
            }
        }

        return numericValueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("street", street),
//                entry("number", number),
//                entry("isAnOfficeBuilding", String.valueOf(isAnOfficeBuilding)),
//                entry("zipCode", zipCode),
//                entry("city", city),
//                entry("country", country)
//        ));

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "[");
    }
}
