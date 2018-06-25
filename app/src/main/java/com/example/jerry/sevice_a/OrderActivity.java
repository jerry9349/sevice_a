package com.example.jerry.sevice_a;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    //주문 현황 탭을 구성하기위해 탭을 받아오는 공간
    /* 해야 할것
     * 1. 주문 대기, 주문 승인, 총 주문건수 버튼을 눌렀을 시 탭 메뉴가 각 해당 페이지로 가도록 포커스 설정 할 것
     * 2. 각 분류별로 DB에서 목록을 받아오게끔 ListView를 만들것
     * */

    Toolbar myToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        //툴바
        myToolbar = (Toolbar)findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);
        //framelayout의 text 없애기
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        //툴바의 홈버튼의 이미지를 변경(기본 이미지는 뒤로가기 화살표임)
        //툴바의 왼쪽에 메뉴 아이콘 넣기
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        //툴바에 홈버튼(메뉴 버튼)을 활성화
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView tv = (TextView)findViewById(R.id.toolbartextView);
        tv.setText("주문 관리");



        //TabLayout 초기화
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        //페이지 목록 등록
        tabLayout.addTab(tabLayout.newTab().setText("주문 대기"));
        tabLayout.addTab(tabLayout.newTab().setText("주문 승인"));
        tabLayout.addTab(tabLayout.newTab().setText("총 주문 건수"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //viewPager 초기화
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        //어댑터 생성
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //탭을 선택했을 시
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //슬라이딩이 아니라 위에 탭을 선택했을 때도 페이지 이동 가능하게
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
    //메뉴 버튼눌렀을때 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:{ //toolbar의 메뉴버튼 눌렀을 때 동작
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
