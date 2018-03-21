package ru.bellintegrator.denisov.model;

import ru.bellintegrator.denisov.model.Office;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import ru.bellintegrator.denisov.view.OrganizationView;

@Entity(name = "Organization")
public class Organization {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Hibernate service field
     */
    @Version
    private Integer version;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;
    
    @Basic(optional = false)
    @Column(name = "inn")
    private Integer inn;
    
    @Basic(optional = false)
    @Column(name = "kpp")
    private Integer kpp;
    
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "is_active")
    private Boolean active;
    
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
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
        view.isActive = active;
        
        return view;
    }
    
    public OrganizationView toConvertFilterOrgDTO() {
        OrganizationView view = new OrganizationView();
        
        view.id = String.valueOf(id);
        view.name = name;
        view.isActive = active;
        
        return view;
    }
    

    public Organization() {
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

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public int getKpp() {
        return kpp;
    }

    public void setKpp(int kpp) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}