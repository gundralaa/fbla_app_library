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
    Book b1 = new Book("1", "999", "Sycamore Row", "John Grisham", "Law/Fiction", "", "1");
    Book b2 = new Book("1", "999", "The Innocent Man", "John Grisham", "Law/Fiction", "", "1");
    Book b3 = new Book("1", "999", "The Litigators", "John Grisham", "Law/Fiction", "", "1");
    Book b4 = new Book("1", "999", "People who Changed the Wold", "Barak Obama", "Insiprational/Nonfiction", "", "1");
    Book b5 = new Book("1", "999", "Living by Chemistry", "Angelica Stacy", "Textbook/Chemistry/Nonfiction", "", "1");
    Book b6 = new Book("1", "999", "Barron's AP Computer Science A", "Roselyn Teukolsky", "Textbook/Computer Science/Java/AP/Nonfiction", "", "1");
    Book b7 = new Book("1", "999", "The Almanac of American History", "Arthor Bowman", "History/US History/Nonfiction", "", "1");
    Book b8 = new Book("1", "999", "The American Pageant", "David Kennedy", "History/US History/Nonfiction/Textbook", "", "1");
    Book b9 = new Book("1", "999", "Precalculus, 7th edition", "Larson Hostetler", "Math/Textbook/Precalculus", "", "1");
    Book b10 = new Book("1", "999", "Android Programming: The Big Nerd Ranch", "Phillip Marsicano", "Java/Android/App Development", "", "1");
    Book b11 = new Book("1", "999", "AP Economics Macro & Micro", "Priceton Review", "AP/Economics", "", "1");
    Book b12 = new Book("1", "999", "AP Chemistry", "Priceton Review", "AP/Chemistry", "", "1");
    Book b13 = new Book("1", "999", "AP U.S. History: Premium Edition", "Priceton Review", "History/US History/Nonfiction/AP", "", "1");
    Book b14 = new Book("1", "999", "AP U.S. History 2017-2018", "Krista Dornbush", "History/US History/Nonfiction/AP", "", "1");
    Book[] library = new Book[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14};

    public BookListAdapter() {

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
        }
    }

    @Override
    public int getItemCount() {
        if (null == library) return 0;
        return library.length;
    }

    public void writeToArray() {
        Book book1 = new Book("12534dda", "99", "The Scarlet Letter", "Nathanial Hawthorne", ("nonfiction"), "lol", "9");
        library[0] = book1;
    }

    class BookListViewHolder extends RecyclerView.ViewHolder {

        public final TextView mBookTitle;
        public final TextView mAuthorName;

        public BookListViewHolder(View view) {
            super(view);
            mBookTitle = (TextView) view.findViewById(R.id.tv_book_name);
            mAuthorName = (TextView) view.findViewById(R.id.tv_book_author);
        }

    }
}
