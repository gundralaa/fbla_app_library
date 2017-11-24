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

        holder.co.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                //set checked out
                usr.checkOut(library[position], true);
                holder.hold.setVisibility(View.INVISIBLE);
                holder.co.setVisibility(View.INVISIBLE);

                holder.returnButton.setVisibility(View.VISIBLE);
                holder.mBookAva.setTextColor(Color.RED);
                holder.mBookAva.setText("Checked out, returning in ~ " + library[position].checkTim());


            }
        }));
        holder.hold.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                //set checked out
                usr.addToHolds(library[position]);
                library[position].hold();
            }
        }));

        holder.returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usr.returnBook(library[position]);
                if (library[position].held_line.size() == 0) {
                    holder.hold.setVisibility(View.INVISIBLE);
                    holder.co.setVisibility(View.VISIBLE);
                    holder.returnButton.setVisibility((View.INVISIBLE));
                    holder.mBookAva.setTextColor(Color.GREEN);
                    holder.mBookAva.setText("Avalible in Library now");
                } else {

                }


            }
        });

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
            if (library[position].isCheckedOutToUser(Resources.usr)) {
                holder.hold.setVisibility(View.INVISIBLE);
                holder.co.setVisibility(View.INVISIBLE);
                holder.returnButton.setVisibility(View.INVISIBLE);
                holder.mBookAva.setTextColor(Color.RED);
                holder.mBookAva.setText("Your expected to return this book in " + library[position].checkTim() + " days");
            } else if (library[position].isHeldByUser(Resources.usr)) {
                holder.hold.setVisibility(View.INVISIBLE);
                holder.co.setVisibility(View.INVISIBLE);
                holder.returnButton.setVisibility(View.INVISIBLE);
                holder.mBookAva.setTextColor(Color.RED);
                holder.mBookAva.setText("Will be avalible in " + library[position].checkTim() + " days for your checkout");
            } else if (!library[position].isCheckedOutToUser(Resources.usr) && library[position].isCheckedOut()) {
                holder.hold.setVisibility(View.VISIBLE);
                holder.co.setVisibility(View.INVISIBLE);
                holder.returnButton.setVisibility(View.INVISIBLE);
                holder.mBookAva.setTextColor(Color.RED);
                holder.mBookAva.setText("Checked out");
            } else {
                holder.hold.setVisibility(View.INVISIBLE);
                holder.co.setVisibility(View.VISIBLE);
                holder.returnButton.setVisibility((View.INVISIBLE));
                holder.mBookAva.setTextColor(Color.GREEN);
                holder.mBookAva.setText("Avalible in Library now");
            }

        } else {
            holder.hold.setVisibility(View.INVISIBLE);
            holder.co.setVisibility(View.VISIBLE);
            holder.mBookAva.setText("...E...");
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
        public final Button returnButton;

        public BookListViewHolder(View view) {
            super(view);
            mBookTitle = (TextView) view.findViewById(R.id.tv_book_name);
            mBookAva = (TextView) view.findViewById(R.id.tv_book_ava);
            mAuthorName = (TextView) view.findViewById(R.id.tv_book_author);
            hold = (Button) view.findViewById(R.id.button_reserve);
            co = (Button) view.findViewById(R.id.button_checkout);
            returnButton = (Button) view.findViewById(R.id.button_return);
            returnButton.setVisibility(View.INVISIBLE);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onClick(adapterPosition, library);
        }

    }
}
