package com.example.hafiz.akusukaberhitung;

/**
 * Created by asus on 25-Nov-17.
 */

public class Menu {

    private String mTitle;
    private int mImage;

    public Menu(String mtitle, int image){
        mTitle=mtitle;
        mImage=image;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmTitle() {
        return mTitle;
    }
}
