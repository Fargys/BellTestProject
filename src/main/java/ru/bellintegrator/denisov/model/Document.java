package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name = "Document")
public class Document implements Serializable  {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Version
    private Integer version;
    
    @Basic(optional = false)
    @Column(name = "doc_number")
    private Integer number;
    
    @Basic(optional = false)
    @Column(name = "doc_date")
    @Temporal(value = TemporalType.DATE)
    private Date date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type")
    private DocumentType type;
    
    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
    private Set<User> users;
    

    public Document() {
    }

    public Long getId() {
        return id;
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

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
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