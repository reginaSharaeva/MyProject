package ru.kpfu.itis.toyshop.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Regina on 28.12.2015.
 */
@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "hash_pass")
    private String hash_pass;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "name")
    private String name;

    @Column(name = "check")
    private String check;

    @Column(name = "key")
    private String key;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="users")
    private List<Address> address;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="users")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="users")
    private List<Cart> cart;

    public User() {
    }

    public User(String login, String hash_pass, String avatar, String name, String check, String key, List<Address> address, List<Order> orders, List<Cart> cart) {
        this.login = login;
        this.hash_pass = hash_pass;
        this.avatar = avatar;
        this.name = name;
        this.check = check;
        this.key = key;
        this.address = address;
        this.orders = orders;
        this.cart = cart;
    }


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getHash_pass() {
        return hash_pass;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getCheck() {
        return check;
    }

    public String getKey() {
        return key;
    }

    public List<Address> getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Cart> getCart() {
        return cart;
    }
}
