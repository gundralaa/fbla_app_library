package com.example.android.blubrary;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by abhin on 9/21/2017.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListViewHolder> {

    private final BookListAdapterClickHandler mClickHandler;
    Book library[];
    User usr;

    public BookListAdapter(Book inLib[], BookListAdapterClickHandler clickHandler, User inusr) {
        mClickHandler = clickHandler;
        library = inLib;
        usr = inusr;
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
    public void onBindViewHolder(final BookListViewHolder holder, final int position) {
        holder.hold.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //set reserved
                usr.reserve(library[position], true);


            }
        });
        holder.co.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                //set checked out
                usr.checkOut(library[position], true);
                holder.hold.setVisibility(View.VISIBLE);
                holder.co.setVisibility(View.INVISIBLE);
                holder.mBookAva.setTextColor(Color.RED);
                holder.mBookAva.setText("Checked out, returning in ~ " + library[position].checkTim());


            }
        }));

        //get data to set color and things
        if (library[position] != null) {
            holder.mAuthorName.setText(library[position].getAuthor());
            String title = library[position].getTitle();
            if (title.length() > 31) {
                holder.mBookTitle.setText((title.substring(0, 25) + "..."));
            } else {
                holder.mBookTitle.setText(library[position].getTitle());
            }
            Log.d("Book " + library[position].getTitle(), String.valueOf(library[position].isCheckedOut()));
            if (library[position].isCheckedOut()) {
                //holder.hold.setVisibility(View.VISIBLE);
                holder.co.setVisibility(View.INVISIBLE);
                holder.mBookAva.setTextColor(Color.RED);
                holder.mBookAva.setText("Checked out ETR " + library[position].checkTim() + " days");
            } else {
                holder.hold.setVisibility(View.INVISIBLE);
                holder.co.setVisibility(View.VISIBLE);
                holder.mBookAva.setTextColor(Color.GREEN);
                holder.mBookAva.setText("Avalibe, ");
            }

        } else {
            holder.hold.setVisibility(View.INVISIBLE);
            holder.co.setVisibility(View.VISIBLE);
            holder.mBookAva.setText("Available");
            holder.mBookAva.setTextColor(Color.GREEN);


        }
    }

    @Override
    public int getItemCount() {
        if (null == library) return 0;
        return library.length;
    }

    public interface BookListAdapterClickHandler {
        void onClick(int position, Book lib[]);
    }

    class BookListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mBookTitle;
        public final TextView mAuthorName;
        public final TextView mBookAva;
        public final Button hold;
        public final Button co;

        public BookListViewHolder(View view) {
            super(view);
            mBookTitle = (TextView) view.findViewById(R.id.tv_book_name);
            mBookAva = (TextView) view.findViewById(R.id.tv_book_ava);
            mAuthorName = (TextView) view.findViewById(R.id.tv_book_author);
            hold = (Button) view.findViewById(R.id.button_reserve);
            co = (Button) view.findViewById(R.id.button_checkout);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onClick(adapterPosition, library);
        }

    }
}
