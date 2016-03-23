package com.lanou.dllo.mynews.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.fragment.ListenFragment;
import com.lanou.dllo.mynews.fragment.MeFragment;
import com.lanou.dllo.mynews.fragment.NewsFragment;
import com.lanou.dllo.mynews.fragment.ReadFragment;
import com.lanou.dllo.mynews.fragment.TopicFragment;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends BaseActivity {
    private TabHost tabHost;
    private ImageButton plus;
    private DrawerLayout mDrawerLayout;

    @Override
    public void initData() {
        tabHost.setup();
        TabHost.TabSpec news = tabHost.newTabSpec("news");
        View n = getLayoutInflater().inflate(R.layout.tab_news, null);
        news.setIndicator(n);
        news.setContent(R.id.tab_news);
        tabHost.addTab(news);

        TabHost.TabSpec reading = tabHost.newTabSpec("reading");
        View r = getLayoutInflater().inflate(R.layout.tab_read, null);
        reading.setIndicator(r);
        reading.setContent(R.id.tab_reading);
        tabHost.addTab(reading);

        TabHost.TabSpec listen = tabHost.newTabSpec("listen");
        View l = getLayoutInflater().inflate(R.layout.tab_listen, null);
        listen.setIndicator(l);
        listen.setContent(R.id.tab_listen);
        tabHost.addTab(listen);

        TabHost.TabSpec topic = tabHost.newTabSpec("topic");
        View t = getLayoutInflater().inflate(R.layout.tab_topic, null);
        topic.setIndicator(t);
        topic.setContent(R.id.tab_topic);
        tabHost.addTab(topic);

        TabHost.TabSpec me = tabHost.newTabSpec("me");
        View m = getLayoutInflater().inflate(R.layout.tab_me, null);
        me.setIndicator(m);
        me.setContent(R.id.tab_me);
        tabHost.addTab(me);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();

        tran.replace(R.id.tab_news, new NewsFragment());
        tran.replace(R.id.tab_reading, new ReadFragment());
        tran.replace(R.id.tab_listen, new ListenFragment());
        tran.replace(R.id.tab_topic, new TopicFragment());
        tran.replace(R.id.tab_me, new MeFragment());

        tran.commit();

        init();
        initEvents();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置抽屉从右面打开
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                //设置抽屉是否锁定
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                        Gravity.RIGHT);
            }
        });
    }

    @Override
    public void initView() {
        tabHost = bindView(android.R.id.tabhost);
        plus = bindView(R.id.main_plus);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    private void initEvents() {
        //为抽屉设置抽屉的监听

        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            // 这个方法是设置抽屉视图交互的函数 里面的两个参数分别是抽屉的视图和位移
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // 创建一个View的对象叫做mContent(就是内容的视图),要显示的是获取在0位置处的抽屉
                View mContent = mDrawerLayout.getChildAt(0);
                // 创建一个View的对象叫做mMenu,叫他跟我们的参数匹配
                View mMenu = drawerView;
                // 创建float类型的参数 scale(比例) 整体的比重
                float scale = 1 - slideOffset;//1就是比重是1,1-slideOffset就是滑动后剩下的比重
                // 同理  创建一个 右侧的比重 rightScale,因为你划出  所以会越来越大,那么右侧的比重就是 80%+整体比重的20%
                float rightScale = 0.8f + scale * 0.2f;
                // 判断 (根据Tag找到视图) 如果drawerView的tag是"LEFT",那么就执行语句
                if (drawerView.getTag().equals("LEFT")) {
                    // 创建一个左面的比重 ,这个值到时候可以自己设置,然后寻求效果
                    float leftScale = 1 - 0.3f * scale;
                    //这里的ViewHelper是引的jar包 叫做nineoldandroids - 2.4.0  大家可以在build的libs文件夹下找到它
                    // 设置各种效果,例如ViewHelper.setScaleX(view, float)
                    // 这里的view参数是大家想要移动哪个View就是你要在上面进行活动的界面,float参数就是要移动的距离 ,注意是浮点类型,
                    // 假如参考坐标最开始的中心位置是0,那么ViewHelper.setScaleX(view,100)就是把view向右移动100.
                    ViewHelper.setScaleX(mMenu, leftScale);//把mMenu横向的比重
                    ViewHelper.setScaleY(mMenu, leftScale);// 竖向的比重
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));// Alpha就是透明度的意思
                    // 设置各种效果,例如ViewHelper.setTranslationX(view, float)
                    // 这里的view参数是大家想要移动哪个View就是你要在上面进行活动的界面,float参数就是要移动的距离 ,注意是浮点类型,
                    // 假如参考坐标最开始的中心位置是0,那么ViewHelper.setSTranslationX(view,100)就是把view向右移动100.
                    ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));//把mContent向右移动 mMenu的宽*(1-scale);
                    ViewHelper.setPivotX(mContent, 0);// 把mContent为轴心向右旋转0
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);//把mContent为轴心向下旋转整个宽的1/2
                    mContent.invalidate();//使mContent无效,因为它移动到后面去了,不能再让他们还能点了

                    ViewHelper.setScaleX(mContent, rightScale);// 同上面的mMenu
                    ViewHelper.setScaleY(mContent, rightScale);
                } else {
                    ViewHelper.setTranslationX(mContent,
                            -mMenu.getMeasuredWidth() * slideOffset);
                    ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }

            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            //当抽屉关闭的时候的功能
            @Override
            public void onDrawerClosed(View drawerView) {

                mDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }
        });
    }

    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.RIGHT);
    }


}
