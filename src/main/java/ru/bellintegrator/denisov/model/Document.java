package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Document")
@NamedQuery(name = "Document.findAll", query = "SELECT p FROM Document p") 
public class Document implements Serializable  {
    
    @Id
    @Column(name = "doc_code")
    private Long docCode;
    
    @Version
    private Integer version = 0;
    
    @Column(name = "doc_name")
    private String docName;
    
    
    public Document() {
    }

    public Long getDocCode() {
        return docCode;
    }

    public void setDocCode(Long docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
    
}