package com.example.baseadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<String> data;

    public MyBaseAdapter(Context context, ArrayList<String> data) {
        this.mContext = context;  //定义上下文,由MainActivity传入
        this.inflater = LayoutInflater.from(context); //获取布局管理器
        this.data = data; //获取传入的数据
    }

    // 获取一个有几个item
    @Override
    public int getCount() {
        return this.data.size();
    }

    // 获取当前屏幕渲染item位置对应data数据
    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    // 获取当前屏幕渲染item位置
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.text = convertView.findViewById(R.id.text);
            holder.delete_btn = convertView.findViewById(R.id.delete);
            holder.setEvent();
            convertView.setTag(holder);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MyBaseAdapter.this.mContext, holder.text.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text.setText(this.data.get(position));
        return convertView;
    }

    class ViewHolder implements View.OnClickListener {
        // 实现View.OnClickListener接口
        TextView text;
        Button delete_btn;

        public void setEvent() {
            // 设置点击事件,this 传入当前实现接口类实例
            this.delete_btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.delete:
                    MyBaseAdapter.this.data.remove(this.text.getText());
                    MyBaseAdapter.this.notifyDataSetChanged();
            }
        }
    }
}
