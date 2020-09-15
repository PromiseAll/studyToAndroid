package com.example.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    MyBaseAdapter adapter;
    ArrayList<String> data =  new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.list = this.findViewById(R.id.listView);
        this.adapter = new MyBaseAdapter(this.getApplicationContext(),this.data);
        this.list.setAdapter(adapter);
        this.addEvent();
    }

    public void addEvent(){
        Button addBtn = this.findViewById(R.id.button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.data.add("添加数据");
                MainActivity.this.adapter.notifyDataSetChanged();
            }
        });
    }
}