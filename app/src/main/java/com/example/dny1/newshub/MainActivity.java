package com.example.dny1.newshub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;
    Context context;
    ArrayList arrayList;

    public static String[] gridViewStrings = {
            "Local News",
            "Foreign News",
            "Sports",
            "Technology",
            "Entertainment",
            "Games",
            "Scholarship",
            "Finance News",
            "Search for specific News",

    };
    public static int[] gridViewImages = {
            R.drawable.local,
            R.drawable.local,
            R.drawable.sports,
            R.drawable.technology,
            R.drawable.entertainment,
            R.drawable.games,
            R.drawable.scholarship,
            R.drawable.finance,
            R.drawable.search
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages));

        initInstances();

       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item Clicked: "+((TextView)view.findViewById(R.id.gridview_text)).getText(), Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(view.getContext(),activities[position]);
               view.getContext().startActivity(intent);
                /*Intent intent = null;
                if (position == 0){
                    intent = new Intent(view.getContext(), LocalActivity.class);
                }
                if (position == 1){
                    intent = new Intent(view.getContext(), LocalActivity.class);
                }
                startActivity(intent);*/
            }
        });

    }
    private void initInstances() {
        rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayoutAndroid.setTitle("   Newshub");
    }
  /*  public void test(View view){
        Intent intent = new Intent(this, LocalActivity.class);
        startActivity(intent);
    }*/
    private Class[] activities ={
            LocalActivity.class,
            MainActivity.class,
    };
   /*public  void onClick (View view,int position){
        Toast.makeText(MainActivity.this, " "+position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(view.getContext(),activities[position]);
        view.getContext().startActivity(intent);
    }*/

}
