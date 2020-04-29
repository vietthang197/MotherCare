package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.fragment.DatTenFragment;

public class DatTenActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_ten);

        viewPager = (ViewPager) findViewById(R.id.viewPagerDatTen);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutDatTen);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new DatTenFragment(),"Tổng quan");
        adapter.addFragment(new DatTenFragment(),"Bé trai");
        adapter.addFragment(new DatTenFragment(),"Bé gái");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
