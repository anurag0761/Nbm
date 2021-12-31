package com.app.nbm.view.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.app.nbm.R;
import com.app.nbm.adapter.GalleryAdapter;
import com.app.nbm.model.HomeInfo;
import com.app.nbm.view.fragment.SlideshowDialogFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GalleryActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
   private List<HomeInfo> albumList;
    private GalleryAdapter mAdapter;
    private RecyclerView recyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        mContext = GalleryActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getString(R.string.gallery));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();

        fetchImages();

        mAdapter = new GalleryAdapter(mContext, albumList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

         recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", (Serializable) albumList);
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


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
}