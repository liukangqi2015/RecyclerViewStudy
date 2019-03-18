package com.liu.recyclerviewstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liu.ItemDecorationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.base_recyclerView_study_btn)
    Button baseRecyclerViewStudyBtn;
    @BindView(R.id.more_recyclerView_study_btn)
    Button moreRecyclerViewStudyBtn;
    @BindView(R.id.recyclerView_many_layout_study_btn)
    Button recyclerViewManyLayoutStudyBtn;
    @BindView(R.id.recyclerView_refresh_and_loadMore_study_btn)
    Button recyclerView_refresh_and_loadMore_study_btn;
    @BindView(R.id.use_of_ItemDecoration_btn)
    Button use_of_ItemDecoration_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.base_recyclerView_study_btn, R.id.more_recyclerView_study_btn,R.id.recyclerView_many_layout_study_btn,R.id.recyclerView_refresh_and_loadMore_study_btn,
    R.id.use_of_ItemDecoration_btn})
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.base_recyclerView_study_btn:
                startActivity(new Intent(this, BaseRecyclerViewActivity.class));
                break;
            case R.id.more_recyclerView_study_btn:
                startActivity(new Intent(this, MoreRecyclerViewActivity.class));
                break;
            case R.id.recyclerView_many_layout_study_btn:
                startActivity(new Intent(this,ManyLayoutRecyclerViewActivity.class));
                break;
            case R.id.recyclerView_refresh_and_loadMore_study_btn:
                startActivity(new Intent(this,RefreshAndLoadMoreActivity.class));
                break;
            case R.id.use_of_ItemDecoration_btn:
                startActivity(new Intent(this, ItemDecorationActivity.class));
                break;
        }
    }
}
