package com.manlesscafe.cafe2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.manlesscafe.cafe2.Data.MemberData;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainRegister extends AppCompatActivity {
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "phptest";

    private Context mContext;
    private EditText mEditTextName, mEditTextemail;
    private EditText mEditTextpassword;
    private EditText mEditTextusername;

    private Button button_main_insert;
    private TextView mTextViewResult;


    Button btn_Insert;
    EditText edit_Password;
    EditText edit_Name;
    EditText edit_Email;
    EditText edit_Username;
    TextView text_Password;
    TextView text_Name;
    TextView text_Email;
    TextView text_Username;

    long nowIndex;
    String password;
    String name;
    String username;
    String email;
    String sort = "userid";

    MemberData data;


    ArrayAdapter<String> arrayAdapter;

    static ArrayList<String> arrayIndex = new ArrayList<String>();
    static ArrayList<String> arrayData = new ArrayList<String>();
    private DBOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        text_Password = (TextView) findViewById(R.id.textView_main_password);
        text_Name = (TextView) findViewById(R.id.textView_main_name);
        text_Email = (TextView) findViewById(R.id.textView_email);
        text_Username = (TextView) findViewById(R.id.textView_username);


        mDbOpenHelper = new DBOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();

        //showDatabase(sort);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        mEditTextName = (EditText) findViewById(R.id.editText_main_name);
        mEditTextpassword = (EditText) findViewById(R.id.editText_main_password);
        mTextViewResult = (TextView) findViewById(R.id.textView_main_result);


        mEditTextemail = (EditText) findViewById(R.id.editText_email);
        mEditTextusername = (EditText) findViewById(R.id.editText_username);

        //dbHelper = new DatabaseHelper(this, 4);
        //db = dbHelper.getWritableDatabase();


        ImageButton BtnReturn = (ImageButton) findViewById(R.id.BtnReturn);
        BtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button buttonInsert = (Button) findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name =  mEditTextName.getText().toString();
                String password = mEditTextpassword.getText().toString();
                String email = mEditTextemail.getText().toString();
                String username = mEditTextusername.getText().toString();


                /*name = mEditTextName.getText().toString();
                mEditTextName.setText("");
                mEditTextpassword.setText("");
                mEditTextemail.setText("");
                mEditTextusername.setText("");

                mDbOpenHelper.open();
                mDbOpenHelper.insertColumn(name, password, email, username);
                //showDatabase(sort);
                //setInsertMode();
                mEditTextName.requestFocus();
                mEditTextName.setCursorVisible(true);*/

                //new register().execute(name,password,email,username);

                if (username.getBytes().length <= 0) {
                    Toast.makeText(getApplicationContext(), " 이름를 입력하세요.", Toast.LENGTH_LONG).show();
                } else if (name.getBytes().length <= 0) {
                    Toast.makeText(getApplicationContext(), " 아이디을 입력하세요.", Toast.LENGTH_LONG).show();
                } else if (password.getBytes().length <= 0) {
                    Toast.makeText(getApplicationContext(), " 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                } else if (email.getBytes().length <= 0) {
                    Toast.makeText(getApplicationContext(), " 이메일를 입력하세요.", Toast.LENGTH_LONG).show();
                } else {
                    new register().execute(name,password,email,username);
                    Toast.makeText(getApplicationContext(), "id : " + name + " 님의 회원가입이 완료 되었습니다.", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainRegister.this, MainLogin.class);
                    //Intent intent1;
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });

    }

    public void setInsertMode() {
        mEditTextpassword.setText("");
        mEditTextName.setText("");
        mEditTextemail.setText("");
        mEditTextusername.setText("");
    }
    String url = "http://www.stander-mcs.com/rest_join";

    class register extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s == null) {
                Toast.makeText(mContext, "Server Error", Toast.LENGTH_SHORT).show();
                Log.e("dpfj", s);
            } else {
                Log.e("test", s);
                Gson gson = new Gson();
                MemberData data = gson.fromJson(s, MemberData.class); //GSON으로 변환
                //                if(data.getCheck_in().equals("")){
                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                intent.putExtra("test", data);
                startActivity(intent);
                //                }
                //                else{
                //                    Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
                //                }
            }

        }
        @Override
        protected String doInBackground(String... strings){
            RequestBody formBody = new FormBody.Builder()
                    .add("username",strings[0])
                    .add("password",strings[1])
                    .add("email",strings[2])
                    .add("name",strings[3])
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