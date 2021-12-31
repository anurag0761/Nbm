package com.app.nbm.view.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.nbm.R;
import com.app.nbm.adapter.BhajanListAdapter;
import com.app.nbm.databinding.ActivityBhajanLayoutBinding;
import com.app.nbm.model.HomeInfo;

import java.util.ArrayList;
import java.util.List;


public class BhajanListActivity extends AppCompatActivity {

    private String TAG = BhajanListActivity.class.getSimpleName();
    private List<HomeInfo> albumList;
    private BhajanListAdapter mAdapter;
    private RecyclerView recyclerView;
    private Context mContext;
    private ActivityBhajanLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bhajan_layout);
        mContext = BhajanListActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getString(R.string.bhajan));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        albumList = new ArrayList<>();

       fetchImages();




    }

    private void fetchImages() {

        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        HomeInfo a = new HomeInfo("True Xscpae", 13, covers[0]);
        albumList.add(a);

        a = new HomeInfo("Xscpae", 8, covers[1]);
        albumList.add(a);

        a = new HomeInfo("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new HomeInfo("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new HomeInfo("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new HomeInfo("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new HomeInfo("Loud", 11, covers[6]);
        albumList.add(a);

        a = new HomeInfo("Legend", 14, covers[7]);
        albumList.add(a);

        a = new HomeInfo("Hello", 11, covers[8]);
        albumList.add(a);

        a = new HomeInfo("Greatest Hits", 17, covers[9]);
        albumList.add(a);


        mAdapter = new BhajanListAdapter(mContext, albumList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}