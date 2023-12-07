package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class AddressForIndividualClient implements Comparable<AddressForIndividualClient> {
    @LazyGroup("FIRST_PHASE_ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "street")
    private String street;

    @LazyGroup("FIRST_PHASE_ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "number")
    private String number;

    @LazyGroup("FIRST_PHASE_ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "is_apartment")
    private boolean isApartment;

    @LazyGroup("FIRST_PHASE_ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "apartment_number")
    private String apartmentNumber;


    @LazyGroup("SECOND_PHASE_ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "zip_code")
    private String zipCode;

    @LazyGroup("SECOND_PHASE_ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "country")
    private String country;

    @LazyGroup("SECOND_PHASE_ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "city")
    private String city;

    public AddressForIndividualClient() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressForIndividualClient that)) return false;

        if ((!that.street.equals(this.street)) || (!that.number.equals(this.number)) ||
            (!that.zipCode.equals(this.zipCode))) {
            return false;
        }

        return that.city.equals(this.city);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();

        result = 31 * result + number.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + city.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull AddressForIndividualClient o) {
        int numericValueToBeReturned = o.city.compareTo(this.city);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = o.zipCode.compareTo(this.zipCode);

            if (numericValueToBeReturned == 0) {
                numericValueToBeReturned = o.street.compareTo(this.street);

                if (numericValueToBeReturned == 0) {
                    return o.number.compareTo(this.number);
                }
            }
        }

        return numericValueToBeReturned;
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("street", street),
//                entry("number", number),
//                entry("isApartment", String.valueOf(isApartment)),
//                entry("apartmentNumber", apartmentNumber),
//                entry("zipCode", zipCode),
//                entry("country", country),
//                entry("city", city)
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, "Address [");
    }
}
