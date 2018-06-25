package com.example.jerry.sevice_a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter{
    //탭 기능을 설정하는 어댑터 클래스

    //탭 갯수
    private int tabCount;

    //fragment가 탭 갯수를 인식하는 생성자
    public TabPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount=tabCount;
    }


    @Override
    public Fragment getItem(int position) {
        //각 탭들을 각 해당 클래스에 연결
        switch (position){
            case 0 ://0번 탭에 주문 대기 페이지 연결
                OrderWaitActivity orderWaitActivity = new OrderWaitActivity();
                return orderWaitActivity;
            case 1 ://1번 탭에 주문 승인 페이지 연결
                OrderConfirmActivity orderConfirmActivity = new OrderConfirmActivity();
                return orderConfirmActivity;
            case 2 ://2번 탭에 총 주문 갯수 페이지 연결
                OrderCountActivity orderCountActivity = new OrderCountActivity();
                return orderCountActivity;
            default:
                return null;
        }
    }

    //원하는 페이지 수 받아오기
    @Override
    public int getCount() {
        return tabCount;
    }
}
