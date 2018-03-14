package ru.bellintegrator.denisov.view;

import com.fasterxml.jackson.annotation.JsonInclude;

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
    
    public String docDate;
    
    public String citizenshipName;
    
    public String citizenshipCode;
    
    public Boolean isIdentified;
    
    //for jackson
    public UserView() {

    }
    
}
