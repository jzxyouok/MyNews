package com.lanou.dllo.mynews.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.activity.GoldMallActivity;
import com.lanou.dllo.mynews.activity.LoginActivity;
import com.lanou.dllo.mynews.base.BaseFragment;

/**
 * Created by dllo on 16/3/2.
 */
public class MeFragment extends BaseFragment {

    private static final int LOGINCODE = 0;
    private static final int REGISTER = 10;

    private TextView landingTv;
    private LinearLayout lineMall;
    private SimpleDraweeView imageView;

    @Override
    protected void initData() {

        landingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent, LOGINCODE);
                getActivity().overridePendingTransition(R.anim.content_before,R.anim.content_after);
            }
        });
        lineMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GoldMallActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.content_before, R.anim.content_after);

            }
        });

    }

    @Override
    protected void initView() {
        landingTv = bindView(R.id.me_landing_tv);
        lineMall = bindView(R.id.me_line_mall);
        imageView = bindView(R.id.me_iv);
    }

    @Override
    protected int getLayout() {

        return R.layout.fragment_me;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == REGISTER) {
            if (data != null) {
                String name = data.getStringExtra("name");
                String head = data.getStringExtra("head");
                landingTv.setText(name);
                GenericDraweeHierarchy headChy = GenericDraweeHierarchyBuilder.newInstance
                        (Resources.getSystem()).setRoundingParams(RoundingParams.asCircle()).build();
                imageView.setHierarchy(headChy);
                imageView.setImageURI(Uri.parse(head));
            }
            return;
        }

    }
}
