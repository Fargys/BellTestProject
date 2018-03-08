package ru.bellintegrator.practice.denisov.model;

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
    private String docName;
    
    @Basic(optional = false)
    @Column(name = "doc_number")
    private Integer docNumber;
    
    @Basic(optional = false)
    @Column(name = "doc_date")
    @Temporal(value=TemporalType.DATE)
    private Date docDate;
    
    @ManyToMany(mappedBy = "documents")
    private Set<User> users;
    

    public Document() {
    }

    public Long getId() {
        return id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Integer getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Integer docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
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