package com.example.dahabcity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class ViewPagerAdapter extends FragmentPagerAdapter {
    // context object to pass it for constructor
    Context context;

    // ViewPagerAdapter constructor
    public ViewPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // getItem method to manage pages positions
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CafesFragment();
        } else if (position == 1) {
            return new RestaurantFragment();
        } else if (position == 2) {
            return new EventsFragment();
        } else
            return new JourneysFragment();
    }

    //getCount to return pages number
    @Override
    public int getCount() {
        return 4;
    }

    // getPageTitle method to return each tab text
    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        if (position == 0) {
            return context.getString(R.string.cafes);
        } else if (position == 1) {
            return context.getString(R.string.restaurant);
        } else if (position == 2) {
            return context.getString(R.string.events);
        } else
            return context.getString(R.string.journeys);
    }
}
