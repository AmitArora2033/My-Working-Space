package com.space.working.my.myworkingspace.model.domain;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class Feed implements Parcelable {

  public static Feed create(String creatorName, String creatorCompany, String creatorImagUrl,
      String content, String contentImage, String centerName,String centerCity, int noOfLikes) {
    return new AutoValue_Feed(creatorName, creatorCompany, creatorImagUrl, content, contentImage,
        centerName,centerCity ,false, noOfLikes);
  }

  public abstract String creatorName();

  public abstract String creatorCompany();

  @Nullable public abstract String creatorImagUrl();

  public abstract String content();

  @Nullable public abstract String contentImage();

  public abstract String centerName();

  public abstract String centerCity();

  public abstract boolean isLiked();

  public abstract int noOfLikes();

  public abstract Feed withNoOfLikes(int noOfLikes);

  public abstract Feed withIsLiked(boolean isLiked);
}
