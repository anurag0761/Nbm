package com.app.nbm.view.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.nbm.R;
import com.app.nbm.adapter.BookingAdapter;
import com.app.nbm.adapter.MainAdapter;
import com.app.nbm.databinding.ActivityBookingDetailBinding;
import com.app.nbm.model.HomeInfo;
import com.app.nbm.utills.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class BookingDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String TAG = BookingDetailActivity.class.getSimpleName();
    private Context mContext;
    ActivityBookingDetailBinding binding;
    String[] country = {"Please select your trip month", "January", "February", "March", "April", "May"};
    private BookingAdapter adapter;
    private List<HomeInfo> homeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_booking_detail);

        mContext = BookingDetailActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        binding.spinnerSelectTrip.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerSelectTrip.setAdapter(aa);

        homeList = new ArrayList<>();
        adapter = new BookingAdapter(this, homeList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(adapter);

        prepareHomeData();


    }

    private void prepareHomeData() {

        for (int i = 1; i < 16; i++) {
            HomeInfo a = new HomeInfo(getString(R.string.bus_no) + " " + i, R.drawable.buss);
            homeList.add(a);
        }

        adapter.notifyDataSetChanged();


    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}