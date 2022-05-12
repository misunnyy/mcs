package com.manlesscafe.cafe2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ImageButton BtnUser = (ImageButton)findViewById(R.id.BtnUser);
        ImageButton BtnReservation = (ImageButton) findViewById(R.id.BtnReservation);
        ImageButton BtnMap = (ImageButton)findViewById(R.id.BtnMap);
        ImageButton BtnEct = (ImageButton)findViewById(R.id.BtnEct);

        BtnUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
            }
        });

        BtnReservation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainReservation.class);
                startActivity(intent);
            }
        });

        BtnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
                startActivity(intent);
            }
        });

        BtnEct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainEct.class);
                startActivity(intent);
            }
        });

        //myHelper = new myDBHelper(this);


       // BtnJoin.setOnClickListener(new View.OnClickListener(){
            //public void onClick(View v){
               // sqIDB = myHelper.getWritableDatabase();
               // sqIDB.execSQL("INSERT INTO groupTBL VALUES('"+edtName.getText().toString()+"',"+edtNumber.getText().toString()+"," +"'"+edtID.getText().toString()+"','"+edtPW.getText().toString()+"');");

               // edtName.setText("");
                //edtNumber.setText("");
               // sqIDB.close();
                //Toast.makeText(getApplicationContext(),"입력됨", Toast.LENGTH_SHORT).show();
           // }
       // });
    }

}