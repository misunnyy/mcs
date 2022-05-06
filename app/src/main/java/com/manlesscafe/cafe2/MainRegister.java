package com.manlesscafe.cafe2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainRegister extends AppCompatActivity {
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "phptest";

    private EditText mEditTextName,mEditTextemail;
    private EditText mEditTextpassword, mEditTextphone;
    private EditText mEditTextusername, mEditTextage, mEditTextgender;

    private Button button_main_insert;
    private TextView mTextViewResult;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        mEditTextName = (EditText)findViewById(R.id.editText_main_name);
        mEditTextpassword = (EditText)findViewById(R.id.editText_main_password);
        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);
        mEditTextphone = (EditText)findViewById(R.id.editText_phone);

        mEditTextemail = (EditText)findViewById(R.id.editText_email);
        mEditTextusername = (EditText)findViewById(R.id.editText_username);
        mEditTextage = (EditText)findViewById(R.id.editText_age);
        mEditTextgender = (EditText)findViewById(R.id.editText_gender);



        mTextViewResult.setMovementMethod(new ScrollingMovementMethod());


        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mEditTextName.getText().toString();
                String password = mEditTextpassword.getText().toString();
                String phone = mEditTextphone.getText().toString();
                String email = mEditTextemail.getText().toString();
                String username = mEditTextusername.getText().toString();
                String age = mEditTextage.getText().toString();
                String gender = mEditTextgender.getText().toString();

                InsertData task = new InsertData();
                task.execute("http://" + IP_ADDRESS + "/insert.php", name,password,phone,email,username,age,gender);

                name = mEditTextName.getText().toString();
                mEditTextName.setText("");
                mEditTextpassword.setText("");
                mEditTextphone.setText("");
                mEditTextemail.setText("");
                mEditTextusername.setText("");
                mEditTextage.setText("");
                mEditTextgender.setText("");

                Toast.makeText(getApplicationContext(), "id : "+name +" 님의 회원가입이 완료 되었습니다.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainRegister.this, MainLogin.class);
                startActivity(intent);
            }
        });

    }



    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainRegister.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String name = (String)params[1];
            String password = (String)params[2];
            String phone = (String)params[3];
            String email = (String)params[4];
            String username = (String)params[5];
            String age = (String)params[6];
            String gender = (String)params[7];

            String serverURL = (String)params[0];
            String postParameters = "name=" + name + "&password=" + password +"&phone="+phone +"&email=" + email +"&username=" + username +"&age=" + age +"&gender=" + gender;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }

}