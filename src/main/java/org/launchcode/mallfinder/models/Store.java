package org.launchcode.mallfinder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue
    private int id;

    private String storeName;
    @ManyToMany
    private List<Mall> malls;

    public Store(int id, String storeName) {
        this.id = id;
        this.storeName = storeName;
    }

    public List<Mall> getMalls() {
        return malls;
    }

    public Store() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
