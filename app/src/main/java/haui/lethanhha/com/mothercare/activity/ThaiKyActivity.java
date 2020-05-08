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
import haui.lethanhha.com.mothercare.fragment.ThaiKyFragment;
import haui.lethanhha.com.mothercare.model.ThaiKy;

public class ThaiKyActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_ky);


        viewPager = findViewById(R.id.viewPagerThaiKy);
        tabLayout =  findViewById(R.id.tabLayoutThaiKy);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        List<ThaiKy> thaiKyList = new ArrayList<>();
        thaiKyList.add(new ThaiKy(R.drawable.atiso, R.drawable.nen, "Tuần 1", "Thai Ky"));
        thaiKyList.add(new ThaiKy(R.drawable.atiso, R.drawable.nen, "Tuần 2", "Thai Ky"));
        thaiKyList.add(new ThaiKy(R.drawable.atiso, R.drawable.nen, "Tuần 3", "Thai Ky"));
        thaiKyList.add(new ThaiKy(R.drawable.atiso, R.drawable.nen, "Tuần 4", "Thai Ky"));
        thaiKyList.add(new ThaiKy(R.drawable.atiso, R.drawable.nen, "Tuần 5", "Thai Ky"));
        thaiKyList.add(new ThaiKy(R.drawable.atiso, R.drawable.nen, "Tuần 6", "Thai Ky"));


        adapter.addFragment(new ThaiKyFragment(thaiKyList), "", R.drawable.mushroom);

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
        Intent intent = new Intent(ThaiKyActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }
}
