package com.dev.yazid.moviesubmission.adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dev.yazid.moviesubmission.R;
import com.dev.yazid.moviesubmission.model.Movie;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.MovieViewHolder> {
    private Context context;

    public ListMovieAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Movie> listMovie;

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_movie, parent, false);
        return new MovieViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getListMovie().get(position).getTitle());
        holder.tvDateRelease.setText(getListMovie().get(position).getReleaseDate());
        holder.tvRating.setText(getListMovie().get(position).getRating());
        holder.tvDescription.setText(getListMovie().get(position).getDescription());
        Glide.with(context)
                .load(getListMovie().get(position).getImage())
                .apply(new RequestOptions().override(100,120))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvTitle, tvDateRelease, tvDescription, tvRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDateRelease = itemView.findViewById(R.id.tv_item_date_release);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
        }
    }
}
