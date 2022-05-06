package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TicketBuyActivity extends Activity {

    Button btnBuy;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_buy);

        ImageButton BtnReturn = (ImageButton) findViewById(R.id.BtnReturn);
        BtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnBuy = (Button) findViewById(R.id.BtnBuy);


        final boolean[] selected = {false};
        Button BtnTimeTicket1 = findViewById(R.id.BtnTimeTicket1);
        Button BtnTimeTicket3 = findViewById(R.id.BtnTimeTicket3);
        Button BtnTimeTicket6 = findViewById(R.id.BtnTimeTicket6);
        Button BtnTimeTicket9 = findViewById(R.id.BtnTimeTicket9);
        Button BtnTimeTicket12 = findViewById(R.id.BtnTimeTicket12);

        BtnTimeTicket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket1.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setEnabled(true);
                    BtnTimeTicket6.setEnabled(true);
                    BtnTimeTicket9.setEnabled(true);
                    BtnTimeTicket12.setEnabled(true);

                }
                else{
                    BtnTimeTicket1.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setEnabled(false);
                    BtnTimeTicket6.setEnabled(false);
                    BtnTimeTicket9.setEnabled(false);
                    BtnTimeTicket12.setEnabled(false);
                }
            }
        });

        //View TimeTicket3 = findViewById(R.id.BtnTimeTicket3);
        BtnTimeTicket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket3.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket1.setEnabled(true);
                    BtnTimeTicket6.setEnabled(true);
                    BtnTimeTicket9.setEnabled(true);
                    BtnTimeTicket12.setEnabled(true);
                }
                else{
                    BtnTimeTicket3.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket1.setEnabled(false);
                    BtnTimeTicket6.setEnabled(false);
                    BtnTimeTicket9.setEnabled(false);
                    BtnTimeTicket12.setEnabled(false);
                }
            }
        });
        //View TimeTicket6 = findViewById(R.id.BtnTimeTicket6);
        BtnTimeTicket6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket6.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setEnabled(true);
                    BtnTimeTicket1.setEnabled(true);
                    BtnTimeTicket9.setEnabled(true);
                    BtnTimeTicket12.setEnabled(true);
                }
                else{
                    BtnTimeTicket6.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setEnabled(false);
                    BtnTimeTicket1.setEnabled(false);
                    BtnTimeTicket9.setEnabled(false);
                    BtnTimeTicket12.setEnabled(false);
                }
            }
        });
        //View TimeTicket9 = findViewById(R.id.BtnTimeTicket9);
        BtnTimeTicket9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket9.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setEnabled(true);
                    BtnTimeTicket6.setEnabled(true);
                    BtnTimeTicket1.setEnabled(true);
                    BtnTimeTicket12.setEnabled(true);
                }
                else{
                    BtnTimeTicket9.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setEnabled(false);
                    BtnTimeTicket6.setEnabled(false);
                    BtnTimeTicket1.setEnabled(false);
                    BtnTimeTicket12.setEnabled(false);
                }
            }
        });
       // View TimeTicket12 = findViewById(R.id.BtnTimeTicket12);
        BtnTimeTicket12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket12.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setEnabled(true);
                    BtnTimeTicket6.setEnabled(true);
                    BtnTimeTicket9.setEnabled(true);
                    BtnTimeTicket1.setEnabled(true);
                }
                else{
                    BtnTimeTicket12.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setEnabled(false);
                    BtnTimeTicket6.setEnabled(false);
                    BtnTimeTicket9.setEnabled(false);
                    BtnTimeTicket1.setEnabled(false);
                }
            }
        });

        Button BtnBuy = (Button) findViewById(R.id.BtnBuy);
        BtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selected[0]) {
                    Intent intent = new Intent(getApplicationContext(), PayCompleteActivity.class);
                    startActivity(intent);
                }
                else  {
                    Toast.makeText(getApplicationContext(), "시간을 선택하세요", Toast.LENGTH_LONG).show();
                }}
        });
    }
}
