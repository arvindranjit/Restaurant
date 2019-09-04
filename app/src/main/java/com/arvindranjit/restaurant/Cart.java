package com.arvindranjit.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Cart extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerAdapterC mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int quantity = 0;
    private TextView prices;

/*
    private Button buttonremove;
    private Button buttonplus;
    private Button buttonminus;
    private TextView tvname;
    private TextView tvprice;
    private ImageView image;
    */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        prices = findViewById(R.id.pricetextview);

        buildRecyclerView();
        setprices();













    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerViewCart);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new RecyclerAdapterC();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerAdapterC.OnItemClickListener() {

            @Override
            public void OnplusClick(int position) {

                Global.getInstance().increasequantity(position);
                mAdapter.notifyItemChanged(position);
                setprices();


            }
            @Override
            public void OnminusClick(int position) {

                Global.getInstance().decreasequantity(position);
                mAdapter.notifyItemChanged(position);
                setprices();

            }

            @Override
            public void onRemoveClick(int position) {

                Global.getInstance().removeitem(position);
                mAdapter.notifyItemRemoved(position);
                setprices();

            }
        });
    }


    public void setprices() {


        int price = Global.getInstance().getpricetotal();

        prices.setText("Total Price: "+ Integer.toString(price));





    }






   /* public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerViewCart);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CartItems(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CartItems.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

*/

}
