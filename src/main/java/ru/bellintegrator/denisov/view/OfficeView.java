package ru.bellintegrator.denisov.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeView {
    @ApiModelProperty(hidden = true)
    public String id;   
    
    public String name;
    
    public String phone;
    
    public Boolean active;
    
    //for jackson
    public OfficeView() {

    }

    @Override
    public String toString() {
        return "OfficeView{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", active=" + active + '}';
    }
    
}
