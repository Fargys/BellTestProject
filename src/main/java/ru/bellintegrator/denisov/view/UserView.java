package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.model.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserView {
    
    public String id;
    
    public String firstName;
    
    public String secondName;
    
    public String middleName;
    
    public String position;
    
    public String phone;
    
    public String docName;
    
    public String docNumber;
    
    public Date docDate;
    
    public String citizenshipName;
    
    public String citizenshipCode;
    
    public Boolean isIdentified;
    
    public String officeId;

    
    public UserView() {
    }

    public UserView(String firstName, String officeId) {
        this.firstName = firstName;
        this.officeId = officeId;
    }
    
    public UserView(String id, String firstName, String officeId) {
        this.id = id;
        this.firstName = firstName;
        this.officeId = officeId;
    }
    
    
    public User toConvertUserEntity(User user, Document document, Citizenship citizenship) {
        
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        user.setPosition(position);
        user.setPhone(phone);
        user.setDocNumber(docNumber);
        user.setDocDate(docDate);
        user.setIdentified(isIdentified);
        user.setDocument(document);
        user.setCitizenship(citizenship);
        
        return user;
    }

    public User toConvertUserEntity(Office office, Document document, Citizenship citizenship) {
        
        User user = new User();
        
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        user.setPosition(position);
        user.setPhone(phone);
        user.setDocNumber(docNumber);
        user.setDocDate(docDate);
        user.setIdentified(isIdentified);
        user.setDocument(document);
        user.setCitizenship(citizenship);
        user.setOffice(office);
        
        return user;
    }
    

    @Override
    public String toString() {
        return "UserView{" + "id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", middleName=" 
                + middleName + ", position=" + position + ", phone=" + phone + ", docName=" + docName + ", docNumber=" 
                + docNumber + ", docDate=" + docDate + ", citizenshipName=" + citizenshipName + ", citizenshipCode=" 
                + citizenshipCode + ", isIdentified=" + isIdentified + ", officeId=" + officeId + '}';
    }
    
}
