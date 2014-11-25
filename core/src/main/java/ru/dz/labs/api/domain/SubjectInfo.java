package ru.dz.labs.api.domain;

import javax.persistence.*;

/**
 * Класс с информацией о предметах
 *
 * @author Gataullin Kamil
 *         06.10.2014 1:27
 */
@Entity
@Table(name="Subject")
public class SubjectInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название предмета
     */
    @Column(name = "name")
    private String name;

    public SubjectInfo() {
    }

    public SubjectInfo(Long id) {
        this.id = id;
    }

    public SubjectInfo(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubjectInfo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append("'}");
        return sb.toString();
    }
}
