package com.space.working.my.myworkingspace.remote;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.space.working.my.myworkingspace.model.Datum;
import com.space.working.my.myworkingspace.model.FeedsReader;
import com.space.working.my.myworkingspace.model.domain.Feed;
import io.reactivex.Single;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Repository {

  private static final String TAG = Repository.class.getSimpleName();
  private final Context context;

  public Repository(Context context) {
    this.context = context;
  }

  private String getAssetsFromFile() {
    String json;

    try {
      InputStream is = context.getAssets().open("data.json");
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();

      json = new String(buffer, "UTF-8");
    } catch (Exception e) {
      Log.e(TAG, e.toString());
      return null;
    }

    return json;
  }

  private Single<FeedsReader> getParsedJson() {
    try {
      FeedsReader feeds = new Gson().fromJson(getAssetsFromFile(), FeedsReader.class);
      return Single.just(feeds);
    } catch (Exception e) {
      Log.e(TAG, e.toString());
      return Single.just(new FeedsReader(e.toString(), null, false));
    }
  }

  public Single<List<Feed>> getData() {
    return getParsedJson().map(feedsReader -> {
      List<Feed> feeds = new ArrayList<>();
      if (feedsReader.isSuccess()) {

        List<Datum> datumList =
            feedsReader.getData();
        for (Datum datum : datumList) {

          feeds.add(Feed.create(datum.getCreator().getName(), datum.getCreator().getCompany(),
              datum.getCreator().getImageLoc(), datum.getArticle().getContent(),
              datum.getArticle().getImageLoc(), datum.getCreator().getCenterName(),
              datum.getCreator().getCity(),
              datum.getArticle().getLikes() != null ? datum.getArticle().getLikes().size() : 0));
        }
      }
      return feeds;
    });
  }
}
