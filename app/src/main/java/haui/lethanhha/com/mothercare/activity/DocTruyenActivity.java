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
import haui.lethanhha.com.mothercare.fragment.DocTruyenFragment;
import haui.lethanhha.com.mothercare.model.DocTruyen;

public class DocTruyenActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView imgBgDocTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);

        imgBgDocTruyen = findViewById(R.id.imgBgDocTruyen);
        Picasso.with(this).load(R.drawable.image_anuong).into(imgBgDocTruyen); /// chưa xet lai anh

        viewPager = findViewById(R.id.viewPagerDocTruyen);
        tabLayout =  findViewById(R.id.tabLayoutDocTruyen);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        List<DocTruyen> docTruyenList = new ArrayList<>();
        docTruyenList.add(new DocTruyen(R.drawable.atiso, R.drawable.nen, "Truyện 1", "Truyen co tich"));
        docTruyenList.add(new DocTruyen(R.drawable.atiso, R.drawable.nen, "Truyện 2", "Truyen co tich"));
        docTruyenList.add(new DocTruyen(R.drawable.atiso, R.drawable.nen, "Truyện 3", "Truyen co tich"));
        docTruyenList.add(new DocTruyen(R.drawable.atiso, R.drawable.nen, "Truyện 4", "Truyen co tich"));

        adapter.addFragment(new DocTruyenFragment(docTruyenList), "", R.drawable.mushroom);

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
        Intent intent = new Intent(DocTruyenActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }
}
