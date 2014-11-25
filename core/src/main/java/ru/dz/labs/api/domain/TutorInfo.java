package ru.dz.labs.api.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Класс с информацией о репетиторах
 *
 * @author Gataullin Kamil
 *         23.11.2014 15:58
 */
@Entity
@Table(name = "Tutors")
public class TutorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Имя репетитора
     */
    @Column(nullable = false, length = 25)
    private String name;

    /**
     * Фамилия репетитора
     */
    @Column(length = 25)
    private String surname;

    /**
     * Отчество репетитора
     */
    @Column(length = 25)
    private String patronymic;

    /**
     * Дата рождения репетитора
     */
    private Date birthday;

    /**
     * Список предметов репетитора
     */
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "Tutor_Subjects",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<SubjectInfo> subjects;

    /**
     * Город в котором работает репетитор
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private CityInfo city;

    public TutorInfo() {
    }

    public TutorInfo(String name, String surname, String patronymic, Date birthday, List<SubjectInfo> subjects, CityInfo city) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.subjects = subjects;
        this.city = city;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<SubjectInfo> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectInfo> subjects) {
        this.subjects = subjects;
    }

    public CityInfo getCity() {
        return city;
    }

    public void setCity(CityInfo city) {
        this.city = city;
    }
}
