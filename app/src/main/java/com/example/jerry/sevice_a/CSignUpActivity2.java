package com.example.jerry.sevice_a;

        import android.content.Intent;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class CSignUpActivity2 extends AppCompatActivity {
    //가맹등록 번호인증 페이지

    List<String> listview_items;
    ArrayAdapter<String> listview_adapter;
    Button btn1,btn2;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_signup2);


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
                Intent intent = new Intent(CSignUpActivity2.this,CSignUpActivity1.class);
                startActivity(intent);
                finish();
            }
        });

        //다음 버튼
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSignUpActivity2.this,CSignUpActivity3.class);
                startActivity(intent);
                //finish();
            }
        });

        /*
         * 스피너에서 선택한 항목들을 보여줄 리스트뷰
         */
        ListView listview = (ListView)findViewById(R.id.listView);

        //데이터를 저장하게 되는 리스트
        listview_items = new ArrayList<>();

        //리스트뷰와 리스트를 연결하기 위해 사용되는 어댑터
        listview_adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listview_items);

        //리스트뷰의 어댑터 지정
        listview.setAdapter(listview_adapter);


        /*
         * 스피너 관련
         */
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapterView.getItemAtPosition(i).toString();

                if ( str != "")
                    listview_adapter.add( str );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //데이터를 저장하게 되는 리스트
        List<String> spinner_items = new ArrayList<>();

        //스피너와 리스트를 연결하기 위해 사용되는 어댑터
        ArrayAdapter<String> spinner_adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinner_items);

        spinner_items.add("010");
        spinner_items.add("011");
        spinner_items.add("0130");
        spinner_items.add("016");
        spinner_items.add("017");
        spinner_items.add("018");
        spinner_items.add("019");

        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //스피너의 어댑터 지정
        spinner.setAdapter(spinner_adapter);

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
