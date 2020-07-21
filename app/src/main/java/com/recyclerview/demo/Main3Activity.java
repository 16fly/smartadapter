package com.recyclerview.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.smart.adapter.adapter.MultiItemTypeAdapter;
import com.smart.adapter.base.ItemViewDelegate;
import com.smart.adapter.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通的多条目
 */
public class Main3Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private List<User> mUserList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mRecyclerView = findViewById(R.id.recycler_view);
        mUserList.add(new User("张三1", 0));
        mUserList.add(new User("张三2", 0));
        mUserList.add(new User("张三3", 1));
        mUserList.add(new User("张三4", 0));
        mUserList.add(new User("张三5", 0));
        mUserList.add(new User("张三6", 1));
        mUserList.add(new User("张三7", 0));
        mUserList.add(new User("张三8", 0));
        mUserList.add(new User("张三9", 1));
        mUserList.add(new User("张三10", 1));
        mUserList.add(new User("张三11", 0));

        mUserList.add(new User("张三12", 2));
        mUserList.add(new User("张三13", 0));
        mUserList.add(new User("张三14", 2));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter adapter = new UserAdapter(this, mUserList);
        mRecyclerView.setAdapter(adapter);
    }

    //MultiItemTypeAdapter  多条目Adapter的父类
    public class UserAdapter extends MultiItemTypeAdapter<User> {

        public UserAdapter(Context context, List<User> datas) {
            super(context, datas);

            addItemViewDelegate(new User0Delegate());
            addItemViewDelegate(new User1Delegate());
            addItemViewDelegate(new User3Delegate());
        }

        //ItemViewDelegate  每个条目的父类
        public class User0Delegate implements ItemViewDelegate<User> {

            @Override//返回条目的布局
            public int getItemViewLayoutId() {
                return R.layout.item_0;
            }

            @Override//判断在什么条件下显示该条目
            public boolean isForViewType(User user, int position) {
                return user.getType() == 0;
            }

            @Override
            public void convert(ViewHolder holder, User user, int position) {
                holder.setText(R.id.tv, user.getName());
            }
        }

        public class User1Delegate implements ItemViewDelegate<User> {

            @Override
            public int getItemViewLayoutId() {
                return R.layout.item_1;
            }

            @Override
            public boolean isForViewType(User item, int position) {
                return item.getType() == 1;
            }

            @Override
            public void convert(ViewHolder holder, User user, int position) {
                holder.setText(R.id.tv, user.getName());
            }
        }

        public class User3Delegate implements ItemViewDelegate<User> {

            @Override
            public int getItemViewLayoutId() {
                return R.layout.item_2;
            }

            @Override
            public boolean isForViewType(User item, int position) {
                return item.getType() == 2;
            }

            @Override
            public void convert(ViewHolder holder, final User user, int position) {
                holder.setText(R.id.tv, user.getName());
                holder.setOnClickListener(R.id.tv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(mContext, user.getName(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }


    }
}
