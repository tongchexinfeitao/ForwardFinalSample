package com.bw.forwardfinalsample.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.forwardfinalsample.R;
import com.bw.forwardfinalsample.model.bean.OrderformBean;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单的适配器
 *
 * 订单中商品列表如何展示商品数据？
 *
 * 1、在订单适配器的 onBindViewHolder()中 ，创建商品的适配器
 * 2、将商品的适配器 设置给 订单viewHolder 中的商品 RecyclerView
 */
public class OrderformAdapter extends RecyclerView.Adapter<OrderformAdapter.OrderformViewHolder> {

    //订单集合
    private List<OrderformBean.OrderListBean> list;

    public OrderformAdapter(List<OrderformBean.OrderListBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public OrderformViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order_form, viewGroup, false);
        return new OrderformViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderformViewHolder orderformViewHolder, int i) {
        //拿到当前订单数据
        OrderformBean.OrderListBean orderListBean = list.get(i);

        //设置订单号
        orderformViewHolder.mTvOrderId.setText("订单号 " + orderListBean.getOrderId());

        //订单时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(orderListBean.getOrderTime());
        orderformViewHolder.mTvTime.setText(format);

        //拿到状态码
        int orderStatus = orderListBean.getOrderStatus();
        //根据订单状态显示支付或者确认收货按钮
        if (orderStatus == 1) {
            orderformViewHolder.mBtnPayOrReceive.setVisibility(View.VISIBLE);
            orderformViewHolder.mBtnPayOrReceive.setText("去支付");
        } else if (orderStatus == 2) {
            orderformViewHolder.mBtnPayOrReceive.setVisibility(View.VISIBLE);
            orderformViewHolder.mBtnPayOrReceive.setText("确认收货");
        } else {
            orderformViewHolder.mBtnPayOrReceive.setVisibility(View.GONE);
        }

        // TODO: 2020/2/15  给商品列值表赋值，如何赋？  就配是给他设置 布局管理器和适配器

        //设置了布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(orderformViewHolder.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        orderformViewHolder.mRecyclerCommidity.setLayoutManager(linearLayoutManager);
        
        // 1、拿到商品列表
        List<OrderformBean.OrderListBean.DetailListBean> detailList = orderListBean.getDetailList();
        // 2、构造商品列表适配器 ，两个参数，一个商品列表，一个订单状态
        OrderformCommodityAdapter orderformCommodityAdapter = new OrderformCommodityAdapter(detailList,orderStatus);
        // 3、给viewHolder中的商品 RecyclerView 设置适配器
        orderformViewHolder.mRecyclerCommidity.setAdapter(orderformCommodityAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //订单的ViewHolder
    class OrderformViewHolder extends RecyclerView.ViewHolder {
        //订单号
        @BindView(R.id.tv_order_id)
        TextView mTvOrderId;
        //商品列表
        @BindView(R.id.recycler_commidity)
        RecyclerView mRecyclerCommidity;
        //订单时间
        @BindView(R.id.tv_time)
        TextView mTvTime;
        //订单按钮
        @BindView(R.id.btn_pay_or_receive)
        Button mBtnPayOrReceive;

        public OrderformViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
