package com.example.hafiz.akusukaberhitung;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by asus on 25-Nov-17.
 */

public class IniAdapter extends ArrayAdapter<Menu> {

    public IniAdapter(Context context,ArrayList<Menu> objects){
        super(context,0,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_fill,parent,false);
        }

        Menu menu=getItem(position);

        ImageView menuImage=(ImageView) listItemView.findViewById(R.id.menu_image);
        menuImage.setImageResource(menu.getmImage());

        TextView menuTitle=(TextView) listItemView.findViewById(R.id.menu_title);
        menuTitle.setText(menu.getmTitle());

        return listItemView;
    }


}
