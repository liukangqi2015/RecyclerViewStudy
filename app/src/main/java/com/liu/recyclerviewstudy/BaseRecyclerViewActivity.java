package com.liu.recyclerviewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.liu.recyclerviewstudy.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.base_recyclerview)
    RecyclerView baseRecyclerview;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler_view);
        ButterKnife.bind(this);
        initView();
        initData();
        setData();
    }

    private void initView() {
        toolbar.inflateMenu(R.menu.base_recyclerview_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuId = item.getItemId();
                switch (menuId) {
                    case R.id.linear_layout_manager:
                        //线性的LayoutManager
                        LinearLayoutManager linearLayoutManger = new LinearLayoutManager(BaseRecyclerViewActivity.this);
                        baseRecyclerview.setLayoutManager(linearLayoutManger);
                        MyAdapter linearAdapter = new MyAdapter(data, null);
                        baseRecyclerview.setAdapter(linearAdapter);
                        break;
                    case R.id.grid_layout_manager:
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(BaseRecyclerViewActivity.this, 3);
                        baseRecyclerview.setLayoutManager(gridLayoutManager);
                        MyAdapter gridAdapter = new MyAdapter(data, null);
                        baseRecyclerview.setAdapter(gridAdapter);
                        break;
                    case R.id.staggeredGrid_layout_manager:
                        //瀑布流LayoutManager
                        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                        baseRecyclerview.setLayoutManager(staggeredGridLayoutManager);
                        List<Integer> heights=new ArrayList<>();
                        for (int i=0;i<data.size();i++){
                            heights.add(100 + (int) (Math.random() * 100));
                        }
                        MyAdapter adapter = new MyAdapter(data, heights);
                        baseRecyclerview.setAdapter(adapter);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

//        baseRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST) );
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            data.add(i + "");
        }
    }

    private void setData() {

        //表格LayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        baseRecyclerview.setLayoutManager(gridLayoutManager);

        MyAdapter adapter = new MyAdapter(data, null);
        baseRecyclerview.setAdapter(adapter);
    }
}
