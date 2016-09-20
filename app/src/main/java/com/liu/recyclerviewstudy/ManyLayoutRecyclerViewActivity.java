package com.liu.recyclerviewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liu.recyclerviewstudy.adapter.ManyLayoutAdapter;
import com.liu.recyclerviewstudy.model.Krystal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ManyLayoutRecyclerViewActivity extends AppCompatActivity {
    private List<Krystal> data=new ArrayList<>();
    private int[] imgsId={R.mipmap.krystal01,R.mipmap.krystal02,R.mipmap.krystal03,R.mipmap.krystal04};

    @BindView(R.id.many_layout_recyclerView)
    RecyclerView manyLayoutRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_layout_recycler_view);
        ButterKnife.bind(this);
        initData();
        setData();
    }

    private void initData() {
        for (int i=0;i<20;i++){
            Krystal krystal=new Krystal();
            krystal.setImgId(imgsId[i%imgsId.length]);
            krystal.setName("Krystal"+i);
            data.add(krystal);
        }
    }

    private void setData() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        manyLayoutRecyclerView.setLayoutManager(linearLayoutManager);
        ManyLayoutAdapter adapter=new ManyLayoutAdapter(data);
        manyLayoutRecyclerView.setAdapter(adapter);
    }
}
