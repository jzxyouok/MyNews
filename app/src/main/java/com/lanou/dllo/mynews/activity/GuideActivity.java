package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.adapter.GuidePagerAdapter;
import com.lanou.dllo.mynews.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by zhang on 2016/3/2.
 */
public class GuideActivity extends BaseActivity {

    private ViewPager guideViewPager;
    private GuidePagerAdapter guidePagerAdapter;
    private ArrayList<View> mViews;
    // 底部导航的小点
    private ImageView[] guideDots;
    // 记录当前选中的图片
    private int currentIndex;
    // 还记得我们的开始按钮吗？
    private TextView textView;

    // 图片资源，这里我们放入了3张图片，因为第四张图片，我们已经在guide_content_view.xml中加载好了
    private final int images[] = {
            //TODO 引导页图片待更换
            R.mipmap.one, R.mipmap.two, R.mipmap.three
    };

    @Override
    protected void initData() {
        initDot();
        // 添加页面更换监听事件，来更新导航小点的状态。
        guideViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                setCurrentDot(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    @Override
    protected void initView() {
        guideViewPager = bindView(R.id.guide_view_pager);
        mViews = new ArrayList<View>();

        for (int i = 0; i < images.length; i++) {
            // 新建一个ImageView容器来放置我们的图片。
            ImageView iv = new ImageView(GuideActivity.this);
            iv.setBackgroundResource(images[i]);

            // 将容器添加到图片列表中
            mViews.add(iv);
        }

        // 上面添加了三张图片了，还有一张放在guide_content_view.xml中，我们把这个页面也添加进来。
        View view = LayoutInflater.from(GuideActivity.this).inflate(R.layout.activity_guide_content_view, null);
        mViews.add(view);

        // 现在为我们的开始按钮找到对应的控件
//        textView = bindView(R.id.start_btn);
        textView = (TextView) view.findViewById(R.id.guide_start);
        // 开始按钮的点击事件监听
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 跳到主页
//                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
//                startActivity(intent);
//                GuideActivity.this.finish();
//            }
//        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // 现在用到我们的页面适配器了
        guidePagerAdapter = new GuidePagerAdapter(mViews);
        guideViewPager.setAdapter(guidePagerAdapter);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_guide_view;
    }

    // 初始化导航小点
    private void initDot() {
        // 找到放置小点的布局
        LinearLayout layout = bindView(R.id.guide_dots);

        // 初始化小点数组
        guideDots = new ImageView[mViews.size()];

        // 循环取得小点图片，让每个小点都处于正常状态
        for (int i = 0; i < mViews.size(); i++) {
            guideDots[i] = (ImageView) layout.getChildAt(i);
            guideDots[i].setSelected(false);
        }

        // 初始化第一个小点为选中状态
        currentIndex = 0;
        guideDots[currentIndex].setSelected(true);
    }

    // 页面更换时，更新小点状态
    private void setCurrentDot(int position) {
        if (position < 0 || position > mViews.size() - 1 || currentIndex == position) {
            return;
        }
        guideDots[position].setSelected(true);
        guideDots[currentIndex].setSelected(false);
        currentIndex = position;
    }

}
