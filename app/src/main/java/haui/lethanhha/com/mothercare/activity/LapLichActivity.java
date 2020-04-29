package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.fragment.LapLichFragment;

public class LapLichActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_lich);
        viewPager = (ViewPager) findViewById(R.id.viewPagerLapLich);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutLapLich);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new LapLichFragment(),"Tiêm chủng");
        adapter.addFragment(new LapLichFragment(),"Khám thai");
        adapter.addFragment(new LapLichFragment(),"Khác");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
