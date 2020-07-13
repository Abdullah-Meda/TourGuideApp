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


public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        final ArrayList<Venue> venues = new ArrayList<>();
        venues.add(new Venue(getString(R.string.Burj_Khalifa),
                getString(R.string.Burj_Khalifa_emirate),
                getString(R.string.Burj_Khalifa_description),
                getString(R.string.Burj_Khalifa_website),
                getString(R.string.Burj_Khalifa_phone),
                R.drawable.burj_khalifa));

        venues.add(new Venue(getString(R.string.Burj_Al_Arab),
                getString(R.string.Burj_Al_Arab_emirate),
                getString(R.string.Burj_Al_Arab_description),
                getString(R.string.Burj_Al_Arab_website),
                getString(R.string.Burj_Al_Arab_phone),
                R.drawable.burj_al_arab));

        venues.add(new Venue(getString(R.string.The_Dubai_Mall),
                getString(R.string.The_Dubai_Mall_emirate),
                getString(R.string.The_Dubai_Mall_description),
                getString(R.string.The_Dubai_Mall_website),
                getString(R.string.The_Dubai_Mall_phone),
                R.drawable.dubai_mall));

        venues.add(new Venue(getString(R.string.Sheikh_Zayed_Grand_Mosque),
                getString(R.string.Sheikh_Zayed_Grand_Mosque_emirate),
                getString(R.string.Sheikh_Zayed_Grand_Mosque_description),
                getString(R.string.Sheikh_Zayed_Grand_Mosque_website),
                getString(R.string.Sheikh_Zayed_Grand_Mosque_phone),
                R.drawable.zayed_mosque));

        venues.add(new Venue(getString(R.string.Emirates_Palace),
                getString(R.string.Emirates_Palace_emirate),
                getString(R.string.Emirates_Palace_description),
                getString(R.string.Emirates_Palace_website),
                getString(R.string.Emirates_Palace_phone),
                R.drawable.emirates_palace));

        venues.add(new Venue(getString(R.string.Palm_Jumeirah),
                getString(R.string.Palm_Jumeirah_emirate),
                getString(R.string.Palm_Jumeirah_description),
                getString(R.string.Palm_Jumeirah_website),
                getString(R.string.Palm_Jumeirah_phone),
                R.drawable.palm_jumeirah));

        venues.add(new Venue(getString(R.string.The_Dubai_Fountain),
                getString(R.string.The_Dubai_Fountain_emirate),
                getString(R.string.The_Dubai_Fountain_description),
                getString(R.string.The_Dubai_Fountain_website),
                getString(R.string.The_Dubai_Fountain_phone),
                R.drawable.dubai_fountain));

        venues.add(new Venue(getString(R.string.Dubai_Marina),
                getString(R.string.Dubai_Marina_emirate),
                getString(R.string.Dubai_Marina_description),
                getString(R.string.Dubai_Marina_website),
                getString(R.string.Dubai_Marina_phone),
                R.drawable.dubai_marina));


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