package com.space.working.my.myworkingspace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FeedsReader {

  @SerializedName("message")
  @Expose
  private String message;
  @SerializedName("data")
  @Expose
  private List<Datum> data = null;
  @SerializedName("status")
  @Expose
  private boolean status;

  public FeedsReader(String message,
      List<Datum> data, boolean status) {
    this.message = message;
    this.data = data;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public List<Datum> getData() {
    return data;
  }

  public boolean isSuccess() {
    return status;
  }
}


