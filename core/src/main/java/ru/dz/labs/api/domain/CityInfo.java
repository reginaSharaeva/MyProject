package ru.dz.labs.api.domain;

import javax.persistence.*;

/**
 * Класс города
 *
 * @author Gataullin Kamil
 *         23.11.2014 16:21
 */
@Entity
@Table(name = "City")
public class CityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Короткий алиас города
     */
    @Column(unique = true, nullable = false, length = 20)
    private String alias;

    /**
     * Название города
     */
    @Column(nullable = false, length = 50)
    private String name;

    public CityInfo() {
    }

    public CityInfo(String alias, String name) {
        this.alias = alias;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
