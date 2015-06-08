package ru.maven.spitter.DAO.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static long serialVersionUID = 2L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public User(){
    }
    
    @Id
    @Column(name = "USERNAME", unique = true, length = 45, nullable = false)
    @NotEmpty
    @Size(min = 2, max = 20)
    private String username;

    @Column(name = "PASSWORD", length = 60, nullable = false)
    @NotEmpty
    @Size(min = 6, max = 100)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private Integer enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

}
