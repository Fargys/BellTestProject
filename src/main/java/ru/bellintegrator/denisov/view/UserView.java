package ru.bellintegrator.denisov.view;

import io.swagger.annotations.ApiModelProperty;

public class UserView {
    @ApiModelProperty(hidden = true)
    public String id;
    
    public String firstName;
    
    public String secondName;
    
    public String middleName;
    
    public String position;
    
    public String phone;
    
    public Boolean active;
    
    //for jackson
    public UserView() {

    }

    @Override
    public String toString() {
        return "UserView{" + "id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", middleName="
                + middleName + ", position=" + position + ", phone=" + phone + ", active=" + active + '}';
    }
    
}
