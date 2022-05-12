package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TicketBuyActivity extends Activity {
    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.ticket_buy);
        Button BtnBuy = (Button)findViewById(R.id.BtnBuy);

        TextView selecttime = (TextView)findViewById(R.id.selecttime);
        Button[] seatnumButtons = new Button[5];
        Integer[] seatnumBtnIDs = { R.id.BtnTimeTicket1,R.id.BtnTimeTicket3,R.id.BtnTimeTicket6,R.id.BtnTimeTicket9,R.id.BtnTimeTicket12};
        //Integer [] selecttimes = {900,10800,21600,32400,43200};


        Button BtnTimeTicket1,BtnTimeTicket3, BtnTimeTicket6, BtnTimeTicket9,BtnTimeTicket12;

        final boolean[] selected = {false};
        BtnTimeTicket1 = findViewById(R.id.BtnTimeTicket1);
        BtnTimeTicket3 = findViewById(R.id.BtnTimeTicket3);
        BtnTimeTicket6 = findViewById(R.id.BtnTimeTicket6);
        BtnTimeTicket9 = findViewById(R.id.BtnTimeTicket9);
        BtnTimeTicket12 = findViewById(R.id.BtnTimeTicket12);

        //Button[] numButtons = new Button[5];
        //Integer[] numBtnIDs = { R.id.BtnTimeTicket1,R.id.BtnTimeTicket3,R.id.BtnTimeTicket6,R.id.BtnTimeTicket9,R.id.BtnTimeTicket12 };

        //final int[] time = new int[]{1,3,6,9,12};

        BtnTimeTicket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //15분 = 900초

                //time[1] = 900;

            }
        });

        BtnTimeTicket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //3시간 = 10,800

                //time[3] = 10800;

            }
        });

        BtnTimeTicket6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//6시간 = 21,600

                //time[6] = 21600;

            }
        });

        BtnTimeTicket9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//9시간 = 32,400

                //time[9] = 32400;

            }
        });

        BtnTimeTicket12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //12시간 = 43,200

                //time[12] = 43200;

            }
        });

        for(int i=0;i<seatnumButtons.length;i++){
            seatnumButtons[i] = (Button)findViewById(seatnumBtnIDs[i]);

            final int index;
            index = i;

            seatnumButtons[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    if (index == 0){
                        BtnTimeTicket1.setSelected(true);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("15분"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.BLUE);
                        //Toast.makeText(getApplicationContext(),"15분을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else if(index == 1){
                        BtnTimeTicket3.setSelected(true);
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("3시간"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.BLUE);
                        //Toast.makeText(getApplicationContext(),"3시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else if(index == 2){
                        BtnTimeTicket6.setSelected(true);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("6시간"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.BLUE);
                        //Toast.makeText(getApplicationContext(),"6시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else if(index == 3){
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(true);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("9시간"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.BLUE);
                        //Toast.makeText(getApplicationContext(),"9시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else if(index == 4){
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(true);
                        selecttime.setText("12시간"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.BLUE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        BtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selecttime.length() <= 0) {
                    Toast.makeText(getApplicationContext(),"결제시간을 선택하세요",Toast.LENGTH_SHORT).show();
                }
                else{
                    String time = selecttime.getText().toString();;
                    Intent intent = new Intent(TicketBuyActivity.this, PayCompleteActivity.class);
                    intent.putExtra("reservetime",time);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),"결제완료",Toast.LENGTH_SHORT).show();
                }
            }
        });

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

        ImageButton BtnReservation = (ImageButton) findViewById(R.id.BtnReservation);
        BtnReservation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainReservation.class);
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
    }
}