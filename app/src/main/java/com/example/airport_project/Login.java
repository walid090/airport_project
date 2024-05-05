package com.example.airport_project;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import DataBase.DbHandler;

public class Login extends AppCompatActivity {
    private Button loginButton;
    private EditText user_nameEdt, passwordEdt;
    private DbHandler dbHandler;
    public static int id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.loginButton);
        user_nameEdt=findViewById(R.id.username);
        passwordEdt=findViewById(R.id.password);
        dbHandler = new DbHandler(Login.this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Authetification();
            }
        });

}

public void Authetification(){
    String user_name=user_nameEdt.getText().toString();
    String password=passwordEdt.getText().toString();
    int test = dbHandler.Auth(user_name,password);
    id=test;
     if(test!=0){
         //SaveId(test);
         SendToDashbord( test);
     }
     else Toast.makeText(Login.this, "password or username incorrect", android.widget.Toast.LENGTH_SHORT).show();
    }
public void SendToDashbord(int id){
    Intent intent=new Intent(Login.this,Dashbord.class);
    intent.putExtra("id",id);
    startActivity(intent);
}
/*public  void SaveId(int id){
    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Login.this);
    SharedPreferences.Editor myEditor = myPreferences.edit();
    myEditor.putInt("id", id);
    //int age = myPreferences.getInt("AGE", 0);
}*/

}