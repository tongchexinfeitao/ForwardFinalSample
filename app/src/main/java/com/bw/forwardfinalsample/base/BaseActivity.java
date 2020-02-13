package com.bw.forwardfinalsample.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * P extends BasePresenter
 * <p>
 * 坑点：
 * oncreate方法不要写错
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    //受保护的类型 P
    protected P mPresenter;
    private Unbinder unbinder;

    //注意：别写错了onCreate
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //提供布局id
        setContentView(layoutId());
        //提供p
        mPresenter = providePresenter();
        //绑定
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        //初始化view
        unbinder = ButterKnife.bind(this);

        //特殊view的监听
        initView();
        //初始化数据
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P providePresenter();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        if (mPresenter != null) {
            mPresenter.detach();
        }
        //butterkni 解绑，不要求
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
