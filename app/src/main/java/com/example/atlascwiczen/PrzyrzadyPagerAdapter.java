package com.example.atlascwiczen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * adapter cwiczen z przyrzadami
 */
public class PrzyrzadyPagerAdapter extends FragmentStateAdapter {

    private final AtlasCwiczenObject[] cwiczeniaZPrzyrzadami ;

    public PrzyrzadyPagerAdapter(@NonNull FragmentActivity fragmentActivity, AtlasCwiczenObject[] cwiczeniaZPrzyrzadami) {
        super(fragmentActivity);

        this.cwiczeniaZPrzyrzadami = cwiczeniaZPrzyrzadami;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return AtlasCwiczenFragment.newInstance(cwiczeniaZPrzyrzadami[position].getPrzyrzady());
    }

    @Override
    public int getItemCount() {
        return cwiczeniaZPrzyrzadami.length;
    }
}
