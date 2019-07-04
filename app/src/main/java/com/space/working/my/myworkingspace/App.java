package com.space.working.my.myworkingspace;

import android.app.Application;
import android.content.Context;
import com.space.working.my.myworkingspace.di.AppComponent;
import com.space.working.my.myworkingspace.di.DaggerAppComponent;

public class App extends Application {

  public AppComponent appComponent;

  public static App get(Context context) {
    return (App) context.getApplicationContext();
  }

  public AppComponent getComponent() {
    return appComponent;
  }

  @Override public void onCreate() {
    super.onCreate();
    appComponent = DaggerAppComponent.builder().application(this).build();

    appComponent.inject(this);

  }
}
