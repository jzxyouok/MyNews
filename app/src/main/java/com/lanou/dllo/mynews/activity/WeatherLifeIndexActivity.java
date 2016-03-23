package com.lanou.dllo.mynews.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.lanou.dllo.mynews.R;
import com.lanou.dllo.mynews.base.BaseActivity;
import com.lanou.dllo.mynews.net.SingleQueue;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dllo on 16/3/22.
 */
public class WeatherLifeIndexActivity extends BaseActivity {
    private ImageView back;
    private TextView comf_brf,comf_txt,cw_brf,cw_txt,drsg_brf,drsg_txt,
                     flu_brf,flu_txt,sport_brf,sport_txt,trav_brf,trav_txt,uv_brf,uv_txt;
    @Override
    protected void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherLifeIndexActivity.this, WeatherActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.title_back_before, R.anim.title_back_after);
            }
        });
        getValue();

    }

    @Override
    protected void initView() {
        back = bindView(R.id.life_back);
        comf_brf = bindView(R.id.life_comf_brf);
        comf_txt = bindView(R.id.life_comf_txt);
        cw_brf = bindView(R.id.life_cw_brf);
        cw_txt = bindView(R.id.life_cw_txt);
        drsg_brf = bindView(R.id.life_drsg_brf);
        drsg_txt = bindView(R.id.life_drsg_txt);
        flu_brf = bindView(R.id.life_flu_brf);
        flu_txt = bindView(R.id.life_flu_txt);
        sport_brf = bindView(R.id.life_sport_brf);
        sport_txt = bindView(R.id.life_sport_txt);
        uv_brf = bindView(R.id.life_uv_brf);
        uv_txt = bindView(R.id.life_uv_txt);
        trav_brf = bindView(R.id.life_trav_brf);
        trav_txt = bindView(R.id.life_trav_txt);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_weather_lifeindex;
    }
    private void getValue() {
        SingleQueue singleQueue = SingleQueue.getInstance();
        RequestQueue requestQueue = singleQueue.getQueue();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://api.heweather.com/x3/weather?cityid=CN101070201&key=54dd112a18b143fea86b5bd0e0895cd3",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject objData = null;
                try {
                    objData = response.getJSONArray("HeWeather data service 3.0").
                            getJSONObject(0).getJSONObject("suggestion");
                    comf_brf.setText(objData.getJSONObject("comf").getString("brf"));
                    comf_txt.setText(objData.getJSONObject("comf").getString("txt"));
                    cw_brf.setText(objData.getJSONObject("cw").getString("brf"));
                    cw_txt.setText(objData.getJSONObject("cw").getString("txt"));
                    drsg_brf.setText(objData.getJSONObject("drsg").getString("brf"));
                    drsg_txt.setText(objData.getJSONObject("drsg").getString("txt"));
                    flu_brf.setText(objData.getJSONObject("flu").getString("brf"));
                    flu_txt.setText(objData.getJSONObject("flu").getString("txt"));
                    sport_brf.setText(objData.getJSONObject("sport").getString("brf"));
                    sport_txt.setText(objData.getJSONObject("sport").getString("txt"));
                    trav_brf.setText(objData.getJSONObject("trav").getString("brf"));
                    trav_txt.setText(objData.getJSONObject("trav").getString("txt"));
                    uv_brf.setText(objData.getJSONObject("uv").getString("brf"));
                    uv_txt.setText(objData.getJSONObject("uv").getString("txt"));

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //失败
            }

        });

        requestQueue.add(jsonObjectRequest);
    }
}
