package com.lanou.dllo.mynews.net;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lanou.dllo.mynews.base.BaseApplication;

/**
 * Created by dllo on 16/3/5.
 */
public class SingleQueue {

    //第二步 在内部保存一个静态的自己
    private static SingleQueue singleQueue;
    private RequestQueue queue;//请求队列的对象

    //第一步 构造方法私有化
    private SingleQueue() {
        queue = Volley.newRequestQueue(BaseApplication.getContext());

    }

    public RequestQueue getQueue() {
        return queue;
    }

    //第三步提供方法暴露出一个方法,将自己暴露出去
    public static SingleQueue getInstance() {
        if (singleQueue == null) {
            //synchronizd 能保证大括号的内部只有一个线程
            synchronized (SingleQueue.class) {
                //判断这个类里只有一个线程,判断()里是一个类
                if (singleQueue == null) {
                    singleQueue = new SingleQueue();
                }
            }
        }
        return singleQueue;
    }

}
