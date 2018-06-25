package com.example.jerry.sevice_a;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OrderConfirmActivity extends Fragment {
    //TabPagerAdapter에서 연결된 주문 승인 페이지

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_order_confirm,container,false);

        //ListView 또는 RecyclerView 사용하여 주문 승인 목록 데이터를 DB에서 받아서 와야함
        //블로그 참고
        //http://developer88.tistory.com/3
    }

    //받아올 데이터 클래스(OrderDTO)
    public class OrderConfirm{
        private String coustomer;//고객
        private String profile;//고객 프로필
        private int orderCount;//주문 갯수
        private String orderList;//주문 목록

        public String getCoustomer() {
            return coustomer;
        }

        public void setCoustomer(String coustomer) {
            this.coustomer = coustomer;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getOrderList() {
            return orderList;
        }

        public void setOrderList(String orderList) {
            this.orderList = orderList;
        }
    }

}
