package org.lep.hibernate.model;

import java.util.Set;

/**
 * Created by lvep on 2016/3/21.
 */
public class Person {
    private long id;
    private Address address;
    private Set<Address> addressList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<Address> addressList) {
        this.addressList = addressList;
    }
}
