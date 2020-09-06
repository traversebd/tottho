package com.teamtraverse.tottho.models.link;

public class Post {
    private int Id;
    private String Name;
    private String Email;
    private String MobileNumber;
    private String WebUrl;
    private String Address;
    private int UserId;
    private String PostDate;

    public Post() {
    }

    public Post(int id, String name, String email, String mobileNumber, String webUrl, String address, int userId, String postDate) {
        Id = id;
        Name = name;
        Email = email;
        MobileNumber = mobileNumber;
        WebUrl = webUrl;
        Address = address;
        UserId = userId;
        PostDate = postDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getWebUrl() {
        return WebUrl;
    }

    public void setWebUrl(String webUrl) {
        WebUrl = webUrl;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
