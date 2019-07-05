package com.dev.yazid.moviesubmission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dev.yazid.moviesubmission.model.Movie;

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

        Movie movie = getIntent().getParcelableExtra("MOVIE_DETAIL");

        setActionBarTitle(movie.getTitle());
        Glide.with(this).load(movie.getImage()).into(ivDataImage);
        tvTitle.setText(movie.getTitle());
        tvReleaseDate.setText(movie.getReleaseDate());
        tvDescription.setText(movie.getDescription());
        tvRating.setText(movie.getRating());
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
