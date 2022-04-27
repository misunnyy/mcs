package com.manlesscafe.cafe2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;

public class MainReservation extends Activity {

    Button btnchoice;

    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.reservation_main);

        btnchoice = (Button) findViewById(R.id.BtnChoice);

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

        ImageButton BtnMap = (ImageButton) findViewById(R.id.BtnMap);
        BtnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainMap.class);
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



        final int[19] selected = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
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

        selectedBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn1.setSelected(false);
                    selected[0] = false;
                    selectedBtn2.setEnabled(true);
                }
                else{
                    selectedBtn1.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                }
            }
        });

        //Button selectedBtn2 = findViewById(R.id.BtnTable2);
        selectedBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn2.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn2.setSelected(true);
                    selected[0] = true;
                }
            }
        });


        selectedBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn3.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn3.setSelected(true);
                    selected[0] = true;
                }
            }
        });

        selectedBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn4.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn4.setSelected(true);
                    selected[0] = true;
                }
            }
        });

        selectedBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn5.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn5.setSelected(true);
                    selected[0] = true;
                }
            }
        });

        selectedBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn6.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn6.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn7 = findViewById(R.id.BtnTable7);
        selectedBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn7.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn7.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn8 = findViewById(R.id.BtnTable8);
        selectedBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn8.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn8.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn9 = findViewById(R.id.BtnTable9);
        selectedBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn9.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn9.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn10 = findViewById(R.id.BtnTable10);
        selectedBtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn10.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn10.setSelected(true);
                    selected[0] = true;
                }
            }
        });

        //Button selectedBtn11 = findViewById(R.id.BtnTable11);
        selectedBtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn11.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn11.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn12 = findViewById(R.id.BtnTable12);
        selectedBtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn12.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn12.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn13 = findViewById(R.id.BtnTable13);
        selectedBtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn13.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn13.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn14 = findViewById(R.id.BtnTable14);
        selectedBtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn14.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn14.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn15 = findViewById(R.id.BtnTable15);
        selectedBtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn15.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn15.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn16 = findViewById(R.id.BtnTable16);
        selectedBtn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn16.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn16.setSelected(true);
                    selected[0] = true;
                }
            }
        });

        //Button selectedBtn17 = findViewById(R.id.BtnTable17);
        selectedBtn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn17.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn17.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn18 = findViewById(R.id.BtnTable18);
        selectedBtn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn18.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn18.setSelected(true);
                    selected[0] = true;
                }
            }
        });
        //Button selectedBtn19 = findViewById(R.id.BtnTable19);
        selectedBtn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn19.setSelected(false);
                    selected[0] = false;
                }
                else{
                    selectedBtn19.setSelected(true);
                    selected[0] = true;
                }
            }
        });


        Button BtnChoice = (Button) findViewById(R.id.BtnChoice);
        BtnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
                startActivity(intent);
            }
        });

    }
}