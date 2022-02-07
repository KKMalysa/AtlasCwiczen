package com.example.atlascwiczen;

import static com.example.atlascwiczen.AtlasCwiczenFragment.OBJECTS_KEY;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class PrzyrzadyFragment extends Fragment {

    @BindView((R.id.przyrzadyViewPager))
    ViewPager przyrzadyViewPager;


    public PrzyrzadyFragment() {
        // Required empty public constructor
    }

    public static PrzyrzadyFragment newInstance(AtlasCwiczenObject[] atlasCwiczenObjects) {

        Bundle args = new Bundle();
        args.putSerializable(OBJECTS_KEY, atlasCwiczenObjects);

        PrzyrzadyFragment fragment = new PrzyrzadyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_przyrzady, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AtlasCwiczenObject[] atlasCwiczenObjects = (AtlasCwiczenObject[]) getArguments().getSerializable(OBJECTS_KEY);
        PrzyrzadyPagerAdapter przyrzadyPagerAdapter = new PrzyrzadyPagerAdapter(getChildFragmentManager(), atlasCwiczenObjects );
//        przyrzadyViewPager.setAdapter(przyrzadyPagerAdapter);
        przyrzadyViewPager.setAdapter(przyrzadyPagerAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
         ButterKnife.bind(this,getView()); // a czemu tu chce to getView? ... nie wiem
    }
}