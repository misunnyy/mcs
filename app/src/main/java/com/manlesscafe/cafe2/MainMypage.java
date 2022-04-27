package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainMypage extends Activity {
    ArrayList<String> Mypages = new ArrayList<String>();

    ListView listView;
    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.mypage_main);

        Mypages.add("나의 정보");
        Mypages.add("입,퇴실 관리");
        Mypages.add("푸쉬알림 설정");
        Mypages.add("예약확인 및 취소");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Mypages);

        listView = (ListView)findViewById(R.id.mypageList);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainMypage.this,Mypages.get(position),Toast.LENGTH_SHORT).show();
            }
        };

        listView.setOnItemClickListener(listener);

        ImageButton BtnHome = (ImageButton) findViewById(R.id.BtnHome);
        BtnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton BtnUser = (ImageButton) findViewById(R.id.BtnUser);
        BtnUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
            }
        });

        ImageButton BtnEct = (ImageButton) findViewById(R.id.BtnEct);
        BtnEct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainEct.class);
                startActivity(intent);
            }
        });

        ImageButton BtnReservation = (ImageButton) findViewById(R.id.BtnReservation);
        BtnReservation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainReservation.class);
                startActivity(intent);
            }
        });

        ImageButton BtnMap = (ImageButton) findViewById(R.id.BtnMap);
        BtnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainMap.class);
                startActivity(intent);
            }
        });
    }
}