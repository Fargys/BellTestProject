package ru.bellintegrator.denisov.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name = "Document")
public class Document {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Version
    private Integer version;
    
    @Basic(optional = false)
    @Column(name = "doc_name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "doc_number")
    private Integer number;
    
    @Basic(optional = false)
    @Column(name = "doc_date")
    @Temporal(value=TemporalType.DATE)
    private Date date;
    
    @ManyToMany(mappedBy = "documents")
    private Set<User> users;
    

    public Document() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String docName) {
        this.name = docName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer docNumber) {
        this.number = docNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date docDate) {
        this.date = docDate;
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