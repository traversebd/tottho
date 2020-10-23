package com.teamtraverse.tottho.models.post;

public class PostDetails {
    private int PostId;
    private int NumberOfLikes;
    private int NumberOfShares;

    public int getPostId() {
        return PostId;
    }

    public void setPostId(int postId) {
        PostId = postId;
    }

    public int getNumberOfLikes() {
        return NumberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        NumberOfLikes = numberOfLikes;
    }

    public int getNumberOfShares() {
        return NumberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        NumberOfShares = numberOfShares;
    }
}
