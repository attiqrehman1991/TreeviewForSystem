package com.attiqurrehmanrao.treeview;

import android.app.Application;

import com.github.johnkil.print.PrintConfig;

public class PrintApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PrintConfig.initDefault(getAssets(), "fonts/material-icon-font.ttf");
    }

}