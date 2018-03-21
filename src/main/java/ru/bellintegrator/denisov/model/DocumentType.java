package ru.bellintegrator.denisov.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name = "Document_type")
public class DocumentType {
    
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
    @Column(name = "doc_code")
    private Integer code;
    
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Document document;
    

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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
    
}
