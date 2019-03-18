package com.liu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.liu.recyclerviewstudy.MoreRecyclerViewActivity;
import com.liu.recyclerviewstudy.R;
import com.liu.recyclerviewstudy.adapter.MoreAdapter;
import com.liu.recyclerviewstudy.itemDecoration.DividerItemDecoration;
import com.liu.recyclerviewstudy.model.Krystal;
import com.liu.recyclerviewstudy.myinterface.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDecorationActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.more_recyclerView)
    RecyclerView moreRecyclerView;

    private MoreAdapter adapter;
    private List<Krystal> data=new ArrayList<>();
    private int[] imgsId={R.mipmap.krystal01,R.mipmap.krystal02,R.mipmap.krystal03,R.mipmap.krystal04};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);
        ButterKnife.bind(this);
        initView();
        initData();
        setData();
    }

    private void initView() {
        toolbar.inflateMenu(R.menu.item_decoration_recyclerview_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.vertica:
                        moreRecyclerView.addItemDecoration(new DividerItemDecoration(ItemDecorationActivity.this,LinearLayoutManager.VERTICAL));
                        break;
                }
                return false;
            }
        });
    }

    private void initData(){
        for (int i=0;i<20;i++){
            Krystal krystal=new Krystal();
            krystal.setImgId(imgsId[i%imgsId.length]);
            krystal.setName("Krystal"+i);
            data.add(krystal);
        }
    }


    private void setData(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        moreRecyclerView.setLayoutManager(linearLayoutManager);
        moreRecyclerView.setHasFixedSize(true);
        adapter=new MoreAdapter(data);
        moreRecyclerView.setAdapter(adapter);
    }
}
