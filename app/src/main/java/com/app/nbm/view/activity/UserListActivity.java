package com.app.nbm.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.nbm.R;
import com.app.nbm.adapter.UserAdapter;
import com.app.nbm.model.HomeInfo;

import java.util.ArrayList;
import java.util.List;


public class UserListActivity extends AppCompatActivity {

    private String TAG = UserListActivity.class.getSimpleName();
    private List<HomeInfo> albumList;
    private UserAdapter mAdapter;
    private RecyclerView recyclerView;
    private Context mContext;
    private static final int REQUEST = 112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        mContext = UserListActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();


        getCallPermission();

        fetchImages();

        mAdapter = new UserAdapter(mContext, albumList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    public void getCallPermission() {

        if (Build.VERSION.SDK_INT >= 23) {
            String[] PERMISSIONS = {android.Manifest.permission.CALL_PHONE};
            if (!hasPermissions(mContext, PERMISSIONS)) {
                ActivityCompat.requestPermissions((Activity) mContext, PERMISSIONS, REQUEST );
            } else {
                // makeCall();
            }
        } else {
            //makeCall();
        }
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

        HomeInfo a = new HomeInfo("True Romance", 13, covers[0]);
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

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //  makeCall();
                } else {
                    Toast.makeText(mContext, "The app was not allowed to call.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}