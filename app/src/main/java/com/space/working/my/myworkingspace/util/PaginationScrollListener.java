package com.space.working.my.myworkingspace.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
  private final LinearLayoutManager layoutManager;

  public PaginationScrollListener(LinearLayoutManager layoutManager) {
    this.layoutManager = layoutManager;
  }

  @Override public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
    int visibleItemCount = layoutManager.getChildCount();
    int totalItemCount = layoutManager.getItemCount();
    int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

    if (!isLastPage()) {

      if ((visibleItemCount + firstVisibleItemPosition >= totalItemCount)
          && firstVisibleItemPosition >= 0 )    {
          loadMorItems();
      }
    }

    super.onScrolled(recyclerView, dx, dy);
  }

  public abstract void loadMorItems();

  public abstract boolean isLastPage();

  public abstract int getTotalPageCount();
}

