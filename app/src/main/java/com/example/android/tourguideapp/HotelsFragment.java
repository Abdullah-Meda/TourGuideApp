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


public class HotelsFragment extends Fragment {

    public HotelsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        final ArrayList<Venue> venues = new ArrayList<>();
        venues.add(new Venue(getString(R.string.One_Only_The_Palm),
                getString(R.string.One_Only_The_Palm_emirate),
                getString(R.string.One_Only_The_Palm_description),
                getString(R.string.One_Only_The_Palm_website),
                getString(R.string.One_Only_The_Palm_phone),
                R.drawable.one_only_the_palm));

        venues.add(new Venue(getString(R.string.Raffles),
                getString(R.string.Raffles_emirate),
                getString(R.string.Raffles_description),
                getString(R.string.Raffles_website),
                getString(R.string.Raffles_phone),
                R.drawable.raffles));

        venues.add(new Venue(getString(R.string.Address_Dubai_Marina),
                getString(R.string.Address_Dubai_Marina_emirate),
                getString(R.string.Address_Dubai_Marina_description),
                getString(R.string.Address_Dubai_Marina_website),
                getString(R.string.Address_Dubai_Marina_phone),
                R.drawable.address_dubai_marina));

        venues.add(new Venue(getString(R.string.The_Oberoi),
                getString(R.string.The_Oberoi_emirate),
                getString(R.string.The_Oberoi_description),
                getString(R.string.The_Oberoi_website),
                getString(R.string.The_Oberoi_phone),
                R.drawable.the_oberoi));

        venues.add(new Venue(getString(R.string.The_H),
                getString(R.string.The_H_emirate),
                getString(R.string.The_H_description),
                getString(R.string.The_H_website),
                getString(R.string.The_H_phone),
                R.drawable.the_h));


        VenueAdapter adapter = new VenueAdapter(getActivity(), venues);

        ListView listView = rootView.findViewById(R.id.list);

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