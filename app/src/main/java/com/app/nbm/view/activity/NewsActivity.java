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
import com.app.nbm.adapter.NewsAdapter;
import com.app.nbm.databinding.ActivityNewsLayoutBinding;
import com.app.nbm.model.HomeInfo;

import java.util.ArrayList;
import java.util.List;


public class NewsActivity extends AppCompatActivity {

    private String TAG = NewsActivity.class.getSimpleName();
    private Context mContext;
    private List<HomeInfo> newsList;
    ActivityNewsLayoutBinding binding;
    NewsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_layout);

        mContext = NewsActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getString(R.string.news));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        newsList = new ArrayList<>();

        fetchNewsData();

        mAdapter = new NewsAdapter(mContext, newsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(mAdapter);

    }

    private void fetchNewsData() {

        for (int i = 1; i < 11; i++) {
            HomeInfo homeInfo = new HomeInfo("Most newspapers are divided into sections. Typical sections include: national/international news; local news; sports; entertainment/amusements; classified advertisements; and neighborhood news.");
            newsList.add(homeInfo);
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}