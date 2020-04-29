package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;

import haui.lethanhha.com.mothercare.fragment.MuaLamFragment;

public class MuaLamActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua_lam);

        viewPager = (ViewPager) findViewById(R.id.viewPagerMuaLam);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutMuaLam);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new MuaLamFragment(),"Cần mua & Cần làm");
        adapter.addFragment(new MuaLamFragment(),"Chuẩn bị sinh");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
