package com.lanou.dllo.mynews.net;

import java.util.ArrayList;

/**
 * Created by dllo on 16/3/5.
 */
public interface NetListener<T> {
    void getSuccess(T t);

    void getFailed(String s);

    void getSuccessed(ArrayList<T> t);

}
