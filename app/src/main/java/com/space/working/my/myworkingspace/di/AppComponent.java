package com.space.working.my.myworkingspace.di;

import android.app.Application;
import com.space.working.my.myworkingspace.App;
import com.space.working.my.myworkingspace.module.home.HomeActivity;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { AppModule.class }) public interface AppComponent {

  void inject(App app);

  void inject(HomeActivity mainActivity);


  @Component.Builder interface Builder {

    @BindsInstance Builder application(App application);

    AppComponent build();
  }
}
