package ru.maven.spitter.DAO.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "USERS")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    public Users() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "^[а-яА-Я0-9]+$|^[a-zA-Z0-9]+$",
            message = "Username must be alphanumeric with no spaces")
    @Size(min = 2, max = 20, message = "Minimum 2, maximum 20 words.")
    @Column(name = "NICKNAME")
    private String nickName;

    @NotEmpty
    @Pattern(regexp = "^[а-яА-Я]+$|^[a-zA-Z]+$",
            message = "Username must be alphanumeric with no spaces")
    @Size(min = 2, max = 20, message = "Minimum 2, maximum 20 words.")
    @Column(name = "FIRSTNAME")
    private String firstName;

    @NotEmpty
    @Pattern(regexp = "^[а-яА-Я]+$|^[a-zA-Z]+$",
            message = "Username must be alphanumeric with no spaces")
    @Size(min = 2, max = 20, message = "Minimum 2, maximum 20 words.")
    @Column(name = "LASTNAME")
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}",
            message = "Invalid email address.")
    @Column(name = "EMAIL")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
