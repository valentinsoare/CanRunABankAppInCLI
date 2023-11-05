package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Embeddable
public class Address implements Comparable<Address> {
    @LazyGroup("ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "street")
    private String street;

    @LazyGroup("ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "number")
    private int number;

    @LazyGroup("ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "apartment")
    private int apartment;

    @LazyGroup("ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "city")
    private String city;

    @LazyGroup("ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "country")
    private String country;

    @LazyGroup("ADDRESS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "zipcode")
    private int zipcode;

    public Address() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;

        if ((number != address.number) || (apartment != address.apartment) || (zipcode != address.zipcode) ||
                (!street.equals(address.street)) || (!city.equals(address.city))) {
            return false;
        }

        return country.equals(address.country);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();

        result = 31 * result + number;
        result = 31 * result + apartment;
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + zipcode;

        return result;
    }

    @Override
    public int compareTo(@NotNull Address o) {
        int numericReturnedValue = Integer.compare(o.apartment, this.apartment);

        if (numericReturnedValue == 0) {
            numericReturnedValue = Integer.compare(o.number, this.number);

            if (numericReturnedValue == 0) {
                numericReturnedValue = o.street.compareTo(this.street);

                if (numericReturnedValue == 0) {
                    numericReturnedValue = o.city.compareTo(this.city);

                    if (numericReturnedValue == 0) {
                        return Integer.compare(o.zipcode, this.zipcode);
                    }
                }
            }
        }

        return numericReturnedValue;
    }

    @Override
    public String toString() {
        return String.format("Address [street: %s, number: %s, apartment: %s, city: %s, country: %s, zipcode: %s]",
                street, number, apartment, city, country, zipcode);
    }
}
