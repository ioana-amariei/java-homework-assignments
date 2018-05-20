package com.example.ami.javalab12;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ami.persistence.AppDatabase;
import com.example.ami.persistence.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InputActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private EditText name;
    private EditText date;
    private EditText details;
    private AppDatabase database;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        this.linearLayout = findViewById(R.id.linearLayout);
        this.name = findViewById(R.id.name);
        this.date = findViewById(R.id.date);
        this.details = findViewById(R.id.details);

        this.database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "java-lab12").allowMainThreadQueries().build();
    }

    public void saveInput(View view) {
        Event event = getEvent();
        database.eventDao().insertAll(event);
        scheduleEvent(event);
        Toast.makeText(linearLayout.getContext(), "The event was saved", Toast.LENGTH_SHORT).show();
    }

    private void scheduleEvent(Event event) {
        Intent intent = new Intent();
        intent.setAction("com.example.ami.POPUP_NOTIFICATION");
        intent.putExtra("name", event.getName());
        intent.putExtra("details", event.getDetails());

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long scheduledTime = getScheduledTime(event);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, random.nextInt(), intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, scheduledTime, pendingIntent);
    }

    private long getScheduledTime(Event event) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm ss");
        Date date = null;
        try {
            date = sdf.parse(event.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        return date.getTime();
    }

    public Event getEvent() {
        String name = this.name.getText().toString();
        String date = this.date.getText().toString();
        String details = this.details.getText().toString();

        return new Event(name, date, details);
    }

    public void launchEventsActivity(View view) {
        Intent intent = new Intent(this, EventsActivity.class);
        startActivity(intent);
    }

}
