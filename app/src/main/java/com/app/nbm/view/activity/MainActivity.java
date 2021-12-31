package com.app.nbm.view.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.app.nbm.R;
import com.app.nbm.adapter.MainAdapter;
import com.app.nbm.databinding.ActivityMainBinding;
import com.app.nbm.model.HomeInfo;
import com.app.nbm.utills.GridSpacingItemDecoration;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<HomeInfo> homeList;
    private HomeBannerPager homeBannerPager;
    ActivityMainBinding binding;
    int images[] = {R.drawable.banner1, R.drawable.banner2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        homeList = new ArrayList<>();
        adapter = new MainAdapter(this, homeList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        homeBannerPager = new HomeBannerPager(images);
        binding.viewPager.setAdapter(homeBannerPager);
        binding.dotsIndicator.setViewPager(binding.viewPager);
        //   binding.viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        prepareHomeData();

        try {
            Glide.with(this).load(R.drawable.place_holder).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareHomeData() {
        int[] covers = new int[]{
                R.mipmap.group_icon,
                R.mipmap.gallery_icon,
                R.mipmap.music_icon,
                R.mipmap.news_icon,
                R.mipmap.booking_icon,
                R.mipmap.program_icon};

        HomeInfo a = new HomeInfo(getString(R.string.group_volunteers), 13, covers[0]);
        homeList.add(a);

        a = new HomeInfo(getString(R.string.gallery), 8, covers[1]);
        homeList.add(a);

        a = new HomeInfo(getString(R.string.bhajan), 11, covers[2]);
        homeList.add(a);

        a = new HomeInfo(getString(R.string.news), 12, covers[3]);
        homeList.add(a);

        a = new HomeInfo(getString(R.string.booking_detail), 14, covers[4]);
        homeList.add(a);

        a = new HomeInfo(getString(R.string.program_detail), 1, covers[5]);
        homeList.add(a);


        adapter.notifyDataSetChanged();
    }


    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

  /*  //	page change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            //displayMetaInfo(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };*/

    public class HomeBannerPager extends PagerAdapter {

        private LayoutInflater layoutInflater;
        int images[];

        public HomeBannerPager(int[] images) {
            this.images = images;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.image_banner_preview, container, false);

            ImageView imageBanner = (ImageView) view.findViewById(R.id.image_banner);

            //HomeInfo image = images[position];

            Glide.with(MainActivity.this).load(images[position])
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageBanner);

            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}