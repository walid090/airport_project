package com.example.airport_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Navigation extends AppCompatActivity {
    public ImageView  imageView;
    public CardView DvorButton,DmeButton,InstrementButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        InstrementButton=findViewById(R.id.buttonInstrement);
        InstrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendToListls();
            }
        });


        DmeButton=findViewById(R.id.DMEButton);
        DmeButton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             goDme();
                                         }
                                     });

        DvorButton=findViewById(R.id.DvorButton);
        DvorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            goDvor();
            }
        });
        imageView = findViewById(R.id.goback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }
        public void  goBack(){
            Intent intent = new Intent(Navigation.this,Dashbord.class);
            startActivity(intent);
        }

        public void goDvor(){
            Intent intent = new Intent(Navigation.this,Article_vor.class);
            startActivity(intent);
        }
        public void goDme(){
                Intent intent = new Intent(Navigation.this,Article_dme.class);
                startActivity(intent);
        }
        public void    SendToListls(){
            Intent intent = new Intent(Navigation.this,list_ils.class);
            startActivity(intent);
        }
}
