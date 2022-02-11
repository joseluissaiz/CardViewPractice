package com.overshade.cardviewpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**___MainActivity >>> first activity at launching app <<< ___*/
public class MainActivity extends AppCompatActivity {

    //================================================================================
    // Properties
    //================================================================================

    private List<GameInfo> mGameList;
    private RecyclerView mGameListView;

    //================================================================================
    // Lifecycle Events
    //================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //--> Activity init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--> Create Game list items.
        this.mGameList = createGameList();

        //--> Get the recyclerview and assign a new adapter.
        this.mGameListView = findViewById(R.id.game_recyclerview);
        this.mGameListView.setLayoutManager(
                new GridLayoutManager(this, getResources().getInteger(R.integer.column_number))
        );
        this.mGameListView.setAdapter(new GameListAdapter(this.mGameList));

        //--> Set item touch callback for the recyclerview holder
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
        itemTouchHelper.attachToRecyclerView(mGameListView);
    }

    //================================================================================
    // Instance Methods
    //================================================================================

    private List<GameInfo> createGameList() {
        List<GameInfo> gameList = new ArrayList<>();
        gameList.add(new GameInfo("Peg Solitaire", R.drawable.peg_solitaire_wall));
        gameList.add(new GameInfo("Super 2048", R.drawable.a2048_wall));
        gameList.add(new GameInfo("Skyrim", R.drawable.skyrim_wall));
        gameList.add(new GameInfo("Grand Theft Auto V", R.drawable.gtav_wall));
        gameList.add(new GameInfo("Destiny 2", R.drawable.destiny2_wall));

        return gameList;
    }


    private ItemTouchHelper.Callback createHelperCallback() {
        return new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                moveItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                if (swipeDir == ItemTouchHelper.LEFT || swipeDir == ItemTouchHelper.RIGHT) {
                    deleteItem(viewHolder.getAdapterPosition());
                }
                if (swipeDir == ItemTouchHelper.UP) {
                    if (viewHolder.getAdapterPosition() > 0) {
                        replaceItem(viewHolder.getAdapterPosition(), viewHolder.getAdapterPosition()-1);
                    }
                }
            }
        };
    }

    private void replaceItem(int currentPos, int movedPos) {
        GameInfo current = mGameList.get(currentPos);
        GameInfo moved = mGameList.get(movedPos);

        mGameList.remove(movedPos);
        mGameList.remove(current);
        mGameList.add(movedPos, current);
        mGameList.add(currentPos, moved);
    }

    private void moveItem(int oldPos, int newPos) {
        GameInfo item = mGameList.get(oldPos);
        mGameList.remove(oldPos);
        mGameList.add(newPos, item);
        Objects.requireNonNull(mGameListView.getAdapter()).notifyItemMoved(oldPos, newPos);
    }

    private void deleteItem(final int position) {
        mGameList.remove(position);
        Objects.requireNonNull(mGameListView.getAdapter()).notifyItemRemoved(position);
    }


}