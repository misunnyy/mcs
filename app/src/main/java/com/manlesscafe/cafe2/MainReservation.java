package com.manlesscafe.cafe2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;

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



        final boolean[] selected = {false};
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
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);

                }
                else{
                    selectedBtn1.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn1.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn2.setSelected(true);
                    selected[0] = true;
                    selectedBtn1.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
                }
            }
        });


        selectedBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn3.setSelected(false);
                    selected[0] = false;
                    selectedBtn2.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn3.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
                }
            }
        });

        selectedBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn4.setSelected(false);
                    selected[0] = false;
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn4.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
                }
            }
        });

        selectedBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn5.setSelected(false);
                    selected[0] = false;
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn5.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
                }
            }
        });

        selectedBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    selectedBtn6.setSelected(false);
                    selected[0] = false;
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn6.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn7.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn8.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn9.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn10.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn11.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn12.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn13.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn14.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn15.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn16.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn17.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                    selectedBtn19.setEnabled(true);
                }
                else{
                    selectedBtn18.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                    selectedBtn19.setEnabled(false);
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
                    selectedBtn2.setEnabled(true);
                    selectedBtn3.setEnabled(true);
                    selectedBtn4.setEnabled(true);
                    selectedBtn5.setEnabled(true);
                    selectedBtn6.setEnabled(true);
                    selectedBtn7.setEnabled(true);
                    selectedBtn8.setEnabled(true);
                    selectedBtn9.setEnabled(true);
                    selectedBtn10.setEnabled(true);
                    selectedBtn11.setEnabled(true);
                    selectedBtn12.setEnabled(true);
                    selectedBtn13.setEnabled(true);
                    selectedBtn14.setEnabled(true);
                    selectedBtn15.setEnabled(true);
                    selectedBtn16.setEnabled(true);
                    selectedBtn17.setEnabled(true);
                    selectedBtn18.setEnabled(true);
                    selectedBtn1.setEnabled(true);
                }
                else{
                    selectedBtn19.setSelected(true);
                    selected[0] = true;
                    selectedBtn2.setEnabled(false);
                    selectedBtn3.setEnabled(false);
                    selectedBtn4.setEnabled(false);
                    selectedBtn5.setEnabled(false);
                    selectedBtn6.setEnabled(false);
                    selectedBtn7.setEnabled(false);
                    selectedBtn8.setEnabled(false);
                    selectedBtn9.setEnabled(false);
                    selectedBtn10.setEnabled(false);
                    selectedBtn11.setEnabled(false);
                    selectedBtn12.setEnabled(false);
                    selectedBtn13.setEnabled(false);
                    selectedBtn14.setEnabled(false);
                    selectedBtn15.setEnabled(false);
                    selectedBtn16.setEnabled(false);
                    selectedBtn17.setEnabled(false);
                    selectedBtn18.setEnabled(false);
                    selectedBtn1.setEnabled(false);
                }
            }
        });


        Button BtnChoice = (Button) findViewById(R.id.BtnChoice);
        BtnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selected[0]) {
                    Intent intent = new Intent(getApplicationContext(), TicketBuyActivity.class);
                    startActivity(intent);
                }
                else  {
                    Toast.makeText(getApplicationContext(), "좌석을 선택하세요", Toast.LENGTH_LONG).show();
                }}
        });

    }
}