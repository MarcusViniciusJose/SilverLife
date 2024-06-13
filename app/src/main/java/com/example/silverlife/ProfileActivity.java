package com.example.silverlife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView backArrow = findViewById(R.id.back_button);
        TextView profileName = findViewById(R.id.profile_name);
        TextView profileProfession = findViewById(R.id.profile_profession);
        TextView profileDescription = findViewById(R.id.profile_description);
        Button reviewsButton = findViewById(R.id.ratings_button);
        Button appointmentButton = findViewById(R.id.schedule_button);


        String userName = getIntent().getStringExtra("userName");


        if (userName != null && userName.equals("Fernanda")) {
            profileName.setText("Fernanda");
            profileProfession.setText("Enfermeira");
            profileDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        } else {
            profileName.setText("Nome não encontrado");
            profileProfession.setText("Profissão não disponível");
            profileDescription.setText("Descrição não disponível");
        }

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToHome();
            }
        });

        reviewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReviews();
            }
        });

        appointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAppointment();
            }
        });
    }

    private void goBackToHome() {
        startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
        finish();
    }

    private void goToReviews() {
        Intent intent = new Intent(ProfileActivity.this, RatingsActivity.class);
        intent.putExtra("userName", "Fernanda"); // Passe o nome do usuário para a próxima atividade
        startActivity(intent);
    }

    private void goToAppointment() {
        Intent intent = new Intent(ProfileActivity.this, ScheduleActivity.class);
        intent.putExtra("userName", "Fernanda"); // Passe o nome do usuário para a próxima atividade
        startActivity(intent);
    }
}
