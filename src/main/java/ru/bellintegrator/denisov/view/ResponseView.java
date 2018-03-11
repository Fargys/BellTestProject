package ru.bellintegrator.denisov.view;

public class ResponseView {
    
    public Object data;
    
    public String error;

    //for jackson
    public ResponseView() {
    }
    
    public static String getDataView(Object data) {
        return "{data:" + data.toString() + "}";
    }
    
    public static String getErrorView(String errorMessage) {
        return "{error:" + errorMessage + "}";
    }
    
    public static String getSuccesView() {
        return "{data:{result:succes}}";
    }
}
