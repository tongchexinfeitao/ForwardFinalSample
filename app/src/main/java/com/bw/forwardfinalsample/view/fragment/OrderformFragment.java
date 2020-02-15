package com.bw.forwardfinalsample.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.forwardfinalsample.R;
import com.bw.forwardfinalsample.base.BaseFragment;
import com.bw.forwardfinalsample.contract.IOrderformContract;
import com.bw.forwardfinalsample.model.bean.OrderformBean;
import com.bw.forwardfinalsample.presenter.OrderformPresenter;
import com.bw.forwardfinalsample.view.adapter.OrderformAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * 要联网
 */
public class OrderformFragment extends BaseFragment<OrderformPresenter> implements IOrderformContract.IView {


    @BindView(R.id.recycler_order)
    RecyclerView mRecyclerOrder;
    Unbinder unbinder;    //订单状态
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;

    private int status = 0;
    //订单的页数
    private int page = 1;


    //所有数据 ，也可以叫 旧数据
    List<OrderformBean.OrderListBean> list = new ArrayList<>();

    @Override
    protected OrderformPresenter providePresenter() {
        return new OrderformPresenter();
    }

    @Override
    protected void initView(View inflate) {
        //设置支持刷新
        mSmart.setEnableRefresh(true);
        //设置支持分页 加载更多
        mSmart.setEnableLoadMore(true);
        //设置刷新监听
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //0、清除旧数据
                list.clear();
                //1、页数重置为 1
                page = 1;
                //2、重新请求
                mPresenter.getOrderformData(27822,
                        "158166496455127822",
                        status,
                        page,
                        5);
                //3、隐藏刷新的状态
                mSmart.finishRefresh();
            }
        });
        //设置加载更多监听
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //1、页数增加
                page++;
                //2、重新请求
                mPresenter.getOrderformData(27822,
                        "158166496455127822",
                        status,
                        page,
                        5);
                //3、隐藏加载更多的状态
                mSmart.finishLoadMore();
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initData() {

        //防止viewpager 复用 fragment 造成的重复加载
        list.clear();

        //1、获取当前订单的状态
        Bundle bundle = getArguments();
        if (bundle != null) {
            status = bundle.getInt("status");
        }
        //2、根据订单状态，请求对应的数据
        mPresenter.getOrderformData(27822,
                "158166496455127822",
                this.status,
                page,
                5);
    }

    //封装一个给fragment动态传值的方法，并返回fragment对象
    public static OrderformFragment getInstance(int status) {
        OrderformFragment orderformFragment = new OrderformFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("status", status);
        //核心代码，就一句  fragment.setArguments(bundle)
        orderformFragment.setArguments(bundle);
        return orderformFragment;
    }

    //联网请求回来的数据只是一页数据，不是我们全部的数据
    @Override
    public void onOrderformSuccess(OrderformBean orderformBean) {
        // TODO: 2020/2/15 这行代码必须这么写，必须把新数据添加到list中
        //0、拿到订单集合,将订单集合，添加到旧数据里面
        list.addAll(orderformBean.getOrderList());
        //1、设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerOrder.setLayoutManager(linearLayoutManager);

        //2、设置适配器
        OrderformAdapter orderformAdapter = new OrderformAdapter(list);
        mRecyclerOrder.setAdapter(orderformAdapter);
    }

    @Override
    public void onOrderformFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "订单失败" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
