package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookstore.model.Book;

public class BookDetailsActivity extends AppCompatActivity {
    ImageView imgBook;
    TextView nameBook, authorBook, priceBook, detailBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        imgBook = findViewById(R.id.book_images);
        nameBook = findViewById(R.id.book_names);
        authorBook = findViewById(R.id.book_author);
        priceBook = findViewById(R.id.book_price);
        detailBook = findViewById(R.id.book_detail);

        Book book = (Book) bundle.get("object_book");
    }
}