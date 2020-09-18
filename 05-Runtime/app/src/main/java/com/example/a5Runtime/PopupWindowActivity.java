package com.example.a5Runtime;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PopupWindowActivity extends AppCompatActivity {
    View view;
    PopupWindow popWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.popup_window);

        this.view = LayoutInflater.from(this).inflate(R.layout.item_popup, null, false);
        this.popWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);

        this.findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWindow.showAsDropDown(v, 50, 0);
            }
        });

        this.findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopupWindowActivity.this, "点击测试~", Toast.LENGTH_SHORT).show();
            }
        });

        this.view.findViewById(R.id.btn_xixi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopupWindowActivity.this, "你点击了嘻嘻~", Toast.LENGTH_SHORT).show();
                PopupWindowActivity.this.popWindow.dismiss();
            }
        });
    }
}
