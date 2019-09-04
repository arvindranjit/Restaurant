package com.arvindranjit.restaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterC extends RecyclerView.Adapter<RecyclerAdapterC.ViewHolder> {


    private ArrayList<CartItems> mitemList;


    private OnItemClickListener mListener;



    public interface OnItemClickListener {


        void onRemoveClick(int position);
        void OnplusClick(int position);
        void OnminusClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mname;
        public TextView mquantity;
        public TextView mprice;
        public Button  plusbutton;
        public Button minusbutton;
        public Button removefromcart;

        public ViewHolder(View itemView,final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mname = itemView.findViewById(R.id.nametextview);
            mquantity = itemView.findViewById(R.id.quantitytextView);
            mprice = itemView.findViewById(R.id.textViewPrices);
            plusbutton = itemView.findViewById(R.id.buttonplus);
            removefromcart = itemView.findViewById(R.id.buttonremovefromcart);
            minusbutton = itemView.findViewById(R.id.buttonminus);


            removefromcart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onRemoveClick(position);
                        }
                    }
                }
            });

            minusbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnminusClick(position);
                        }
                    }
                }
            });

            plusbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnplusClick(position);
                        }
                    }
                }
            });




        }
    }

    public RecyclerAdapterC() {


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartitem, parent, false);
       ViewHolder evh = new ViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {




        holder.mImageView.setImageResource(Global.getInstance().getimage(position));
        holder.mquantity.setText(Integer.toString(Global.getInstance().getquantity(position)));
        holder.mprice.setText(Integer.toString(Global.getInstance().getprice(position)));
        holder.mname.setText(Global.getInstance().getname(position));
    }

    @Override
    public int getItemCount() {

       return Global.getInstance().getsize();
    }


}
