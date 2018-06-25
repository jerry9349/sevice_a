package com.example.jerry.sevice_a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class CSignUpActivity1 extends AppCompatActivity{
    //가맹등록 정보입력 페이지

    Toolbar myToolbar;
    TextView tv2,tv3,tv4;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_signup1);

        //툴바 선언
        myToolbar = (Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);
        //framelayout의 text를 false로 선언해서 없애기
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //actionbar 선언//actionbar 자리에 toolbar를 놓을 것
        ActionBar actionBar = getSupportActionBar();
        //툴바의 홈버튼의 이미지를 변경(기본 이미지는 뒤로가기 화살표임)
        //툴바의 왼쪽에 기본 회색 화살표대신 내 아이콘 넣기
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        //툴바에 홈버튼(메뉴 버튼)을 활성화
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //툴바의 text뷰 이름 바꾸기
        TextView tv = (TextView)findViewById(R.id.toolbartextView);
        tv.setText("회원가입");

        tv2 = (TextView)findViewById(R.id.textView1);
        tv3 = (TextView)findViewById(R.id.textView2);
        tv4 = (TextView)findViewById(R.id.textView3);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);



        //다음 버튼 페이지 이동
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSignUpActivity1.this,CSignUpActivity2.class);
                startActivity(intent);
                finish();
            }
        });


    }
    //  뒤로가기버튼 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 뒤로가기키 눌렀을 때 동작
                //액티비티 종료//바꿔야함
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}