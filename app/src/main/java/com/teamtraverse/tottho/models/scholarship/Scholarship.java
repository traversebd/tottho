package com.teamtraverse.tottho.models.scholarship;

import android.os.Parcel;
import android.os.Parcelable;

public class Scholarship implements Parcelable {
    private int Id;
    private String Title;
    private String ScholarshipType;
    private String ScholarshipDescription;
    private String Eligibility;
    private String Deadline;
    private String ApplyProcedure;
    private String OfficialContactAddress;
    private String OfficialContactEmail;
    private String OfficialContactWebsite;
    private String PostDate;
    private int TimeToRead;

    public Scholarship() {
    }

    public Scholarship(int id, String title, String scholarshipType, String scholarshipDescription, String eligibility, String deadline, String applyProcedure,
                       String officialContactAddress, String officialContactEmail, String officialContactWebsite, String postDate, int timeToRead) {
        Id = id;
        Title = title;
        ScholarshipType = scholarshipType;
        ScholarshipDescription = scholarshipDescription;
        Eligibility = eligibility;
        Deadline = deadline;
        ApplyProcedure = applyProcedure;
        OfficialContactAddress = officialContactAddress;
        OfficialContactEmail = officialContactEmail;
        OfficialContactWebsite = officialContactWebsite;
        PostDate = postDate;
        TimeToRead = timeToRead;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getScholarshipType() {
        return ScholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        ScholarshipType = scholarshipType;
    }

    public String getScholarshipDescription() {
        return ScholarshipDescription;
    }

    public void setScholarshipDescription(String scholarshipDescription) {
        ScholarshipDescription = scholarshipDescription;
    }

    public String getEligibility() {
        return Eligibility;
    }

    public void setEligibility(String eligibility) {
        Eligibility = eligibility;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getApplyProcedure() {
        return ApplyProcedure;
    }

    public void setApplyProcedure(String applyProcedure) {
        ApplyProcedure = applyProcedure;
    }

    public String getOfficialContactAddress() {
        return OfficialContactAddress;
    }

    public void setOfficialContactAddress(String officialContactAddress) {
        OfficialContactAddress = officialContactAddress;
    }

    public String getOfficialContactEmail() {
        return OfficialContactEmail;
    }

    public void setOfficialContactEmail(String officialContactEmail) {
        OfficialContactEmail = officialContactEmail;
    }

    public String getOfficialContactWebsite() {
        return OfficialContactWebsite;
    }

    public void setOfficialContactWebsite(String officialContactWebsite) {
        OfficialContactWebsite = officialContactWebsite;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public int getTimeToRead() {
        return TimeToRead;
    }

    public void setTimeToRead(int timeToRead) {
        TimeToRead = timeToRead;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", ScholarshipType='" + ScholarshipType + '\'' +
                ", ScholarshipDescription='" + ScholarshipDescription + '\'' +
                ", Eligibility='" + Eligibility + '\'' +
                ", Deadline='" + Deadline + '\'' +
                ", ApplyProcedure='" + ApplyProcedure + '\'' +
                ", OfficialContactAddress='" + OfficialContactAddress + '\'' +
                ", OfficialContactEmail='" + OfficialContactEmail + '\'' +
                ", OfficialContactWebsite='" + OfficialContactWebsite + '\'' +
                ", PostDate='" + PostDate + '\'' +
                ", TimeToRead=" + TimeToRead +
                '}';
    }

    //region parcelable
    protected Scholarship(Parcel in) {
        Id = in.readInt();
        Title = in.readString();
        ScholarshipType = in.readString();
        ScholarshipDescription = in.readString();
        Eligibility = in.readString();
        Deadline = in.readString();
        ApplyProcedure = in.readString();
        OfficialContactAddress = in.readString();
        OfficialContactEmail = in.readString();
        OfficialContactWebsite = in.readString();
        PostDate = in.readString();
        TimeToRead = in.readInt();
    }

    public static final Creator<Scholarship> CREATOR = new Creator<Scholarship>() {
        @Override
        public Scholarship createFromParcel(Parcel in) {
            return new Scholarship(in);
        }

        @Override
        public Scholarship[] newArray(int size) {
            return new Scholarship[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Id);
        parcel.writeString(this.Title);
        parcel.writeString(this.ScholarshipType);
        parcel.writeString(this.ScholarshipDescription);
        parcel.writeString(this.Eligibility);
        parcel.writeString(this.Deadline);
        parcel.writeString(this.ApplyProcedure);
        parcel.writeString(this.OfficialContactAddress);
        parcel.writeString(this.OfficialContactEmail);
        parcel.writeString(this.OfficialContactWebsite);
        parcel.writeString(this.PostDate);
        parcel.writeInt(this.TimeToRead);
    }
    //endregion
}
