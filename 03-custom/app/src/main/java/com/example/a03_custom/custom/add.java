package com.example.a03_custom.custom;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;

import com.example.a03_custom.R;

public class add extends RelativeLayout {
    int number = 0;
    View btn_add;
    View btn_reduce;
    EditText value_number;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public add(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public add(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public add(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public add(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_add, this, false);
        addView(view);
        init();

    }

    public void init() {
        this.setView();
        this.updateValue(0);
    }

    public void setView() {
        btn_add = this.findViewById(R.id.add);
        btn_reduce = this.findViewById(R.id.reduce);
        value_number = findViewById(R.id.number);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

        btn_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reduce();
            }
        });
    }

    public void updateValue(int value) {
        this.value_number.setText(String.valueOf(value));
    }

    public void add() {
        this.number = this.number + 1;
        this.updateValue(this.number);
    }

    public void reduce() {
        this.number = this.number - 1;
        this.updateValue(this.number);
    }
}

