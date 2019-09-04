package com.arvindranjit.restaurant;

public class CartItems {

    private int image;
    private String name;
    private int quantity;
    private int price;



    public CartItems(int imageResource, String text1,int mquantity, int mprice) {
        image = imageResource;
        name = text1;
        quantity = mquantity;
        price = mprice;
    }


    public int getImageResource() {
        return image;

    }

    public String getname() {
        return name;
    }

    public int getquantity() {
        return quantity;
    }

    public int getprice() {
        return price;
    }
    public void decrease() {

        quantity--;

    }
    public void increase() {

        quantity++;

    }




}

