package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import haui.lethanhha.com.mothercare.R;

public class ThongTinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ThongTinActivity.this, MenuMainActivity.class);
        startActivity(intent);
        finish();
    }
}
