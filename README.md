## 一、简介
Android智能的Adapter for RecyclerView,支持各种item类型的情况

动图演示如下：

<img src="https://github.com/ydstar/smartadapter/blob/master/images/show.gif" alt="动图演示效果" width="250px">


## 二、导入方式
### 将JitPack存储库添加到您的构建文件中(项目根目录下build.gradle文件)
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### 添加依赖项
仅支持`AndroidX`
```
dependencies {
    implementation 'com.github.ydstar:smartadapter:1.0.0'
}
```

## 三、使用方法
### 1.单条目
```
 public class DataAdapter extends CommonAdapter<String> {

        public DataAdapter(Context context) {
            super(context, R.layout.item_normal);
        }

        @Override
        protected void convert(ViewHolder holder, String s, int position) {
            holder.setText(R.id.tv, s);
        }
 }
```
只需要写自己的Adapter继承CommonAdapter,重写convert方法即可。

### 2.多条目
```
MultiItemTypeAdapter adapter = new MultiItemTypeAdapter(this,mDatas);
adapter.addItemViewDelegate(new User0Delegate());
adapter.addItemViewDelegate(new User1Delegate());
adapter.addItemViewDelegate(new User3Delegate());
```

每种Item类型对应一个ItemViewDelegate
```
   public class UserAdapter extends MultiItemTypeAdapter<User> {

         public UserAdapter(Context context, List<User> datas) {
             super(context, datas);

             addItemViewDelegate(new User0Delegate());
             addItemViewDelegate(new User1Delegate());
             addItemViewDelegate(new User3Delegate());
         }
    }
```

### 3.标准的一个组对应一个列表
```
  SectionRVAdapter adapter = new SectionRVAdapter(this);
  adapter.addSection(new DataSection(this, "我是Section1", mStrList));
  adapter.addSection(new DataSection(this, "我是Section2", mStrList));
  adapter.addSection(new DataSection(this, "我是Section3", mStrList));
```

一个组对应一个list
```
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
    }
```

### 4.添加头和脚,在上面的标准的一个组对应一个列表基础上添加
```
    SectionRVAdapter adapter = new SectionRVAdapter(this);
    adapter.addSection(new DataSection(this, "我是Section1", mStrList));
    adapter.addSection(new DataSection(this, "我是Section2", mStrList));
    adapter.addSection(new DataSection(this, "我是Section3", mStrList));

    mTopWrapper = new TopWrapper(adapter);
```

```
  public class TopWrapper extends HeaderAndFooterWrapper {

         public TopWrapper(RecyclerView.Adapter adapter) {
             super(adapter);

             View view = View.inflate(Main5Activity.this, R.layout.top, null);
             addHeaderView(view);
             addFootView(view);
         }
  }
```

