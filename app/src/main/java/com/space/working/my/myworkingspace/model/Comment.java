package com.space.working.my.myworkingspace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

  @SerializedName("image_loc")
  @Expose
  private String imageLoc;
  @SerializedName("ckey")
  @Expose
  private int ckey;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("center")
  @Expose
  private String center;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("timelog")
  @Expose
  private long timelog;
  @SerializedName("company")
  @Expose
  private String company;
  @SerializedName("pkey")
  @Expose
  private int pkey;
  @SerializedName("content")
  @Expose
  private String content;

  public String getImageLoc() {
    return imageLoc;
  }

  public int getCkey() {
    return ckey;
  }

  public String getCity() {
    return city;
  }

  public String getCenter() {
    return center;
  }

  public String getName() {
    return name;
  }

  public long getTimelog() {
    return timelog;
  }

  public String getCompany() {
    return company;
  }

  public int getPkey() {
    return pkey;
  }

  public String getContent() {
    return content;
  }
}
