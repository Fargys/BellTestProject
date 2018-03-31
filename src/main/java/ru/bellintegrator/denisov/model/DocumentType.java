package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name = "Document_type")
@NamedQuery(name = "DocumentType.findAll", query = "SELECT p FROM Document_type p") 
public class DocumentType implements Serializable  {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Version
    private Integer version;
    
    @Column(name = "doc_name")
    private String name;
    
    @Column(name = "doc_code")
    private Integer code;
    
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Set<Document> documents;
    

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        if (documents == null) {
            documents = new HashSet<>();
        }
        this.documents = documents;
    }
    
}
