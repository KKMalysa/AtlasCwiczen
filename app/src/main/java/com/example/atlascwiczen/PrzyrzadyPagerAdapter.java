package com.example.atlascwiczen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * adapter cwiczen z przyrzadami
 */
public class PrzyrzadyPagerAdapter extends FragmentStatePagerAdapter {

    private final AtlasCwiczenObject[] cwiczeniaZPrzyrzadami ;

    public PrzyrzadyPagerAdapter(FragmentManager fragmentManager, AtlasCwiczenObject[] cwiczeniaZPrzyrzadami) {
        super(fragmentManager);
        this.cwiczeniaZPrzyrzadami = cwiczeniaZPrzyrzadami;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return AtlasCwiczenFragment.newInstance(cwiczeniaZPrzyrzadami[position].getPrzyrzady());
    }

    @Override
    public int getCount() {
        return cwiczeniaZPrzyrzadami.length;
    }
}
