package com.example.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewAdapterViewHolder> {
    private Context mContext;
    private Cursor mCursor;
    public RecyclerViewAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }
    public class RecyclerViewAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView countText;
        public RecyclerViewAdapterViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.productName);
            countText = itemView.findViewById(R.id.tesco_Price);
        }
    }
    @Override
    public RecyclerViewAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recyclerview_layout, parent, false);
        return new RecyclerViewAdapterViewHolder(view);
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapterViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }
        String name = mCursor.getString(mCursor.getColumnIndex(Product.ProductEntry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(Product.ProductEntry.COLUMN_AMOUNT));
        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
    }
    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}