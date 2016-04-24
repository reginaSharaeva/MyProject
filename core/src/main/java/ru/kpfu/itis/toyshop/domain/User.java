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

    @Column(name = "name")
    private String name;

    @Column(name = "checks")
    private boolean check;

    @Column(name = "keys")
    private String key;

    @Column(name = "role")
    private String role;

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

    public User(String login, String hash_pass, String name, boolean check, String key, String role) {
        this.login = login;
        this.hash_pass = hash_pass;
        this.name = name;
        this.check = check;
        this.key = key;
        this.role = role;
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

    public String getName() {
        return name;
    }

    public boolean getCheck() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHash_pass(String hash_pass) {
        this.hash_pass = hash_pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}

