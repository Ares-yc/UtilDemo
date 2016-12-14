package com.ares.utildemo.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ares.utildemo.R;

/**
 * Material Design 风格Dialog工具类
 * Created by kxd on 2016/11/30/030.
 */

public class DialogUtil {

    private static AlertDialog.Builder builder;
    private static AlertDialog alertDialog;
    private static DialogUtil single;

    private DialogUtil(){

    }

    public static DialogUtil getSingle(){
        if (single == null) {
            synchronized (DialogUtil.class){
                single = new DialogUtil();
            }
        }
        return single;
    }

    /**
     * 自定义布局AlertDialog
     * @param title             标题
     * @param message           内容
     * @param contentView       自定义布局
     * @param positiveBtnText   确认按钮
     * @param negativeBtnText   取消按钮
     * @param positiveCallback  确认事件监听器
     * @param negativeCallback  取消事件监听器
     * @param cancelable        是否支持点击任意位置取消对话框
     */
    public void showDialog(Context context, String title, String message, View contentView,
                           String positiveBtnText, String negativeBtnText,
                           DialogInterface.OnClickListener positiveCallback,
                           DialogInterface.OnClickListener negativeCallback,
                           boolean cancelable) {
        builder = new AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(title == null ? "提示" : title);
        builder.setIcon(R.mipmap.ic_launcher);
        if (message != null) {
            builder.setMessage(message);
        }

        if (contentView != null) {
            builder.setView(contentView);
        }

        if (positiveBtnText != null) {
            builder.setPositiveButton(positiveBtnText, positiveCallback);
        }

        if (negativeBtnText != null) {
            builder.setNegativeButton(negativeBtnText, negativeCallback);
        }

        builder.setCancelable(cancelable);
        alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     *  普通AlertDialog
     * @param title             标题
     * @param message           内容
     * @param positiveBtnText   确认按钮
     * @param negativeBtnText   取消按钮
     * @param positiveCallback  确认事件监听器
     * @param negativeCallback  取消事件监听器
     * @param cancelable        是否支持点击任意位置取消对话框
     */
    public void showDialog(Context context, String title, String message,
                           String positiveBtnText, String negativeBtnText,
                           DialogInterface.OnClickListener positiveCallback,
                           DialogInterface.OnClickListener negativeCallback,
                           boolean cancelable) {
        showDialog(context,title, message, null, positiveBtnText, negativeBtnText, positiveCallback, negativeCallback, cancelable);
    }

    /**
     * 带ProgressBar的对话框
     * @param title             标题
     * @param message           内容
     * @param positiveBtnText   确认按钮文字
     * @param negativeBtnText   取消按钮文字
     * @param positiveCallback  确认事件监听器
     * @param negativeCallback  取消事件监听器
     * @param cancelable        是否支持点击任意位置取消对话框
     */
    public void showProgressDialog(Context context, String title, String message,
                                   String positiveBtnText, String negativeBtnText,
                                   DialogInterface.OnClickListener positiveCallback,
                                   DialogInterface.OnClickListener negativeCallback,
                                   boolean cancelable) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_circular_progressbar, null);
        if (message != null) {
            final TextView messageTv = (TextView) view.findViewById(R.id.progressbar_msg);
            messageTv.setText(message);
        }

        showDialog(context,title, null, view, positiveBtnText, negativeBtnText, positiveCallback, negativeCallback, cancelable);
    }

    /**
     * 正在加载对话框
     * @param cancelable  是否支持点击任意位置取消对话框
     */
    public void showLoadDialog(Context context, boolean cancelable){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_circular_progressbar, null);
        showDialog(context,null, null, view, null, null, null, null, cancelable);
    }

    /**
     * 隐藏对话框
     */
    public void hideDialog(){
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }
}
