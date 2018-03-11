package ru.bellintegrator.denisov.view;

public class UserFilterView {
    
    public String officeId;
    
    public String firstName;
    
    public String lastName;
    
    public String middleName;
    
    public String position;
    
    public String docCode;
    
    public String citizenshipCode;

    //for jackson
    public UserFilterView() {
    }

    @Override
    public String toString() {
        return "{firstName;" + firstName + "; lastName:" + lastName + "; middleName:" + middleName + "; position:" + position + '}';
    }
    
}
