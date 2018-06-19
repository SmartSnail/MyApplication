package com.example.liulichao.myapplication;

import android.os.Bundle;

public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends BaseActivity {

    protected T mPresenter;

    protected abstract  T createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
