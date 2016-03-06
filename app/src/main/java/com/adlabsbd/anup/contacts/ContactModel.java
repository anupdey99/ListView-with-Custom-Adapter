package com.adlabsbd.anup.contacts;

/**
 * Created by Anup on 05-Mar-16.
 */
public class ContactModel {

    private String name;
    private String phoneNo;
    private int imageID;

    public ContactModel(String name, String phoneNo, int imageID) {
        setName(name);
        setPhoneNo(phoneNo);
        setImageID(imageID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
