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

public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // delete all method to clear table from old data to avoid repetition
        MainActivity.data.deleteAll(DataBase.RESTAURANTS_DATABASE);

        //insert entities to DataBase table
        MainActivity.data.insert(new DataModel("Lindy's Dahab Restaurant","Steakhouse, Pizza, Seafood, Soups, Egyptian, Mediterranean",R.drawable.lindy),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Shams Restaurant","Vegetarian Friendly, Vegan Options, Halal",R.drawable.shams),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Red Cat","European, Healthy, Soups, Eastern European, Ukrainian, Russian",R.drawable.redcat),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Eel Garden View Restaurant","If your looking for a good place that has a beautiful view of the ocean, mountains and sunrise/sunset, then go to Eel Garden. ",R.drawable.garden),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Shark Restaurant","Takeout, Reservations, Outdoor Seating, Seating, Highchairs Available, Wheelchair Accessible, Free Wifi, Accepts Credit Cards, Table Service, Buffet, Waterfront, BYOB",R.drawable.restaurant),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Yum Yum"," traditional Egyptian food",R.drawable.yum),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Ali Baba Restaurant","The restaurant offers a range of local fresh seafood, barbeque and steakhouse as well as lighter bites and breakfast. Steaming hot homemade pita bread and mezze comes with every meal. You are welcome to bring your own alcohol; the bottle opener and ice are provided.",R.drawable.ali),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Hell's Kitchen","Hell's Kitchen offers a casual dining experience in a relaxed, friendly atmosphere. A glance at the menu reveals a wide variety of dishes from around the world, using the freshest, seasonal products on the market, cooked with professional love and care.",R.drawable.hells),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Friends","When it comes to seafood cuisine in Dahab then definitely 'Friends' would suit your needs",R.drawable.friends),DataBase.RESTAURANTS_DATABASE);
        MainActivity.data.insert(new DataModel("Nemo Restaurant","If you ever crave seafood Pasta Nemo is absolutely the best. It felt like heaven in my mouth. The staff was super hospitable and friendly",R.drawable.nemo),DataBase.RESTAURANTS_DATABASE);

        // retrieve data from DateBase table in ArrayList of Data
        ArrayList<DataModel> data = MainActivity.data.get(DataBase.RESTAURANTS_DATABASE);

        // implement recyclerView and bind it
        RecyclerView recyclerView = view.findViewById(R.id.restaurantFragmentRecyclerView);

        // set RecyclerView layOut
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // recyclerViewAdapter object
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(data,getContext());

        // set recyclerView adapter
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}