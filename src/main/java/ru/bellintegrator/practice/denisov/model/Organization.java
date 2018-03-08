package ru.bellintegrator.practice.denisov.model;

import ru.bellintegrator.practice.denisov.model.Office;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;

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
    
    @OneToMany
    @JoinColumn(name = "org_id")
    private Set<Office> offices;
    
    
    public void addOffice(Office office) {
        getOffices().add(office);
        office.setOrganization(this);
    }
    
    public void removeOffice(Office office) {
        getOffices().remove(office);
        office.setOrganization(null);
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