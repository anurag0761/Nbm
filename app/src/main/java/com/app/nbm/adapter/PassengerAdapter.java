package com.app.nbm.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.app.nbm.R;
import com.app.nbm.model.HomeInfo;
import com.app.nbm.view.activity.UserListActivity;

import java.util.List;


public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.MyViewHolder> {

    private List<HomeInfo> images;
    private Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgUser;
        private TextView tvCall;

        public MyViewHolder(View view) {
            super(view);
            imgUser = (ImageView) view.findViewById(R.id.img_user);
            tvCall = (TextView) view.findViewById(R.id.tv_call);

        }
    }


    public PassengerAdapter(Context context, List<HomeInfo> images) {
        mContext = context;
        this.images = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.passenger_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeInfo image = images.get(position);

//        Glide.with(mContext).load(R.drawable.myphoto)
//                .thumbnail(0.5f)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.imgUser);

        holder.tvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ((UserListActivity) mContext).getCallPermission();

                } else {
                    String number = "7568547177";
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + number));
                    mContext.startActivity(callIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

}