package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.manlesscafe.cafe2.Data.MemberData;
import com.manlesscafe.cafe2.Data.MyData;
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

public class ReserveCompleteActivity extends Activity {
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "db";

    MemberData memberData;
    SeatData tdata;
    ReserveData reserveData;
    MyData mydata;

    private Context mContext;
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_complete);
        mContext = this;
        TextView reserveSeat,presentDate,tv;
        reserveSeat = (TextView)findViewById(R.id.reserveSeat);
        presentDate = (TextView)findViewById(R.id.presentDate);
        tv = (TextView)findViewById(R.id.tv);


        tv.setText(memberData.getId());
        String sendid = tv.getText().toString();


        //data = (MemberData) intent.getSerializableExtra("memberData");
        /*
        * intent -> memberData / searNum
        * */
//        Intent mIntent = getIntent();
//        if (mIntent != null ){
//            data = (MemberData) mIntent.getSerializableExtra("memberData");
//        }
//        Intent nIntent = getIntent();
//        if (nIntent != null ){
//            tdata = (SeatData) nIntent.getSerializableExtra("sresult");
//        }
//        Intent rIntent = getIntent();
//        if (rIntent != null ){
//            reserveData = (ReserveData) rIntent.getSerializableExtra("reserveResult");
//        }

        String seat;
        Intent intent = getIntent();
        if (intent != null ) {
            memberData = (MemberData) intent.getSerializableExtra("memberData");
            seat = intent.getStringExtra("selectseat");

            reserveSeat.setText(seat);
            presentDate.setText(getTime());
        }

        Button BtnCheck1 = (Button)findViewById(R.id.BtnCheck1);
        BtnCheck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new reservecomplete().execute(memberData.getId(), memberData.getSeat().getSeat_num());  //reservecomplete class 실행하기 (일단 보류)

//                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
//                //intent.putExtra("selectseat",reserveseat1);
//                startActivity(intent);
                finish();
            }
        });
    }
    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    String url = "http://39.115.156.83:8080/rest_reserve/complete";

    class reservecomplete extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s == null) {
                Toast.makeText(mContext,"Server Error",Toast.LENGTH_SHORT).show();
            } else {
                Log.e("mresult", s);
                Gson gson = new Gson();
//                MyPageData mypagedata = gson.fromJson(s, MyPageData.class); //GSON으로 변환
//                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
//                intent.putExtra("mresult",mypagedata);
//                startActivity(intent);
//                //                if(data.getCheck_in().equals("")){
////                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
////                intent.putExtra("mresult", tdata);
////                startActivity(intent);
//                finish();
                //                }
                //                else{
                //                    Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
                //                }
            }


        }
        @Override
        protected String doInBackground(String... strings){
            RequestBody formBody = new FormBody.Builder()
                    .add("id",strings[0])
                    .add("seat_num",strings[1])
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            OkHttpClient client = new OkHttpClient();

            try{
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e){
                e.printStackTrace();
                return  null;
            }
        }
    }
}
