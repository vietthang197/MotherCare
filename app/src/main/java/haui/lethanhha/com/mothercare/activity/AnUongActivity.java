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
        adapter.addFragment(new ThucPhamFragment(), "Tab 1");
        adapter.addFragment(new ThucPhamFragment(), "Tab 2");
        adapter.addFragment(new ThucPhamFragment(), "Tab 3");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
