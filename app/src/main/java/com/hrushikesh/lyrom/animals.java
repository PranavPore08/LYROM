package com.hrushikesh.lyrom;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class animals extends AppCompatActivity {
    int p=1;
    MediaPlayer lion, tiger, deer, cat, cow, dog, elephant, horse, monkey;
    ImageView li, ti, de, ca, co, el, ho, mo, pause, dog_image;

    ProgressBar progressBar,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6,progressBar7,progressBar8,progressBar9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        lion = MediaPlayer.create(this, R.raw.lion);
        tiger = MediaPlayer.create(this, R.raw.tiger);
        deer = MediaPlayer.create(this, R.raw.deer);
        cat = MediaPlayer.create(this, R.raw.cat);
        cow = MediaPlayer.create(this, R.raw.cow);
        dog = MediaPlayer.create(this, R.raw.dog);
        elephant = MediaPlayer.create(this, R.raw.elephant);
        horse = MediaPlayer.create(this, R.raw.horse);
        monkey = MediaPlayer.create(this, R.raw.monkey);


        li = findViewById(R.id.img1);
        ti = findViewById(R.id.img2);
        de = findViewById(R.id.img4);
        ca = findViewById(R.id.img3);
        co = findViewById(R.id.img8);
        dog_image = findViewById(R.id.img5);
        el = findViewById(R.id.img9);
        ho = findViewById(R.id.img7);
        mo = findViewById(R.id.img6);
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
                    lion.start();
                    tiger.start();
                    deer.start();
                    cat.start();
                    cow.start();
                    dog.start();
                    elephant.start();
                    horse.start();
                    monkey.start();
                    pause.setImageResource(R.drawable.play);
                    lion.pause();
                    tiger.pause();
                    deer.pause();
                    cat.pause();
                    cow.pause();
                    dog.pause();
                    elephant.pause();
                    horse.pause();
                    monkey.pause();

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


    public void LION(View view) {
        if (lion.isPlaying()) {
            progressBar.setVisibility(View.INVISIBLE);
            lion.pause();

        } else {
            progressBar.setVisibility(View.VISIBLE);
            lion.start();
        }
    }

    public void Tiger(View view) {
        if (tiger.isPlaying()) {
            tiger.pause();
            progressBar2.setVisibility(View.INVISIBLE);
        } else {
            tiger.start();
            progressBar2.setVisibility(View.VISIBLE);
        }
    }

    public void Deer(View view) {
        if (deer.isPlaying()) {
            deer.pause();
            progressBar4.setVisibility(View.INVISIBLE);
        } else {
            deer.start();
            progressBar4.setVisibility(View.VISIBLE);
        }
    }

    public void Cat(View view) {
        if (cat.isPlaying()) {
            cat.pause();
            progressBar3.setVisibility(View.INVISIBLE);
        } else {
            cat.start();
            progressBar3.setVisibility(View.VISIBLE);
        }

    }

    public void Dog(View view) {
        if (dog.isPlaying()) {

            progressBar5.setVisibility(View.INVISIBLE);
            dog.pause();

        } else {
            progressBar5.setVisibility(View.VISIBLE);
            dog.start();
        }
    }

    public void Elephant(View view) {
        if (elephant.isPlaying()) {

            progressBar9.setVisibility(View.INVISIBLE);
            elephant.pause();
        } else {
            progressBar9.setVisibility(View.VISIBLE);
            elephant.start();
        }
    }

    public void Cow(View view) {
        if (cow.isPlaying()) {
            progressBar8.setVisibility(View.INVISIBLE);
            cow.pause();
        } else {
            progressBar8.setVisibility(View.VISIBLE);
            cow.start();
        }
    }

    public void Horse(View view) {
        if (horse.isPlaying()) {
            progressBar7.setVisibility(View.INVISIBLE);
            horse.pause();

        } else {
            progressBar7.setVisibility(View.VISIBLE);
            horse.start();
        }
    }

    public void Monkey(View view) {
        if (monkey.isPlaying()) {
            progressBar6.setVisibility(View.INVISIBLE);
            monkey.pause();

        } else {
            progressBar6.setVisibility(View.VISIBLE);
            monkey.start();
        }
    }
}
