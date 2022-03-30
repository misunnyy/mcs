package com.manlesscafe.cafe2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class MainLogin extends Activity {
    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.login_main);

        ImageButton BtnHome = (ImageButton) findViewById(R.id.BtnHome);
        BtnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton BtnReservation = (ImageButton) findViewById(R.id.BtnReservation);
        BtnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainReservation.class);
                startActivity(intent);
            }
        });

        ImageButton BtnMap = (ImageButton) findViewById(R.id.BtnMap);
        BtnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainMap.class);
                startActivity(intent);
            }
        });

        ImageButton BtnEct = (ImageButton) findViewById(R.id.BtnEct);
        BtnEct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainEct.class);
                startActivity(intent);
            }
        });
    }
}