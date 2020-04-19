package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.fragment.ThucPhamFragment;
import haui.lethanhha.com.mothercare.fragment.TiemPhongFragment;

public class TiemPhongActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiem_phong);

        viewPager = (ViewPager) findViewById(R.id.viewPagerTiemPhong);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutTiemPhong);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new TiemPhongFragment(), "Cho mẹ");
        adapter.addFragment(new TiemPhongFragment(), "Cho bé");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
