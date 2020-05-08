package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.db.MotherCareDatabase;
import haui.lethanhha.com.mothercare.fragment.KhamThaiFragment;
import haui.lethanhha.com.mothercare.model.KhamThai;

public class KhamThaiActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView imgBgKhamThai;

    private MotherCareDatabase motherCareDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kham_thai);

        imgBgKhamThai = findViewById(R.id.imgBgKhamThai);
        Picasso.with(this).load(R.drawable.image_anuong).into(imgBgKhamThai); // chưa set lại ảnh bg

        viewPager = findViewById(R.id.viewPagerKhamThai);
        tabLayout =  findViewById(R.id.tabLayoutKhamThai);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        motherCareDatabase = new MotherCareDatabase(this);
        List<KhamThai> khamThaiList = motherCareDatabase.getListKhamThai();

        adapter.addFragment(new KhamThaiFragment(khamThaiList), "Lịch khám thai định kì", R.drawable.mushroom);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        highLightCurrentTab(0); // for initial selected tab view
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position); // for tab change
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(adapter.getTabView(i));
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(adapter.getSelectedTabView(position));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(KhamThaiActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }
}
