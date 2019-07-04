package com.dev.yazid.moviesubmission.onclick;

import android.view.View;

public class CustomOnItemClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;
    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback){
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    public void onClick(View view){
        onItemClickCallback.onItemClicked(view, position);
    }

}
