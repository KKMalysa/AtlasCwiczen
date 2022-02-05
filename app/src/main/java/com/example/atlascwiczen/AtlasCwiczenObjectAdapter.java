package com.example.atlascwiczen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AtlasCwiczenObjectAdapter extends RecyclerView.Adapter<AtlasCwiczenObjectAdapter.AtlasCwiczenObjectViewHolder> {

    private final AtlasCwiczenObject[] atlasCwiczenObjects;

    public AtlasCwiczenObjectAdapter(AtlasCwiczenObject[] atlasCwiczenObjects) {
        this.atlasCwiczenObjects = atlasCwiczenObjects;
    }

    @NonNull
    @Override
    public AtlasCwiczenObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_atlascwiczen_object, parent, false );

        return new AtlasCwiczenObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AtlasCwiczenObjectViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return atlasCwiczenObjects.length;
    }


    class AtlasCwiczenObjectViewHolder extends  RecyclerView.ViewHolder {

        public AtlasCwiczenObjectViewHolder(View itemView) {
            super(itemView);
        }
    }
}
