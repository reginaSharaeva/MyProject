package ru.kpfu.itis.toyshop.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Регина on 06.04.2016.
 */
public class OrderFormBean {
    
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$", message="Неверный формат")
    private String area;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$", message="Неверный формат")
    private String city;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$", message="Неверный формат")
    private String street;

    @Size(min = 1, max = 3, message = "Неверный формат")
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[0-9]+$", message="Неверный формат")
    private String house;

    @Size(min = 1, max = 3, message = "Неверный формат")
    @Pattern(regexp = "^[0-9]+$", message="Неверный формат")
    private String flat;

    @Size(min = 6, max = 6, message="Неверный формат")
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[0-9]+$", message="Неверный формат")
    private String index;

    private String payWay;

    public OrderFormBean() {
    }

    public OrderFormBean(String payWay, String area, String city, String street, String house, String flat, String index) {
        this.area = area;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.index = index;
        this.payWay = payWay;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "OrderFormBean{" +
                "area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", flat=" + flat +
                ", index=" + index +
                '}';
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
}
