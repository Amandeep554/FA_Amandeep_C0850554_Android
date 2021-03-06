package com.example.fa_amandeep_c0850554_android.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fa_amandeep_c0850554_android.adapter.FavoritePlaceAdapter;

public class SwipeCallback extends ItemTouchHelper.SimpleCallback {
    private FavoritePlaceAdapter favoritePlaceAdapter;
    private Context context;
    public SwipeCallback(Context context,FavoritePlaceAdapter favoritePlaceAdapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.context = context;
        this.favoritePlaceAdapter = favoritePlaceAdapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    /**
     * Deletes the item if the user swipes left
     * else updates the item.
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        if (direction == ItemTouchHelper.RIGHT) {
            favoritePlaceAdapter.deleteItem(position);
        } else {
            /*
            Intent i = new Intent(context, AddFavoritePlaceActivity.class);
            FavoritePlace favoritePlace = favoritePlaceAdapter.get
            i.putExtra(id)
            context.startActivity(i);
             */
            favoritePlaceAdapter.updateItem(position);
        }


        /*
            AlertDialog.Builder buider = new AlertDialog.Builder(context);
            buider.setTitle("Are you sure ?");
            buider.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //taskRoomDatabase.categoryDao().deleteCategory(categoryList.get(getAdapterPosition()).getId());
                    //categoryList.remove(getAdapterPosition());
                    //notifyItemRemoved(getAdapterPosition());

                    int position = viewHolder.getAdapterPosition();
                    favoritePlaceAdapter.deleteItem(position);

                }
            });
            buider.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(context,"The address is not deleted", Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog alertDialog =buider.create();
            alertDialog.show();
        */

    }

}