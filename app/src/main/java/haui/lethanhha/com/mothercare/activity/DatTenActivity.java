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
import haui.lethanhha.com.mothercare.fragment.DatTenFragment;
import haui.lethanhha.com.mothercare.fragment.ThucPhamFragment;
import haui.lethanhha.com.mothercare.fragment.TiemPhongFragment;
import haui.lethanhha.com.mothercare.model.TenBe;
import haui.lethanhha.com.mothercare.model.TiemPhong;


public class DatTenActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView imgBgDatTen;

    private MotherCareDatabase motherCareDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_ten);

        imgBgDatTen = findViewById(R.id.imgBgDatTen);
        Picasso.with(this).load(R.drawable.image_anuong).into(imgBgDatTen); // chưa set lại ảnh bg

        viewPager = findViewById(R.id.viewPagerDatTen);
        tabLayout =  findViewById(R.id.tabLayoutDatTen);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        motherCareDatabase = new MotherCareDatabase(this);
        List<TenBe> tenNam = motherCareDatabase.getListTenbe("Nam");
        List<TenBe> tenNu = motherCareDatabase.getListTenbe("Nữ");

        adapter.addFragment(new DatTenFragment(tenNam), "Tên bé trai", R.drawable.mushroom);
        adapter.addFragment(new DatTenFragment(tenNu), "Tên bé gái", R.drawable.muffin);

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
        Intent intent = new Intent(DatTenActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }
}

