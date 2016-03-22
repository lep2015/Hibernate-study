package org.lep.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lvep on 2016/3/20.
 */
@Entity
class Customer {
    @EmbeddedId
    CustomerId id;
    boolean preferredCustomer;

    @MapsId("userId")
    @JoinColumns({
            @JoinColumn(name="userfirstname_fk", referencedColumnName="firstName"),
            @JoinColumn(name="userlastname_fk", referencedColumnName="lastName")
    })
    @OneToOne
    User user;
}

@Embeddable
class CustomerId implements Serializable {
    UserId userId;
    String customerNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerId that = (CustomerId) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return !(customerNumber != null ? !customerNumber.equals(that.customerNumber) : that.customerNumber != null);

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (customerNumber != null ? customerNumber.hashCode() : 0);
        return result;
    }
}


