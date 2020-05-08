package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.util.Calendar;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.fragment.LapLichFragment;

public class LapLichActivity extends AppCompatActivity {

    private EditText edtNhapNgay, edtNhapGio, edtNoiDung;

    private Button btnLuu;

    private RecyclerView rcLapLich;

    private DatePickerDialog.OnDateSetListener date;

    private Calendar myCalendar = Calendar.getInstance();

    private String myFormat = "dd/MM/yyyy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_lich);

        initData();
        initView();
        initEvents();
    }

    private void initData() {

    }

    private void initEvents() {

    }

    private void initView() {
        edtNhapGio = findViewById(R.id.edtChonGio);
        edtNhapNgay = findViewById(R.id.edtChonNgay);
        edtNoiDung = findViewById(R.id.edtNoiDung);
        btnLuu = findViewById(R.id.btnLuu);
        rcLapLich = findViewById(R.id.recyclerLapLich);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LapLichActivity.this, MenuMainActivity.class);
        startActivity(intent);
        finish();
    }
}
