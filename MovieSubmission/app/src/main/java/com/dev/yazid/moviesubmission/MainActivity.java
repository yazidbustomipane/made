package com.dev.yazid.moviesubmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dev.yazid.moviesubmission.adapater.ListMovieAdapter;
import com.dev.yazid.moviesubmission.model.Movie;
import com.dev.yazid.moviesubmission.model.MovieData;
import com.dev.yazid.moviesubmission.onclick.ItemClickSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMovie;
    private ArrayList<Movie> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovie = findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        setActionBarTitle("Nonton Skuy!");
        list.addAll(MovieData.getListData());
        showRecycleList();
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    public void showRecycleList(){
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(this);
        listMovieAdapter.setListMovie(list);
        rvMovie.setAdapter(listMovieAdapter);

        ItemClickSupport.addTo(rvMovie).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMovie(list.get(position));
            }
        });

        ItemClickSupport.addTo(rvMovie).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMovie(list.get(position));
                return true;
            }
        });
    }

    private void showSelectedMovie(Movie movie) {
        Toast.makeText(this, "Kamu memilih " + movie.getTitle(), Toast.LENGTH_SHORT).show();
        Intent moveWithDataIntent = new Intent(MainActivity.this, DetailActivity.class);

        moveWithDataIntent.putExtra("MOVIE_DETAIL",movie);
        startActivity(moveWithDataIntent);
    }
}
