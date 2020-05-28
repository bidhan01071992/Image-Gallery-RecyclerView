package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView imageTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_details);
        Resource imageResource = (Resource) getIntent().getSerializableExtra("Image");
        imageView = findViewById(R.id.imageViewDetails);
        imageTitle = findViewById(R.id.photoTitleDetails);
        imageView.setImageResource(imageResource.getGalleryImageId());
        imageTitle.setText(imageResource.getTitle());
    }
}
