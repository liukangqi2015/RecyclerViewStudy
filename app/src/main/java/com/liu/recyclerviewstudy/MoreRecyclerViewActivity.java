package com.liu.recyclerviewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.liu.recyclerviewstudy.adapter.MoreAdapter;
import com.liu.recyclerviewstudy.itemDecoration.DividerItemDecoration;
import com.liu.recyclerviewstudy.model.Krystal;
import com.liu.recyclerviewstudy.myinterface.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.more_recyclerView)
    RecyclerView moreRecyclerView;

    private MoreAdapter adapter;
    private List<Krystal> data=new ArrayList<>();
    private int[] imgsId={R.mipmap.krystal01,R.mipmap.krystal02,R.mipmap.krystal03,R.mipmap.krystal04};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_recycler_view);
        ButterKnife.bind(this);
        initView();
        initData();
        setData();
    }

    private void initView() {
        toolbar.inflateMenu(R.menu.more_recyclerview_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_item:
                        Krystal newKrystal=new Krystal();
                        newKrystal.setName("NewKrystal");
                        newKrystal.setImgId(R.mipmap.krystal05);
                        adapter.addItem(newKrystal,1);
                        break;
                    case R.id.remove_item:
                        adapter.removeItem(1);
                        break;
                    case R.id.change_item:
                        adapter.changeItem(1);
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
        moreRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        moreRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new MoreAdapter(data);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                TextView tv= ((TextView) view.findViewById(R.id.name_tv));
                Toast.makeText(MoreRecyclerViewActivity.this,"position"+position+"--data"+data.get(position).getName()+"--TextView显示数据"+tv.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        moreRecyclerView.setAdapter(adapter);
    }
}
