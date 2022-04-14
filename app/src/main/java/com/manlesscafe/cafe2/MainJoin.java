package com.manlesscafe.cafe2;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainJoin extends Activity {

    private myDBHelper userDatabaseHelper;
    public static final String TABLE_NAME = "User";
    SQLiteDatabase database;
    Button BtnInsert, BtnSel, BtnDel;
    EditText edtID, edtPW;
    //EditText username, edtID, edtPW, phonenum, personnum_front, personnum_back;
    TextView textView;

    public void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.join_main);


        BtnInsert = findViewById(R.id.BtnInsert);
        BtnSel = findViewById(R.id.BtnSel);
        BtnDel = findViewById(R.id.BtnDel);
        textView = findViewById(R.id.textView);

        //username = findViewById(R.id.username);
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        //phonenum = findViewById(R.id.phonenum);
        //personnum_front = findViewById(R.id.personnum_front);
        //personnum_back = findViewById(R.id.personnum_back);

        BtnSel.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { selectData(TABLE_NAME);
            }
        });

        userDatabaseHelper = myDBHelper.getInstance(this);

        BtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = userDatabaseHelper.getWritableDatabase();
                //String Username = username.getText().toString().trim();
                String id = edtID.getText().toString().trim();
                String password = edtPW.getText().toString().trim();
                //String Phonenum = phonenum.getText().toString().trim();
                //String Personnum_front = personnum_front.getText().toString().trim();
                //String Personnum_back = personnum_back.getText().toString().trim();

                //insertData(Username, id, password, Phonenum, Personnum_front, Personnum_back);
                insertData(id, password);
                userDatabaseHelper.onUpgrade(database,1,2);
                database.close();
            }
        });

        ImageButton BtnReturn = (ImageButton) findViewById(R.id.BtnReturn);
        BtnReturn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v){
                finish();
            }
        });

    }

    private void deleteData(String id) {
        if (database != null) {
            String sql = "DELETE FROM user WHERE id=?";
            Object[] params = {id};
            database.execSQL(sql, params);
        }
    }
    private void selectData(String tableName) {
        if (database != null) {
            String sql = "SELECT id, password FROM " + tableName;
            Cursor cursor = database.rawQuery(sql, null);
            println("데이터 갯수 : " + cursor.getCount());
            for (int i = 0; i <cursor.getCount();
                 i++) { cursor.moveToNext();

                String id = cursor.getString(0);
                String password = cursor.getString(1);

                println("[" + i + "] ID : " + id +", PASSWORD : " + password);
            }
            cursor.close();
        } }
    private void insertData(String id, String password) {
        if (database != null)
        {
            String sql = "INSERT INTO user(id, password) " +
                    "VALUES(?, ?)";
            Object[] params = {id, password};
            database.execSQL(sql, params);
        }
    }
    /*private void selectData(String tableName) {
        if (database != null) {
            String sql = "SELECT Username, id, password, Phonenum, Personnum_front, Personnum_back FROM " + tableName;
            Cursor cursor = database.rawQuery(sql, null);
            println("데이터 갯수 : " + cursor.getCount());
            for (int i = 0; i <cursor.getCount();
                 i++) { cursor.moveToNext();
                String Username = cursor.getString(0);
                String id = cursor.getString(1);
                String password = cursor.getString(2);
                String Phonenum = cursor.getString(3);
                String Personnum_front = cursor.getString(4);
                String Personnum_back = cursor.getString(5);
                println("[" + i + "] Username : " + Username + ", ID : " + id +", PASSWORD : " + password + ", Phonenum : " + Phonenum + ", Personnum_front : " + Personnum_front + ", Personnum_back : " + Personnum_back);
            }
            cursor.close();
        } }


    private void insertData(String Username, String id, String password, String Phonenum, String Personnum_front, String Personnum_back) {
        if (database != null)
        {
            String sql = "INSERT INTO user(Username, id, password, Phonenum, Personnum_front, Personnum_back) " +
                    "VALUES(?, ?)";
            Object[] params = {Username, id, password, Phonenum, Personnum_front, Personnum_back};
            database.execSQL(sql, params);
        }
    }*/
    public void println (String data) {
        textView.append(data + "\n");
    }

    @Override protected void onDestroy() {
        userDatabaseHelper.close();
        super.onDestroy();
    }


}
