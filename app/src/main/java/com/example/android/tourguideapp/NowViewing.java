package com.example.android.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowViewing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_viewing);

        Intent intent = getIntent();

        String nameOfVenue = intent.getStringExtra("nameOfVenue");
        String nameOfEmirate = intent.getStringExtra("nameOfEmirate");
        String description = intent.getStringExtra("description");
        String webLink = intent.getStringExtra("webLink");
        String phone = intent.getStringExtra("phone");
        int imageResourceId = intent.getIntExtra("imageResourceId", R.drawable.motiongate);

        TextView nameOfVenueView = findViewById(R.id.now_viewing_venue_text_view);
        TextView detailsView = findViewById(R.id.now_viewing_details_text_view);
        TextView descriptionView = findViewById(R.id.now_viewing_description_text_view);
        TextView webLinkView = findViewById(R.id.now_viewing_weblink_text_view);
        TextView phoneView = findViewById(R.id.now_viewing_phone_text_view);
        ImageView imageView = findViewById(R.id.now_viewing_image_view);

        nameOfVenueView.setText(nameOfVenue);
        detailsView.setText(nameOfEmirate);
        descriptionView.setText(description);
        webLinkView.setText(webLink);
        phoneView.setText(phone);
        imageView.setImageResource(imageResourceId);
    }
}