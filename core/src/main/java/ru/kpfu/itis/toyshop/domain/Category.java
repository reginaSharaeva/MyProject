package ru.kpfu.itis.toyshop.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Regina on 28.12.2015.
 */
@Entity
@Table(name="Category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "alias")
    private String alias;

    @Column(name = "parent_id")
    private Long parent_id;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="category")
    private List<Good> goods;

    public Category() {
    }

    public Category(String name, String alias, Long parent_id, List<Good> goods) {
        this.name = name;
        this.alias = alias;
        this.parent_id = parent_id;
        this.goods = goods;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public Long getParent_id() {
        return parent_id;
    }
}

