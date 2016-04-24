package ru.kpfu.itis.toyshop.form;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Регина on 18.04.2016.
 */
public class ChangeInfoFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String name;

    private String password;

    private String confirmPassword;


    public ChangeInfoFormBean() {
    }

    public ChangeInfoFormBean(String name, String password, String confirmPassword) {
        this.name = name;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "ChangeInfoFormBean{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
