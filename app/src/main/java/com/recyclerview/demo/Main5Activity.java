package com.recyclerview.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.smart.adapter.base.ViewHolder;
import com.smart.adapter.section.SectionRVAdapter;
import com.smart.adapter.section.StatelessSection;
import com.smart.adapter.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    private RecyclerView rv;
    private List<String> strList = new ArrayList<>();
    private LinearLayout mLayoutContainer;
    private TopWrapper mTopWrapper;
    private RecyclerView mRv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        mLayoutContainer = (LinearLayout) findViewById(R.id.recyclerview_container);
        rv = new RecyclerView(this);
        mLayoutContainer.addView(rv);


        for (int i = 0; i < 20; i++) {
            strList.add("我是section" + i);
        }

        SectionRVAdapter adapter = new SectionRVAdapter(this);
        adapter.addSection(new DataSection(this, "我是Section1", strList));
        adapter.addSection(new DataSection(this, "我是Section2", strList));
        adapter.addSection(new DataSection(this, "我是Section3", strList));

        mTopWrapper = new TopWrapper(adapter);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mTopWrapper);
    }

    //HeaderAndFooterWrapper  是头的父类
    public class TopWrapper extends HeaderAndFooterWrapper {

        public TopWrapper(RecyclerView.Adapter adapter) {
            super(adapter);

            View view = View.inflate(Main5Activity.this, R.layout.top, null);
            addHeaderView(view);
            addFootView(view);
        }
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
