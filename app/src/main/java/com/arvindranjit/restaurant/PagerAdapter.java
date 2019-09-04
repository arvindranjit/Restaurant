package com.arvindranjit.restaurant;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {


    int NoofTabs = 3;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.NoofTabs = NumberOfTabs;


    }


    @Override
    public Fragment getItem(int position) {
       switch (position){

           case 0:
               StartersFragment starter = new StartersFragment();
               return starter;

           case 1:
               MainCourse maincourse = new MainCourse();
               return maincourse;


           case 2:
               Dessert dessert = new Dessert();
                return  dessert;

                default:
                            return null;


       }

    }

    @Override
    public int getCount() {
        return NoofTabs;
    }
}
