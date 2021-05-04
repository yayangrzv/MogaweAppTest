package model;

import java.util.UUID;

public class ObjectClass {
    private Object[] certification;
    private Object[] postTimelines;
    private boolean termsAgreed;
    private long idMogawers;
    private UUID uuid;
    private String mogawers_code;
    private String full_name;
    private String email;
    private Object phone;
    private String password;
    private String idDevice;
    private Object profilePicture;
    private String gender;
    private long birthdate;
    private double latitude;
    private double longitude;
    private Object address;
    private String city;
    private long level;
    private long gaweanSelesai;
    private long douwnlineCount;
    private long pendingPayment;
    private String refCode;
    private String edu;
    private boolean isPhoneActive;
    private long balance;
    private long points;
    private boolean hasPassword;
    private boolean isTermsAgreed;
    private long balanceLatestUpdated;
    private Object statusTimeline;

    public Object[] getCertification() { return certification; }
    public void setCertification(Object[] value) { this.certification = value; }

    public Object[] getPostTimelines() { return postTimelines; }
    public void setPostTimelines(Object[] value) { this.postTimelines = value; }

    public boolean getTermsAgreed() { return termsAgreed; }
    public void setTermsAgreed(boolean value) { this.termsAgreed = value; }

    public long getIDMogawers() { return idMogawers; }
    public void setIDMogawers(long value) { this.idMogawers = value; }

    public UUID getUUID() { return uuid; }
    public void setUUID(UUID value) { this.uuid = value; }

    public String getMogawersCode() { return mogawers_code; }
    public void setMogawersCode(String value) { this.mogawers_code = value; }

    public String getFullName() { return full_name; }
    public void setFullName(String value) { this.full_name = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public Object getPhone() { return phone; }
    public void setPhone(Object value) { this.phone = value; }

    public String getPassword() { return password; }
    public void setPassword(String value) { this.password = value; }

    public String getIDDevice() { return idDevice; }
    public void setIDDevice(String value) { this.idDevice = value; }

    public Object getProfilePicture() { return profilePicture; }
    public void setProfilePicture(Object value) { this.profilePicture = value; }

    public String getGender() { return gender; }
    public void setGender(String value) { this.gender = value; }

    public long getBirthdate() { return birthdate; }
    public void setBirthdate(long value) { this.birthdate = value; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double value) { this.latitude = value; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double value) { this.longitude = value; }

    public Object getAddress() { return address; }
    public void setAddress(Object value) { this.address = value; }

    public String getCity() { return city; }
    public void setCity(String value) { this.city = value; }

    public long getLevel() { return level; }
    public void setLevel(long value) { this.level = value; }

    public long getGaweanSelesai() { return gaweanSelesai; }
    public void setGaweanSelesai(long value) { this.gaweanSelesai = value; }

    public long getDouwnlineCount() { return douwnlineCount; }
    public void setDouwnlineCount(long value) { this.douwnlineCount = value; }

    public long getPendingPayment() { return pendingPayment; }
    public void setPendingPayment(long value) { this.pendingPayment = value; }

    public String getRefCode() { return refCode; }
    public void setRefCode(String value) { this.refCode = value; }

    public String getEdu() { return edu; }
    public void setEdu(String value) { this.edu = value; }

    public boolean getIsPhoneActive() { return isPhoneActive; }
    public void setIsPhoneActive(boolean value) { this.isPhoneActive = value; }

    public long getBalance() { return balance; }
    public void setBalance(long value) { this.balance = value; }

    public long getPoints() { return points; }
    public void setPoints(long value) { this.points = value; }

    public boolean getHasPassword() { return hasPassword; }
    public void setHasPassword(boolean value) { this.hasPassword = value; }

    public boolean getIsTermsAgreed() { return isTermsAgreed; }
    public void setIsTermsAgreed(boolean value) { this.isTermsAgreed = value; }

    public long getBalanceLatestUpdated() { return balanceLatestUpdated; }
    public void setBalanceLatestUpdated(long value) { this.balanceLatestUpdated = value; }
}
