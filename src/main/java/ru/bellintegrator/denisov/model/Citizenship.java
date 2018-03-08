package ru.bellintegrator.denisov.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity(name = "Citizenship")
public class Citizenship {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Version
    private Integer version;
    
    @Basic(optional = false)
    @Column(name = "citizenship_name")
    private String citizenshipName;
    
    @Basic(optional = false)
    @Column(name = "citizenship_code")
    private Integer citizenshipCode;
    
    @ManyToMany(mappedBy = "citizenships")
    private Set<User> users;

    public Citizenship() {
    }

    public Long getId() {
        return id;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public Integer getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Integer citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
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