package com.dev.yazid.moviesubmission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView ivDataImage;
    TextView tvTitle, tvReleaseDate, tvDescription, tvRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivDataImage = findViewById(R.id.img_detail);
        tvTitle = findViewById(R.id.tv_data_title);
        tvReleaseDate = findViewById(R.id.tv_data_date_release);
        tvDescription = findViewById(R.id.tv_data_description);
        tvRating = findViewById(R.id.tv_data_rating);

        String img = getIntent().getParcelableExtra("image");
        String title = getIntent().getParcelableExtra("title");
        String release_date = getIntent().getParcelableExtra("release_date");
        String description = getIntent().getParcelableExtra("description");
        String rating = getIntent().getParcelableExtra("rating");

        setActionBarTitle(title);
        Glide.with(this).load(img).into(ivDataImage);
        tvTitle.setText(title);
        tvReleaseDate.setText(release_date);
        tvDescription.setText(description);
        tvRating.setText(rating);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
