package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.fragment.KhamThaiFragment;

public class KhamThaiActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kham_thai);

        viewPager = (ViewPager) findViewById(R.id.viewPagerKhamThai);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutKhamThai);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new KhamThaiFragment(),"Lịch khám thai định kì");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
