package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.manlesscafe.cafe2.Data.MyData;
import com.manlesscafe.cafe2.Data.MyPageData;
import com.manlesscafe.cafe2.Data.SeatData;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainMypage extends Activity implements View.OnClickListener {
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "db";
    private Context mContext;
    TextView mypage_name, mypage_email, tv;
    String mJsonString;

    MemberData data;
    SeatData tdata;
    MyPageData myPageData;

    TextView reserve_seat, charge_time;
    Button checkIn, checkout,usage_history;
    Intent intent;

    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.mypage_main);
        mContext = this;

        init();
        intent = getIntent();
        Log.e("MainMypage","MainMypage");

        if (intent != null) {
            data = (MemberData) intent.getSerializableExtra("mresult");
            tdata = (SeatData) intent.getSerializableExtra("sresult");
            myPageData = (MyPageData) intent.getSerializableExtra("myPageData") ;

            mypage_name.setText(data.getName());
            mypage_email.setText(data.getEmail());

            tv.setText(data.getId());
            //charge_time.setText(data.getTime());

            int time = Integer.valueOf(data.getTime());

            setTime(time);





            //charge_time.setText(myPageData.getTime());
            //reserve_seat.setText(tdata.getSeat_num());
            //String sendid = tv.getText().toString();
        }

        Button qrcode = (Button) findViewById(R.id.qrcode);
        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getQr() != null) {
                    Intent intent3 = new Intent(getApplicationContext(), CreateQR.class);
                    startActivity(intent3);
                } else {
                    Toast.makeText(mContext, "좌석을 예약해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "로그아웃 되었습니다.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
            }
        });



        /*if (reserve_seat == null) {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();

            String seat = bundle.getString("selectseat");
            reserve_seat.setText(seat);
        }
        if (charge_time == null){
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();

            String time = bundle.getString("selecttime");
            charge_time.setText(time);
        }*/

        ImageButton BtnHome = (ImageButton) findViewById(R.id.BtnHome);
        BtnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
                //new mypage().execute(data.getId());
                Intent intent = new Intent(getApplicationContext(), MainReservation.class);
                startActivity(intent);
            }
        });

        ImageButton BtnPay = (ImageButton) findViewById(R.id.BtnPay);
        BtnPay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
                //intent.putExtra("mresult",sendid);
                //Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
                //intent.putExtra("mresult",data);
                //startActivity(intent);
                new mypage().execute(data.getId());
            }
        });
    }

    private void setTime(int time) {
        int day = time / (60 * 60 * 24);  // day *
        int hour = time % (60 * 60 * 24) / (60 * 60);
        int minute = time % (60 * 60) / 60;
        int second = time % 60;

        charge_time.setText(day+"일"+hour+"시간"+minute+"분"+second+"초");
        data.setTime(day+"일"+hour+"시간"+minute+"분"+second+"초");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("재실행","mypayge Resume");
        new getMyData().execute(data.getId());
    }

    private void init() {
        reserve_seat = (TextView) findViewById(R.id.reserve_seat);
        charge_time = (TextView) findViewById(R.id.charge_time);
        tv = (TextView) findViewById(R.id.tv);
        checkIn = (Button) findViewById(R.id.checkin);
        checkIn.setOnClickListener(this);
        mypage_name = (TextView) findViewById(R.id.mypage_name);
        mypage_email = (TextView) findViewById(R.id.mypage_email);
        checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(this);
        usage_history = (Button) findViewById(R.id.usage_history);
        usage_history.setOnClickListener(this);
    }

    String tempUrl = "rest_mypage";
    String url = "http://www.stander-mcs.com/";

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkin:
                Intent sIntent = getIntent(); //받은 seat_num이 아직 없어 고쳐야함
                if (sIntent != null) {
                    tdata = (SeatData) sIntent.getSerializableExtra("selectseat");

                    //TODO 임의주석
                    Intent intent1 = new Intent(getApplicationContext(), MainReservation.class);
                    startActivity(intent1);
                } else {
                    //reserve_seat.setText(tdata.getSeat_num());
                    Toast.makeText(getApplicationContext(), "시간을 충전해주세요.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.checkout:
                Intent outIntent = getIntent(); //받은 seat_num이 아직 없어 고쳐야함
                if (outIntent != null) {
                    tdata = (SeatData) outIntent.getSerializableExtra("selectseat");

                    tdata.setSeat_num(null);
                    //TODO 임의주석
                    Intent intent1 = new Intent(getApplicationContext(), MainReservation.class);
                    startActivity(intent1);
                }
                Toast.makeText(getApplicationContext(), "퇴실처리 되었습니다.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.usage_history:
                Intent intent2 = new Intent(getApplicationContext(), UsageHistoryActivity.class);
                //intent2.putExtra("history", data);
                startActivity(intent2);
                break;
        }
    }

    class mypage extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                Log.e("result2", s);
                Gson gson = new Gson();
                MyPageData myPageData = gson.fromJson(s, MyPageData.class);
//                MemberData data = gson.fromJson(s, MemberData.class); //GSON으로 변환
                Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
                intent.putExtra("mresult", data);
                intent.putExtra("myPageData",myPageData);
                startActivity(intent);
            } else {
                Log.e("test", s);

                Toast.makeText(mContext, "Err", Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        protected String doInBackground(String... strings) {
            //strings[0] = data.getId();
            RequestBody formBody = new FormBody.Builder()
                    .add("id", strings[0])
                    .build();


            Request request = new Request.Builder()
//                    .header()
                    .url(url + tempUrl)
                    .post(formBody)
                    .build();

//            Request request = new Request.Builder()
////                    .header()
//                    .url(url + tempUrl)
//                    .get()
//                    .build();

            OkHttpClient client = new OkHttpClient();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    class getMyData extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s!= null){
                Log.e("getMyData Result",s);
                Gson gson = new Gson();
                MyData myData = gson.fromJson(s,MyData.class);

                charge_time.setText(myData.getTime());
//                setTime(Integer.parseInt(myData.getTime()));
            }
            else {
                //
                Log.e("getmydata","err");
            }

        }

        @Override
        protected String doInBackground(String... strings) {
            String url ="http://www.stander-mcs.com/rest_mypage";

            RequestBody formBody = new FormBody.Builder()
                    .add("id",strings[0])
//                    .add("password",strings[1])
                    .build();

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("log Err",e.toString());
                return null;
            }

        }
    }


}
