package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.DanhMucAdapter;
import haui.lethanhha.com.mothercare.adapter.RecyclerViewOnClickListener;
import haui.lethanhha.com.mothercare.adapter.ShopAdapter;
import haui.lethanhha.com.mothercare.model.DanhMuc;
import haui.lethanhha.com.mothercare.model.Shop;

public class ShopActivity extends AppCompatActivity implements RecyclerViewOnClickListener {

    private RecyclerView recyclerShop;

    private List<Shop> shopList;

    private ShopAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        initData();
        initView();
        initEvents();
    }

    private void initEvents() {
        recyclerShop.setAdapter(shopAdapter);
        recyclerShop.setLayoutManager(new GridLayoutManager(ShopActivity.this, 3));
        recyclerShop.setHasFixedSize(true);
    }

    private void initView() {
        recyclerShop = findViewById(R.id.recyclerShop);
    }

    private void initData() {
        shopList = new ArrayList<>();
        shopList.add(new Shop(1, R.drawable.amnhacdefault, "https://asianparent-assets-vn.dexecure.net/wp-content/uploads/sites/2/2018/06/chuan-bi-do-so-sinh-day-du-tat-tan-tat-de-don-be-ra-doi-2.jpg", "Shop bán cua", "100.000 đ", "https://www.lazada.vn/products/hat-giong-cai-thia-cao-san-phunongseeds-i202653058-s252914371.html"));
        shopAdapter = new ShopAdapter(shopList, this, this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ShopActivity.this, MenuMainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.trans_right_in,
                R.anim.trans_right_out);
        finish();
    }

    @Override
    public void onClick(int position) {
        Shop shop = shopList.get(position);

        AlertDialog.Builder alert = new AlertDialog.Builder(ShopActivity.this);

        WebView wv = new WebView(getApplicationContext());
        wv.loadUrl(shop.getUrlWeb());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebChromeClient(new WebChromeClient());
        alert.setView(wv);
        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                dialog.cancel();
            }
        });
        alert.show();
    }
}
