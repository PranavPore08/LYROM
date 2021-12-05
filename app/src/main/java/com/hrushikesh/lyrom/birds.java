package com.hrushikesh.lyrom;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class birds extends AppCompatActivity {

    MediaPlayer crow,cuckoo,hen,insect,owl,parrot,peacock,duck,sparrow;
    ImageView cr,cu,he,in,ow,pa,pe,du,sp,pause;
    int p=1;
    ProgressBar progressBar,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6,progressBar7,progressBar8,progressBar9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);
        crow = MediaPlayer.create(this, R.raw.crow);
        cuckoo = MediaPlayer.create(this, R.raw.cuckoo);
        hen = MediaPlayer.create(this, R.raw.hen);
        insect = MediaPlayer.create(this, R.raw.insect);
        owl = MediaPlayer.create(this, R.raw.owl);
        parrot = MediaPlayer.create(this, R.raw.parrot);
        peacock = MediaPlayer.create(this, R.raw.peacock);
        duck = MediaPlayer.create(this, R.raw.duck);
        sparrow = MediaPlayer.create(this, R.raw.sparrow);


        cr = findViewById(R.id.img1);
        cu = findViewById(R.id.img4);
        he = findViewById(R.id.img5);
        in = findViewById(R.id.img2);
        ow = findViewById(R.id.img3);
        pa = findViewById(R.id.img8);
        pe = findViewById(R.id.img9);
        du = findViewById(R.id.img7);
        sp = findViewById(R.id.img6);
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
                    crow.start();
                    cuckoo.start();
                    hen.start();
                    insect.start();
                    owl.start();
                    parrot.start();
                    peacock.start();
                    duck.start();
                    sparrow.start();
                    pause.setImageResource(R.drawable.play);
                    crow.pause();
                    cuckoo.pause();
                    hen.pause();
                    insect.pause();
                    owl.pause();
                    parrot.pause();
                    peacock.pause();
                    duck.pause();
                    sparrow.pause();
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


    public void Crow(View view) {
        if (crow.isPlaying()) {
            progressBar.setVisibility(View.INVISIBLE);
            crow.pause();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            crow.start();
        }
    }

    public void Cuckoo(View view) {
        if (cuckoo.isPlaying()) {
             cuckoo.pause();
            progressBar4.setVisibility(View.INVISIBLE);
        } else {
            cuckoo.start();
            progressBar4.setVisibility(View.VISIBLE);
        }
    }

    public void Hen(View view) {
        if (hen.isPlaying()) {
            hen.pause();
            progressBar5.setVisibility(View.INVISIBLE);
        } else {
            hen.start();
            progressBar5.setVisibility(View.VISIBLE);
        }
    }

    public void Insect(View view) {
        if (insect.isPlaying()) {
            insect.pause();
            progressBar2.setVisibility(View.INVISIBLE);
        } else {
            insect.start();
            progressBar2.setVisibility(View.VISIBLE);
        }

    }

    public void Owl(View view) {
        if (owl.isPlaying()) {
            progressBar3.setVisibility(View.INVISIBLE);
            owl.pause();

        } else {
            progressBar3.setVisibility(View.VISIBLE);
            owl.start();
        }
    }

    public void Parrot(View view) {
        if (parrot.isPlaying()) {
            progressBar8.setVisibility(View.INVISIBLE);
            parrot.pause();

        } else {
            progressBar8.setVisibility(View.VISIBLE);
            parrot.start();
        }
    }

    public void PEACOCK(View view) {
        if (peacock.isPlaying()) {
            progressBar9.setVisibility(View.INVISIBLE);
            peacock.pause();
        } else {
            progressBar9.setVisibility(View.VISIBLE);
            peacock.start();
        }
    }

    public void DUCK(View view) {
        if (duck.isPlaying()) {
            progressBar7.setVisibility(View.INVISIBLE);
            duck.pause();

        } else {
            progressBar7.setVisibility(View.VISIBLE);
            duck.start();
        }
    }

    public void Sparrow(View view) {
        if (sparrow.isPlaying()) {
            progressBar6.setVisibility(View.INVISIBLE);
            sparrow.pause();

        } else {
            progressBar6.setVisibility(View.VISIBLE);
            sparrow.start();
        }
    }
}