package org.clibankinjava.components.businessparts.businessentities.typeofclients;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.AddressForCommercialClient;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.EconomicDetailsForIndividualClient;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.PersonalIdentificationForAnIndividualClient;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "IndividualClient")
@DiscriminatorValue("individual_client")
public class IndividualClient extends Client {
    @Embedded
    private PersonalIdentificationForAnIndividualClient identification;

    @Embedded
    private AddressForCommercialClient address;

    @Embedded
    private EconomicDetailsForIndividualClient economicDetails;

    public IndividualClient() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndividualClient that)) return false;

        if ((!that.identification.getEmail().equals(this.identification.getEmail())) ||
            (!that.address.getZipCode().equals(this.address.getZipCode()))) {
            return false;
        }

        return that.economicDetails.getEstimatedMonthlyRevenue().equals(this.economicDetails.getEstimatedMonthlyRevenue());
    }

    @Override
    public int hashCode() {
        int result = identification.getEmail().hashCode();

        result = 31 * result + address.getZipCode().hashCode();
        result = 31 * result + economicDetails.getEstimatedMonthlyRevenue().hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Client o) {
        if (o instanceof IndividualClient individualClient) {
            int numericValueToBeReturned = individualClient.identification.getEmail()
                    .compareTo(this.identification.getEmail());

            if (numericValueToBeReturned == 0) {
                numericValueToBeReturned = individualClient.address.getZipCode()
                        .compareTo(this.address.getZipCode());

                if (numericValueToBeReturned == 0) {
                    return individualClient.economicDetails.getEstimatedMonthlyRevenue()
                            .compareTo(this.economicDetails.getEstimatedMonthlyRevenue());
                }
            }

            return numericValueToBeReturned;
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
                entry("identification", identification.toString()),
                entry("address", address.toString()),
                entry("economicDetails", economicDetails.toString())
        ));

        return CustomPrinting.of(characteristics,
                String.format("IndividualClient [%s", super.toString()));
    }
}
