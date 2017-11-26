package com.example.hafiz.akusukaberhitung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuMateri extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materi);


        final ArrayList<Menu> menus=new ArrayList<Menu>();

        menus.add(new Menu("TAMBAH",R.drawable.tambah));
        menus.add(new Menu("KURANG",R.drawable.kurang));
        menus.add(new Menu("KALI",R.drawable.kali));
        menus.add(new Menu("BAGI",R.drawable.bagi));

        IniAdapter adapter=new IniAdapter(this,menus);
        ListView listView=(ListView) findViewById(R.id.materi_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(view.getContext(),MateriTambah.class);
                    startActivity(intent);
                }
                if (position==1){
                    Intent intent=new Intent(view.getContext(),MateriKurang.class);
                    startActivity(intent);
                }
                if (position==2){
                    Intent intent=new Intent(view.getContext(),MateriKali.class);
                    startActivity(intent);
                }
                if (position==3){
                    Intent intent=new Intent(view.getContext(),MateriBagi.class);
                    startActivity(intent);
                }
            }
        });

    }
}
