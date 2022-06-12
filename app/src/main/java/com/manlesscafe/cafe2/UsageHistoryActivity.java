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

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UsageHistoryActivity extends Activity {
    MemberData memberData;
    private Context mContext;
    TextView Txtcheckin;
    Button Btnhistory;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usage_history);
        Intent mIntent = getIntent();
        if (mIntent != null) {
            memberData = (MemberData) mIntent.getSerializableExtra("memberData");
        }
        /**
         * data
         * memberData 받아오기
         *
         * */
        mContext = this;
        Btnhistory = (Button)findViewById(R.id.Btnhistory);

        Log.e("UsageHistory","UsageHistory");

         Txtcheckin = (TextView) findViewById(R.id.Txtcheckin); //이걸 textview로 받을지 listview로 받을지
         //Txtcheckout = (TextView) findViewById(R.id.Txtcheckout); //고민 중
//        Intent mIntent = getIntent();
//        if (mIntent != null ){
//
//            data = (MemberData) mIntent.getSerializableExtra("mresult");
            Btnhistory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mIntent = getIntent();
                    if (mIntent != null ) {

                        //data = (MemberData) mIntent.getSerializableExtra("mresult");
                        new history().execute(memberData.getId());

                        //TODO 하드코딩 수정필요
                        //new history().execute("6");
                    }
                    else{
                        Toast.makeText(mContext,"이용내역이 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            });



        /*Intent nIntent = getIntent(); //MySQL에 저장된 seat 객체 불러오기
        if (nIntent != null) {
            new history().execute(data.getId());


            //tdata = (SeatData) nIntent.getSerializableExtra("sresult");
            //new history().execute(tdata.getTid(), tdata.getSeat_num()); //원하는 데이터의 id와 저장하고싶은 seat_num을 받아서 mypage class 실행
            //Txtcheckin.setText(tdata.getCheck_in());
            //Txtcheckout.setText(tdata.getCheck_out());
        } else {
            Toast.makeText(getApplicationContext(), "이용내역이 없습니다.", Toast.LENGTH_SHORT).show();
        }*/

        //Intent intent = getIntent();
        //Bundle bundle = intent.getExtras();

        //String name = bundle.getString("name");
        //mypage_name.setText(name);

        ImageButton usage_back = (ImageButton) findViewById(R.id.usage_back);
        usage_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    String tempUrl = "rest_mypage/use_history";
    String url = "http://39.115.156.83:8080/";

    class history extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                Log.e("history", s);

                Txtcheckin.setText(s);
                Gson gson = new Gson();
                //Toast.makeText(mContext, "등록이 완료되었습니다.", Toast.LENGTH_SHORT).show();
//                finish();
                /*
                SeatData tdata = gson.fromJson(s, SeatData.class); //GSON으로 변환
                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                intent.putExtra("sresult", tdata);
                startActivity(intent);*/
            } else {
                Log.e("test", s);

                Toast.makeText(mContext, "Err", Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        protected String doInBackground(String... strings) {

            RequestBody formBody = new FormBody.Builder()
                    .add("id", strings[0])
                    .build();


            Request request = new Request.Builder()
//                    .header()
                    .url(url + tempUrl)
                    .post(formBody)
                    .build();
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
}
