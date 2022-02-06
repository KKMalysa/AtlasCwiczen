package com.example.atlascwiczen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

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
        AtlasCwiczenObject atlasCwiczenObject = atlasCwiczenObjects[position];
        holder.setAtlasCwiczenObject(atlasCwiczenObject);
    }

    @Override
    public int getItemCount() {
        return atlasCwiczenObjects.length;
    }


    class AtlasCwiczenObjectViewHolder extends  RecyclerView.ViewHolder {

        @BindView(R.id.itemImageView)
        ImageView itemImageView;
        @BindView(R.id.itemTextView)
        TextView itemTextView;


        private AtlasCwiczenObject atlasCwiczenObject;

        public AtlasCwiczenObjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemTextView.setText(atlasCwiczenObject.getName());

            Glide.with(itemImageView.getContext())
                    .load("file:///android_assets/" + atlasCwiczenObject.getImage())
                    .placeholder(R.drawable.cwiczenia_placeholder)
                    .into(itemImageView);

        }

        public void setAtlasCwiczenObject(AtlasCwiczenObject atlasCwiczenObject) {
            this.atlasCwiczenObject = atlasCwiczenObject;

        }

        public AtlasCwiczenObject getAtlasCwiczenObject() {
            return atlasCwiczenObject;
        }
    }
}
