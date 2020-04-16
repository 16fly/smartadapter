package com.recyclerview.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.smart.adapter.adapter.CommonAdapter;
import com.smart.adapter.adapter.MultiItemTypeAdapter;
import com.smart.adapter.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView rv;

    private List<String> strList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rv = (RecyclerView) findViewById(R.id.rv);

        for (int i = 0; i < 20; i++) {
            strList.add("我是普通的条目" + i);
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        DataAdapter adapter = new DataAdapter(this);
        adapter.addDataAll(strList);
        rv.setAdapter(adapter);


        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, Object o, int position) {
                return false;
            }
        });
    }

    //CommonAdapter  是普通单一条目的父类
    public class DataAdapter extends CommonAdapter<String> {

        public DataAdapter(Context context) {
            super(context, R.layout.item_normal);
        }

        @Override
        protected void convert(ViewHolder holder, String s, int position) {
            holder.setText(R.id.tv, s);
        }
    }
}
