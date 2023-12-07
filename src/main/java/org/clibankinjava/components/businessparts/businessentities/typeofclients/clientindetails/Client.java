package org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails.Credit;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.longtermcredit.LongTermCredit;
import org.clibankinjava.customdatastructureandoperationsonthem.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Client")
@Table(name = "client", schema = "client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "type_of_client"
)
@DiscriminatorValue("null")
public abstract class Client implements Comparable<Client> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("FIRST_WAVE_IDENTIFICATION")
    @Column(name = "client_registration_number")
    @Basic(fetch = FetchType.LAZY)
    private String clientRegistrationNumber;

    @LazyGroup("FIRST_WAVE_IDENTIFICATION")
    @Column(name = "client_type")
    @Enumerated(EnumType.STRING)
    @Basic(fetch = FetchType.LAZY)
    private TypeOfClient clientType;

    @LazyGroup("CREATED_BY_EMPLOYEE")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "created_by_employee_id")
    private Employee clientCreatedBy;

    @Embedded
    private RelationshipWithEmployeesDetails relationshipWithEmployees;

    @Embedded
    private StatisticDetails statisticDetails;

    @OrderBy
    @LazyGroup("CREDITS_CONTRACTED")
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Credit> setOfAllCreditsContracted;

    @OrderBy
    @LazyGroup("CREDITS_CONTRACTED")
    @OneToMany(mappedBy = "coSigner", fetch = FetchType.LAZY)
    private Set<LongTermCredit> setOfLongTermCreditsWithCoSigner;

    @LazyGroup("ACCOUNTS_PER_CLIENT")
    @OneToMany(mappedBy = "ownerInformation.owner", fetch = FetchType.LAZY)
    private Set<Account> setOfAllAccounts;

    @LazyGroup("SALARY_ACCOUNT")
    @Column(name = "salary_account_available_at_this_bank")
    @Basic(fetch = FetchType.LAZY)
    private boolean salaryAccountAvailableAtThisBank;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    protected Client() {
        this.setOfAllCreditsContracted = new HashSet<>();
        this.setOfLongTermCreditsWithCoSigner = new HashSet<>();
        this.setOfAllAccounts = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if ((!client.clientRegistrationNumber.equals(this.clientRegistrationNumber)) ||
             (client.clientType != this.clientType)) {
            return false;
        }

        return client.clientCreatedBy.equals(this.clientCreatedBy);
    }

    @Override
    public int hashCode() {
        int result = clientRegistrationNumber.hashCode();

        result = 31 * result + clientType.hashCode();
        result = 31 * result + clientCreatedBy.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Client o) {
        int numericValue = o.clientRegistrationNumber.compareTo(this.clientRegistrationNumber);

        if (numericValue == 0) {
            numericValue = o.clientType.compareTo(this.clientType);

            if (numericValue == 0) {
                return o.clientCreatedBy.compareTo(this.clientCreatedBy);
            }
        }

        return numericValue;
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("clientRegistrationNumber", clientRegistrationNumber),
//                entry("clientType", clientType.toString()),
//                entry("statisticDetails", statisticDetails.toString()),
//                entry("clientCreatedBy", String.format("%s; %s; %s", clientCreatedBy.getFirstName(),
//                        clientCreatedBy.getLastName(), clientCreatedBy.getEmail())),
//                entry("relationshipWithEmployees", relationshipWithEmployees.toString()),
//                entry("salaryAccountAvailableAtThisBank", String.valueOf(salaryAccountAvailableAtThisBank))
//        ));

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "Client [");
    }
}
