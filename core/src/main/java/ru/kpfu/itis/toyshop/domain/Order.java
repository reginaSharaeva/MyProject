package ru.kpfu.itis.toyshop.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Regina on 28.12.2015.
 */
@Entity
@Table(name="Orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "total_sum")
    private BigDecimal total_sum;

    @Column(name = "total_count")
    private int total_count;

    @Column(name = "status")
    private String status;

    @Column(name = "pay_type")
    private String pay_type;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "address")
    private Address address;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private User users;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="orders")
    private List<Order_Good> order_goods;

    public Long getId() {
        return id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public BigDecimal getTotal_sum() {
        return total_sum;
    }

    public int getTotal_count() {
        return total_count;
    }

    public String getStatus() {
        return status;
    }

    public String getPay_type() {
        return pay_type;
    }

    public Address getAddress() {
        return address;
    }

    public User getUsers() {
        return users;
    }

    public List<Order_Good> getOrder_goods() {
        return order_goods;
    }
}
