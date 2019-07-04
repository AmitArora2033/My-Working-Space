package com.space.working.my.myworkingspace.di;

import androidx.lifecycle.ViewModel;
import com.space.working.my.myworkingspace.di.anotation.ViewModelKey;
import com.space.working.my.myworkingspace.module.home.HomeViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module public abstract class ViewModelModule {

  @Binds @IntoMap @ViewModelKey(HomeViewModel.class)
  abstract ViewModel bindHomeViewModel(HomeViewModel homeViewModel);
}
