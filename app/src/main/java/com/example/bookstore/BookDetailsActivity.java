package com.example.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookstore.model.Book;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookDetailsActivity extends AppCompatActivity {
    ImageView imgBook;
    TextView nameBook, authorBook, priceBook, detailBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Intent intent = this.getIntent();
        imgBook = findViewById(R.id.book_images);
        nameBook = findViewById(R.id.book_names);
        authorBook = findViewById(R.id.book_author);
        priceBook = findViewById(R.id.book_price);
        detailBook = findViewById(R.id.book_detail);

        getBook(intent.getStringExtra("idBook"));
    }

    private void getBook(String id){
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Books").child(id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Book book=snapshot.getValue(Book.class);
                Log.d("test",book.getImage());;
                nameBook.setText(book.getName());
                authorBook.setText(book.getAuthor());
                priceBook.setText(String.valueOf(book.getPrice()));
                Glide.with(BookDetailsActivity.this).load(book.getImage()).into(imgBook);
                detailBook.setText(book.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}