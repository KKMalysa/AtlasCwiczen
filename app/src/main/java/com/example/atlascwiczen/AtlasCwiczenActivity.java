package com.example.atlascwiczen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.atlascwiczen.databinding.ActivityAtlasCwiczenBinding;

public class AtlasCwiczenActivity extends AppCompatActivity implements AtlasCwiczenObjectAdapter.AtlasCwiczenClickedListener{


    public static final String OBJECT_KEY = "object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_atlas_cwiczen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static void start(Activity activity, AtlasCwiczenObject atlasCwiczenObject) {
        Intent intent = new Intent(activity, AtlasCwiczenActivity.class);
        intent.putExtra(OBJECT_KEY, atlasCwiczenObject);
        activity.startActivity(intent);
    }

    @Override
    public void atlasCwiczenObjectClicked(AtlasCwiczenObject atlasCwiczenObject) {
        AtlasCwiczenActivity.start(this, atlasCwiczenObject);
    }
}