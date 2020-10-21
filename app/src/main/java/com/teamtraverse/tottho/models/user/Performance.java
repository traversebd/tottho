package com.teamtraverse.tottho.models.user;

public class Performance {
    private int id;
    private int totalPostView;
    private int totalPostSaved;
    private int pointOfReward;
    private int totalPost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPostView() {
        return totalPostView;
    }

    public void setTotalPostView(int totalPostView) {
        this.totalPostView = totalPostView;
    }

    public int getTotalPostSaved() {
        return totalPostSaved;
    }

    public void setTotalPostSaved(int totalPostSaved) {
        this.totalPostSaved = totalPostSaved;
    }

    public int getPointOfReward() {
        return pointOfReward;
    }

    public void setPointOfReward(int pointOfReward) {
        this.pointOfReward = pointOfReward;
    }

    public int getTotalPost() {
        return totalPost;
    }

    public void setTotalPost(int totalPost) {
        this.totalPost = totalPost;
    }
}
