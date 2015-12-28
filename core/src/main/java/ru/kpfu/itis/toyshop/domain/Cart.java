package ru.kpfu.itis.toyshop.domain;

import javax.persistence.*;

/**
 * Created by Regina on 28.12.2015.
 */
@Entity
@Table(name="Cart")
public class Cart {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "goods")
    private Good goods;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private User users;

    @Column(name = "count")
    private Long count;

    public Cart() {
    }

    public Cart(Good goods, User users, Long count) {
        this.goods = goods;
        this.users = users;
        this.count = count;
    }

    public Good getGoods() {
        return goods;
    }

    public User getUsers() {
        return users;
    }

    public Long getCount() {
        return count;
    }
}

