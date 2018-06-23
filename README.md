# RoundImage
### 简介
此控件是基于 [CircleImageView](https://github.com/hdodenhof/CircleImageView) 扩展的一个控件，增加了显示的类型，可以显示圆形、圆角、以及正常显示的控件，通过查看该控件的源码可以知道 此控件实现圆形圆角的方式是通过 BitmapShader，这里只是扩展了一个圆角的图片，项目中使用圆形、圆角的需求比较多，如果有其它的形状，也是可以扩展的；

### 效果图
![正常使用](https://upload-images.jianshu.io/upload_images/7082912-af904ba8344ed14d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![listview中使用](https://upload-images.jianshu.io/upload_images/7082912-1076fdfc60ee0a76.gif?imageMogr2/auto-orient/strip)

### 使用方式
```Java

<!-- 圆形显示 -->
<com.hwy.round.RoundImageView
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:layout_centerInParent="true"
    android:src="@drawable/image"
    app:borderColor="#FF6600"
    app:borderOverlay="true"
    app:borderWidth="5dp"
    app:type="round" />

<!-- 圆角显示 -->
<com.hwy.round.RoundImageView
    android:layout_width="150dp"
    android:layout_height="100dp"
    android:layout_centerInParent="true"
    android:src="@drawable/image2"
    app:borderColor="#FF6600"
    app:borderOverlay="true"
    app:borderWidth="10dp"
    app:corner="10dp"
    app:type="square" />

```
