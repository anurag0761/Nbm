package com.app.nbm.adapter;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.nbm.R;
import com.app.nbm.model.HomeInfo;
import com.app.nbm.view.activity.CurlActivity;

import java.util.List;


public class BhajanListAdapter extends RecyclerView.Adapter<BhajanListAdapter.MyViewHolder> {

    private List<HomeInfo> images;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvChapterName;
        private CardView tvCardLayout;

        public MyViewHolder(View view) {
            super(view);
            tvChapterName = (TextView) view.findViewById(R.id.tv_chapter_name);
            tvCardLayout = (CardView) view.findViewById(R.id.tv_card_layout);
        }
    }


    public BhajanListAdapter(Context context, List<HomeInfo> images) {
        mContext = context;
        this.images = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bhajan_list_item, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeInfo image = images.get(position);
        holder.tvChapterName.setText(image.getName());

        holder.tvCardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(mContext, CurlActivity.class);
                    mContext.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

}