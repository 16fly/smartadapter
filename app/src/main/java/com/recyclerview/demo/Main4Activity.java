package com.recyclerview.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.smart.adapter.base.ViewHolder;
import com.smart.adapter.section.SectionRVAdapter;
import com.smart.adapter.section.StatelessSection;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    private RecyclerView rv;
    private List<String> strList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 20; i++) {
            strList.add("我是section" + i);
        }

        SectionRVAdapter adapter = new SectionRVAdapter(this);
        adapter.addSection(new DataSection(this, "我是Section1", strList));
        adapter.addSection(new DataSection(this, "我是Section2", strList));
        adapter.addSection(new DataSection(this, "我是Section3", strList));

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    //StatelessSection  添加section的父类
    public class DataSection extends StatelessSection {

        private String title;
        private List<String> strList;
        private Context context;

        public DataSection(Context context, String title, List<String> strList) {
            super(R.layout.section_title, R.layout.section_content);
            this.title = title;
            this.context = context;
            this.strList = strList;
        }

        @Override
        public int getContentItemsTotal() {
            return strList.size();
        }

        @Override
        public ViewHolder getItemViewHolder(View view, int viewType) {
            return new ViewHolder(context, view);
        }

        @Override
        public void onBindItemViewHolder(ViewHolder holder, int position) {
            String s = strList.get(position);
            holder.setText(R.id.tv, s);
        }

        @Override
        public ViewHolder getHeaderViewHolder(Context context, View view) {
            return new ViewHolder(context, view);
        }

        @Override
        public void onBindHeaderViewHolder(ViewHolder holder) {
            super.onBindHeaderViewHolder(holder);
            holder.setText(R.id.tv, title);
        }
    }
}
