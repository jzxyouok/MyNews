package com.lanou.dllo.mynews.net;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by dllo on 16/3/5.
 */
public class NetHelper {
    private RequestQueue requestQueue;

    public NetHelper() {
        SingleQueue singleQueue = SingleQueue.getInstance();
        requestQueue = singleQueue.getQueue();
    }


    //从网络获取信息
    public <T> void getDataFromNet(String url, final Map head, final NetListener netListener, final Class<T> clazz) {

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                T t = gson.fromJson(response.toString(), clazz);
                //成功回调,返回给 Activity
                netListener.getSuccess(t);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //错误回调,返回给 Activity
                netListener.getFailed("拉取失败");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (head != null) {
                    //如果有头信息则返回头信息
                    return head;
                }
                return super.getHeaders();
            }
        };
        //添加请求队列
        requestQueue.add(request);
    }


    public <T> void getInfo(String head, final String tid, String leg, String bottom, final Class<T> cls, final NetListener netListener) {
        String url = head + tid + leg + bottom;
        final ArrayList<T> list = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray(tid);
                    for (int i = 0; i < array.length(); i++) {
                        T t = new Gson().fromJson(array.getJSONObject(i).toString(), cls);
                        list.add(t);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                netListener.getSuccessed(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                netListener.getFailed("");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    //从网络获取信息
    public <T> void getVideoFromNet(String heads, final String leg, String bottom, final Map head, final NetListener netListener, final Class<T> clazz) {
        String url = heads + leg + bottom;
        final ArrayList<T> list = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                T t = gson.fromJson(response.toString(), clazz);
                for (int i = 0; i < 10; i++) {

                    list.add(t);
                }
                //成功回调,返回给 Activity
                netListener.getSuccess(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //错误回调,返回给 Activity
                netListener.getFailed("拉取失败");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (head != null) {
                    //如果有头信息则返回头信息
                    return head;
                }
                return super.getHeaders();
            }
        };
        //添加请求队列
        requestQueue.add(request);
    }

    public void getNewsContentFromNet(String url, final NetListener netListener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                netListener.getSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }


}
