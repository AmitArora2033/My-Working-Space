package com.space.working.my.myworkingspace.module.home;

import androidx.lifecycle.MutableLiveData;
import com.space.working.my.base.BaseViewModel;
import com.space.working.my.myworkingspace.model.domain.Feed;
import com.space.working.my.myworkingspace.remote.Repository;
import java.util.List;
import javax.inject.Inject;

public class HomeViewModel extends BaseViewModel {

  private final Repository repository;
  MutableLiveData<List<Feed>> feedMutableLiveData = new MutableLiveData();

  @Inject public HomeViewModel(Repository repository) {
    this.repository = repository;
  }

  public MutableLiveData<List<Feed>> getFeedMutableLiveData() {
    return feedMutableLiveData;
  }

  public void getFeedsData() {
    addCompositeDisposable(
        repository.getData().compose(appSingleTransformer()).subscribe(feeds -> {
          feedMutableLiveData.setValue(feeds);
        }));
  }
}
