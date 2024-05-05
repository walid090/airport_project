package com.example.airport_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import DataBase.DbHandler;

public class Dashbord extends AppCompatActivity {
    private CardView updateButton,LogoutButton,butonNavigation;
    private  int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        butonNavigation=findViewById(R.id.buttonNavigation);
        butonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendToNavigation();
            }
        });


        LogoutButton=findViewById(R.id.LogoutButton);
        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendToLogin();
            }
        });

        updateButton=findViewById(R.id.UpdateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendToUpdate();
            }
        });

    }

    private void SendToUpdate(){
        Intent intent=new Intent(Dashbord.this,UpdateProfile.class);
        startActivity(intent);
    }
    private void SendToLogin(){
        Intent intent=new Intent(Dashbord.this,Login.class);
        startActivity(intent);
    }
    private void SendToNavigation(){
        Intent intent=new Intent(Dashbord.this,Navigation.class);
        startActivity(intent);
    }

}