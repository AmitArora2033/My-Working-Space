package com.space.working.my.myworkingspace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

  @SerializedName("article")
  @Expose
  private Article article;
  @SerializedName("creator")
  @Expose
  private Creator creator;

  public Article getArticle() {
    return article;
  }

  public Creator getCreator() {
    return creator;
  }
}
