package com.example.silverlife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView fernandaArrow = findViewById(R.id.arrow_1);
        ImageView heloArrow = findViewById(R.id.arrow_2);
        ImageView joseArrow = findViewById(R.id.arrow_3);

        fernandaArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile("Fernanda");
            }
        });


    }

    private void openProfile(String userName) {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }
}
