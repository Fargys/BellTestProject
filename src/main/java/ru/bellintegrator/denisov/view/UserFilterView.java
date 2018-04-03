package ru.bellintegrator.denisov.view;

public class UserFilterView {
    
    public String officeId;
    
    public String firstName;
    
    public String lastName;
    
    public String middleName;
    
    public String position;
    
    public String docCode;
    
    public String citizenshipCode;

    public UserFilterView() {
    }

    public UserFilterView(String firstName) {
        this.firstName = firstName;
    }
    
}