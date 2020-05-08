package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import haui.lethanhha.com.mothercare.R;

public class AnUongDetailActivity extends AppCompatActivity {

    private ScrollView sc;

    private TextView tvNoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_uong_detail);

        sc = findViewById(R.id.sc_anuong_detail);
        tvNoiDung = findViewById(R.id.tv_an_uong_detail);
        sc.smoothScrollTo(0, tvNoiDung.getBottom());
        Bundle bundle = getIntent().getExtras();
        String noidung = bundle.getString("data");
        tvNoiDung.setText(noidung);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AnUongDetailActivity.this, AnUongActivity.class);
        startActivity(intent);
        finish();
    }
}
