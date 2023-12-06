package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofclients.clientindetails.Client;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Embeddable
public class OwnerInformation implements Comparable<OwnerInformation> {
    @LazyGroup("CLIENT")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id", columnDefinition = "long default -1")
    private Client owner;

    @LazyGroup("USER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", columnDefinition = "long default -1")
    private User user;

    public OwnerInformation() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerInformation that)) return false;

        if (!that.owner.equals(owner)) return false;
        return that.user.equals(user);
    }

    @Override
    public int hashCode() {
        int result = owner.hashCode();
        result = 31 * result + user.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull OwnerInformation o) {
        int numericValueToReturn = o.owner.compareTo(this.owner);

        if (numericValueToReturn == 0) {
            return o.user.compareTo(this.user);
        }

        return numericValueToReturn;
    }

    @Override
    public String toString() {
        return String.format("OwnerInformation [%s, %s]",
                owner.toString(), user.toString());
    }
}
