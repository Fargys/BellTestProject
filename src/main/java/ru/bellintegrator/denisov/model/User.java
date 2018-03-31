package ru.bellintegrator.denisov.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import ru.bellintegrator.denisov.view.UserView;

@Entity(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT p FROM User p") 
public class User implements Serializable  {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    /**
     * Hibernate service field
     */
    @Version
    private Integer version;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "second_name")
    private String secondName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "position")
    private String position;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "is_identified")
    private Boolean isIdentified;
    
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Account account;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "doc_id")
    private Document document;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "citizenship_id")
    private CitizenshipType citizenship;
    
    
    public UserView toConvertUserDTO() {
        UserView view = new UserView();
        
        view.id = String.valueOf(id);
        view.firstName = firstName;
        view.secondName = secondName;
        view.middleName = middleName;
        view.position = position;
        view.phone = phone;
        view.isIdentified = isIdentified;
        
        Document userDoc = getDocument();
        DocumentType docType = userDoc.getType();
        
        view.docName = docType.getName();
        view.docNumber = userDoc.getNumber();
        view.docDate = userDoc.getDate();
        
        CitizenshipType userCitizenship = getCitizenshipType();
        view.citizenshipName = userCitizenship.getName();
        view.citizenshipCode = userCitizenship.getCode();
        
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

    public CitizenshipType getCitizenshipType() {
        return citizenship;
    }

    public void setCitizenshipType(CitizenshipType citizenship) {
        this.citizenship = citizenship;
    }
    
}