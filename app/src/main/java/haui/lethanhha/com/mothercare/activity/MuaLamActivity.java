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
import haui.lethanhha.com.mothercare.fragment.MuaLamFragment;
import haui.lethanhha.com.mothercare.model.CanMuaCanLam;


public class MuaLamActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView imgBgMuaLam;

    private MotherCareDatabase motherCareDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua_lam);

        imgBgMuaLam = findViewById(R.id.imgBgMuaLam);
        Picasso.with(this).load(R.drawable.image_anuong).into(imgBgMuaLam); // chưa set lại ảnh bg

        viewPager = findViewById(R.id.viewPagerMuaLam);
        tabLayout =  findViewById(R.id.tabLayoutMuaLam);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        motherCareDatabase = new MotherCareDatabase(this);
        List<CanMuaCanLam> canMuaCanLamList = motherCareDatabase.getListCanMuaCanLam();

        List<CanMuaCanLam> canMuaCanLamList2 = new ArrayList<>();


        adapter.addFragment(new MuaLamFragment(canMuaCanLamList), "Cần mua & cần làm", R.drawable.mushroom);
        adapter.addFragment(new MuaLamFragment(canMuaCanLamList2), "Chuẩn bị sinh", R.drawable.muffin);

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
        Intent intent = new Intent(MuaLamActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }
}

