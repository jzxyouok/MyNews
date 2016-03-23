package com.lanou.dllo.mynews.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lanou.dllo.mynews.base.BaseApplication;

/**
 * Created by dllo on 16/3/18.
 */
public class DaoSingleton {
    private static final String DATABASE_NAME = "daodemo.db";

    private volatile static DaoSingleton instance;

    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Context context;
    private DaoMaster.DevOpenHelper helper;
    private FocusDao focusDao;


    private DaoSingleton() {
        context = BaseApplication.getContext();
    }

    public static DaoSingleton getInstance() {
        if (instance == null) {
            synchronized (DaoSingleton.class){
                if (instance == null) {
                    instance = new DaoSingleton();
                }
            }
        }
        return instance;
    }

    public DaoMaster.DevOpenHelper getHelper() {
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(context,DATABASE_NAME,null);
        }
        return helper;
    }

    private SQLiteDatabase getDb(){
        if (db == null) {
            db = getHelper().getWritableDatabase();
        }
        return db;
    }

    private DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            daoMaster = new DaoMaster(getDb());
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        if (daoSession == null) {
            daoSession = getDaoMaster().newSession();
        }
        return daoSession;
    }

    public FocusDao getFocusDao() {
        if (focusDao == null) {
            focusDao = getDaoSession().getFocusDao();
        }
        return focusDao;
    }

}
