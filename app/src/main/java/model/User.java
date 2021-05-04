package model;

public class User {
    private String returnValue;
    private String message;
    private Object uuid;
    private ObjectClass object;
    private Object object2;

    public String getReturnValue() { return returnValue; }
    public void setReturnValue(String value) { this.returnValue = value; }

    public String getMessage() { return message; }
    public void setMessage(String value) { this.message = value; }

    public Object getUUID() { return uuid; }
    public void setUUID(Object value) { this.uuid = value; }

    public ObjectClass getObject() { return object; }
    public void setObject(ObjectClass value) { this.object = value; }

    public Object getObject2() { return object2; }
    public void setObject2(Object value) { this.object2 = value; }
}
