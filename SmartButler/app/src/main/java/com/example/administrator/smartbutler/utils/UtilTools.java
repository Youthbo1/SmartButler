package com.example.administrator.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * 项目名：  SmartButler
 * 包名：    com.example.administrator.smartbutler.utils
 * 文件名:   UtilTools
 * 创建者:   LGL
 * 创建时间:  2017/11/3 13:58
 * 描述：    工具统一类
 */

public class UtilTools {

   
    //设置字体
    public static void setFont(Context mContext, TextView textview) {
        Typeface fontType = Typeface.createFromAsset(mContext.getAssets(), "fonts/FONT.TTF");
        textview.setTypeface(fontType);
    }
}

