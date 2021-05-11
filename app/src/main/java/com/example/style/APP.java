package com.example.style;

import android.app.Application;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/**
 * @author : 鑫宇
 * e-mail : 1769314609@qq.com
 * time   : 2021/05/10
 * desc   :
 * version: 1.0
 */
public class APP extends Application {
    //使用static代码段可以防止内存泄漏
    static {
        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer((context, layout) -> {
//            //开始设置全局的基本参数（可以被下面的DefaultRefreshHeaderCreator覆盖）
//            layout.setReboundDuration(1000);
//            layout.setReboundInterpolator(new DropBounceInterpolator());
//            layout.setFooterHeight(100);
//            layout.setDisableContentWhenLoading(false);
//            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
        });
    }
}