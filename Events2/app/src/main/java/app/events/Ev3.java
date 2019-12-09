package app.events;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Ev3 extends AppCompatActivity {
    DatabaseHelper myDB;
    Button btn3;
    EditText Ev_Na1;
    EditText Ev_Lo1;
    EditText Ev_De1;
    EditText editTime1;
    EditText editDate1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ev3);
        myDB = new DatabaseHelper(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                Ev_Na1=(EditText)findViewById(R.id.Ev_Na);
                Ev_Lo1=(EditText)findViewById(R.id.Ev_Lo);
                Ev_De1=(EditText)findViewById(R.id.Ev_De);
                editTime1=(EditText)findViewById(R.id.editTime);
                editDate1=(EditText)findViewById(R.id.editDate);


                final Calendar c = Calendar.getInstance();
                final int year = c.get(Calendar.YEAR);
                final int month = c.get(Calendar.MONTH);
                final int day = c.get(Calendar.DAY_OF_MONTH);
                final int hour = c.get(Calendar.HOUR_OF_DAY);
                final int minute = c.get(Calendar.MINUTE);

                final EditText TxtTime = (EditText) findViewById(R.id.editTime);
                final EditText TxtDate = (EditText) findViewById(R.id.editDate);


                TxtTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog time_P = new TimePickerDialog(Ev3.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute1) {

                                TxtTime.setText(hour + ":" + minute);
                            }
                        }, hour, minute, true);
                        time_P.setTitle("Select Time");
                        time_P.show();

                    }
                });
                TxtDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog date_p = new DatePickerDialog(Ev3.this, new DatePickerDialog.OnDateSetListener()
                        {
                            @Override
                            public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth)
                            {
                                TxtDate.setText(year + "-" + month + "-" + day );
                            }
                        }, year, month, day);
                        date_p.setTitle("Select Date");
                        date_p.show();

                    }
                });


                btn3 = (Button) findViewById(R.id.add2);
                AddData();





            }

        });
    }
    public void AddData ()
    {
        btn3.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted = myDB.insertData(Ev_Na1.getText().toString(),
                       Ev_Lo1.getText().toString(),
                       editDate1.getText().toString(),
                       editTime1.getText().toString(),Ev_De1.getText().toString());
                if(isInserted == true)
                    Toast.makeText(Ev3.this, "Added", Toast.LENGTH_LONG).show();

                else
                    Toast.makeText(Ev3.this, "Try again", Toast.LENGTH_LONG).show();
            }
        }
);
    }
}

