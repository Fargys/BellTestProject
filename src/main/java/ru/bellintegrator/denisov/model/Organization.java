package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import ru.bellintegrator.denisov.view.OrganizationView;

@Entity
@Table(name = "Organization")
@NamedQuery(name = "Organization.findAll", query = "SELECT p FROM Organization p") 
public class Organization implements Serializable  {
    
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version = 0;
    
    @NotNull
    private String name;
    
    @Column(name = "full_name")
    private String fullName;
    
    private String inn;
    
    private String kpp;
    
    private String address;
    
    private String phone;
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Office> offices;
    
    
    public OrganizationView toConvertOrgDTO() {
        OrganizationView view = new OrganizationView();
        
        view.id = String.valueOf(id);
        view.name = name;
        view.fullName = fullName;
        view.inn = inn;
        view.kpp = kpp;
        view.address = address;
        view.phone = phone;
        view.isActive = isActive;
        
        return view;
    }
    
    public OrganizationView toConvertFilterOrgDTO() {
        OrganizationView view = new OrganizationView();
        
        view.id = String.valueOf(id);
        view.name = name;
        view.isActive = isActive;
        
        return view;
    }
    

    public Organization() {
    }

    public Organization(String name) {
        this.name = name;
    }
    
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
}