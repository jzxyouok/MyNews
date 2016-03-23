package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;

import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String[] args){
        Schema schema = new Schema(1,"com.lanou.dllo.mynews.greendao");
        Entity data = schema.addEntity("Focus");
        data.addIdProperty().primaryKey().autoincrement();
        data.addStringProperty("content");
        data.addStringProperty("title");
        data.addStringProperty("alias");
        data.addStringProperty("name");
        data.addStringProperty("classification");
        data.addStringProperty("picurl");
        data.addStringProperty("headpicurl");
        data.addStringProperty("expertId");
        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java/");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
