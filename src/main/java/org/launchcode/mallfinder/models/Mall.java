package org.launchcode.mallfinder.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mall {
    @Id
    @GeneratedValue
    private int id;

    private String mallName;

    @Embedded
    private Address mallAddress;
    private String phoneNumber;

    @ManyToMany(mappedBy = "malls")
    private List<Store> stores;
    public Mall() {
    }

    public Mall(String mallName, Address mallAddress, String phoneNumber) {
        this.mallName = mallName;
        this.mallAddress = mallAddress;
        this.phoneNumber = phoneNumber;
    }

    public List<Store> getStores() {
        return stores;
    }

    public int getId() {
        return id;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mall_name) {
        this.mallName = mall_name;
    }

    public Address getMallAddress() {
        return mallAddress;
    }

    public void setMallAddress(Address mall_address) {
        this.mallAddress = mall_address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }
}
