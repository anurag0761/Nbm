package com.app.nbm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.nbm.R;
import com.app.nbm.model.HomeInfo;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<HomeInfo> newsList;
    private Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNews;

        public MyViewHolder(View view) {
            super(view);
            tvNews = (TextView) view.findViewById(R.id.tv_news);

        }
    }


    public NewsAdapter(Context context, List<HomeInfo> images) {
        mContext = context;
        this.newsList = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeInfo newsData = newsList.get(position);
        holder.tvNews.setText(newsData.getName());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

}
