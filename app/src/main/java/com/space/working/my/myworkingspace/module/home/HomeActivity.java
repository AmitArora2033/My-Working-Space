package com.space.working.my.myworkingspace.module.home;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.space.working.my.base.BaseActivity;
import com.space.working.my.base.ViewModelFactory;
import com.space.working.my.myworkingspace.App;
import com.space.working.my.myworkingspace.util.PaginationScrollListener;
import com.space.working.my.myworkingspace.R;
import com.space.working.my.myworkingspace.model.domain.Feed;
import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements FeedAdapter.OnItemClickListener {

  public static int CURRENT_PAGE = 1;
  public static int TOTAL_PAGES = 20;
  @BindView(R.id.rcv_list) RecyclerView recyclerView;
  @Inject ViewModelFactory viewModelFactory;
  private HomeViewModel viewModel;
  private FeedAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override public void initDependencies() {
    App.get(this).getComponent().inject(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);
  }

  @Override public void onReady() {
    viewModel.getFeedsData();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);
    adapter = new FeedAdapter(this);
    recyclerView.setAdapter(adapter);

    viewModel.getFeedMutableLiveData().observe(this, newFeeds -> {
      if (adapter.getFeedData() != null && adapter.getFeedData().size() == 0) {
        adapter.setFeedData(newFeeds);
      } else if (newFeeds != null && this.adapter.getFeedData().size() > 0) {
        adapter.getFeedData().addAll(newFeeds);
        adapter.notifyItemInserted(adapter.getFeedData().size() - 1);
      }
    });

    recyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
      @Override public void loadMorItems() {
        CURRENT_PAGE = CURRENT_PAGE + 1;
        viewModel.getFeedsData();
      }

      @Override public boolean isLastPage() {
        return CURRENT_PAGE >= TOTAL_PAGES;
      }

      @Override public int getTotalPageCount() {
        return TOTAL_PAGES;
      }
    });
  }

  @Override public void showError(String errorMessage) {

  }

  @Override public void showContent() {

  }

  @Override public void showProgress() {

  }

  @Override public void onLikeClicked(int position) {
    Feed feed = adapter.getFeedData().get(position);
    if (!feed.isLiked()) {
      feed = feed.withNoOfLikes(feed.noOfLikes() + 1).withIsLiked(true);
    } else {
      feed = feed.withNoOfLikes(feed.noOfLikes() - 1).withIsLiked(false);
    }
    adapter.getFeedData().set(position, feed);
    adapter.notifyItemChanged(position, new Integer[101]);
  }
}
