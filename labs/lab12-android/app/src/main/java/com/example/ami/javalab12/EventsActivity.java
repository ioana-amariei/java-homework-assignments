package com.example.ami.javalab12;

import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ami.persistence.AppDatabase;
import com.example.ami.persistence.Event;

import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        this.linearLayout = findViewById(R.id.eventsLinearLayout);
        this.database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "java-lab12").allowMainThreadQueries().build();

        displayEventNames();
    }

    private void displayEventNames() {
        linearLayout.removeAllViews();
        for(Event event : database.eventDao().getAll()){
            TextView textView = new TextView(linearLayout.getContext());
            textView.append(event.getName());
            textView.setGravity(Gravity.CENTER);
            linearLayout.addView(textView);
        }
    }

    public void launchInputActivity(View view) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    public void deleteEvents(View view) {
        for(Event event : database.eventDao().getAll()) {
            database.eventDao().delete(event);
        }
        displayEventNames();
    }
}
