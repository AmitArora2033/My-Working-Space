package com.space.working.my.myworkingspace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Article {

  @SerializedName("likes")
  @Expose
  private List<Like> likes = null;
  @SerializedName("comments")
  @Expose
  private List<Comment> comments = null;
  @SerializedName("image_loc")
  @Expose
  private String imageLoc;
  @SerializedName("city_name")
  @Expose
  private String cityName;
  @SerializedName("akey")
  @Expose
  private long akey;
  @SerializedName("center_name")
  @Expose
  private String centerName;
  @SerializedName("center_id")
  @Expose
  private int centerId;
  @SerializedName("timelog")
  @Expose
  private long timelog;
  @SerializedName("content")
  @Expose
  private String content;

  public List<Like> getLikes() {
    return likes;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public String getImageLoc() {
    return imageLoc;
  }

  public String getCityName() {
    return cityName;
  }

  public long getAkey() {
    return akey;
  }

  public String getCenterName() {
    return centerName;
  }

  public int getCenterId() {
    return centerId;
  }

  public long getTimelog() {
    return timelog;
  }

  public String getContent() {
    return content;
  }
}
