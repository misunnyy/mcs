package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PayCompleteActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_complete);

        TextView reserveSeat, reserveTime;
        reserveSeat = (TextView)findViewById(R.id.reserveSeat);
        reserveTime = (TextView)findViewById(R.id.reserveTime);

        Button BtnCheck = (Button)findViewById(R.id.BtnCheck);
        BtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}