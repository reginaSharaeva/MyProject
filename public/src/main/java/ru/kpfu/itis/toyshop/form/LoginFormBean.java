package ru.kpfu.itis.toyshop.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Регина on 24.03.2016.
 */
public class LoginFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Неверный формат email")
    private String email;

    @Size(min=6, max=20, message="Пароль должен быть от 6 до 20 символов")
    private String password;

    public LoginFormBean() {
    }

    public LoginFormBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationFormBean{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
