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
            profileDescription.setText("Lorem ipsum dolor sit amet. Ab magnam ipsa ab eligendi quis eum sunt tenetur et magni nostrum At odit quaerat et molestiae deserunt et unde eveniet. Aut officia perspiciatis qui " +
                    "molestias fuga aut iure similique sed tempora doloribus vel doloremque dignissimos. Sed laudantium accusamus ut ullam quidem qui labore saepe ut magnam commodi ut sunt alias.\n" +
                    "Vel magnam voluptatem non omnis explicabo ut impedit. Aut deserunt saepe non beatae reiciendis qui sint veritatis. Qui ratione velit ut galisum impedit cum nihil deleniti id voluptatem voluptas ea iusto dicta.\n" +
                    "\n");
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
        intent.putExtra("userName", "Fernanda");
        startActivity(intent);
    }

    private void goToAppointment() {
        Intent intent = new Intent(ProfileActivity.this, ScheduleActivity.class);
        intent.putExtra("userName", "Fernanda");
        startActivity(intent);
    }
}
