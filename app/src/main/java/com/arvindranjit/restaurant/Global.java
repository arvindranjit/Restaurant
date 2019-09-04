package com.arvindranjit.restaurant;



import android.app.Application;

import java.util.ArrayList;

public class Global extends Application {

    public ArrayList<CartItems> globalcart = new ArrayList<>();
    public int position = 0;

    private static Global singleton;

    public static Global getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }









    public String getname(int position){
        CartItems cartitem = globalcart.get(position);
        return cartitem.getname();
    }
    public int getquantity(int position){
        CartItems cartitem = globalcart.get(position);
        return cartitem.getquantity();
    }
    public int getprice(int position){
        CartItems cartitem = globalcart.get(position);
        return cartitem.getprice();
    }
    public int getimage(int position){
        CartItems cartitem = globalcart.get(position);
        return cartitem.getImageResource();
    }
    public void increasequantity(int position){
        CartItems cartitem = globalcart.get(position);
        cartitem.increase();
        globalcart.set(position, cartitem);



    }



    public int getquantitytotal() {
        int quantitytotal = 0;

        for(int i=0; i<globalcart.size();i++){

            CartItems cartitem = globalcart.get(i);
            quantitytotal = quantitytotal + cartitem.getquantity();

        }
        return quantitytotal;


    }


    public int getpricetotal() {
        int pricetotal = 0;

        for(int i=0; i<globalcart.size();i++){

            CartItems cartitem = globalcart.get(i);
            pricetotal = pricetotal + (cartitem.getprice())*(cartitem.getquantity());

        }
        return pricetotal;


    }


    public int getsize(){
       return globalcart.size();

    }

    public void decreasequantity(int position){
        CartItems cartitem = globalcart.get(position);
        cartitem.decrease();
        globalcart.set(position, cartitem);

    }

    public void additem(int image, String name, int quantity, int price){

        CartItems newitem = new CartItems(image,name,quantity,price);
        globalcart.add(newitem);


    }

    public void removeitem(int position){
        globalcart.remove(position);

    }




















    // public int[] images = new int[30];
  //  public String[] names = new String[30];
   // public int[] price = new int[30];
    //public int[] quantity = new int[30];
   // public int position = 0;




    /* private int d1 = 0;
    private int d2 = 0;
    private int d3 = 0;
    private int d4 = 0;
    private int d5 = 0;
    private int d6 = 0;

    private int s1 = 0;
    private int s2 = 0;
    private int s3 = 0;
    private int s4 = 0;
    private int s5 = 0;
    private int s6 = 0;

    private int mc1 = 0;
    private int mc2 = 0;
    private int mc3 = 0;
    private int mc4 = 0;
    private int mc5 = 0;
    private int mc6 = 0;
    private int mc7 = 0;
    private int mc8 = 0;
    private int mc9 = 0;



    public int getDatad1(){
        return this.d1;
    }

    public void setDatad1(int d){
        this.d1=d;
    }
    public void addd1(int d){
        this.d1 = this.d1 + d;
    }


    public int getDatad2(){
        return this.d2;
    }

    public void setDatad2(int d){
        this.d2=d;
    }
    public void addd2(int d){
        this.d2 = this.d2 + d;
    }



    public int getDatad3(){
        return this.d3;
    }

    public void setDatad3(int d){
        this.d3=d;
    }
    public void addd3(int d){
        this.d3 = this.d3 + d;
    }



    public int getDatad4(){
        return this.d4;
    }

    public void setDatad4(int d){
        this.d4=d;
    }
    public void addd4(int d){
        this.d4 = this.d4 + d;
    }


    public int getDatad5(){
        return this.d5;
    }

    public void setDatad5(int d){
        this.d5=d;
    }
    public void addd5(int d){
        this.d5 = this.d5 + d;
    }





    public int getDatad6(){
        return this.d6;
    }

    public void setDatad6(int d){
        this.d6=d;
    }
    public void addd6(int d){
        this.d6 = this.d6 + d;
    }






    public int getDatas1(){
        return this.s1;
    }

    public void setDatas1(int d){
        this.s1=d;
    }
    public void adds1(int d){
        this.s1 = this.s1 + d;
    }




    public int getDatas2(){
        return this.s2;
    }

    public void setDatas2(int d){
        this.s2=d;
    }
    public void adds2(int d){
        this.s2 = this.s2 + d;
    }


    public int getDatas3(){
        return this.s3;
    }

    public void setDatas3(int d){
        this.s3=d;
    }
    public void adds3(int d){
        this.s3 = this.s3 + d;
    }


    public int getDatas4(){
        return this.s4;
    }

    public void setDatas4(int d){
        this.s4=d;
    }
    public void adds4(int d){
        this.s4 = this.s4 + d;
    }


    public int getDatas5(){
        return this.s5;
    }

    public void setDatas5(int d){
        this.s5=d;
    }
    public void adds5(int d){
        this.s5 = this.s5 + d;
    }


    public int getDatas6(){
        return this.s6;
    }

    public void setDatas6(int d){
        this.s6=d;
    }
    public void adds6(int d){
        this.s6 = this.s6 + d;
    }


    public int getDatamc1(){
        return this.mc1;
    }

    public void setDatamc1(int d){
        this.mc1=d;
    }
    public void addmc1(int d){
        this.mc1 = this.mc1 + d;
    }


    public int getDatamc2(){
        return this.mc2;
    }

    public void setDatamc2(int d){
        this.mc2=d;
    }
    public void addmc2(int d){
        this.mc2 = this.mc2 + d;
    }



    public int getDatamc3(){
        return this.mc3;
    }


    public void setDatamc3(int d){
        this.mc3=d;
    }
    public void addmc3(int d){
        this.mc3 = this.mc3 + d;
    }



    public int getDatamc4(){
        return this.mc4;
    }

    public void setDatamc4(int d){
        this.mc4=d;
    }
    public void addmc4(int d){
        this.mc4 = this.mc4 + d;
    }




    public int getDatamc5(){
        return this.mc5;
    }


    public void setDatamc5(int d){
        this.mc5=d;
    }
    public void addmc5(int d){
        this.mc5 = this.mc5 + d;
    }



    public int getDatamc6(){
        return this.mc6;
    }

    public void setDatamc6(int d){
        this.mc6=d;
    }
    public void addmc6(int d){
        this.mc6 = this.mc6 + d;
    }



    public int getDatamc7(){
        return this.mc7;
    }

    public void setDatamc7(int d){
        this.mc7=d;
    }
    public void addmc7(int d){
        this.mc7 = this.mc7 + d;
    }


    public int getDatamc8(){
        return this.mc8;
    }

    public void setDatamc8(int d){
        this.mc8=d;
    }
    public void addmc8(int d){
        this.mc8 = this.mc8 + d;
    }



    public int getDatamc9(){
        return this.mc9;
    }

    public void setDatamc9(int d){
        this.mc9=d;
    }

    public void addmc9(int d){
        this.mc9 = this.mc9 + d;
    }

*/







}
