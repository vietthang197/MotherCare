package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.fragment.ThucPhamFragment;

public class AnUongActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_uong);

        viewPager = (ViewPager) findViewById(R.id.viewPagerAnUong);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutAnUong);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new ThucPhamFragment(), "Thực phẩm");
        adapter.addFragment(new ThucPhamFragment(), "Món ăn");
        adapter.addFragment(new ThucPhamFragment(), "Nhóm chất");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
