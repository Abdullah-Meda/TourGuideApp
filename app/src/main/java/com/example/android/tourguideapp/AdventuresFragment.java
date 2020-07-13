package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AdventuresFragment extends Fragment {

    public AdventuresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        final ArrayList<Venue> venues = new ArrayList<>();
        venues.add(new Venue(getString(R.string.MOTIONGATE),
                getString(R.string.MOTIONGATE_emirate),
                getString(R.string.MOTIONGATE_description),
                getString(R.string.MOTIONGATE_website),
                getString(R.string.MOTIONGATE_phone),
                R.drawable.motion_gate));

        venues.add(new Venue(getString(R.string.Ferrari_World),
                getString(R.string.Ferrari_World_emirate),
                getString(R.string.Ferrari_World_description),
                getString(R.string.Ferrari_World_website),
                getString(R.string.Ferrari_World_phone),
                R.drawable.ferrari_world));

        venues.add(new Venue(getString(R.string.IMG),
                getString(R.string.IMG_emirate),
                getString(R.string.IMG_description),
                getString(R.string.IMG_website),
                getString(R.string.IMG_phone),
                R.drawable.img));

        venues.add(new Venue(getString(R.string.Legoland),
                getString(R.string.Legoland_emirate),
                getString(R.string.Legoland_description),
                getString(R.string.Legoland_website),
                getString(R.string.Legoland_phone),
                R.drawable.legoland));

        venues.add(new Venue(getString(R.string.Yas_Waterworld),
                getString(R.string.Yas_Waterworld_emirate),
                getString(R.string.Yas_Waterworld_description),
                getString(R.string.Yas_Waterworld_website),
                getString(R.string.Yas_Waterworld_phone),
                R.drawable.yas_waterworld));

        venues.add(new Venue(getString(R.string.Wild_Wadi_Waterpark),
                getString(R.string.Wild_Wadi_Waterpark_emirate),
                getString(R.string.Wild_Wadi_Waterpark_description),
                getString(R.string.Wild_Wadi_Waterpark_website),
                getString(R.string.Wild_Wadi_Waterpark_phone),
                R.drawable.wild_wadi));

        venues.add(new Venue(getString(R.string.Ice_Land_Water_Park),
                getString(R.string.Ice_Land_Water_Park_emirate),
                getString(R.string.Ice_Land_Water_Park_description),
                getString(R.string.Ice_Land_Water_Park_website),
                getString(R.string.Ice_Land_Water_Park_phone),
                R.drawable.ice_land_waterpark));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        VenueAdapter adapter = new VenueAdapter(getActivity(), venues);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent nowViewing = new Intent(getActivity(), NowViewing.class);
                Venue itemAtPosition = (Venue) adapter.getItemAtPosition(position);
                nowViewing.putExtra("nameOfVenue", itemAtPosition.getNameOfVenue());
                nowViewing.putExtra("nameOfEmirate", itemAtPosition.getNameOfEmirate());
                nowViewing.putExtra("description", itemAtPosition.getDescription());
                nowViewing.putExtra("webLink", itemAtPosition.getWebLink());
                nowViewing.putExtra("phone", itemAtPosition.getPhone());
                nowViewing.putExtra("imageResourceId", itemAtPosition.getImageResourceId());
                startActivity(nowViewing);
            }
        });

        return rootView;
    }

}