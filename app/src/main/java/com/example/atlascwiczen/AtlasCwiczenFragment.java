package com.example.atlascwiczen;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AtlasCwiczenFragment extends Fragment implements AtlasCwiczenObjectAdapter.AtlasCwiczenClickedListener {


    public static final String OBJECTS_KEY = "objects";
    @BindView(R.id.objectRecyclerView)
    RecyclerView objectRecyclerView;

    public AtlasCwiczenFragment() {

    }


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
        View view = inflater.inflate(R.layout.fragment_atlas_cwiczen, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AtlasCwiczenObject[] objects = (AtlasCwiczenObject[]) getArguments().getSerializable(OBJECTS_KEY);

        objectRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        AtlasCwiczenObjectAdapter adapter = new AtlasCwiczenObjectAdapter(objects);
        adapter.setAtlasCwiczenClickedListener(this);
        objectRecyclerView.setAdapter(adapter);

    }

    @Override
    public void atlasCwiczenObjectClicked(AtlasCwiczenObject atlasCwiczenObject) {
        Log.d(AtlasCwiczenFragment.class.getSimpleName(), "Clicked" + atlasCwiczenObject.getName());

        AtlasCwiczenActivity.start(getActivity(), atlasCwiczenObject);
    }
}