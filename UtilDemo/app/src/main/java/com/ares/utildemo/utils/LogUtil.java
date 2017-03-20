package com.ares.utildemo.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.ares.utildemo.utils.LogUtil.Level.Verbose;


/**
 * Created by Yan Cui on 2017/3/20/020.
 */

public class LogUtil {

    private static final String TAG = "LogUtil";
    private static boolean isShow = true;

    private LogUtil(){
        throw new UnsupportedOperationException("This Class cant't be instanced!");
    }

    public static void v(String msg){
        if (isShow) {
            show(msg, Verbose);
        }
    }

    public static void d(String msg){
        if (isShow) {
            show(msg, Level.Debug);
        }
    }

    public static void i(String msg){
        if (isShow) {
            show(msg, Level.Info);
        }
    }

    public static void w(String msg){
        if (isShow) {
            show(msg, Level.Warn);
        }
    }

    public static void e(String msg){
        if (isShow) {
            show(msg, Level.Error);
        }
    }

    private static void show(String msg, Level level){
        List<String> msgList = new ArrayList<>();
        //msg的长度是否大于30
        while (msg.length() > 30){
            //大于30--->添加、截取
            msgList.add("|"+msg.substring(0,30)+"|");
            msg = msg.substring(30,msg.length());
        }
        if (msg.length() == 30) {
            msg = "|"+msg+"|";
            msgList.add(msg);
        }else{
            while (msg.length()<30){
                msg = msg+" ";
            }
            msgList.add("|"+msg+"|");
        }

        switch (level){
            case Verbose:
                Log.v(TAG,"--------------------------------");
                Log.v(TAG,"|Verbose                       |");
                Log.v(TAG,"================================");
                for (String str : msgList) {
                    Log.v(TAG,str);
                }
                Log.v(TAG,"--------------------------------");
                break;
            case Debug:
                Log.d(TAG,"--------------------------------");
                Log.d(TAG,"|Debug                         |");
                Log.d(TAG,"================================");
                for (String str : msgList) {
                    Log.d(TAG,str);
                }
                Log.d(TAG,"--------------------------------");
                break;
            case Info:
                Log.i(TAG,"--------------------------------");
                Log.i(TAG,"|Info                          |");
                Log.i(TAG,"================================");
                for (String str : msgList) {
                    Log.i(TAG,str);
                }
                Log.i(TAG,"--------------------------------");
                break;
            case Warn:
                Log.w(TAG,"--------------------------------");
                Log.w(TAG,"|Warn                          |");
                Log.w(TAG,"================================");
                for (String str : msgList) {
                    Log.w(TAG,str);
                }
                Log.w(TAG,"--------------------------------");
                break;
            case Error:
                Log.e(TAG,"--------------------------------");
                Log.e(TAG,"|Error                         |");
                Log.e(TAG,"================================");
                for (String str : msgList) {
                    Log.e(TAG,str);
                }
                Log.e(TAG,"--------------------------------");
                break;
        }
    }

    enum Level{
        Verbose,Debug,Info,Warn,Error
    }
}
