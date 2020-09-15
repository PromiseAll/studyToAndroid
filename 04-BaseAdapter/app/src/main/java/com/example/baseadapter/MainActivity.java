package com.example.baseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.list = this.findViewById(R.id.listView);
        this.list.setAdapter(new MyBaseAdapter(this.getApplicationContext(),new String[]{"234","345","234","234","345","234","234","345","234","234","345","234","234","345","234","234","345","234"}));
    }
}