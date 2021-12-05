package com.hrushikesh.lyrom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gauravk.audiovisualizer.visualizer.BarVisualizer;

import java.io.File;
import java.util.ArrayList;

public class Player_activity extends AppCompatActivity {
        Button btn_next, btn_previous, btn_pause,btn_fastf,btn_fastr;
        TextView songLabel,txtstart,txtstop;
        ImageView image;
        static MediaPlayer myMedia;
        int position;
        String s_name;
        ArrayList<File> mySongs;
        String endTime,currenttime;
        BarVisualizer visualizer;
        int counter=1;

        @Override
        protected void onDestroy() {
            if(visualizer!=null){
                visualizer.release();
            }
            super.onDestroy();
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home){
                onBackPressed();
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_player);
            image=findViewById(R.id.imagebackground);


            SharedPreferences pref=getSharedPreferences("CoinCounter",MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();

            btn_next = findViewById(R.id.next);
            btn_previous = findViewById(R.id.previous);
            btn_pause = findViewById(R.id.pause);
            btn_fastf = findViewById(R.id.forward);
            btn_fastr = findViewById(R.id.reverse);

            visualizer=findViewById(R.id.blast);
            txtstart=findViewById(R.id.txt_start);
            txtstop=findViewById(R.id.txt_stop);

            getSupportActionBar().setTitle("Now Playing");
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            songLabel = findViewById(R.id.song_label);
/*            song_seek = findViewById(R.id.se

            Thread updateSeekBar = new Thread() {
                @Override
                public void run() {
                    int totalDuration = myMedia.getDuration();
                    int currentPosition = 0;
                    while (currentPosition < totalDuration) {
                        try {
                            sleep(500);
                            currentPosition = myMedia.getCurrentPosition();
                            song_seek.setProgress(currentPosition);
                        } catch (InterruptedException | IllegalStateException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
*/
           /* if (myMedia != null) {
                myMedia.stop();
                myMedia.release();
            }*/

            Intent i = getIntent();
            Bundle bundle = i.getExtras();
            mySongs = (ArrayList) bundle.getParcelableArrayList("songs");
            s_name = mySongs.get(position).getName().toString();
            String songName = i.getStringExtra("songname");

            songLabel.setText(songName);
            songLabel.setSelected(true);
            position = bundle.getInt("pos", 0);
            Uri u = Uri.parse(mySongs.get(position).toString());

            myMedia=MediaPlayer.create(getBaseContext(),u);
            myMedia.start();

  /*          song_seek.setMax(myMedia.getDuration());

            updateSeekBar.start();

            song_seek.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
            song_seek.getThumb().setColorFilter(getResources().getColor(R.color.colorPrimary),PorterDuff.Mode.SRC_IN);

            song_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    myMedia.seekTo(seekBar.getProgress());
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    myMedia.seekTo(seekBar.getProgress());
                }
            });
*/
           // endTime=createTime(myMedia.getDuration());
            txtstop.setText(endTime);


            final Handler handler=new Handler();
            final int delay=1000;

            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    endTime=createTime(myMedia.getDuration());
                    txtstop.setText(endTime);
                    currenttime=createTime(myMedia.getCurrentPosition());
                    txtstart.setText(currenttime);
                    handler.postDelayed(this,delay);

                }
            },delay);


            int audiosessionid=myMedia.getAudioSessionId();
            if(audiosessionid!=-1){
                visualizer.setAudioSessionId(audiosessionid);
            }
        if(currenttime==endTime) {
            myMedia.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    btn_next.performClick();
                    counter += 1;
                    editor.putInt("coin", counter);
                    editor.apply();

                }
            });
        }
            btn_pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(myMedia.isPlaying()){
                        btn_pause.setBackgroundResource(R.drawable.icon_play);
                        myMedia.pause();
                    }
                    else{
                        btn_pause.setBackgroundResource((R.drawable.icon_pause));
                        myMedia.start();
                    }

                }

            });

            btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myMedia.stop();
                    myMedia.release();
                    position = ((position + 1) % mySongs.size());

                    Uri u = Uri.parse(mySongs.get(position).toString());
                    myMedia = MediaPlayer.create(getApplicationContext(), u);
                    s_name = mySongs.get(position).getName().toString();
                    songLabel.setText(s_name);
                    btn_pause.setBackgroundResource((R.drawable.icon_pause));
                    myMedia.start();
                    counter+=1;
                    editor.putInt("coin",counter);
                    editor.apply();

                    startAnimationright(image);
                    int audiosessionid=myMedia.getAudioSessionId();
                    if(audiosessionid!=+1){
                        visualizer.setAudioSessionId(audiosessionid);
                    }
                }
            });

            btn_previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myMedia.stop();
                    myMedia.release();
                    position=((position-1)<0)?(mySongs.size()-1):(position-1);

                    Uri u= Uri.parse(mySongs.get(position).toString());

                    myMedia=MediaPlayer.create(getApplicationContext(),u);
                    s_name=mySongs.get(position).getName().toString();
                    songLabel.setText(s_name);
                    myMedia.start();

                    counter+=1;
                    editor.putInt("coin",counter);
                    editor.apply();

                    btn_pause.setBackgroundResource((R.drawable.icon_pause));
                    startAnimationleft(image);
                    int audiosessionid=myMedia.getAudioSessionId();
                    if(audiosessionid!=-1){
                        visualizer.setAudioSessionId(audiosessionid);
                    }
                }
            });

            btn_fastf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(myMedia.isPlaying()){
                        myMedia.seekTo(myMedia.getCurrentPosition()+10000);
                    }
                }
            });

            btn_fastr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(myMedia.isPlaying()){
                        myMedia.seekTo(myMedia.getCurrentPosition()-10000);
                    }
                }
            });
        }



        public void startAnimationright(View view){
            ObjectAnimator animator=ObjectAnimator.ofFloat(image,"rotation",0f,360f);
            animator.setDuration(1000);
            AnimatorSet animatorSet=new AnimatorSet();
            animatorSet.playTogether(animator);
            animatorSet.start();
        }

        public void startAnimationleft(View view){
            ObjectAnimator animator=ObjectAnimator.ofFloat(image,"rotation",0f,-360f);
            animator.setDuration(1000);
            AnimatorSet animatorSet=new AnimatorSet();
            animatorSet.playTogether(animator);
            animatorSet.start();
        }



        public String createTime(int duration){
            String time="";
            int min=duration/1000/60;
            int sec=duration/1000%60;
            time+=min+":";

            if(sec<10)
            {
                time+="0";
            }
            time+=sec;
            return time;
        }

        @Override
        public void onBackPressed() {
            if(myMedia!=null){
                myMedia.release();
                myMedia=null;
            }
        }
}