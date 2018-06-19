package com.example.liulichao.myapplication.presenter.impl;

import com.example.liulichao.myapplication.BasePresenter;
import com.example.liulichao.myapplication.model.impl.SplashModelImpl;
import com.example.liulichao.myapplication.presenter.SplashPresenter;
import com.example.liulichao.myapplication.presenter.listener.OnSplashListener;
import com.example.liulichao.myapplication.view.SplashView;

public class SplashPresenterImpl extends BasePresenter<SplashView> implements SplashPresenter,OnSplashListener{

    private  SplashView mSplashVIew;
    private SplashModelImpl mSplashModelImpl;

    public SplashPresenterImpl(SplashView splashView){
        mSplashVIew = splashView;
        mSplashModelImpl = new SplashModelImpl();
    }

    @Override
    public void loadSaying() {
        mSplashModelImpl.loadSaying(this);
    }

    @Override
    public void onSuccess(String str) {
        mSplashVIew.onGetSayingSuccess(str);
    }

    @Override
    public void onError() {
        mSplashVIew.onGetSayingFailed();
    }
}
