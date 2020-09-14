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


public class JourneysFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journeys, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // delete all method to clear table from old data to avoid repetition
        MainActivity.data.deleteAll(DataBase.JOURNEYS_DATABASE);

        //insert entities to DataBase table.
        MainActivity.data.insert(new DataModel("Blue Hole", "Dahab’s Blue Hole, a natural underwater sinkhole just off the shores of the Red Sea, enjoy a day spent snorkeling the crystal-clear waters of the Red Sea", R.drawable.blue_hole), DataBase.JOURNEYS_DATABASE);
        MainActivity.data.insert(new DataModel("Ras Mohamed", "Travel to Ras Mohammed, the most famous national park in Egypt and one of the most famous sites for diving and snorkeling in the world", R.drawable.ras_mohamed), DataBase.JOURNEYS_DATABASE);
        MainActivity.data.insert(new DataModel("Sand Dunes Safari", "Roar through the Sinai Desert in a 4WD with professional driver\n" +
                "See Arada Canyon, the Safra sand dunes, and Jebel Makharum", R.drawable.makhrom), DataBase.JOURNEYS_DATABASE);
        MainActivity.data.insert(new DataModel("Wadi el wishiwash", "Despite the magnificence and mystery of this place, it maintained hidden beauty within it. And you definitely can enjoy the magical views of the natural pure water and the colourful magical rocks", R.drawable.weshwash), DataBase.JOURNEYS_DATABASE);
        MainActivity.data.insert(new DataModel("Camels Ride", "Meet some of the desert's most ancient inhabitants and enjoy a true Bedouin feast on this 2.5-hour adventure to the mountains from Dahab", R.drawable.camels), DataBase.JOURNEYS_DATABASE);

        // retrieve data from DateBase table in ArrayList of Data
        ArrayList<DataModel> dataModelArrayList = MainActivity.data.get(DataBase.JOURNEYS_DATABASE);
        // implement recyclerView and bind it
        RecyclerView recyclerView = view.findViewById(R.id.journeysRecyclerView);
        // recyclerViewAdapter object
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataModelArrayList, getContext());
        // set RecyclerView layOut
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // set recyclerView adapter
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}