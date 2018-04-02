package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import ru.bellintegrator.denisov.view.OfficeView;

@Entity
@Table(name = "Office")
@NamedQuery(name = "Office.findAll", query = "SELECT p FROM Office p") 
public class Office implements Serializable  {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    private Integer version = 0;
    
    @NotNull
    private String name;
    
    private String phone;
    
    private String address;
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "org_fk")
    private Organization organization;
    
    
    public OfficeView toConvertOfficeDTO() {
        OfficeView view = new OfficeView();
        
        view.id = String.valueOf(id);
        view.name = name;
        view.address = address;
        view.phone = phone;
        view.isActive = isActive;
        
        return view;
    }
    
    public OfficeView toConvertFilterOfficeDTO() {
        OfficeView view = new OfficeView();
        
        view.id = String.valueOf(id);
        view.name = name;
        view.isActive = isActive;
        
        return view;
    }
    
    
    public Office() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}