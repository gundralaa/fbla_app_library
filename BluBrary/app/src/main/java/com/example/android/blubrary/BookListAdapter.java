package com.example.android.blubrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by abhin on 9/21/2017.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListViewHolder> {

    Book book1 = new Book(null, null,"The Scarlet Letter", "Nathanial Hawthorne", null, null, null);
    Book [] books = {book1};
    public BookListAdapter(){}

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
        holder.mAuthorName.setText(books[position].getAuthor());
        holder.mBookTitle.setText(books[position].getTitle());
    }

    @Override
    public int getItemCount() {
        if(null == books) return 0;
        return books.length;
    }

    class BookListViewHolder extends RecyclerView.ViewHolder{

        public final TextView mBookTitle;
        public final TextView mAuthorName;

        public BookListViewHolder(View view){
            super(view);
            mBookTitle = (TextView) view.findViewById(R.id.tv_book_name);
            mAuthorName = (TextView) view.findViewById(R.id.tv_author_name);
        }

    }
}
