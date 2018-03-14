package ru.bellintegrator.denisov.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity(name = "User")
public class User {
    
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
    @Column(name = "first_name")
    private String firstName;
    
    @Basic(optional = false)
    @Column(name = "second_name")
    private String secondName;
    
    @Basic(optional = false)
    @Column(name = "middle_name")
    private String middleName;
    
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "is_identified")
    private Boolean isIdentified;
    
    @OneToOne(
     mappedBy = "user",
     fetch = FetchType.LAZY,
     cascade = CascadeType.ALL,
     optional = false
    )
    private Account account;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    private Document document;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Citizenship citizenship;
    
    
    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        this.isIdentified = identified;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Account getUserLogin() {
        return account;
    }

    public void setUserLogin(Account userLogin) {
        this.account = userLogin;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }
    
}