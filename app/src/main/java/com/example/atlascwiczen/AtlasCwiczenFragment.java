package com.example.atlascwiczen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 *
 */
public class AtlasCwiczenFragment extends Fragment {


    public AtlasCwiczenFragment() {
        // Required empty public constructor
    }


    public static AtlasCwiczenFragment newInstance(String param1, String param2) {
        AtlasCwiczenFragment fragment = new AtlasCwiczenFragment();
        Bundle args = new Bundle();

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
        return inflater.inflate(R.layout.fragment_atlas_cwiczen, container, false);
    }
}