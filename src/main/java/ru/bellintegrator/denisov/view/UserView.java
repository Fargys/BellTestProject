package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.Document;
import ru.bellintegrator.denisov.model.DocumentType;
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
    
    public Integer docNumber;
    
    public Date docDate;
    
    public String citizenshipName;
    
    public Integer citizenshipCode;
    
    public Boolean isIdentified;
    
    public String officeId;
    
    
    public User toConvertUserEntity(User user, DocumentType docType) {
        
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        user.setPosition(position);
        user.setPhone(phone);
        user.setIdentified(isIdentified);
        
        Document userDoc = user.getDocument();
        userDoc.setType(docType);
        userDoc.setNumber(docNumber);
        userDoc.setDate(docDate);
        
        CitizenshipType userCitizenship = user.getCitizenship();
        userCitizenship.setName(citizenshipName);
        userCitizenship.setCode(citizenshipCode);
        
        return user;
    }

    public User toConvertUserEntity(Office office, DocumentType docType) {
        
        Document userDoc = new Document();
        userDoc.setType(docType);
        userDoc.setNumber(docNumber);
        userDoc.setDate(docDate);
        
        CitizenshipType userCitizenship = new CitizenshipType();
        userCitizenship.setName(citizenshipName);
        userCitizenship.setCode(citizenshipCode);
        
        User user = new User();
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        user.setPosition(position);
        user.setPhone(phone);
        user.setIdentified(isIdentified);
        user.setDocument(userDoc);
        user.setCitizenship(userCitizenship);
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
