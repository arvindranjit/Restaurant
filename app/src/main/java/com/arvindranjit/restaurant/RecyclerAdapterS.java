package com.arvindranjit.restaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapterS extends RecyclerView.Adapter<RecyclerAdapterS.ImageViewS> {

    private RecyclerAdapterS.OnItemClickListener mListener;

    private int[] images;
    private String[] names;
    private int[] prices;
    private char type;
    private int[] quantity;


    public interface OnItemClickListener {
        void onPlusClick(int position);

        void onAddClick(int position);

        void onMinusClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public RecyclerAdapterS(int[] images, String[] names, int[] prices, char t, int[] quantity){

        this.images = images;
        this.names = names;
        this.prices = prices;
        this.type = t;
        this.quantity = quantity;

    }

    @NonNull
    @Override
    public ImageViewS onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menuitems,parent,false);
        ImageViewS imageViewHolder = new ImageViewS(view, mListener);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewS holder, int position) {

        int image_id = images[position];
        holder.imageview1.setImageResource(image_id);
        holder.textviewtitle.setText(names[position]);
        holder.textviewprices.setText("₹" + Integer.toString(prices[position]));
        holder.textviewquantity.setText(Integer.toString(quantity[position]));


    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public static class ImageViewS extends RecyclerView.ViewHolder {


        ImageView imageview1;
        TextView textviewtitle;
        TextView textviewprices;
        Button minusbutton;
        Button plusbutton;
        Button addtocartbutton;
        TextView textviewquantity;


        public ImageViewS(@NonNull View itemView, final OnItemClickListener listener) {

                        super(itemView);
                        imageview1 = itemView.findViewById(R.id.imageView);
                        textviewtitle = itemView.findViewById(R.id.textViewtitle);
                        textviewprices = itemView.findViewById(R.id.textViewPrices);
                        textviewquantity = itemView.findViewById(R.id.quantitytextView);
                        plusbutton = itemView.findViewById(R.id.buttonplus);
                        minusbutton = itemView.findViewById(R.id.buttonminus);
                        addtocartbutton = itemView.findViewById(R.id.buttonaddtocart);


            plusbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onPlusClick(position);
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
                            listener.onMinusClick(position);
                        }
                    }
                }
            });


            addtocartbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onAddClick(position);
                        }
                    }
                }
            });





        }
    }

}
