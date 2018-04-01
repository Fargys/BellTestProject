package ru.bellintegrator.denisov.view;

public class ResponseView {
    
    public Object data;
    
    public Boolean result;
    
    public String error;
    
    private ResponseView() {
            // private constructor
        }
    
    public static Builder newBuilder() {
        return new ResponseView().new Builder();
    }
    
    public Object getData() {
        return data;
    }

    public Boolean getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "ResponseView{" + "data=" + data + ", result=" + result + ", error=" + error + '}';
    }
    
    public class Builder {
        
        private Builder() {
            // private constructor
        }
        
        public Builder setData(Object data) {
            ResponseView.this.data = data;

            return this;
        }

        public Builder setResult(Boolean result) {
            ResponseView.this.result = result;

            return this;
        }
        
        public Builder setError(String error) {
            ResponseView.this.error = error;

            return this;
        }
        
        public ResponseView build() {
            return ResponseView.this;
        }
    }
    
}
