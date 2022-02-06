package com.example.atlascwiczen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AtlasCwiczenObjectAdapter extends RecyclerView.Adapter<AtlasCwiczenObjectAdapter.AtlasCwiczenObjectViewHolder> {

    private final AtlasCwiczenObject[] atlasCwiczenObjects;
    private AtlasCwiczenClickedListener atlasCwiczenClickedListener;

    public AtlasCwiczenObjectAdapter(AtlasCwiczenObject[] atlasCwiczenObjects) {
        this.atlasCwiczenObjects = atlasCwiczenObjects;
    }

    public void setAtlasCwiczenClickedListener(AtlasCwiczenClickedListener atlasCwiczenClickedListener) {
        this.atlasCwiczenClickedListener = atlasCwiczenClickedListener;
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


    //onClick
    private void itemClicked(AtlasCwiczenObject atlasCwiczenObject) {
        if(atlasCwiczenClickedListener != null) {
            atlasCwiczenClickedListener.atlasCwiczenObjectClicked(atlasCwiczenObject);
        }
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
            itemView.setOnClickListener((View.OnClickListener) this);


        }

        public void setAtlasCwiczenObject(AtlasCwiczenObject atlasCwiczenObject) {
            this.atlasCwiczenObject = atlasCwiczenObject;

            itemTextView.setText(atlasCwiczenObject.getName());

            Glide.with(itemImageView.getContext())
                    .load("file:///android_assets/" + atlasCwiczenObject.getImage())
                    .placeholder(R.drawable.cwiczenia_placeholder)
                    .into(itemImageView);

        }

        public AtlasCwiczenObject getAtlasCwiczenObject() {
            return atlasCwiczenObject;
        }

//        @Override
        public void onClick(View view) {
            itemClicked(atlasCwiczenObject);
        }
    }

    public interface AtlasCwiczenClickedListener {
        void atlasCwiczenObjectClicked(AtlasCwiczenObject atlasCwiczenObject);
    }
}

