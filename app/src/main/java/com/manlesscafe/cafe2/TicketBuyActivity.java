package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.manlesscafe.cafe2.Data.MemberData;
import com.manlesscafe.cafe2.Data.MyPageData;
import com.manlesscafe.cafe2.Data.SeatData;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TicketBuyActivity extends Activity {
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "db";
    private Context mContext;

    MemberData memberData;
    MyPageData myPageData;
    SeatData tdata;

    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.ticket_buy);
        Button BtnBuy = (Button) findViewById(R.id.BtnBuy);

        Log.e("TicketBuyActivity","TicketBuyActivity");

        Intent tempIntent = getIntent();
        memberData = (MemberData) tempIntent.getSerializableExtra("memberData");
        myPageData = (MyPageData) tempIntent.getSerializableExtra("myPageData");//우리

        memberData.getId();


        mContext = this;
        TextView tv;
        tv = (TextView)findViewById(R.id.tv);

        Intent mIntent = getIntent(); //MySQL에 저장된 member 객체 불러오기
        if (mIntent != null ){
            memberData = (MemberData) mIntent.getSerializableExtra("memberData");
        }

        //tv.setText(memberData.getId());
        //String sendid = tv.getText().toString();

        TextView selecttime = (TextView) findViewById(R.id.selecttime);
        Button[] seatnumButtons = new Button[5];
        Integer[] seatnumBtnIDs = {R.id.BtnTimeTicket1, R.id.BtnTimeTicket3, R.id.BtnTimeTicket6, R.id.BtnTimeTicket9, R.id.BtnTimeTicket12};
        //Integer [] selecttimes = {900,10800,21600,32400,43200};

        String TIME = selecttime.getText().toString();

        //new pay().execute(TIME);  //pay class 실행하기

        Button BtnTimeTicket1, BtnTimeTicket3, BtnTimeTicket6, BtnTimeTicket9, BtnTimeTicket12;

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
                String str = "900";
                int time = Integer.valueOf(str);

                int day = time / (60 * 60 * 24);  // day *
                int hour = time % (60 * 60 * 24) / (60 * 60);
                int minute = time % (60 * 60) / 60;
                int second = time % 60;
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

        for (int i = 0; i < seatnumButtons.length; i++) {
            seatnumButtons[i] = (Button) findViewById(seatnumBtnIDs[i]);

            final int index;
            index = i;

            seatnumButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (index == 0) {
                        BtnTimeTicket1.setSelected(true);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("900"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"15분을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 1) {
                        BtnTimeTicket3.setSelected(true);
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("10800"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"3시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 2) {
                        BtnTimeTicket6.setSelected(true);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("21600"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"6시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 3) {
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(true);
                        BtnTimeTicket12.setSelected(false);
                        selecttime.setText("32400"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"9시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 4) {
                        BtnTimeTicket1.setSelected(false);
                        BtnTimeTicket3.setSelected(false);
                        BtnTimeTicket6.setSelected(false);
                        BtnTimeTicket9.setSelected(false);
                        BtnTimeTicket12.setSelected(true);
                        selecttime.setText("43200"); //버튼 번호를 받아와 띄움
                        selecttime.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        BtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selecttime.length() <= 0) {
                    Toast.makeText(getApplicationContext(), "결제시간을 선택하세요", Toast.LENGTH_SHORT).show();
                } else {
                    String time1 = selecttime.getText().toString();

//                    int time = Integer.valueOf(time1);
//
//                    int day = time / (60 * 60 * 24);  // day *
//                    int hour = time % (60 * 60 * 24) / (60 * 60);
//                    int minute = time % (60 * 60) / 60;
//                    int second = time % 60;

                        new pay().execute(memberData.getId(),time1);
//                        Intent intent = new Intent(TicketBuyActivity.this, MainMypage.class);
//                        //intent.putExtra("reservetime", day + "일 " + hour + "시간 " + minute + "분" + second + "초");
//                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "결제완료", Toast.LENGTH_SHORT).show();


                        // A -> B -> C
                    // 로그인 -> 마이페이지 ->

                    //Log.d(TAG, "POST response  - " + time);
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
                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
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
    String url ="http://39.115.156.83:8080/rest_pay";

    class pay extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) { // s는 오빠가 보내주는 ok
            super.onPostExecute(s);

            if (s!= null){
                Log.e("pay Result",s);
                //Log.e("test",s);
                Gson gson = new Gson();
//                MyPageData myPageData = gson.fromJson(s, MyPageData.class); //GSON으로 변환
                Toast.makeText(mContext, "등록이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
//                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
//                intent.putExtra("myPageData",myPageData);
//                startActivity(intent);
            }else {
                Log.e("payErr","err");
                Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        protected String doInBackground(String... strings){
            RequestBody formBody = new FormBody.Builder()
                    .add("id",strings[0])
                    .add("time",strings[1])
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            OkHttpClient client = new OkHttpClient();

            try{
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (IOException e){
                e.printStackTrace();
                return null;
            }
        }
    }
}