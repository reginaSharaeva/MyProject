package ru.kpfu.itis.toyshop.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Regina on 28.12.2015.
 */
@Entity
@Table(name="Address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private int house;

    @Column(name = "flat")
    private int flat;

    @Column(name = "index")
    private int index;

    @Column(name = "area")
    private String area;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private User users;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="address")
    private List<Order> orders;

    public Address() {
    }

    public Address(String city, String street, int house, int flat, int index, String area, User users, List<Order> orders) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.index = index;
        this.area = area;
        this.users = users;
        this.orders = orders;
    }

    public Address(String city, String street, int house, int flat, int index, String area, User users) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.index = index;
        this.area = area;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public double getFlat() {
        return flat;
    }

    public int getIndex() {
        return index;
    }

    public String getArea() {
        return area;
    }

    public User getUsers() {
        return users;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

