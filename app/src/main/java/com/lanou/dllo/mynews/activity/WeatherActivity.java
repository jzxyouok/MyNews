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
import com.lanou.dllo.mynews.bean.WeatherBean;
import com.lanou.dllo.mynews.net.SingleQueue;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dllo on 16/3/17.
 */
public class WeatherActivity extends BaseActivity {

    private WeatherBean.HourlyForecastEntity bean = new WeatherBean.HourlyForecastEntity();
    private WeatherBean.HourlyForecastEntity hourBean = new WeatherBean.HourlyForecastEntity();
    private TextView tmp, hum, pres, sc, dir, spd, vis,qlty,life;
    private ImageView back;


    @Override
    protected void initData() {
        getValue();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.title_back_before, R.anim.title_back_after);

            }
        });
        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherActivity.this, WeatherLifeIndexActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.title_before, R.anim.title_after);
            }
        });

    }

    @Override
    protected void initView() {
        tmp = bindView(R.id.weather_hourly_tmp);
        hum = bindView(R.id.weather_hourly_hum);
        pres = bindView(R.id.weather_hourly_pres);
        sc = bindView(R.id.weather_hourly_sc);
        dir = bindView(R.id.weather_hourly_dir);
        spd = bindView(R.id.weather_hourly_spd);
        back = bindView(R.id.weather_back);
        vis = bindView(R.id.weather_hourly_vis);
        qlty = bindView(R.id.weather_aqi_city_qlty);
        life = bindView(R.id.weather_hourly_lifeindex);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_weather;
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
                            getJSONObject(0).getJSONObject("now");
                    tmp.setText(objData.getString("fl"));
                    hum.setText(objData.getString("hum"));
                    pres.setText(objData.getString("pres"));
                    vis.setText(objData.getString("vis"));
                    dir.setText(objData.getJSONObject("wind").getString("dir"));
                    sc.setText(objData.getJSONObject("wind").getString("sc"));
                    spd.setText(objData.getJSONObject("wind").getString("spd"));
                    qlty.setText(objData.getJSONObject("cond").getString("txt"));
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
