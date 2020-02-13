package com.bw.forwardfinalsample.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 坑点：
 * 1、onCreateView 方法绝对不能返回 super，白板 ，最好直接干掉
 * 2、千万不要把 onActivityCreated 方法，写成  onActivityResult 方法， 这样的话，initData不会执行
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), null);
        mPresenter = providePresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        ButterKnife.bind(this, inflate);
        initView(inflate);
        return inflate; //千万别忘了返回 inflate
    }

    protected abstract P providePresenter();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();

    //千万别写成 onActivityResult
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
