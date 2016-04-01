package ru.kpfu.itis.toyshop.form;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * Created by Regina on 24.03.2016.
 */

public class RegisterFormBean {

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String name;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Неверный формат email")
    private String email;

    @Size(min=6, max=20, message="Пароль должен быть от 6 до 20 символов")
    private String password;

    @Size(min=6, max=20, message="Пароль должен быть от 6 до 20 символов")
    private String confirmPassword;

    public RegisterFormBean() {
    }

    public RegisterFormBean(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "RegistrationFormBean{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}

