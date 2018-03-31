package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name = "Citizenship_type")
@NamedQuery(name = "CitizenshipType.findAll", query = "SELECT p FROM Citizenship_type p") 
public class CitizenshipType implements Serializable  {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Version
    private Integer version;
    
    @Column(name = "citizenship_name")
    private String name;
    
    @Column(name = "citizenship_code")
    private Integer code;
    
    @OneToMany(mappedBy = "citizenship", fetch = FetchType.LAZY)
    private Set<User> users;

    public CitizenshipType() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String citizenshipName) {
        this.name = citizenshipName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer citizenshipCode) {
        this.code = citizenshipCode;
    }

    public Set<User> getUsers() {
        if (users == null) {
            users = new HashSet<>();
        }
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
}