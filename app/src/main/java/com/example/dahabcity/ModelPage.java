package com.example.dahabcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class ModelPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_page);
        ImageView imageView = findViewById(R.id.imageView);
        TextView title = findViewById(R.id.title_TV);
        TextView description = findViewById(R.id.description_TV);
        imageView.setImageResource(Objects.requireNonNull(getIntent().getExtras()).getInt(getString(R.string.image_key)));
        title.setText(getIntent().getExtras().getString(getResources().getString(R.string.title_key)));
        description.setText(getIntent().getExtras().getString(getResources().getString(R.string.description_key)));
    }
}