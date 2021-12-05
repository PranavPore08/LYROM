package com.hrushikesh.lyrom;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Nature_sounds extends AppCompatActivity {
    int p=1;
    MediaPlayer rain,thunder,flames,storm,wind,waves,rocks,leaves,rooftop_rain;
    ImageView ra,th,fl,st,wi,wa,ro,le,roof,pause;
    ProgressBar progressBar,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6,progressBar7,progressBar8,progressBar9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_sounds);
        rain = MediaPlayer.create(this, R.raw.rain);
        thunder = MediaPlayer.create(this, R.raw.thunder);
        flames = MediaPlayer.create(this, R.raw.flames);
        storm = MediaPlayer.create(this, R.raw.storm);
        wind = MediaPlayer.create(this, R.raw.wind);
        waves = MediaPlayer.create(this, R.raw.waves);
        rocks = MediaPlayer.create(this, R.raw.rocks);
        leaves = MediaPlayer.create(this, R.raw.leaves);
        rooftop_rain = MediaPlayer.create(this, R.raw.thunder);


        ra = findViewById(R.id.img2);
        th = findViewById(R.id.img7);
        fl = findViewById(R.id.img1);
        st = findViewById(R.id.img5);
        wi = findViewById(R.id.img8);
        wa = findViewById(R.id.img9);
        ro = findViewById(R.id.img6);
        le = findViewById(R.id.img3);
        roof = findViewById(R.id.img4);
        pause = findViewById(R.id.imageView8);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);
        progressBar6 = (ProgressBar) findViewById(R.id.progressBar6);
        progressBar7 = (ProgressBar) findViewById(R.id.progressBar7);
        progressBar8 = (ProgressBar) findViewById(R.id.progressBar8);
        progressBar9 = (ProgressBar) findViewById(R.id.progressBar9);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(p==1) {
                    rain.start();
                    thunder.start();
                    flames.start();
                    storm.start();
                    wind.start();
                    waves.start();
                    rooftop_rain.start();
                    leaves.start();
                    rocks.start();
                    pause.setImageResource(R.drawable.play);
                    rain.pause();
                    thunder.pause();
                    flames.pause();
                    storm.pause();
                    wind.pause();
                    waves.pause();
                    rooftop_rain.pause();
                    leaves.pause();
                    rocks.pause();

                    final Handler handler=new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pause.setImageResource(R.drawable.pause);
                            progressBar.setVisibility(View.INVISIBLE);
                            progressBar2.setVisibility(View.INVISIBLE);
                            progressBar3.setVisibility(View.INVISIBLE);
                            progressBar4.setVisibility(View.INVISIBLE);
                            progressBar5.setVisibility(View.INVISIBLE);
                            progressBar6.setVisibility(View.INVISIBLE);
                            progressBar7.setVisibility(View.INVISIBLE);
                            progressBar8.setVisibility(View.INVISIBLE);
                            progressBar9.setVisibility(View.INVISIBLE);
                        }
                    },50);


                }
            }
        });
    }


    public void Rain(View view) {
        if (rain.isPlaying()) {
            progressBar2.setVisibility(View.INVISIBLE);
            rain.pause();

        } else {
            progressBar2.setVisibility(View.VISIBLE);
            rain.start();
        }
    }

    public void Thunder(View view) {
        if (thunder.isPlaying()) {
            thunder.pause();
            progressBar7.setVisibility(View.INVISIBLE);
        } else {
            thunder.start();
            progressBar7.setVisibility(View.VISIBLE);
        }
    }

    public void Rocks(View view) {
        if (rocks.isPlaying()) {
            rocks.pause();
            progressBar6.setVisibility(View.INVISIBLE);
        } else {
            rocks.start();
            progressBar6.setVisibility(View.VISIBLE);
        }
    }

    public void Leaves(View view) {
        if (leaves.isPlaying()) {
            leaves.pause();
            progressBar3.setVisibility(View.INVISIBLE);
        } else {
            leaves.start();
            progressBar3.setVisibility(View.VISIBLE);
        }

    }

    public void Storm(View view) {
        if (storm.isPlaying()) {
            progressBar5.setVisibility(View.INVISIBLE);
            storm.pause();

        } else {
            progressBar5.setVisibility(View.VISIBLE);
            storm.start();
        }
    }

    public void WIND(View view) {
        if (wind.isPlaying()) {
            progressBar8.setVisibility(View.INVISIBLE);
            wind.pause();

        } else {
            progressBar8.setVisibility(View.VISIBLE);
            wind.start();
        }
    }

    public void FLAMES(View view) {
        if (flames.isPlaying()) {
            progressBar.setVisibility(View.INVISIBLE);
            flames.pause();

        } else {
            progressBar.setVisibility(View.VISIBLE);
            flames.start();
        }
    }

    public void Roof(View view) {
        if (rooftop_rain.isPlaying()) {
            progressBar4.setVisibility(View.INVISIBLE);
            rooftop_rain.pause();

        } else {
            progressBar4.setVisibility(View.VISIBLE);
            rooftop_rain.start();
        }
    }

    public void Waves(View view) {
        if (waves.isPlaying()) {
            progressBar9.setVisibility(View.INVISIBLE);
            waves.pause();

        } else {
            progressBar9.setVisibility(View.VISIBLE);
            waves.start();
        }
    }
}