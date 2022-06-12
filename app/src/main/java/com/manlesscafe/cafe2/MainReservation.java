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

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.manlesscafe.cafe2.Data.MemberData;
import com.manlesscafe.cafe2.Data.MyPageData;
import com.manlesscafe.cafe2.Data.ReserveData;
import com.manlesscafe.cafe2.Data.SeatData;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainReservation extends Activity {
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "db";

    private Context mContext;
    Button btnchoice;
    TextView selectnum;

    MemberData memberData;
    ReserveData reserveData;
    SeatData tdata;
    MyPageData mypagedata;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    Button selectedBtn1;
    Button selectedBtn2;
    Button selectedBtn3;
    Button selectedBtn4;
    Button selectedBtn5;
    Button selectedBtn6;
    Button selectedBtn7;
    Button selectedBtn8;
    Button selectedBtn9;
    Button selectedBtn10;
    Button selectedBtn11;
    Button selectedBtn12;
    Button selectedBtn13;
    Button selectedBtn14;
    Button selectedBtn15;
    Button selectedBtn16;
    Button selectedBtn17;
    Button selectedBtn18;
    Button selectedBtn19;

    //MemberData memberData;

    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.reservation_main);
        mContext = this;
        btnchoice = (Button) findViewById(R.id.BtnChoice);
        selectnum = (TextView) findViewById(R.id.selectnum);

        Intent intent = getIntent();
        memberData = (MemberData) intent.getSerializableExtra("memberData");
        Log.e("MainReservation","MainReservation");

        selectedBtn1 = findViewById(R.id.BtnTable1);
        selectedBtn2 = findViewById(R.id.BtnTable2);
        selectedBtn3 = findViewById(R.id.BtnTable3);
        selectedBtn4 = findViewById(R.id.BtnTable4);
        selectedBtn5 = findViewById(R.id.BtnTable5);
        selectedBtn6 = findViewById(R.id.BtnTable6);
        selectedBtn7 = findViewById(R.id.BtnTable7);
        selectedBtn8 = findViewById(R.id.BtnTable8);
        selectedBtn9 = findViewById(R.id.BtnTable9);
        selectedBtn10 = findViewById(R.id.BtnTable10);
        selectedBtn11 = findViewById(R.id.BtnTable11);
        selectedBtn12 = findViewById(R.id.BtnTable12);
        selectedBtn13 = findViewById(R.id.BtnTable13);
        selectedBtn14 = findViewById(R.id.BtnTable14);
        selectedBtn15 = findViewById(R.id.BtnTable15);
        selectedBtn16 = findViewById(R.id.BtnTable16);
        selectedBtn17 = findViewById(R.id.BtnTable17);
        selectedBtn18 = findViewById(R.id.BtnTable18);
        selectedBtn19 = findViewById(R.id.BtnTable19);

        Intent mIntent = getIntent();
        if (mIntent != null ){
            memberData = (MemberData) mIntent.getSerializableExtra("memberData");
        }

        Intent rIntent = getIntent();
        if (rIntent != null ){
            reserveData = (ReserveData) rIntent.getSerializableExtra("reserveResult");
        }

        new reserve().execute();  //reserve class 실행하기

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

        ImageButton BtnPay = (ImageButton) findViewById(R.id.BtnPay);
        BtnPay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
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
        //final TextView[] selectednum = new TextView[19];


        Button[] numButtons = new Button[19];
        Integer[] numBtnIDs = {R.id.BtnTable1, R.id.BtnTable2, R.id.BtnTable3, R.id.BtnTable4, R.id.BtnTable5,
                R.id.BtnTable6, R.id.BtnTable7, R.id.BtnTable8,
                R.id.BtnTable9, R.id.BtnTable10, R.id.BtnTable11, R.id.BtnTable12,
                R.id.BtnTable13, R.id.BtnTable14, R.id.BtnTable15, R.id.BtnTable16, R.id.BtnTable17, R.id.BtnTable18, R.id.BtnTable19};

        final boolean[] selected = {false};

        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    /*if (index < 19) {

                        selectnum.setText((index + 1) + "번"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.BLUE);
                        //numButtons.setSelected(Color.BLUE);
                        //Toast.makeText(getApplicationContext(), (index+1)+"번 좌석을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }*/
                    if (index == 0) {
                        selectedBtn1.setSelected(true);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("1"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"15분을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 1) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(true);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("2"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"3시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 2) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(true);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("3"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"6시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 3) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(true);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("4"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"9시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 4) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(true);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("5"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 5) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(true);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("6"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 6) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(true);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("7"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 7) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(true);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("8"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 8) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(true);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("9"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 9) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(true);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("10"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 10) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(true);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("11"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 11) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(true);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("12"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 12) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(true);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("13"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 13) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(true);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("14"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 14) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(true);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("15"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 15) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(true);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("16"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 16) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(true);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("17"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 17) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(true);
                        selectedBtn19.setSelected(false);
                        selectnum.setText("18"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    } else if (index == 18) {
                        selectedBtn1.setSelected(false);
                        selectedBtn2.setSelected(false);
                        selectedBtn3.setSelected(false);
                        selectedBtn4.setSelected(false);
                        selectedBtn5.setSelected(false);
                        selectedBtn6.setSelected(false);
                        selectedBtn7.setSelected(false);
                        selectedBtn8.setSelected(false);
                        selectedBtn9.setSelected(false);
                        selectedBtn10.setSelected(false);
                        selectedBtn11.setSelected(false);
                        selectedBtn12.setSelected(false);
                        selectedBtn13.setSelected(false);
                        selectedBtn14.setSelected(false);
                        selectedBtn15.setSelected(false);
                        selectedBtn16.setSelected(false);
                        selectedBtn17.setSelected(false);
                        selectedBtn18.setSelected(false);
                        selectedBtn19.setSelected(true);
                        selectnum.setText("19"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.WHITE);
                        //Toast.makeText(getApplicationContext(),"12시간을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if(selected[0]){ //좌석 정보 없으면 인원 정보도 없는 것
                    Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
                    startActivity(intent);
                }*/
                if (selectnum.length() <= 0) {
                    Toast.makeText(getApplicationContext(), "좌석을 선택하세요.", Toast.LENGTH_SHORT).show();
                }
                else if(memberData.getSeat().getSeat_num() != null){

                    String seat_num = selectnum.getText().toString();
                    Intent intent = new Intent(MainReservation.this, ReserveCompleteActivity.class);
                    intent.putExtra("selectseat", seat_num);
                    intent.putExtra("memberData", memberData);
                    startActivity(intent);
                    finish();

                    //

                    Toast.makeText(getApplicationContext(), "예약완료", Toast.LENGTH_SHORT).show();

                    Log.d(TAG, "POST response  - " + getTime() + seat_num);
                }
                else{

                    Toast.makeText(getApplicationContext(), "좌석이 이미 예약되어 있습니다.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("재실행","mypayge Resume");
        new reserve().execute();
    }

    String url = "http://39.115.156.83:8080/rest_reserve";

    class reserve extends AsyncTask<String, Void, String> { //비동기식 전송방식
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) { //받는거
            super.onPostExecute(s);

            if (s == null) {
                Toast.makeText(mContext,"Server Error",Toast.LENGTH_SHORT).show();
            } else {
                Log.e("mresult", s);
                Gson gson = new Gson();
                ReserveData data = gson.fromJson(s, ReserveData.class); //GSON으로 변환
                if (data != null) {
                    //Log.e("4",data.getSeat4());
                    if (data.getSeat1() != null) {

                        selectedBtn1.setText(data.getSeat1());
                        selectedBtn1.setEnabled(false);
                    } else {
                        selectedBtn1.setEnabled(true);
                    }
                    if (data.getSeat2() != null) {

                        selectedBtn2.setText(data.getSeat2());
                        selectedBtn2.setEnabled(false);
                    } else {
                        selectedBtn2.setEnabled(true);
                    }
                    if (data.getSeat3() != null) {

                        selectedBtn3.setText(data.getSeat3());
                        selectedBtn3.setEnabled(false);
                    } else {
                        selectedBtn3.setEnabled(true);
                    }
                    if (data.getSeat4() != null) {

                        selectedBtn4.setText(data.getSeat4());
                        selectedBtn4.setEnabled(false);
                    } else {
                        selectedBtn4.setEnabled(true);
                    }
                    if (data.getSeat5() != null) {

                        selectedBtn5.setText(data.getSeat5());
                        selectedBtn5.setEnabled(false);
                    } else {
                        selectedBtn5.setEnabled(true);
                    }
                    if (data.getSeat6() != null) {

                        selectedBtn6.setText(data.getSeat6());
                        selectedBtn6.setEnabled(false);
                    } else {
                        selectedBtn6.setEnabled(true);
                    }
                    if (data.getSeat7() != null) {

                        selectedBtn7.setText(data.getSeat7());
                        selectedBtn7.setEnabled(false);
                    } else {
                        selectedBtn7.setEnabled(true);
                    }
                    if (data.getSeat8() != null) {

                        selectedBtn8.setText(data.getSeat8());
                        selectedBtn8.setEnabled(false);
                    } else {
                        selectedBtn8.setEnabled(true);
                    }
                    if (data.getSeat9() != null) {

                        selectedBtn9.setText(data.getSeat9());
                        selectedBtn9.setEnabled(false);
                    } else {
                        selectedBtn9.setEnabled(true);
                    }
                    if (data.getSeat10() != null) {

                        selectedBtn10.setText(data.getSeat10());
                        selectedBtn10.setEnabled(false);
                    } else {
                        selectedBtn10.setEnabled(true);
                    }
                    if (data.getSeat11() != null) {

                        selectedBtn11.setText(data.getSeat11());
                        selectedBtn11.setEnabled(false);
                    } else {
                        selectedBtn11.setEnabled(true);
                    }
                    if (data.getSeat12() != null) {

                        selectedBtn12.setText(data.getSeat12());
                        selectedBtn12.setEnabled(false);
                    } else {
                        selectedBtn12.setEnabled(true);
                    }
                    if (data.getSeat13() != null) {

                        selectedBtn13.setText(data.getSeat13());
                        selectedBtn13.setEnabled(false);
                    } else {
                        selectedBtn13.setEnabled(true);
                    }
                    if (data.getSeat14() != null) {

                        selectedBtn14.setText(data.getSeat14());
                        selectedBtn14.setEnabled(false);
                    } else {
                        selectedBtn14.setEnabled(true);
                    }
                    if (data.getSeat15() != null) {

                        selectedBtn15.setText(data.getSeat15());
                        selectedBtn15.setEnabled(false);
                    } else {
                        selectedBtn15.setEnabled(true);
                    }
                    if (data.getSeat16() != null) {

                        selectedBtn16.setText(data.getSeat16());
                        selectedBtn16.setEnabled(false);
                    } else {
                        selectedBtn16.setEnabled(true);
                    }
                    if (data.getSeat17() != null) {

                        selectedBtn17.setText(data.getSeat17());
                        selectedBtn17.setEnabled(false);
                    } else {
                        selectedBtn17.setEnabled(true);
                    }
                    if (data.getSeat18() != null) {

                        selectedBtn18.setText(data.getSeat18());
                        selectedBtn18.setEnabled(false);
                    } else {
                        selectedBtn18.setEnabled(true);
                    }
                    if (data.getSeat19() != null) {

                        selectedBtn19.setText(data.getSeat19());
                        selectedBtn19.setEnabled(false);
                    } else {
                        selectedBtn19.setEnabled(true);
                    }
                    //                if(data.getCheck_in().equals("")){
//                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
//                intent.putExtra("mresult", data);
//                startActivity(intent);
                    //                }
                    //                else{
                    //                    Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
                    //                }
                } else {
                    selectedBtn1.setEnabled(true);
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
            }

        }
        @Override
        protected String doInBackground(String... strings) { //보내는거

            RequestBody formBody = new FormBody.Builder()

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