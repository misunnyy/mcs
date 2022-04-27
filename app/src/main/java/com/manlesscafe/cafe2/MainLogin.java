package com.manlesscafe.cafe2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        findViews();
    }
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    private void findViews() {
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        register=(Button) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                System.out.println(name);
                String pass=password.getText().toString();
                System.out.println(pass);

                Log.i("TAG",name+"_"+pass);
                UserService uService=new UserService(MainLogin.this);
                boolean flag=uService.login(name, pass);

                if(flag){
                    Log.i("TAG"," 로그인 성공");
                    Toast.makeText(MainLogin.this, " 로그인 성공 ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainLogin.this,MainMypage.class);
                    startActivity(intent);
                }else{
                    Log.i("TAG"," 로그인 실패");
                    Toast.makeText(MainLogin.this, " 로그인 실패 ", Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(MainLogin.this,MainRegister.class);
                startActivity(intent);
            }
        });
    }
}