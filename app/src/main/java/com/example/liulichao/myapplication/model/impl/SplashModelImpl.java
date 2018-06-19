package com.example.liulichao.myapplication.model.impl;

import android.os.AsyncTask;

import com.example.liulichao.myapplication.model.SplashModel;
import com.example.liulichao.myapplication.presenter.listener.OnSplashListener;
import com.example.liulichao.myapplication.util.ShowApiUtil;

public class SplashModelImpl implements SplashModel{

    private OnSplashListener onSplashListener;

    @Override
    public void loadSaying(OnSplashListener splashListener) {
        this.onSplashListener = splashListener;
        new ShowAsyncTask().execute(ShowApiUtil.SAYING);
    }

    class ShowAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s != null){
                onSplashListener.onSuccess(s);
            }else{
                onSplashListener.onError();
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            return ShowApiUtil.parseJsonFromSaying(ShowApiUtil.getData(strings[0]));
        }
    }
}
