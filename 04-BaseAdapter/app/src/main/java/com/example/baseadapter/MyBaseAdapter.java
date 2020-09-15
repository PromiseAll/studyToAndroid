package com.example.baseadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyBaseAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private String[] data;

    public MyBaseAdapter(Context context, String[] data) {
        this.mContext =  context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return this.data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.text = convertView.findViewById(R.id.text);
            convertView.setTag(holder);
            convertView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(MyBaseAdapter.this.mContext, data[position],Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text.setText(this.data[position]);
        return convertView;
    }

    static class ViewHolder {
        TextView text;
    }
}
