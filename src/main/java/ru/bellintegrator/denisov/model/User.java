package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import ru.bellintegrator.denisov.view.UserView;

@Entity
@Table(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT p FROM User p")
public class User implements Serializable  {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Version
    private Integer version = 0;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "second_name")
    private String secondName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    private String position;
    
    private String phone;
    
    @Column(name = "doc_number")
    private String docNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "doc_date")
    private Date docDate;
    
    @Column(name = "is_identified")
    private Boolean isIdentified;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doc_type_fk")
    private Document document;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_fk")
    private Office office;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "citizenship_type_fk")
    private Citizenship citizenship;
    
    
    public UserView toConvertUserDTO() {
        UserView view = new UserView();
        
        view.id = String.valueOf(id);
        view.firstName = firstName;
        view.secondName = secondName;
        view.middleName = middleName;
        view.position = position;
        view.phone = phone;
        view.docName = document.getDocName();
        view.docNumber = docNumber;
        view.docDate = docDate;
        view.citizenshipCode = String.valueOf(citizenship.getCountryCode());
        view.citizenshipName = citizenship.getCountryName();
        view.isIdentified = isIdentified;
        view.officeId = String.valueOf(office.getId());
        
        return view;
    }
    
    public UserView toConvertFilterUserDTO() {
        UserView view = new UserView();
        
        view.id = String.valueOf(id);
        view.firstName = firstName;
        view.secondName = secondName;
        view.middleName = middleName;
        view.position = position;
        
        return view;
    }
    
    
    public User() {
    }

    public User(String firstName) {
        this.firstName = firstName;
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

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean isIdentified) {
        this.isIdentified = isIdentified;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", version=" + version + ", firstName=" + firstName + ", secondName=" + secondName 
                + ", middleName=" + middleName + ", position=" + position + ", phone=" + phone + ", docNumber=" + docNumber 
                + ", docDate=" + docDate + ", isIdentified=" + isIdentified + ", document=" + document + ", office=" + office 
                + ", citizenship=" + citizenship + '}';
    }
    
    
    
}