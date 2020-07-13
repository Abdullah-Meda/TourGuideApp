package com.example.android.tourguideapp;

public class Venue {

    private String mNameOfVenue;
    private String mNameOfEmirate;
    private String mDescription;
    private String mWebLink;
    private String mPhone;
    private int mImageResourceId;


    public Venue(String nameOfVenue, String nameOfEmirate,String description, String webLink,String phone, int imageResourceId) {
        mNameOfVenue = nameOfVenue;
        mNameOfEmirate = nameOfEmirate;
        mDescription = description;
        mWebLink = webLink;
        mPhone = phone;
        mImageResourceId = imageResourceId;
    }

    public String getNameOfVenue() {
        return mNameOfVenue;
    }

    public String getNameOfEmirate() {
        return mNameOfEmirate;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getWebLink() {
        return mWebLink;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getPhone() {
        return mPhone;
    }

}
