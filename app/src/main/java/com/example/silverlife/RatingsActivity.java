package com.example.silverlife;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RatingsActivity extends AppCompatActivity {

    private LinearLayout reviewsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        reviewsContainer = findViewById(R.id.reviews_container);

        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RatingsActivity.this, ProfileActivity.class);
                intent.putExtra("userName", "Fernanda");
                startActivity(intent);
                finish();
            }
        });

        loadReviews();
    }

    private void loadReviews() {
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(new Review("Vinicius", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum...."));
        reviewList.add(new Review("Julia", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum...."));
        reviewList.add(new Review("Lucia", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum...."));
        reviewList.add(new Review("Carlos", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum...."));

        populateReviews(reviewList);
    }

    private void populateReviews(List<Review> reviews) {
        for (Review review : reviews) {
            LinearLayout reviewView = new LinearLayout(this);
            reviewView.setOrientation(LinearLayout.VERTICAL);
            reviewView.setPadding(8, 8, 8, 8);

            LinearLayout reviewHeader = new LinearLayout(this);
            reviewHeader.setOrientation(LinearLayout.HORIZONTAL);

            TextView reviewUserName = new TextView(this);
            reviewUserName.setText(review.getUserName());
            reviewUserName.setTextSize(16);
            reviewUserName.setTypeface(null, Typeface.BOLD);

            ImageView likeIcon = new ImageView(this);
            likeIcon.setImageResource(R.drawable.ic_thumb_up);
            LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(40, 40);
            iconParams.setMargins(8, 0, 0, 0);  // Margin to add space between name and icon
            likeIcon.setLayoutParams(iconParams);

            reviewHeader.addView(reviewUserName);
            reviewHeader.addView(likeIcon);

            TextView reviewText = new TextView(this);
            reviewText.setText(review.getText());
            reviewText.setTextSize(14);
            reviewText.setPadding(8, 8, 8, 0);

            reviewView.addView(reviewHeader);
            reviewView.addView(reviewText);

            reviewsContainer.addView(reviewView);
        }
    }
}
