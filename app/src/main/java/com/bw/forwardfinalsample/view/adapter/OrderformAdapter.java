package com.bw.forwardfinalsample.view.adapter;

import android.support.annotation.NonNull;
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
        orderformViewHolder.mTvTime.setText(format );

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
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OrderformViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_order_id)
        TextView mTvOrderId;
        @BindView(R.id.recycler_commidity)
        RecyclerView mRecyclerCommidity;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.btn_pay_or_receive)
        Button mBtnPayOrReceive;

        public OrderformViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
