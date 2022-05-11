package com.example.bookstore.adapter;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookstore.BookDetailsActivity;
import com.example.bookstore.R;
import com.example.bookstore.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.bookviewholder> {
     Context context;
    List<Book> data;
    private Context context;

    public BookAdapter(Context context,List<Book> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_grid,parent,false);
        return new bookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookviewholder holder, int position) {
        final Book book = data.get(position);
        if (book == null){
            return;
        }
        holder.name.setText(data.get(position).getName());

        Glide.with(context).load(data.get(position).getImage()).into(holder.imgBook);
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(book);
            }
        });
    }
    private void onClickGoToDetail(Book book){
        Intent intent = new Intent(context, BookDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_book",book);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class bookviewholder extends RecyclerView.ViewHolder{

        private ConstraintLayout layoutItem;
        ImageView imgBook;
        TextView name;

        public bookviewholder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.book_layout);
            imgBook = itemView.findViewById(R.id.book_image);
            name = itemView.findViewById(R.id.book_name);
        }
    }

}
