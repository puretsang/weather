package com.wai.coroutines;

import android.app.Application;

public class BaseApplication extends Application {
    public static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        loadConfig(Config.class);
    }

    public void loadConfig(Class<? extends BaseConfig> clazz) {
        //让各子类加载, 执行父类配置修改.
        try {
            clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
