package com.overshade.cardviewpractice;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/** ___Game list adapter___ */
public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameListViewHolder> {

    //================================================================================
    // Properties
    //================================================================================

    private final List<GameInfo> mGameList;

    //================================================================================
    // Constructors
    //================================================================================

    public GameListAdapter(List<GameInfo> gameList) {
        this.mGameList = gameList;
    }

    //================================================================================
    // ViewHolder implementation
    //================================================================================

    @NonNull
    @Override
    public GameListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate view using the row layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_card_row, parent, false);

        return new GameListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameListViewHolder holder, int position) {
        holder.getTitleTextView().setText(mGameList.get(position).getName());
        holder.getmPreviewImageView().setImageResource(mGameList.get(position).getPreviewResource());
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }


    /** ___View Holder Class___ */
    public static class GameListViewHolder extends RecyclerView.ViewHolder {

        //================================================================================
        // Properties
        //================================================================================

        private final TextView mTitleTextView;
        private final ImageView mPreviewImageView;

        //================================================================================
        // Constructors
        //================================================================================

        public GameListViewHolder(@NonNull View itemView) {
            super(itemView);
            /////-> TODO: define click listener for view
            /////-> here:


            mTitleTextView = itemView.findViewById(R.id.title_textview);
            mPreviewImageView = itemView.findViewById(R.id.preview_imageview);
        }

        //================================================================================
        // Accessors
        //================================================================================

        public TextView getTitleTextView() { return mTitleTextView; }

        public ImageView getmPreviewImageView() { return mPreviewImageView; }

    }


}
