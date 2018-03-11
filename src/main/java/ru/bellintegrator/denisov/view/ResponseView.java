package ru.bellintegrator.denisov.view;

public class ResponseView {
    
    public Object data;
    
    public String error;
    
    public String result = "success";

    //for jackson
    public ResponseView() {
    }
    
    public String getDataView(Object data) {
        return "{ data:" + data.toString() + "}";
    }
    
    public String getErrorView(String errorMessage) {
        return "{error:" + errorMessage + "}";
    }
    
    public String getResultView() {
        return "{result:succes}";
    }
}
