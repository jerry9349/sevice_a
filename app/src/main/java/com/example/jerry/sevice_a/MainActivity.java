package com.example.jerry.sevice_a;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imgbtn1,imgbtn2,imgbtn3,imgbtn4;
    ImageView imgview6,imgview7,imgview8;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 해야 할것
        * 1. 주문 대기, 주문 승인, 총 주문건수 버튼을 눌렀을 시 탭 메뉴가 각 해당 페이지로 가도록 포커스 설정 할 것
        * 2. 각 메뉴 버튼 이벤트 처리하여 페이지 이동(intent) 시키기
        * 3. 옆 drawer view의 레이아웃을 수정하려면 res-layout - drawer_header.xml 로 가서 수정할 것
        * 4. 옆 drawer view의 메뉴를 수정하려면 res- value - string.xml에서 목록 수정후 res - menu- drawer.xml에서 순서 조절
        * 5. drawer view의 메뉴를 클릭할 시 클릭한 버튼만 색깔이 바뀌도록 수정할 것 res- menu - drawer.xml에서 수정
        * */


        //툴바
        TextView tv = (TextView)findViewById(R.id.toolbartextView);
        //아래줄에 DB의 데이터를 받아와서 툴바 textview에 세탁소 이름 넣어야함
        tv.setText("야인세탁소");

        Toolbar toolbar = (Toolbar)findViewById(R.id.myToolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        //framelayout의 text 없애기
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        //툴바의 홈버튼의 이미지를 변경(기본 이미지는 뒤로가기 화살표임)
        //툴바의 왼쪽에 메뉴 아이콘 넣기
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        //툴바에 홈버튼(메뉴 버튼)을 활성화
        actionBar.setDisplayHomeAsUpEnabled(true);

        //네이게이션 뷰
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        //네이게이션 뷰 아이템 클릭시 이뤄지는 이벤트
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id = item.getItemId();
                //각 메뉴 클릭시 이뤄지는 이벤트
                switch (id){
                    //내 정보 수정
                    case R.id.nav_my_information:
                        Toast.makeText(MainActivity.this, "안뇽", Toast.LENGTH_SHORT).show();
                        break;
                    //설정
                    //푸시알림 설정
                    case R.id.nav_setting_menu1:
                        Toast.makeText(MainActivity.this, "안뇽1", Toast.LENGTH_SHORT).show();
                        break;
                        //소리 설정
                    case R.id.nav_setting_menu2:
                        Toast.makeText(MainActivity.this, "안뇽1", Toast.LENGTH_SHORT).show();
                        break;
                        //도움말
                    //자주 묻는 질문
                    case R.id.nav_frequently_asked_questions:
                        Toast.makeText(MainActivity.this, "안뇽2", Toast.LENGTH_SHORT).show();
                        break;
                        //1:1 상담하기
                    case R.id.nav_one_to_one_consulting:
                        Toast.makeText(MainActivity.this, "안뇽1", Toast.LENGTH_SHORT).show();
                        break;
                        //개인정보 약관
                    case R.id.nav_privacy_terms:
                        Toast.makeText(MainActivity.this, "안뇽1", Toast.LENGTH_SHORT).show();
                        break;
                        //로그아웃
                    case R.id.nav_logout:
                        Toast.makeText(MainActivity.this, "안뇽3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



        imgview6 = (ImageView)findViewById(R.id.imageView6);
        imgview7 = (ImageView)findViewById(R.id.imageView7);
        imgview8 = (ImageView)findViewById(R.id.imageView8);
        //주문 대기를 눌렀을때 탭 메뉴로 이동
        imgview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        //주문 승인을 눌렀을때 탭 메뉴로 이동
        imgview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        //총 주문 건수를 눌렀을때 탭 메뉴로 이동
        imgview8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });


    }

    //툴바의 메뉴 버튼눌렀을때 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:{ //toolbar의 메뉴버튼 눌렀을 때 drawerLayout이 나타나도록 처리
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
            case R.id.newPost:{
                Toast.makeText(this, "메뉴 눌렀당", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
