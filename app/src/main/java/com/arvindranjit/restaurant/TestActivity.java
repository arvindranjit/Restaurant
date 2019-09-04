package com.arvindranjit.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int[] images = { R.drawable.starter1 , R.drawable.starter2, R.drawable.starter3,R.drawable.starter4, R.drawable.starter5 };

    private RecyclerAdapterS adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



    }
}
