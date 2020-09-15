package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 创建了自定义的适配器，继承于RecyclerView.Adapter，将泛型指定为FruitAdapter.ViewHolder
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {


    private List<Fruit> mFruitList;

    /**
     * 定义内部类ViewHolder 继承自 RecyclerView.ViewHolder
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;        //子项最外层布局实例
        TextView fruitName;

        /**
         * 构造参数中传入参数view
         *
         * @param view RecyclerView子项的最外层布局
         */
        public ViewHolder(@NonNull View view) {
            super(view);
            fruitView = view;
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    /**
     * 传入数据源
     * 构造函数
     *
     * @param fruitList
     */
    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    /**
     * 重写onCreateViewHolder方法，用于创建ViewHolder实例，并把加载出来的布局传入到构造函数中，最后将ViewHolder的实例返回
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);

        //声明为final，这样匿名内部类中也能获取
        final ViewHolder holder = new ViewHolder(view);

        //重写onClick方法，为Fruit的视图view设置单击监听器
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得被单击的item的实例
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                //提示信息
                Toast.makeText(v.getContext(), "You clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

//        //重写OnClick方法，为Fruit的图片image也设置单击监听器
//        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                Fruit fruit = mFruitList.get(position);
//                Toast.makeText(v.getContext(), "You cliked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return holder;
    }

    /**
     * 对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitName.setText(fruit.getName());
    }

    /**
     * 告诉RecyclerView有多少子项
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}