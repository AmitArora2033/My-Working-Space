package com.space.working.my.myworkingspace.di;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.space.working.my.base.ViewModelFactory;
import com.space.working.my.myworkingspace.App;
import com.space.working.my.myworkingspace.remote.Repository;
import dagger.Module;
import dagger.Provides;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Singleton;

@Module(includes = { ViewModelModule.class }) public class AppModule {

  @Provides Context provideContext(App app) {
    return app.getApplicationContext();
  }

  @Provides @Singleton ViewModelFactory provideViewModelFactory(
      Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
    return new ViewModelFactory(creators);
  }

  @Provides @Singleton Repository provideRepository(Context context) {
    return new Repository(context);
  }
}
