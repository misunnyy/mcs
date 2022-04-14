package com.manlesscafe.cafe2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TicketBuyActivity extends Activity {
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


        Button BtnTimeTicket1;

        final boolean[] selected = {false};
        BtnTimeTicket1 = findViewById(R.id.BtnTimeTicket);
        BtnTimeTicket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket1.setSelected(false);
                    selected[0] = false;
                }
                else{
                    BtnTimeTicket1.setSelected(true);
                    selected[0] = true;
                }
            }
        });

        View TimeTicket3 = findViewById(R.id.BtnTimeTicket3);
        TimeTicket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    TimeTicket3.setSelected(false);
                    selected[0] = false;
                }
                else{
                    TimeTicket3.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        View TimeTicket6 = findViewById(R.id.BtnTimeTicket6);
        TimeTicket6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    TimeTicket6.setSelected(false);
                    selected[0] = false;
                }
                else{
                    TimeTicket6.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        View TimeTicket9 = findViewById(R.id.BtnTimeTicket9);
        TimeTicket9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    TimeTicket9.setSelected(false);
                    selected[0] = false;
                }
                else{
                    TimeTicket9.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        View TimeTicket12 = findViewById(R.id.BtnTimeTicket12);
        TimeTicket12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    TimeTicket12.setSelected(false);
                    selected[0] = false;
                }
                else{
                    TimeTicket12.setSelected(true);
                    selected[0] = true;
                }
            }
        });

    }
}
