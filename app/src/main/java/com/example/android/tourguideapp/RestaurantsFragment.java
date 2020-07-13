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

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        final ArrayList<Venue> venues = new ArrayList<>();

        venues.add(new Venue("Bleu Blanc Dubai",
                "Dubai",
                "Trying to reproduce the heart-warming food of a rustic Southen French bistro can be fraught with peril, but Bleu Blanc does the concept justice. With a chef’s table that puts diners just a meter away from the kitchen’s huge open-flame grill, the food is simple and lets the ingredients to the talking. For those not wanting to feel the heat from the kitchen, elsewhere the dining room is light, bright and cosy.",
                "https://www.bleublanc-dubai.com/",
                "+971 4 512 5533",
                R.drawable.bleu_blanc_dubai));

        venues.add(new Venue("Bonna Annee",
                "Abu Dhabi",
                "Bonna Annee, an unassuming Ethiopian joint, is the antithesis of the opulent food inside many Abu Dhabi hotels—and that’s exactly why people love it. Curries and stews hold the menu together. Don't miss the tibs (tender lamb cubes sauteed with Ethiopian spice butter and onions) and the key wet (thick beef stew with diced onions, tomatoes, garlic, and Ethiopian chili powder). There are also plenty of vegan-friendly and gluten-free options, including a chickpea stew with a house spice blend. Each dish is served on injera (traditional Ethiopian sourdough bread) and is meant to be consumed with your hands.",
                "https://www.cntraveler.com/restaurants/abu-dhabi/bonna-annee",
                "04 266 0323",
                R.drawable.bonna_annee));

        venues.add(new Venue("Nusr-Et Steakhouse",
                "Abu Dhabi",
                "This place is no sop to the people nostalgic for a 1950s steakhouse; rather, Nusr-Et champions a modern approach to meat. From the blonde wood paneling to the minimalist chandeliers, the design shows restraint, leaving room to highlight various epicurean elements as decor: a glass case facing the dining room shows off a cache of steak and the back wall is lined with wine bottles. Although the menu does have dishes like meat sushi (beef sirloin, avocado, soy sauce crisp) and beef carpaccio, the char-grill is the centerpiece. Highlights include milk- and soy sauce–marinated tenderloin.",
                "https://www.cntraveler.com/restaurants/abu-dhabi/nusr-et-steakhouse-abu-dhabi",
                "04 407 4100",
                R.drawable.nusr_et));

        venues.add(new Venue("SALT",
                "Abu Dhabi",
                "After a few years on the road, the UAE's first food truck is now a permanent spot at Umm Al Emarat Park. Though it’s in the middle of Abu Dhabi, it could just as easily be in, say, Santa Monica. Burgers come from a gleaming vintage Airstream trailer, and an Astroturf patio is lined with communal tables, striped umbrellas, and string lights. Burgers are all slider-size and come with the staples (cheese, pickles, sauce, and optional jalapenos).",
                "https://www.cntraveler.com/restaurants/abu-dhabi/salt",
                "055 996 7381",
                R.drawable.salt));

        venues.add(new Venue("Bu Tafish",
                "Abu Dhabi",
                "Founded in 1968, Bu Tafish Seafood Restaurant is one of the oldest restaurants in Abu Dhabi. It was originally a street food stall run by a Palestinian immigrant who got the nickname Bu Tafish from the late Sheikh Zayed, a huge fan of his food. Fresh, local fish and calamari are prepared and presented simply, and the ingredients are allowed to speak for themselves. Sea bream and red snapper are seasoned and cooked in the oven, then topped with olive and lemon fried prawns come with Arabic bread, avocado, and house-made hot sauce.",
                "https://www.visitdubai.com/en/pois/bu-tafish",
                "04 346 0009",
                R.drawable.bu_tafish));

        venues.add(new Venue("Meylas",
                "Abu Dhabi",
                "Meylas first lures patrons with its modern Middle Eastern fusion and Instagram-ready open kitchen. Shaikha Al Kaabi, a young Emirati, opened Meylas with the mission to make Emirati food accessible to everyone. The food though, takes its cues from the classics of the cuisine. Dishes follow recipes passed down through the generations and are prepared with local ingredients. Standouts range from balaleet, simple noodles with saffron and cardamom, to salonat badu, a bedouin stew with lamb and rice. ",
                "https://www.cntraveler.com/restaurants/abu-dhabi/meylas",
                "02 444 8884",
                R.drawable.meylas));

        venues.add(new Venue("Milas",
                "Abu Dhabi",
                "Milas, tucked into the first floor of the Shangri-La, decidedly modern with purple neon light fixtures and stark black interiors. But for all the heavy-handed contemporary accents , there are softer tributes to local heritage through touches like old photos and, most notably, the menu. Standouts include the rosemary lamb chops, grilled halloumi, and dill kashmiri: dill bread filled with potato and green moong sprout and served in a tamarind-yogurt sauce with mint chutney. More adventurous eaters should try the chicken livers in a pomegranate-molasses dressing.",
                "https://www.cntraveler.com/restaurants/abu-dhabi/milas",
                "02 558 0425",
                R.drawable.milas));


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