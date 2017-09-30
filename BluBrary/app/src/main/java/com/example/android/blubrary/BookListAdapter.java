package com.example.android.blubrary;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by abhin on 9/21/2017.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListViewHolder> {
    Book library[];

    private final BookListAdapterClickHandler mClickHandler;

    public interface BookListAdapterClickHandler {
        void onClick(int position);
    }

    public BookListAdapter(Book inLib[], BookListAdapterClickHandler clickHandler) {
        mClickHandler = clickHandler;
        library = inLib;
    }

    @Override
    public BookListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.book_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new BookListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookListViewHolder holder, int position) {
        if (library[position] != null) {
            holder.mAuthorName.setText(library[position].getAuthor());
            holder.mBookTitle.setText(library[position].getTitle());
            if (library[position].isCheckedOut() || library[position].isReserved()) {
                holder.mBookAva.setText("Unavailable");
                holder.mBookAva.setTextColor(Color.RED);
            } else {
                holder.mBookAva.setText("Available");
                holder.mBookAva.setTextColor(Color.GREEN);
            }

        }
    }

    @Override
    public int getItemCount() {
        if (null == library) return 0;
        return library.length;
    }

    class BookListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mBookTitle;
        public final TextView mAuthorName;
        public final TextView mBookAva;

        public BookListViewHolder(View view) {
            super(view);
            mBookTitle = (TextView) view.findViewById(R.id.tv_book_name);
            mBookAva = (TextView) view.findViewById(R.id.tv_book_ava);
            mAuthorName = (TextView) view.findViewById(R.id.tv_book_author);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onClick(adapterPosition);
        }
    }
}
