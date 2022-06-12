package com.manlesscafe.cafe2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.manlesscafe.cafe2.Data.MemberData;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainLogin extends AppCompatActivity {

    EditText name, password;
    Button sign_in, sign_up, find;
    private TextView mTextViewResult;
    private String mJsonString;
    char result2;
    private static String IP_ADDRESS = "10.0.2.2:80";//"www.stander-mcs.com";


    private EditText ID;
    private EditText PW;

    private CheckBox cb_save;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        mContext = this; // 이거 필수!



        ID = (EditText) findViewById(R.id.ID);
        PW = (EditText) findViewById(R.id.PW);


        cb_save = (CheckBox) findViewById(R.id.cb_save);
        boolean boo = PreferenceManager.getBoolean(mContext,"check"); //로그인 정보 기억하기 체크 유무 확인
        if(boo){ // 체크가 되어있다면 아래 코드를 수행
            //저장된 아이디와 암호를 가져와 셋팅한다.
            ID.setText(PreferenceManager.getString(mContext, "id"));
            PW.setText(PreferenceManager.getString(mContext, "pw"));
            cb_save.setChecked(true); //체크박스는 여전히 체크 표시 하도록 셋팅
        }


        name = findViewById(R.id.ID);
        password = findViewById(R.id.PW);

        mTextViewResult = findViewById(R.id.textView_main_result);
        sign_in = (Button) findViewById(R.id.sign_in);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String NAME = name.getText().toString();
                String PASSWORD = password.getText().toString();

                //Intent intent = new Intent(MainLogin.this, MainMypage.class); //이건 없어도 무방
                // 저장한 키 값으로 저장된 아이디와 암호를 불러와 String 값에 저장

                //PreferenceManager.setString(mContext, "id", ID.getText().toString()); //id라는 키값으로 저장
                //PreferenceManager.setString(mContext, "pw", PW.getText().toString()); //pw라는 키값으로 저장

                //String checkId = PreferenceManager.getString(mContext, "id");
                //String checkPw = PreferenceManager.getString(mContext, "pw");  //아이디와 암호가 비어있는 경우를 체크

                //new login().execute("test","!@#$asdf1234");

                if (TextUtils.isEmpty(NAME) || TextUtils.isEmpty(PASSWORD)){
                    //아이디나 암호 둘 중 하나가 비어있으면 토스트메시지를 띄운다
                    Toast.makeText(MainLogin.this, "아이디/암호를 입력해주세요",
                            Toast.LENGTH_SHORT).show();
                }else { //둘 다 충족하면 다음 동작을 구현해놓음
                    Log.e("mainLogin","name : " + NAME + " " + " pw : " + PASSWORD);
                    new login().execute(NAME,PASSWORD);
                    //new login().execute("test","!@#$asdf1234");
                }

            }
        });

        //로그인 기억하기 체크박스 유무에 따른 동작 구현
        cb_save.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()) { // 체크박스 체크 되어 있으면
                    //editText에서 아이디와 암호 가져와 PreferenceManager에 저장한다.
                    PreferenceManager.setString(mContext, "id", ID.getText().toString()); //id 키값으로 저장
                    PreferenceManager.setString(mContext, "pw", PW.getText().toString()); //pw 키값으로 저장
                    PreferenceManager.setBoolean(mContext, "check", cb_save.isChecked()); //현재 체크박스 상태 값 저장
                } else { //체크박스가 해제되어있으면
                    PreferenceManager.setBoolean(mContext, "check", cb_save.isChecked()); //현재 체크박스 상태 값 저장
                    PreferenceManager.clear(mContext); //로그인 정보를 모두 날림
                }
            }
        }) ;


        sign_up = (Button) findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this, MainRegister.class);
                startActivity(intent);
            }
        });

        find = (Button) findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLogin.this, InformationFindActivity.class);
                startActivity(intent);
            }
        });
        //ImageButton BtnUser = (ImageButton)findViewById(R.id.BtnUser);
        ImageButton BtnReservation = (ImageButton) findViewById(R.id.BtnReservation);
        ImageButton BtnMap = (ImageButton) findViewById(R.id.BtnMap);
        ImageButton BtnEct = (ImageButton) findViewById(R.id.BtnEct);

        BtnReservation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "로그인 해주세용",
                        Toast.LENGTH_SHORT).show();
            }
        });

        BtnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "로그인 해주세용",
                        Toast.LENGTH_SHORT).show();
            }
        });

        BtnEct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "로그인 해주세용",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton BtnHome = (ImageButton) findViewById(R.id.BtnHome);
        BtnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "로그인 해주세용",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    String url ="http://www.stander-mcs.com/rest-login";

    class login extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s == null){
                Log.e("loginResult",s);
                Toast.makeText(mContext, "Server Error", Toast.LENGTH_SHORT).show();
            }
            else {
                Log.e("test",s);
                Gson gson = new Gson();
                MemberData data = gson.fromJson(s, MemberData.class); //GSON으로 변환
//                if(data.getCheck_in().equals("")){
                    Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                    intent.putExtra("mresult",data);
                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
//                }
            }


        }

        @Override
        protected String doInBackground(String... strings) {
            RequestBody formBody = new FormBody.Builder()
                    .add("username",strings[0])
                    .add("password",strings[1])
                    .build();


            //http://39.115.156.83:8080/rest-login?username=test&password=!@%23$asdf1234#$asfd1234
            //http://39.115.156.83:8080/rest-login?username=test&password=!@#  $asdf1234#$asfd1234
            //!@#$asdf1234
            //http://39.115.156.83:8080/rest-login

//            String makeUrl = url + "?username=" +  strings[0] + "&password=" + strings[1] + "#$asfd1234";
//            Log.e("url",makeUrl);
            Request request = new Request.Builder()
//                    .header("Content-Type","application/json")
//                    .header("Accept","application/json")
//                    .header("charset","utf-8")
                    .url(url)
                    .post(formBody)
                    .build();

            OkHttpClient client = new OkHttpClient();

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