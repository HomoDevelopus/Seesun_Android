package com.akhil.cameraxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorialActivity extends AppCompatActivity {
    private Button playBtn;
    private Button endBtn;
    private MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        playBtn = findViewById(R.id.btn3);//다시듣기 버튼
        endBtn = findViewById(R.id.btn4);//시작하기 버튼

        //다시듣기버튼
        playBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m.isPlaying()){
                    m.stop();
                }
                play();
            }
        });
        //시작하기 버튼
        endBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.stop();
                //mainActivity로 이동
                Intent intent = new Intent(TutorialActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        play();
    }

    public void play(){
        m = MediaPlayer.create(TutorialActivity.this,R.raw.mix2);
//        m = MediaPlayer.create(TutorialActivity.this,R.raw.tutorial);
        m.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mp3자원 해제
        m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                mp.stop();
                mp.release();
            }
        });
    }
}