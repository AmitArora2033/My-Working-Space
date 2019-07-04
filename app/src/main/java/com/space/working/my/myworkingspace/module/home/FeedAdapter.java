package com.space.working.my.myworkingspace.module.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.space.working.my.myworkingspace.R;
import com.space.working.my.myworkingspace.model.domain.Feed;
import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

  private final OnItemClickListener listener;
  private List<Feed> feeds = new ArrayList<>();

  public FeedAdapter(OnItemClickListener listener) {
    this.listener = listener;
  }

  public void setFeedData(List<Feed> feeds) {
    this.feeds.clear();
    this.feeds = feeds;
    notifyDataSetChanged();
  }

  public void addFeedData(List<Feed> feeds) {
    this.feeds.addAll(feeds);
    notifyItemInserted(feeds.size() - 1);
  }


  public List<Feed> getFeedData(){
    return feeds;
  }


  @NonNull @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false),
        listener);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position,
      @NonNull List<Object> payloads) {

    if (!payloads.isEmpty() && payloads.get(0) instanceof Integer) {
      holder.imgHeart.setImageResource(feeds.get(position).isLiked() ? R.drawable.ic_heart_red
          : R.drawable.ic_heart_outline_grey);
      holder.tvNoOfLikes.setText(holder.tvNoOfLikes.getContext()
          .getString(R.string.no_of_like, feeds.get(position).noOfLikes()));
      return;
    }
    super.onBindViewHolder(holder, position, payloads);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    Glide.with(holder.imgCreator.getContext())
        .load(feeds.get(position).creatorImagUrl())
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .apply(RequestOptions.circleCropTransform())
        .error(R.drawable.drawable_error)
        .into(holder.imgCreator);

    holder.tvCreatorName.setText(feeds.get(position).creatorName());
    holder.tvCreatorCompany.setText(feeds.get(position).creatorCompany());
    holder.tvContent.setText(feeds.get(position).content());

    if (feeds.get(position).contentImage() == null
        || feeds.get(position).contentImage().length() == 0) {
      holder.imgContentImage.setVisibility(View.GONE);
    } else {
      holder.imgContentImage.setVisibility(View.VISIBLE);

      Glide.with(holder.imgContentImage)
          .load(feeds.get(position).contentImage())
          .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
          .fitCenter()
          .into(holder.imgContentImage);
    }
    holder.imgHeart.setImageResource(feeds.get(position).isLiked() ? R.drawable.ic_heart_red
        : R.drawable.ic_heart_outline_grey);
    holder.tvNoOfLikes.setText(holder.tvNoOfLikes.getContext()
        .getString(R.string.no_of_like, feeds.get(position).noOfLikes()));

    holder.tvCenterName.setText(holder.tvCenterName.getContext()
        .getString(R.string.center_name_loc, feeds.get(position).centerName(),
            feeds.get(position).centerCity()));
  }

  @Override public int getItemCount() {
    return feeds.size();
  }

  public interface OnItemClickListener {
    void onLikeClicked(int position);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_creator) ImageView imgCreator;
    @BindView(R.id.tv_creator_name) TextView tvCreatorName;
    @BindView(R.id.tv_creator_company) TextView tvCreatorCompany;
    @BindView(R.id.tv_content) TextView tvContent;
    @BindView(R.id.img_content_image) ImageView imgContentImage;
    @BindView(R.id.img_heart) ImageView imgHeart;
    @BindView(R.id.img_comment) ImageView imgCommet;
    @BindView(R.id.tv_center_name) TextView tvCenterName;
    @BindView(R.id.tv_no_of_likes) TextView tvNoOfLikes;

    public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      imgHeart.setOnClickListener(v -> listener.onLikeClicked(getAdapterPosition()));
    }
  }
}
