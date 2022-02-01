package com.example.atlascwiczen;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AtlasCwiczenFragment extends Fragment {


    public static final String OBJECTS_KEY = "objects";


    /** wzorzec fabryki */
    public static AtlasCwiczenFragment newInstance(AtlasCwiczenObject[] objects) {
        AtlasCwiczenFragment fragment = new AtlasCwiczenFragment();
        Bundle args = new Bundle();
        args.putSerializable(OBJECTS_KEY, objects);

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

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.objectTextView);
        AtlasCwiczenObject[] objects = (AtlasCwiczenObject[]) getArguments().getSerializable(OBJECTS_KEY);

        for (AtlasCwiczenObject object : objects) {
            textView.setText(textView.getText().toString() + " " + object.getName());
        }

    }
}