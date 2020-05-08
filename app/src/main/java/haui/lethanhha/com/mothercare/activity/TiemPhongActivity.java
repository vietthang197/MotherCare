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
import haui.lethanhha.com.mothercare.fragment.ThucPhamFragment;
import haui.lethanhha.com.mothercare.fragment.TiemPhongFragment;
import haui.lethanhha.com.mothercare.model.TiemPhong;


public class TiemPhongActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView imgBgTiemPhong;

    private MotherCareDatabase motherCareDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiem_phong);

        motherCareDatabase = new MotherCareDatabase(this);
        List<TiemPhong> tiemPhongMe = motherCareDatabase.getListTiemPhong("Mẹ");
        List<TiemPhong> tiemPhongCon = motherCareDatabase.getListTiemPhong("Bé");

        imgBgTiemPhong = findViewById(R.id.imgBgTiemPhong);
        Picasso.with(this).load(R.drawable.image_anuong).into(imgBgTiemPhong); // chưa set lại ảnh bg

        viewPager = findViewById(R.id.viewPagerTiemPhong);
        tabLayout =  findViewById(R.id.tabLayoutTiemPhong);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        adapter.addFragment(new TiemPhongFragment(tiemPhongMe), "Cho mẹ", R.drawable.mushroom);
        adapter.addFragment(new TiemPhongFragment(tiemPhongCon), "Cho bé", R.drawable.muffin);

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
        Intent intent = new Intent(TiemPhongActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }
}

