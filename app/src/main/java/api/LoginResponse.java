package api;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    private String returnValue;
    private String message;
    private Object uuid;
    private String token;
    private Object type;
    private Object object;

    public String getReturnValue() { return returnValue; }
    public void setReturnValue(String value) { this.returnValue = value; }

    public String getMessage() { return message; }
    public void setMessage(String value) { this.message = value; }

    public Object getUUID() { return uuid; }
    public void setUUID(Object value) { this.uuid = value; }

    public String getToken() { return token; }
    public void setToken(String value) { this.token = value; }

    public Object getType() { return type; }
    public void setType(Object value) { this.type = value; }

    public Object getObject() { return object; }
    public void setObject(Object value) { this.object = value; }
}
