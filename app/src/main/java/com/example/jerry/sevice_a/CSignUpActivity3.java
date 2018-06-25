package com.example.jerry.sevice_a;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CSignUpActivity3 extends AppCompatActivity {

    //가맹등록 사업자 등록 페이지

    Toolbar myToolbar;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_signup3);

        //툴바
        myToolbar = (Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);
        //framelayout의 text 없애기
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //actionbar 선언//actionbar 자리에 toolbar를 놓을 것
        ActionBar actionBar = getSupportActionBar();
        //툴바의 홈버튼의 이미지를 변경(기본 이미지는 뒤로가기 화살표임)
        //툴바의 왼쪽에 메뉴 아이콘 넣기
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        //툴바에 홈버튼(메뉴 버튼)을 활성화
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //툴바의 text뷰 이름 바꾸기
        TextView tv = (TextView)findViewById(R.id.toolbartextView);
        tv.setText("회원가입");

        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);

        //이전 버튼
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSignUpActivity3.this,CSignUpActivity2.class);
                startActivity(intent);
                finish();
            }
        });
        //다음 버튼
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSignUpActivity3.this,MainActivity.class);
                startActivity(intent);
            }
        });


        //사업자 등록증, + 아이콘 이미지 투명도 조절
        Drawable ceoLicense = ((ImageView)findViewById(R.id.imageView1)).getDrawable();
        ceoLicense.setAlpha(80);
        Drawable plus = ((ImageView)findViewById(R.id.imageView5)).getDrawable();
        plus.setAlpha(90);



    }
    //  뒤로가기버튼
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 뒤로가기키 눌렀을 때 동작
                //뒤로가기 메소드
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
