package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Account")
@NamedQuery(name = "Account.findAll", query = "SELECT p FROM Account p") 
public class Account implements Serializable  {
    
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    
    @Version
    private Integer version = 0;
    
    private String name;
    
    private String login;
    
    private String password;
    
    @Column(name = "activation_code")
    private String activationCode;
    
    @Column(name = "activation_status")
    private Boolean activationStatus;
    

    public Account() {
    }

    public Account(String login) {
        this.login = login;
    }
    

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(Boolean activationStatus) {
        this.activationStatus = activationStatus;
    }
    
}
