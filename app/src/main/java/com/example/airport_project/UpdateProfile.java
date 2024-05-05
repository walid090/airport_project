package com.example.airport_project;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import DataBase.DbHandler;
import entity.User;

public class UpdateProfile extends AppCompatActivity {
    private DbHandler dbHandler;
    public User user =new User();
    private ArrayList<User> users=new ArrayList<>();
    public EditText user_name ,password,phone,email;
    public Button updatebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        dbHandler = new DbHandler(UpdateProfile.this);
        user_name=findViewById(R.id.user_name);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone_number);
        email=findViewById(R.id.email);
        SetUpData();

        updatebutton=findViewById(R.id.UpdateButton);
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });
    }
    private void  SetUpData(){
        users = dbHandler.readUserById(Login.id);
        password.setText(users.get(0).getPassword());
        user_name.setText(users.get(0).getUser_name());
        email.setText(users.get(0).getEmail());
        phone.setText(users.get(0).getPhone_number());
    }
    private void  update(){
        User user1 =new User(Login.id,user_name.getText().toString(),
                password.getText().toString(),phone.getText().toString(),email.getText().toString());
        dbHandler.UpdateUser(user1);
            SendToDashbord();
    }
   public void SendToDashbord(){
       Intent intent=new Intent(this,Dashbord.class);
       startActivity(intent);
   }

}