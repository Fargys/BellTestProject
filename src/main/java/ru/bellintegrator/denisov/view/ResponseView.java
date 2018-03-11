package ru.bellintegrator.denisov.view;

public class ResponseView {
    Object data;
    String error;

    public ResponseView() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
