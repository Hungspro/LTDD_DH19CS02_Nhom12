package com.example.bookstore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.adapter.BookAdapter;
import com.example.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    BookAdapter bookAdapter;
    List<Book> data;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rv_book);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        initViews();
        initDataBooks();
        setupBookAdapter();
        return view;
    }

    private void setupBookAdapter() {
        bookAdapter = new BookAdapter(getContext(),data);
        recyclerView.setAdapter(bookAdapter);
    }

    private void initViews(){
        recyclerView = recyclerView.findViewById(R.id.rv_book);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);


    }

    private void initDataBooks() {
        data = new ArrayList<>();
        data.add(new Book(R.drawable.anh1,"hung"));
        data.add(new Book(R.drawable.anh1,"hung1"));
        data.add(new Book(R.drawable.anh1,"hung2"));
        data.add(new Book(R.drawable.anh1,"hung3"));
        data.add(new Book(R.drawable.anh1,"hung4"));
        data.add(new Book(R.drawable.anh1,"hung5"));
        data.add(new Book(R.drawable.anh1,"hung6"));

    }
}