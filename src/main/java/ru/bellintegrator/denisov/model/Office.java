package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import ru.bellintegrator.denisov.view.OfficeView;

@Entity(name = "Office")
@NamedQuery(name = "Office.findAll", query = "SELECT p FROM Office p") 
public class Office implements Serializable  {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    /**
     * Hibernate service field
     */
    @Version
    private Integer version;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "is_active")
    private Boolean active;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;
    
    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private Set<User> users;
    
    public OfficeView toConvertOfficeDTO() {
        OfficeView view = new OfficeView();
        
        view.id = String.valueOf(id);
        view.name = name;
        view.address = address;
        view.phone = phone;
        view.isActive = active;
        
        return view;
    }
    
    public OfficeView toConvertFilterOfficeDTO() {
        OfficeView view = new OfficeView();
        
        view.id = String.valueOf(id);
        view.name = name;
        view.isActive = active;
        
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
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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