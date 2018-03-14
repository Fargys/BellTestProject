package ru.bellintegrator.denisov.view;

public class ResponseView {
    
    public Object data;
    
    public Boolean result;
    
    public String error;

    //for jackson
    public ResponseView() {
    }
    
    
    public Object getDataView(Object data) {
        setData(data);
        return getData();
    }
    
    public Boolean getResultView(boolean result){
        setResult(result);
        return getResult();
    }
    
    public String getErrorView(String error) {
        setError(error);
        return getError();
    }
    

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
