package com.lanou.dllo.mynews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by dllo on 16/3/2.
 * Fragment的基类
 */
public abstract class BaseFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(),null);
        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }


    protected abstract void initData();
    protected abstract void initView();
    protected abstract int getLayout();
    protected <T extends View> T bindView(int id){
        return (T) view.findViewById(id);
    }
}
