package com.example.fragment_06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentManager manager;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private View button1;
    private View button2;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();

    }

    private void init() {
        // 获取按钮
        this.button1 = this.findViewById(R.id.button1);
        this.button2 = this.findViewById(R.id.button2);
        this.button1.setOnClickListener(this);
        this.button2.setOnClickListener(this);
        // 获取Fragment
        this.fragment1 = new Fragment1();
        this.fragment2 = new Fragment2();

        // 获取布局管理器
        this.manager = this.getSupportFragmentManager();
        //使用FragmentManager对象用来开启一个Fragment事务
        this.transaction = this.manager.beginTransaction();
        //默认显示fragment1
        this.transaction.add(R.id.fragmentBox, this.fragment1).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                this.transaction = manager.beginTransaction();
                this.transaction.replace(R.id.fragmentBox, this.fragment1).commit();
                break;
            case R.id.button2:
                this.transaction = manager.beginTransaction();
                this.transaction.replace(R.id.fragmentBox, this.fragment2).commit();
                break;
        }
    }
}