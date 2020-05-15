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
import haui.lethanhha.com.mothercare.db.MotherCareDatabase;
import haui.lethanhha.com.mothercare.model.DanhMuc;

public class MenuMainActivity extends AppCompatActivity  implements RecyclerViewOnClickListener {

    private RecyclerView recyclerDanhMuc;

    private List<DanhMuc> danhMucList;

    private DanhMucAdapter danhMucAdapter;

    private MotherCareDatabase motherCareDatabase;

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
        motherCareDatabase = new MotherCareDatabase(this);
        danhMucList = motherCareDatabase.getListDanhMuc();
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
            case 1:
                doGoAnUongActivity();
                break;
            case 2:
                doGoTiemPhongActivity();
                break;
            case 3:
                doGoKhamThaiActivity();
                break;
            case 4:
                doGoMuaLamActivity();
                break;
            case 5:
                doGoDatTenActivity();
                break;
            case 6:
                dogoDocTruyenActivity();
                break;
            case 8:
                doGoLapLichActivity();
                break;
            case 9:
                doGoThongTinActivity();
                break;
            case 10:
                doGoThaiKyActivity();
                break;
        }
    }

    private void doGoThongTinActivity() {
        Intent intent = new Intent(MenuMainActivity.this, ThongTinActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void dogoDocTruyenActivity() {
        Intent intent = new Intent(MenuMainActivity.this, DocTruyenActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoThaiKyActivity() {
        Intent intent = new Intent(MenuMainActivity.this, ThaiKyActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoLapLichActivity() {
        Intent intent = new Intent(MenuMainActivity.this, LapLichActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoDatTenActivity() {
        Intent intent = new Intent(MenuMainActivity.this, DatTenActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoMuaLamActivity() {
        Intent intent = new Intent(MenuMainActivity.this, MuaLamActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoKhamThaiActivity() {
        Intent intent = new Intent(MenuMainActivity.this, KhamThaiActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoTiemPhongActivity() {
        Intent intent = new Intent(MenuMainActivity.this, TiemPhongActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoAnUongActivity() {
        Intent intent = new Intent(MenuMainActivity.this, AnUongActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }

    private void doGoShopActivity() {
        Intent intent = new Intent(MenuMainActivity.this, ShopActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_left_in,
                R.anim.trans_left_out);
        finish();
    }
}
