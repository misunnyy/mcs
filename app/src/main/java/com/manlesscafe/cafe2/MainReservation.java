package com.manlesscafe.cafe2;

import android.app.Activity;
import android.app.ProgressDialog;
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainReservation extends Activity {
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "db";

    Button btnchoice;
    TextView selectnum;

    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.reservation_main);

        btnchoice = (Button) findViewById(R.id.BtnChoice);
        selectnum = (TextView)findViewById(R.id.selectnum);

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

        /*Button selectedBtn1 = findViewById(R.id.BtnTable1);
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
        Button selectedBtn19 = findViewById(R.id.BtnTable19);*/

        Button[] numButtons = new Button[19];
        Integer[] numBtnIDs = { R.id.BtnTable1,R.id.BtnTable2,R.id.BtnTable3,R.id.BtnTable4,R.id.BtnTable5,
                R.id.BtnTable6,R.id.BtnTable7,R.id.BtnTable8,
                R.id.BtnTable9,R.id.BtnTable10, R.id.BtnTable11,R.id.BtnTable12,
                R.id.BtnTable13, R.id.BtnTable14, R.id.BtnTable15,R.id.BtnTable16,R.id.BtnTable17,R.id.BtnTable18,R.id.BtnTable19};

        final boolean[] selected = {false};

        for(int i=0;i<numButtons.length;i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (index < 19) {
                        selectnum.setText((index + 1) + "번"); //버튼 번호를 받아와 띄움
                        selectnum.setTextColor(Color.BLUE);
                        //numButtons.setSelected(Color.BLUE);
                        //Toast.makeText(getApplicationContext(), (index+1)+"번 좌석을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
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
                else {
                    String seatnum = selectnum.getText().toString();

                    InsertData task = new InsertData();
                    task.execute("http://" + IP_ADDRESS + "/seatinsert.php", seatnum);

                    Intent intent = new Intent(MainReservation.this, MainMypage.class);
                    intent.putExtra("selectseat",seatnum);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "예약완료", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BtnUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
            }
        });
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainReservation.this,
                    "Please Wait", null, true, true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            //String id = (String)params[1];
            //String check_in = (String)params[2];
            //String check_out = (String)params[3];
            //String present_use = (String)params[4];
            String seat_num = (String)params[1];
            //String member_id = (String)params[6];

            String serverURL = (String)params[0];
            String postParameters = "&seatnum=" + seat_num;

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