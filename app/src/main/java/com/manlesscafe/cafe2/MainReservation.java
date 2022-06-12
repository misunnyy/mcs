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
import com.manlesscafe.cafe2.Data.ReserveData;

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

    MemberData data;
    ReserveData reserveData;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.reservation_main);
        mContext = this;
        btnchoice = (Button) findViewById(R.id.BtnChoice);
        selectnum = (TextView) findViewById(R.id.selectnum);
        Log.e("MainReservation","MainReservation");

        Intent mIntent = getIntent();
        if (mIntent != null ){
            data = (MemberData) mIntent.getSerializableExtra("mresult");
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

        Button selectedBtn1 = findViewById(R.id.BtnTable1);
        Button selectedBtn2 = findViewById(R.id.BtnTable2);
        Button selectedBtn3 = findViewById(R.id.BtnTable3);
        Button selectedBtn4 = findViewById(R.id.BtnTable4);
        Button selectedBtn5 = findViewById(R.id.BtnTable5);
        Button selectedBtn6 = findViewById(R.id.BtnTable6);
        Button selectedBtn7 = findViewById(R.id.BtnTable7);
        Button selectedBtn8 = findViewById(R.id.BtnTable8);
        Button selectedBtn9 = findViewById(R.id.BtnTable9);
        Button selectedBtn10 = findViewById(R.id.BtnTable10);
        Button selectedBtn11 = findViewById(R.id.BtnTable11);
        Button selectedBtn12 = findViewById(R.id.BtnTable12);
        Button selectedBtn13 = findViewById(R.id.BtnTable13);
        Button selectedBtn14 = findViewById(R.id.BtnTable14);
        Button selectedBtn15 = findViewById(R.id.BtnTable15);
        Button selectedBtn16 = findViewById(R.id.BtnTable16);
        Button selectedBtn17 = findViewById(R.id.BtnTable17);
        Button selectedBtn18 = findViewById(R.id.BtnTable18);
        Button selectedBtn19 = findViewById(R.id.BtnTable19);

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
                } else {
                    String seat_num = selectnum.getText().toString();


                    Intent intent = new Intent(MainReservation.this, ReserveCompleteActivity.class);
                    intent.putExtra("selectseat", seat_num);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "예약완료", Toast.LENGTH_SHORT).show();

                    Log.d(TAG, "POST response  - " + getTime() + seat_num);
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

    String url = "http://www.stander-mcs.com/rest_reserve";

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

                Log.e("4",data.getSeat4());

                //                if(data.getCheck_in().equals("")){
//                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
//                intent.putExtra("mresult", data);
//                startActivity(intent);
                //                }
                //                else{
                //                    Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
                //                }
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