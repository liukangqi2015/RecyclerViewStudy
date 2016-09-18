package com.liu.recyclerviewstudy.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liu.recyclerviewstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2016/9/13.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    //数据集
    private List<String> data;
    private int[] color = {Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE};
    private List<Integer> heights = new ArrayList<>();

    public MyAdapter(List<String> data, List<Integer> heights) {
        this.data = data;
        this.heights = heights;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_recyclerview_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
        if (heights != null && heights.size() > 0) {
            ViewGroup.LayoutParams lp = holder.linearLayout.getLayoutParams();
            lp.height = heights.get(position);
            Log.e("TAG", "postion" + position + "--height" + lp.height);
            holder.linearLayout.setLayoutParams(lp);
        }
        int j = position % color.length;
        holder.linearLayout.setBackgroundColor(color[j]);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = ((TextView) itemView.findViewById(R.id.tv));
            linearLayout = ((LinearLayout) itemView.findViewById(R.id.ll));
        }
    }
}
