package com.example.android.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class VenueAdapter extends ArrayAdapter<Venue> {

    public VenueAdapter(Context context, ArrayList<Venue> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Venue currentWord = getItem(position);

        TextView destinationTextView = (TextView) listItemView.findViewById(R.id.destination_text_view);
        destinationTextView.setText(currentWord.getNameOfVenue());

        TextView detailsTextView = (TextView) listItemView.findViewById(R.id.details_text_view);
        detailsTextView.setText(currentWord.getNameOfEmirate());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentWord.getImageResourceId());

        return listItemView;
    }
}
