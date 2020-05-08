package haui.lethanhha.com.mothercare.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import haui.lethanhha.com.mothercare.R;

public class WelcomeActivity extends AppCompatActivity {

    private EditText edtKySinhCuoi;

    private TextView tvNgayDuSinh, tvTuanTuoi;

    private Button btnNext;

    private DatePickerDialog.OnDateSetListener date;

    private Calendar myCalendar = Calendar.getInstance();

    private String myFormat = "dd/MM/yyyy";

    private SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initView();
        initEvents();
    }

    private void initEvents() {
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                edtKySinhCuoi.setText(sdf.format(myCalendar.getTime()));
                //Calendar.getInstance().getTime().

                int week = Weeks.weeksBetween(new DateTime(myCalendar.getTime()), new DateTime(Calendar.getInstance())).getWeeks();

                myCalendar.add(Calendar.MONTH, 9);
                myCalendar.add(Calendar.DATE, 10);

                tvNgayDuSinh.setText(sdf.format(myCalendar.getTime()));
                tvTuanTuoi.setText("Thai nhi được " + week + " tuần tuổi");
            }

        };

        edtKySinhCuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        edtKySinhCuoi = findViewById(R.id.edtKySinhCuoi);
        tvNgayDuSinh = findViewById(R.id.tvNgayDuSinh);
        tvTuanTuoi = findViewById(R.id.tvTuanTuoi);
        btnNext = findViewById(R.id.btnNext);
    }
}
