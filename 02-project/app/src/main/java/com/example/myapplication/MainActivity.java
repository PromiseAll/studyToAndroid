package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化水果数据
        initFruits();

        //获取RecyclerView的实例
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //参数1：把布局分成三列   参数2：让布局纵向排列
        //指定RecyclerView的布局方式为 3列纵向瀑布流布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

//        GridLayoutManager layoutManager=new GridLayoutManager(this,5,GridLayoutManager.VERTICAL,false);

        //指定RecyclerView的布局方式为线性布局
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置布局管理器layoutManager的布局方向为水平,默认为垂直
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        //为RecyclerView设置Adapter
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

    }

    private void initFruits() {

        for (int i = 0; i < 3; i++) {


//            Fruit apple=new Fruit("Apple",R.drawable.apple_pic);
            Fruit apple = new Fruit("Apple");
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana");
            fruitList.add(banana);

            Fruit orange = new Fruit("Orange");
            fruitList.add(orange);

            Fruit pear = new Fruit("Pear");
            fruitList.add(pear);

            Fruit watermelon = new Fruit("Watermelon");
            fruitList.add(watermelon);

            Fruit grape = new Fruit("Grape");
            fruitList.add(grape);

            Fruit pineapple = new Fruit("Pineapple");
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit("Strawberry");
            fruitList.add(strawberry);

        }
    }

    private String getRandomLengthName(String name) {

        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}