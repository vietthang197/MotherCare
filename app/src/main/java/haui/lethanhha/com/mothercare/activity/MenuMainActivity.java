package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.DanhMucAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.model.DanhMuc;

public class MenuMainActivity extends AppCompatActivity  implements RecyclerViewOnClickListener {

    private RecyclerView recyclerDanhMuc;

    private List<DanhMuc> danhMucList;

    private DanhMucAdapter danhMucAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        initData();
        initView();
        initEvents();
    }

    private void initData() {
        danhMucList = new ArrayList<>();
        danhMucList.add(new DanhMuc(1, R.drawable.shopnormal, "Shop"));
        danhMucList.add(new DanhMuc(2, R.drawable.anuongdefault, "Ăn uống"));
        danhMucList.add(new DanhMuc(3, R.drawable.tiemphongdefault, "Tiêm phòng"));
        danhMucList.add(new DanhMuc(4, R.drawable.lichkhamthaidefault, "Lịch khám thai"));
        danhMucList.add(new DanhMuc(5, R.drawable.canmuacanlamdefault, "Cần mua & cần làm"));
        danhMucList.add(new DanhMuc(6, R.drawable.dattenchobedefault, "Đặt tên cho bé"));
        danhMucList.add(new DanhMuc(7, R.drawable.doctruyendefault, "Đọc truyện"));
        danhMucList.add(new DanhMuc(8, R.drawable.amnhacdefault, "Âm nhạc"));
        danhMucList.add(new DanhMuc(9, R.drawable.laplichdefault, "Lập lịch"));
        danhMucList.add(new DanhMuc(10, R.drawable.hoidapdefault, "Hỏi đáp"));
        danhMucList.add(new DanhMuc(11, R.drawable.thaikydefault, "Thai kỳ"));
        danhMucAdapter = new DanhMucAdapter(MenuMainActivity.this, danhMucList, this);

    }

    private void initEvents() {
        recyclerDanhMuc.setAdapter(danhMucAdapter);
        recyclerDanhMuc.setLayoutManager(new GridLayoutManager(MenuMainActivity.this, 3));
        recyclerDanhMuc.setHasFixedSize(true);
    }

    private void initView() {
        recyclerDanhMuc = findViewById(R.id.recyclerDanhMuc);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MenuMainActivity.this, WelcomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }

    @Override
    public void onClick(int position) {
        switch (position) {
            case 0:
                doGoShopActivity();
                break;
        }
    }

    private void doGoShopActivity() {
        Intent intent = new Intent(MenuMainActivity.this, ShopActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }
}
