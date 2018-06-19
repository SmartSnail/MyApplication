package com.example.liulichao.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);

    }


    protected  void showProgress(String msg){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void hideProgress(){
        if(mProgressDialog != null){
            mProgressDialog.dismiss();

        }
    }

    protected void startActivity(Class activity){
        startActivity(activity,true);
    }
    protected void startActivity(Class activity,boolean finish){

        Intent intent = new Intent(this,activity);
        startActivity(intent);
        if(finish){
            finish();
        }

    }

    protected  void toast(String msg){

    }

    protected abstract int getLayoutRes();
}
