package ru.kpfu.itis.toyshop.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Regina on 28.12.2015.
 */
@Entity
@Table(name="Goods")
public class Good {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Date year;

    @Column(name = "country")
    private String country;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "count")
    private int count;

    @Column(name = "size")
    private double size;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String discription;

    @Column(name = "color")
    private String color;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="goods")
    private List<Cart> cart;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="goods")
    private List<Order_Good> order_goods;

    public Good() {
    }

    public Good(String name, Date year, String country, BigDecimal price, int count, double size, String image, String discription, String color, Category category, List<Cart> cart, List<Order_Good> order_goods) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.price = price;
        this.count = count;
        this.size = size;
        this.image = image;
        this.discription = discription;
        this.color = color;
        this.category = category;
        this.cart = cart;
        this.order_goods = order_goods;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public double getSize() {
        return size;
    }

    public String getImage() {
        return image;
    }

    public String getDiscription() {
        return discription;
    }

    public String getColor() {
        return color;
    }

    public Category getCategory() {
        return category;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public List<Order_Good> getOrder_goods() {
        return order_goods;
    }
}

