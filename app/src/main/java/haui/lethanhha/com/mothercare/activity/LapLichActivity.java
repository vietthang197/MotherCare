package haui.lethanhha.com.mothercare.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.adapter.LapLichAdapter;
import haui.lethanhha.com.mothercare.adapter.TabAdapter;
import haui.lethanhha.com.mothercare.db.MotherCareDatabase;
import haui.lethanhha.com.mothercare.fragment.LapLichFragment;
import haui.lethanhha.com.mothercare.model.LapLich;
import haui.lethanhha.com.mothercare.service.AlarmNotify;

public class LapLichActivity extends AppCompatActivity {

    private EditText edtNhapNgay, edtNhapGio, edtNoiDung;

    private Button btnLuu;

    private RecyclerView rcLapLich;

    private DatePickerDialog.OnDateSetListener dateSelect;

    private TimePickerDialog.OnTimeSetListener timeSelect;

    private Calendar myCalendar = Calendar.getInstance();

    private String myFormat = "dd/MM/yyyy";

    private SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

    private String ngayDuocChon;

    private String gioDuocChon;

    private MotherCareDatabase motherCareDatabase;

    private List<LapLich> lapLichList;

    private LapLichAdapter lapLichAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_lich);

        motherCareDatabase = new MotherCareDatabase(this);

        initData();
        initView();
        initEvents();

        lapLichAdapter = new LapLichAdapter(lapLichList, this);
        rcLapLich.setAdapter(lapLichAdapter);
        rcLapLich.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcLapLich.setHasFixedSize(true);
    }

    private void initData() {
        lapLichList = motherCareDatabase.getListLapLich();
    }

    private void initEvents() {

        dateSelect = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                ngayDuocChon = dayOfMonth + "/" + monthOfYear + "/" + year;
            }

        };

        timeSelect = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                gioDuocChon = hourOfDay + ":" + minute;
            }
        };

        edtNhapNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                new DatePickerDialog(LapLichActivity.this, dateSelect, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        edtNhapGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(LapLichActivity.this, timeSelect, 0, 0, true).show();
            }
        });

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ngayDuocChon == null || gioDuocChon == null) {
                    Toast.makeText(getApplicationContext(), "Phải nhập đủ ngày giờ", Toast.LENGTH_SHORT).show();
                } else if (edtNoiDung.getText().toString() == null) {
                    Toast.makeText(getApplicationContext(), "Phải nhập nội dung", Toast.LENGTH_SHORT).show();
                } else {
                    LapLich lapLich = new LapLich();
                    lapLich.setGhiChu(edtNoiDung.getText().toString());
                    lapLich.setGioNhacNho(gioDuocChon);
                    lapLich.setNgayNhacNho(ngayDuocChon);
                    lapLich.setTrangThai(1);
                    int idInserted = motherCareDatabase.themLapLich(lapLich);

                    if (idInserted < 0) {
                        Toast.makeText(getApplicationContext(), "Thêm lập lịch không thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Calendar calendar = Calendar.getInstance();
                        try {
                            Date date = sdf.parse(ngayDuocChon);
                            calendar.setTime(date);
                            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(gioDuocChon.split(":")[0]));
                            calendar.set(Calendar.MINUTE, Integer.parseInt(gioDuocChon.split(":")[1]));
                            Intent _myIntent = new Intent(getBaseContext(), AlarmNotify.class);
                            AlarmManager alarmManager = (AlarmManager) LapLichActivity.this.getSystemService(Context.ALARM_SERVICE);
                            _myIntent.setAction("THONGBAO");
                            _myIntent.putExtra("NOIDUNG", lapLich.getGhiChu());
                            PendingIntent _myPendingIntent = PendingIntent.getBroadcast(getBaseContext(), idInserted, _myIntent, 0);
                            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),_myPendingIntent);
                            lapLichList.add(lapLich);
                            lapLichAdapter.notifyDataSetChanged();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
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
