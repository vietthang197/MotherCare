package thangducanh.tagroup.com.mothercare.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import thangducanh.tagroup.com.mothercare.R;

public class WelcomeActivity extends AppCompatActivity {

    private EditText edtKySinhCuoi;

    private TextView tvNgayDuSinh, tvTuanTuoi;

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
    }

    private void initView() {
        edtKySinhCuoi = findViewById(R.id.edtKySinhCuoi);
        tvNgayDuSinh = findViewById(R.id.tvNgayDuSinh);
        tvTuanTuoi = findViewById(R.id.tvTuanTuoi);
    }

}
