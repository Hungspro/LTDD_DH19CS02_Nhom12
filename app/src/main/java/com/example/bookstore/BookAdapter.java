package com.example.bookstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.bookviewholder> {
    List<Book> data;

    public BookAdapter(List<Book> data){
        this.data = data;
    }

    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_grid,parent,false);
        return new bookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookviewholder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.imgBook.setImageResource(data.get(position).getDrawableResources());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class bookviewholder extends RecyclerView.ViewHolder{

        ImageView imgBook, imgFav;
        TextView name;

        public bookviewholder(@NonNull View itemView) {
            super(itemView);

            imgBook = itemView.findViewById(R.id.book_image);
            name = itemView.findViewById(R.id.book_name);
//            imgFav = itemView.findViewById(R.id.fav_icon);
        }
    }

}
