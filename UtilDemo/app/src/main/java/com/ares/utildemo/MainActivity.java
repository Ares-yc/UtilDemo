package com.ares.utildemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ares.utildemo.utils.DialogUtil;
import com.ares.utildemo.utils.T;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button showToast,showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast = (Button) findViewById(R.id.btn_show_toast);
        showDialog = (Button) findViewById(R.id.btn_show_dialog);

        showToast.setOnClickListener(this);
        showDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show_toast:
                T.show("Button被点击了！",1000);
                break;
            case R.id.btn_show_dialog:
                DialogUtil.getSingle().showDialog(this,"提示","显示Dialog","确定","取消",null,null,true);
                break;
        }
    }
}
