package com.lanou.dllo.mynews.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.NewsContentActivity;
import com.lanou.dllo.mynews.adapter.NewsReusePagerApapter;
import com.lanou.dllo.mynews.base.BaseApplication;
import com.lanou.dllo.mynews.base.BaseFragment;
import com.lanou.dllo.mynews.bean.NewsPageBean;
import com.lanou.dllo.mynews.net.NetHelper;
import com.lanou.dllo.mynews.net.NetListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/3/7.
 */
public class NewsReuseFragment extends BaseFragment implements NetListener<NewsPageBean> {
    private String tid;
    private ListView listView;
    private NewsReusePagerApapter newsReusePagerApapter;
    private ArrayList<NewsPageBean> bean = new ArrayList<>();
    private boolean isBottom = false;
    private int itemId = 0;
    private Context context;
    //**************
    private RelativeLayout rl;
    private ViewPager viewPager;
    private LinearLayout pointGroup;
    private List<String> urls;
    private ArrayList<ImageView> imageList;
    private ImageLoader loader;
    protected int lastPosition;
    private RequestQueue queue;
    //**************
    private SwipeRefreshLayout swipeRefreshLayout;

    public NewsReuseFragment(String tid) {
        this.tid = tid;
    }

    @Override
    protected void initData() {
        NetHelper netHelper = new NetHelper();
        netHelper.getInfo("http://c.m.163.com/nc/article/list/", tid, "/0", "-20.html", NewsPageBean.class, this);
        listView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (listView.getLastVisiblePosition() == bean.size() - 1 && isBottom) {
                    Toast.makeText(getActivity(), "加载完成", Toast.LENGTH_SHORT).show();
                    NetHelper helper = new NetHelper();
                    itemId += 20;
                    helper.getInfo("http://c.m.163.com/nc/article/list/", tid, "/" + itemId, "-20.html", NewsPageBean.class, new NetListener<NewsPageBean>() {

                        @Override
                        public void getSuccess(NewsPageBean newsPageBean) {
                        }

                        @Override
                        public void getFailed(String s) {
                        }

                        @Override
                        public void getSuccessed(ArrayList<NewsPageBean> t) {
                            newsReusePagerApapter.addData(t);//适配器中 定义一个方法 往里面加入list集合
                            listView.setSelection(itemId - 1);
                        }
                    });
                    isBottom = false;
                } else if (listView.getLastVisiblePosition() != bean.size() - 1) {
                    isBottom = true;
                }
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (listView.getLastVisiblePosition() == bean.size() - 1 && isBottom) {
                    Toast.makeText(getActivity(), "加载完成", Toast.LENGTH_SHORT).show();
                    NetHelper helper = new NetHelper();
                    itemId += 20;
                    helper.getInfo("http://c.m.163.com/nc/article/list/", tid, "/" + itemId, "-20.html", NewsPageBean.class, new NetListener<NewsPageBean>() {

                        @Override
                        public void getSuccess(NewsPageBean newsPageBean) {
                        }

                        @Override
                        public void getFailed(String s) {
                        }

                        @Override
                        public void getSuccessed(ArrayList<NewsPageBean> t) {
                            newsReusePagerApapter.addData(t);//适配器中 定义一个方法 往里面加入list集合
                            listView.setSelection(itemId - 1);
                        }
                    });
                    isBottom = false;
                } else if (listView.getLastVisiblePosition() != bean.size() - 1) {
                    isBottom = true;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        reFresh();
    }

    private boolean isRunning = false;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            // 让viewPager 滑动到下一页
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            if (isRunning) {
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        }

        ;
    };

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        //获得页面的总数
        public int getCount() {
            return Integer.MAX_VALUE; // 使得图片可以循环
        }

        @Override
        /**
         * 获得相应位置上的view
         * container view的容器，其实就是viewpager自身
         * position 相应的位置
         */
        public Object instantiateItem(ViewGroup container, int position) {
            // 给 container 添加一个view
            container.addView(imageList.get(position % imageList.size()));
//            container.addView(pics.get(position % pics.size()));
            // 返回一个和该view相对的object
            return imageList.get(position % imageList.size());
        }

        @Override
        // 判断 view和object的对应关系
        public boolean isViewFromObject(View view, Object object) {
            if (view == object) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        // 销毁对应位置上的object
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            object = null;
        }
    }

    public class MemoryCache implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> cache;

        public MemoryCache() {
            long maxSize = Runtime.getRuntime().maxMemory() / 1024;
            int cacheSize = (int) (maxSize / 4);
            cache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight() / 1024;
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
        }
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.news_fragment_listview);
        rl = (RelativeLayout) LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.item_news_carousel_figure, null);
        viewPager = (ViewPager) rl.findViewById(R.id.item_news_carouselfigure);
        pointGroup = (LinearLayout) rl.findViewById(R.id.point_group);
        listView.addHeaderView(rl);
        swipeRefreshLayout = bindView(R.id.news_fragment_refresh);
    }

    private void reFresh() {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_news_reuse;
    }

    @Override
    public void getSuccess(NewsPageBean newsPageBean) {

    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSuccessed(ArrayList<NewsPageBean> t) {
        bean = t;
        newsReusePagerApapter = new NewsReusePagerApapter(bean, context);
        listView.setAdapter(newsReusePagerApapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NewsContentActivity.class);
                intent.putExtra("url", bean.get(position - 1).getPostid());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.content_before,R.anim.content_after);
            }
        });

        queue = Volley.newRequestQueue(getActivity());
        urls = new ArrayList<>();

        if (bean.get(0).getAds() != null) {
            for (int i = 0; i < bean.get(0).getAds().size(); i++) {
                urls.add(bean.get(0).getAds().get(i).getImgsrc());
            }
        } else {
            urls.add(bean.get(0).getImgsrc());
        }
        Random random = new Random();
        urls.add(bean.get(random.nextInt(19)).getImgsrc());
        urls.add(bean.get(random.nextInt(19)).getImgsrc());
        urls.add(bean.get(random.nextInt(19)).getImgsrc());

        imageList = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            ImageView image = new ImageView(getActivity());
            loader = new ImageLoader(queue, new MemoryCache());
            ImageLoader.ImageListener listener = ImageLoader.getImageListener(image, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
            String url = urls.get(i);
            loader.get(url, listener);

            // 初始化图片资源

            imageList.add(image);
            // 添加指示点
            ImageView point = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 20;
            point.setLayoutParams(params);

            point.setBackgroundResource(R.drawable.point_bg);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }
            pointGroup.addView(point);
        }

        viewPager.setAdapter(new MyPagerAdapter());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //页面切换后调用position 新的页面位置
            public void onPageSelected(int position) {
                position = position % imageList.size();
                // 改变指示点的状态
                // 把当前点enbale 为true
                pointGroup.getChildAt(position).setEnabled(true);
                // 把上一个点设为false
                pointGroup.getChildAt(lastPosition).setEnabled(false);
                lastPosition = position;
            }

            @Override
            //页面正在滑动时回调
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            //当前页面发生变化时回调
            public void onPageScrollStateChanged(int state) {
            }
        });

 /*
  * 自动循环： 1、定时器：Timer 2、开子线程 while true 循环 3、ColckManager 4、 用handler
  * 发送延时信息，实现循环
  */
        isRunning = true;
        // 设置图片的自动滑动
        handler.sendEmptyMessageDelayed(0, 3000);

    }

}
