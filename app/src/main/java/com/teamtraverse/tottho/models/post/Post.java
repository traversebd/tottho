package com.teamtraverse.tottho.models.post;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    private int PostId;
    private String Name;
    private String Email;
    private String MobileNumber;
    private String WebUrl;
    private String Address;
    private int UserId;
    private String PostDate;

    public Post() {
    }

    public Post(int postId, String name, String email, String mobileNumber, String webUrl, String address, int userId, String postDate) {
        PostId = postId;
        Name = name;
        Email = email;
        MobileNumber = mobileNumber;
        WebUrl = webUrl;
        Address = address;
        UserId = userId;
        PostDate = postDate;
    }

    protected Post(Parcel in) {
        PostId = in.readInt();
        Name = in.readString();
        Email = in.readString();
        MobileNumber = in.readString();
        WebUrl = in.readString();
        Address = in.readString();
        UserId = in.readInt();
        PostDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(PostId);
        dest.writeString(Name);
        dest.writeString(Email);
        dest.writeString(MobileNumber);
        dest.writeString(WebUrl);
        dest.writeString(Address);
        dest.writeInt(UserId);
        dest.writeString(PostDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

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
        return PostId;
    }

    public void setId(int id) {
        PostId = id;
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
