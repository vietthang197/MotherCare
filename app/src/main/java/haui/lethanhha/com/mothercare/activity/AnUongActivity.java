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
import haui.lethanhha.com.mothercare.fragment.ThucPhamFragment;
import haui.lethanhha.com.mothercare.model.AnUong;

public class AnUongActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView imgBgAnUong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_uong);

        imgBgAnUong = findViewById(R.id.ingBgAnUong);
        Picasso.with(this).load(R.drawable.image_anuong).into(imgBgAnUong);

        viewPager = findViewById(R.id.viewPagerAnUong);
        tabLayout =  findViewById(R.id.tabLayoutAnUong);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        List<AnUong> anUongList = new ArrayList<>();
        anUongList.add(new AnUong(R.drawable.atiso, R.drawable.nen, "ss", "sss"));
        anUongList.add(new AnUong(R.drawable.atiso, R.drawable.nen, "ss", "ssfs"));
        anUongList.add(new AnUong(R.drawable.atiso, R.drawable.nen, "sds", "sdss"));
        anUongList.add(new AnUong(R.drawable.atiso, R.drawable.nen, "sds", "sssss"));

        adapter.addFragment(new ThucPhamFragment(anUongList), "Thực phẩm", R.drawable.mushroom);
        adapter.addFragment(new ThucPhamFragment(anUongList), "Món ăn", R.drawable.muffin);
        adapter.addFragment(new ThucPhamFragment(anUongList), "Nhóm chất", R.drawable.chart);
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
        Intent intent = new Intent(AnUongActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }
}
