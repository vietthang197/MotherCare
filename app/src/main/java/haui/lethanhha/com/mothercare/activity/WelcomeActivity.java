package haui.lethanhha.com.mothercare.activity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import haui.lethanhha.com.mothercare.R;
import haui.lethanhha.com.mothercare.service.AlarmNotify;

public class WelcomeActivity extends AppCompatActivity {

    private EditText edtKyKinhCuoi;

    private TextView tvNgayDuSinh, tvTuanTuoi;

    private Button btnNext;

    private DatePickerDialog.OnDateSetListener date;

    private String myFormat = "dd/MM/yyyy";

    private SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

    public static final String CACHE_NGAY_MANG_THAI = "CACHE_NGAY_MANG_THAI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initView();
        checkData();
        initEvents();
    }

    private void checkData() {
        SharedPreferences sharedPreferences = getSharedPreferences(CACHE_NGAY_MANG_THAI, MODE_PRIVATE);
        String cacheNgayMangThai = sharedPreferences.getString("NGAY_MANG_THAI", null);
        if (cacheNgayMangThai != null) {
            try {
                Date ngayMangThai = sdf.parse(cacheNgayMangThai);
                Calendar calendarNgayMangThai = Calendar.getInstance();
                calendarNgayMangThai.setTime(ngayMangThai);
                Calendar calendarNgayDuSinh = Calendar.getInstance();
                String cacheNgayDuSinh = sharedPreferences.getString("NGAY_DU_SINH", null);
                Date ngayDuSinh = sdf.parse(cacheNgayDuSinh);
                int week = Weeks.weeksBetween(new DateTime(calendarNgayMangThai.getTime()), new DateTime(Calendar.getInstance())).getWeeks();
                edtKyKinhCuoi.setText(sdf.format(calendarNgayMangThai.getTime()));
                tvTuanTuoi.setText("Thai nhi được " + week + " tuần tuổi");
                tvNgayDuSinh.setText(cacheNgayDuSinh);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void initEvents() {
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                Calendar myCalendar = Calendar.getInstance();
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String ngayMangThai = sdf.format(myCalendar.getTime());
                SharedPreferences sharedPreferences = getSharedPreferences(CACHE_NGAY_MANG_THAI, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NGAY_MANG_THAI", ngayMangThai);
                editor.commit();
                edtKyKinhCuoi.setText(ngayMangThai);
                try {
                    datLichThongBao(ngayMangThai);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                int week = Weeks.weeksBetween(new DateTime(myCalendar.getTime()), new DateTime(Calendar.getInstance())).getWeeks();

                myCalendar.add(Calendar.MONTH, 9);
                myCalendar.add(Calendar.DATE, 10);

                String ngayDuSinh = sdf.format(myCalendar.getTime());
                editor.putString("NGAY_DU_SINH", ngayDuSinh);
                editor.commit();
                tvNgayDuSinh.setText(ngayDuSinh);
                tvTuanTuoi.setText("Thai nhi được " + week + " tuần tuổi");
            }

        };

        edtKyKinhCuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                new DatePickerDialog(WelcomeActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MenuMainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in,
                        R.anim.trans_left_out);
                finish();
            }
        });
    }

    private void initView() {
        edtKyKinhCuoi = findViewById(R.id.edtKyKinhCuoi);
        tvNgayDuSinh = findViewById(R.id.tvNgayDuSinh);
        tvTuanTuoi = findViewById(R.id.tvTuanTuoi);
        btnNext = findViewById(R.id.btnNext);
    }

    private void datLichThongBao(String ngayMangThai) throws ParseException {
        //Calendar calendar = Calendar.getInstance();
        //Date date = sdf.parse(ngayMangThai);
       // calendar.setTime(date);

        Intent _myIntent = new Intent(getBaseContext(), AlarmNotify.class);
        Calendar myAlarmDate = Calendar.getInstance();
        myAlarmDate.setTimeInMillis(System.currentTimeMillis());
        myAlarmDate.add(Calendar.MINUTE, 1);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        _myIntent.setAction("THONGBAO");
        _myIntent.putExtra("NOIDUNG","Đến lịch khám thai");
        PendingIntent _myPendingIntent = PendingIntent.getBroadcast(getBaseContext(), 1, _myIntent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, myAlarmDate.getTimeInMillis(),_myPendingIntent);
    }
}
