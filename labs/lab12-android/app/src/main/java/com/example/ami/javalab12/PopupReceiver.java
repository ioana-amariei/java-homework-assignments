package com.example.ami.javalab12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.support.design.widget.Snackbar.LENGTH_SHORT;

public class PopupReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        String details = intent.getStringExtra("details");
        String text = String.format("Name: %s\nDetails: %s", name, details);
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
