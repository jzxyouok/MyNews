package com.lanou.dllo.mynews.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.LoginActivity;
import com.lanou.dllo.mynews.base.BaseFragment;

/**
 * Created by dllo on 16/3/22.
 */
public class MenuFragment extends BaseFragment{
    private ImageView update,setup,iv;
    private TextView name;
    private SimpleDraweeView login;
    private static final int LOGINCODE = 0;
    private static final int REGISTER = 10;
    @Override
    protected void initData() {
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("*****","你牛逼 你点上了 草  就是没有效果");
                iv.setVisibility(View.GONE);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent, LOGINCODE);
                getActivity().overridePendingTransition(R.anim.content_before,R.anim.content_after);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "亲，已经是最新版本了", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initView() {
        login = bindView(R.id.menu_login);
        update = bindView(R.id.menu_update);
        setup = bindView(R.id.menu_setup);
        name = bindView(R.id.menu_tv);
        iv = bindView(R.id.menu_iv);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_menu;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == REGISTER) {
            if (data != null) {
                String names = data.getStringExtra("name");
                String heads = data.getStringExtra("head");
                name.setText(names);
                GenericDraweeHierarchy headChy = GenericDraweeHierarchyBuilder.newInstance
                        (Resources.getSystem()).setRoundingParams(RoundingParams.asCircle()).build();
                login.setHierarchy(headChy);
                login.setImageURI(Uri.parse(heads));
            }
            return;
        }
    }
}
