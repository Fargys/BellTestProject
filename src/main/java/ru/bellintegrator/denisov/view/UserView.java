package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

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
    
    //for jackson
    public UserView() {

    }

    @Override
    public String toString() {
        return "UserView{" + "id=" + id + ", firstName=" + firstName + ", secondName=" + secondName 
                + ", middleName=" + middleName + ", position=" + position + ", phone=" + phone 
                + ", docName=" + docName + ", docNumber=" + docNumber + ", docDate=" + docDate 
                + ", citizenshipName=" + citizenshipName + ", citizenshipCode=" + citizenshipCode 
                + ", isIdentified=" + isIdentified + '}';
    }
    
    
    
}
