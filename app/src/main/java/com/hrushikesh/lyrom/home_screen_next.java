package com.hrushikesh.lyrom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home_screen_next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_next);
    }


    public void birds(View view) {
        Intent abc = new Intent(this, birds.class);
        startActivity(abc);
    }

    public void animals(View view) {
        Intent pqr = new Intent(this, animals.class);
        startActivity(pqr);
    }

    public void nature(View view) {
        Intent xyz = new Intent(this, Nature_sounds.class);
        startActivity(xyz);
    }
}