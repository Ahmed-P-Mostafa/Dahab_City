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

public class EventsFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // delete all method to clear table from old data to avoid repetition
        MainActivity.data.deleteAll(DataBase.EVENTS_DATABASE);

        //insert entities to DataBase table
        MainActivity.data.insert(new DataModel("Friday Market","local market every friday to offer their home made products or hand made product",R.drawable.events),DataBase.EVENTS_DATABASE);
        MainActivity.data.insert(new DataModel("Twilat mountain parties","bedouin night parties everyday night at Twilat mountain with almost bedouin style",R.drawable.twilat),DataBase.EVENTS_DATABASE);
        MainActivity.data.insert(new DataModel("Everyday Cafe nights","random musician and undergrounds bands plays music every Thursday and Friday with free styles and underground music",R.drawable.everyday_party),DataBase.EVENTS_DATABASE);
        MainActivity.data.insert(new DataModel("Elkhan nights","local market every friday to offer their home made products or hand made product",R.drawable.events),DataBase.EVENTS_DATABASE);
        MainActivity.data.insert(new DataModel("Kung Fu pasta","",R.drawable.events),DataBase.EVENTS_DATABASE);

        // retrieve data from DateBase table in ArrayList of Data
        ArrayList<DataModel> dataModelArrayList = MainActivity.data.get(DataBase.EVENTS_DATABASE);

        // implement recyclerView and bind it
        RecyclerView recyclerView = view.findViewById(R.id.eventsFragmentRecyclerView);

        // recyclerViewAdapter object
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataModelArrayList,getContext());

        // set RecyclerView layOut
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // set recyclerView adapter
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}