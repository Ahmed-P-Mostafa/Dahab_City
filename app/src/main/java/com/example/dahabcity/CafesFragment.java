package com.example.dahabcity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CafesFragment extends Fragment {
    RecyclerView recyclerView;


    public CafesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // delete all method to clear table from old data to avoid repetition
        MainActivity.data.deleteAll(DataBase.CAFES_DATABASE);

        //insert entities to DataBase table
        MainActivity.data.insert(new DataModel("Ralph's German Bakery", "Bakeries, German, Cafe, International, European, Deli", R.drawable.ralph_german, "28.5000227,34.5184421,19z"), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("EveryDay Cafe", "Good atmospheric place with good music at night and good decorations", R.drawable.everyday, "28.49518886071274,34.51740392381722"), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Tea Garden Cafe", "Outdoor Seating, Seating, Delivery, Reservations, Wheelchair Accessible, Table Service", R.drawable.teagarden, "28.50098,34.51338"), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Yambo Cafe", "European, Egyptian, Cafe, Mediterranean", R.drawable.yambo), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Planet Cafe", "Breakfast, Lunch, Dinner, Brunch, Late Night\n" +
                "FEATURES\n" +
                "Outdoor Seating, Seating, Takeout, Table Service", R.drawable.planet), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Mojo CoWork Cafe", "American, German, European, Fusion, Healthy, Cafe", R.drawable.mojo), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Alcapone", "The best grilled food I ate in the long time. All the rest was also delicious.\n" +
                "Prices are good, cheaper than buffet in the hotel. Very comfortable, nice sea view, the whole atmosphere is good", R.drawable.alcapone), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Kung Fu Pasta", "No Details available now", R.drawable.cafe), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Light Cafe Dahab", "No Details available now", R.drawable.cafe), DataBase.CAFES_DATABASE);
        MainActivity.data.insert(new DataModel("Coffee Wheel", "No Details available now", R.drawable.cafe), DataBase.CAFES_DATABASE);

        // retrieve data from DateBase table in ArrayList of Data
        ArrayList<DataModel> dataModelArrayList = MainActivity.data.get(DataBase.CAFES_DATABASE);

        // implement recyclerView and bind it
        recyclerView = view.findViewById(R.id.cafeFragmentRecyclerView);

        // set RecyclerView layOut
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // recyclerViewAdapter object
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataModelArrayList, getContext());

        // set recyclerView adapter
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafes, container, false);
    }
}