package com.akhil.cameraxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        // 다이얼로그의 배경을 투명으로 만든다.
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        Button yesButton = findViewById(R.id.btn1);
        Button noButton = findViewById(R.id.btn2);

        // 버튼 리스너 설정
        yesButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //예 버튼 클릭시
                //튜토리얼 액티비티로 이동
                String str1 = "튜토리얼로 이동";
                Toast.makeText(getApplicationContext(), str1 , Toast.LENGTH_SHORT).show();
                //튜토리얼로 이동
                Intent intent = new Intent(getApplicationContext(),TutorialActivity.class);
                startActivity(intent);
            }
        });
        noButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //아니오 버튼 클릭시
                //바로 시작
                String str2 = "바로 시작";
                Toast.makeText(getApplicationContext(), str2 , Toast.LENGTH_SHORT).show();
                //메인으로 이동
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}