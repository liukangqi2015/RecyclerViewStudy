package com.liu.recyclerviewstudy;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liu.recyclerviewstudy.adapter.LoadMoreAdapter;
import com.liu.recyclerviewstudy.itemDecoration.DividerItemDecoration;
import com.liu.recyclerviewstudy.model.Krystal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * RecyclerView的下拉刷新和上拉加载
 * Created by liu on 2016/11/15.
 */
public class RefreshAndLoadMoreActivity extends AppCompatActivity{
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipe_refresh_layout;
    @BindView(R.id.refresh_recyclerview)
    RecyclerView refresh_recyclerview;

    private LoadMoreAdapter adapter;
    private List<Krystal> data=new ArrayList<>();
    private int[] imgsId={R.mipmap.krystal01,R.mipmap.krystal02,R.mipmap.krystal03,R.mipmap.krystal04};
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_and_loadmore);
        ButterKnife.bind(this);
        initView();
        setListener();
        initData();
        setData();
    }

    private void initView() {
        // 设置下拉进度条颜色
        swipe_refresh_layout.setColorSchemeResources(R.color.colorAccent);
        linearLayoutManager=new LinearLayoutManager(this);
        refresh_recyclerview.setLayoutManager(linearLayoutManager);
        refresh_recyclerview.setHasFixedSize(true);
        refresh_recyclerview.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
    }


    private void setListener() {
        //设置下拉刷新的监听
        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
        //设置滑动监听，完成上拉加载
        refresh_recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState ==RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==adapter.getItemCount()) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<Krystal> newData=new ArrayList<Krystal>();
                            for (int i=0;i<5;i++){
                                Krystal krystal=new Krystal();
                                krystal.setImgId(imgsId[i%imgsId.length]);
                                krystal.setName("NewKrystal"+i);
                                newData.add(krystal);
                            }
                            adapter.addMoreItem(newData);
                            adapter.changeMoreStatus(LoadMoreAdapter.PULLUP_LOAD_MORE);
                        }
                    },1500);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem =linearLayoutManager.findLastVisibleItemPosition();
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
        adapter=new LoadMoreAdapter(data);
        refresh_recyclerview.setAdapter(adapter);
    }


    private void refreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Krystal newKrystal=new Krystal();
                newKrystal.setName("NewKrystal");
                newKrystal.setImgId(R.mipmap.krystal05);
                data.add(0,newKrystal);
                swipe_refresh_layout.setRefreshing(false);
                adapter.notifyDataSetChanged();
            }
        },1500);
    }
}
