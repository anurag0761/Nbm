package com.app.nbm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.nbm.R;
import com.app.nbm.model.HomeInfo;
import com.app.nbm.view.activity.PassengerListActivity;
import com.app.nbm.view.activity.UserListActivity;
import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {

    private Context mContext;
    private List<HomeInfo> homeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public CardView cardView;
        public LinearLayout mLinearLayout;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            cardView = (CardView) view.findViewById(R.id.card_view);
            mLinearLayout = (LinearLayout) view.findViewById(R.id.ll_view);

        }
    }


    public BookingAdapter(Context mContext, List<HomeInfo> homeList) {
        this.mContext = mContext;
        this.homeList = homeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        HomeInfo album = homeList.get(position);
        holder.title.setText(album.getName());
        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);


        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, PassengerListActivity.class);
                i.putExtra("title",mContext.getString(R.string.passenger_details));
                mContext.startActivity(i);

            }
        });

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, PassengerListActivity.class);
                i.putExtra("title", mContext.getString(R.string.passenger_details));
                mContext.startActivity(i);

            }
        });
    }


    @Override
    public int getItemCount() {
        return homeList.size();
    }
}
