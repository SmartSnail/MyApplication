package com.example.liulichao.myapplication.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liulichao.myapplication.BaseActivity;
import com.example.liulichao.myapplication.BasePresenter;
import com.example.liulichao.myapplication.MVPBaseActivity;
import com.example.liulichao.myapplication.MainActivity;
import com.example.liulichao.myapplication.R;
import com.example.liulichao.myapplication.presenter.impl.SplashPresenterImpl;
import com.example.liulichao.myapplication.view.SplashView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends MVPBaseActivity<SplashView,SplashPresenterImpl> implements SplashView {
    @BindView(R.id.tv_show_saying)
    TextView mTvShowSaying;
    @BindView(R.id.iv_show_pic)
    ImageView mIvShowPic;

    @Override
    protected SplashPresenterImpl createPresenter() {
        return new SplashPresenterImpl(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
        mPresenter.loadSaying();
        startAnim(MainActivity.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_splash;
    }


    private void startAnim(final Class act){
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvShowPic,"scaleX",1f,1.15f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvShowPic,"scaleY",1f,1.15f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000).play(animatorX).with(animatorY);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(act);
            }
        });
    }

    @Override
    public void onGetSayingSuccess(String sayingStr) {
        mTvShowSaying.setText(sayingStr);
    }

    @Override
    public void onGetSayingFailed() {
        mTvShowSaying.setText(getString(R.string.default_saying));
    }
}
