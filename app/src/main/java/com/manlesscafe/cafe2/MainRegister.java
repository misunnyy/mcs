package com.manlesscafe.cafe2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainRegister extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText age;
    RadioGroup sex;
    Button register;
    //ImageButton BtnReturn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        findViews();
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String agestr = age.getText().toString().trim();
                String sexstr = ((RadioButton) MainRegister.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
                Log.i("TAG", name + "_" + pass + "_" + agestr + "_" + sexstr);
                UserService uService = new UserService(MainRegister.this);
                User user = new User();
                user.setUsername(name);
                user.setPassword(pass);
                user.setAge(Integer.parseInt(agestr));
                user.setSex(sexstr);
                uService.register(user);
                Toast.makeText(MainRegister.this, " 회원가입 성공 ", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainRegister.this,MainLogin.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        username=(EditText) findViewById(R.id.usernameRegister);
        password=(EditText) findViewById(R.id.passwordRegister);
        age=(EditText) findViewById(R.id.ageRegister);
        sex=(RadioGroup) findViewById(R.id.sexRegister);
        register=(Button) findViewById(R.id.Register);
    }

}