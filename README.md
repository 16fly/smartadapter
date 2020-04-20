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