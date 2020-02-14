package com.bw.forwardfinalsample.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.bw.forwardfinalsample.R;
import com.bw.forwardfinalsample.base.BaseActivity;
import com.bw.forwardfinalsample.base.BasePresenter;
import com.bw.forwardfinalsample.view.fragment.OrderformFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单activity不需要联网请求，所以不需要presenter
 *
 * 坑点：
 * Tablayout 不要写成 Tablelayout
 */
public class OrderformActivity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;

    //Fragment集合
    List<Fragment> fragmentList = new ArrayList<>();
    //标题字符串的集合
    List<String> titleList = new ArrayList<>();

    @Override
    protected void initData() {
        //0、添加标题
        titleList.add("全部订单");
        titleList.add("待支付");
        titleList.add("待收货");
        titleList.add("待评价");
        titleList.add("已完成");

        //1、构造5个fragment
        OrderformFragment allFragment = OrderformFragment.getInstance(0);
        OrderformFragment waitPayFragment = OrderformFragment.getInstance(1);
        OrderformFragment waiReceiveFragment = OrderformFragment.getInstance(2);
        OrderformFragment waitEvaluateFragment = OrderformFragment.getInstance(3);
        OrderformFragment completeFragment = OrderformFragment.getInstance(9);

        //2、添加到fragment集合
        fragmentList.add(allFragment);
        fragmentList.add(waitPayFragment);
        fragmentList.add(waiReceiveFragment);
        fragmentList.add(waitEvaluateFragment);
        fragmentList.add(completeFragment);

        //3、给vp设置适配器
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            //4、给tablayout设置标题
            //如何设置？？？在 FragmentPagerAdapter 中重写getPageTitle 方法,返回标题
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position); //一定要返回标题
            }

        });

        //5、tablayout和vp关联
        mTab.setupWithViewPager(mVp);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_orderform;
    }

}
