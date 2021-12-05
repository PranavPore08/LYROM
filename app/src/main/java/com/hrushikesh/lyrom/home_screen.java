package com.hrushikesh.lyrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }


    public void home_screen_next(View view) {
        Intent k = new Intent(this, home_screen_next.class);
        startActivity(k);
    }

    public void cust_song(View view) {
        Intent i = new Intent(this, Custom_Songs.class);
        startActivity(i);
    }


    public void aboutus(View view) {
        Intent z = new Intent(this, About_us.class);
        startActivity(z);
    }

    public void Credits(View view) {
        Intent l= new Intent(this,credits.class);
        startActivity(l);
    }
}