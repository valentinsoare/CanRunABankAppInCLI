package org.clibankinjava.components.businessparts.businessentities.typeofclients;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.AddressForCommercialClient;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.EconomicDetailsForCompany;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.IdentificationForACompany;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "EnterpriseClient")
@DiscriminatorValue("enterprise_client")
public class EnterpriseClient extends Client {
    @Embedded
    private IdentificationForACompany identification;

    @Embedded
    private AddressForCommercialClient address;

    @Embedded
    private EconomicDetailsForCompany economicDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnterpriseClient that)) return false;
        if (!super.equals(o)) return false;

        if (((!that.identification.getCUI().equals(this.identification.getCUI())) ||
             (!that.address.getZipCode().equals(this.address.getZipCode())))) {
            return false;
        }

        return that.economicDetails.getCAEN().equals(this.economicDetails.getCAEN());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + identification.getCUI().hashCode();
        result = 31 * result + address.getZipCode().hashCode();
        result = 31 * result + economicDetails.getCAEN().hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Client o) {
        if (o instanceof EnterpriseClient enterprise) {
            int numericValue = enterprise.identification.getCUI()
                    .compareTo(this.identification.getCUI()
            );

            if (numericValue == 0) {
                numericValue = enterprise.address.getZipCode()
                        .compareTo((this.address.getZipCode())
                );

                if (numericValue == 0) {
                    return enterprise.economicDetails.getCAEN()
                            .compareTo(this.economicDetails.getCAEN()
                    );
                }
            }

            return numericValue;
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("identification", identification.toString()),
//                entry("address", address.toString()),
//                entry("economicDetails", economicDetails.toString())
//        ));

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);

        return CustomPrinting.of(characteristics,
                String.format("EnterpriseClient [%s", super.toString()));
    }
}
