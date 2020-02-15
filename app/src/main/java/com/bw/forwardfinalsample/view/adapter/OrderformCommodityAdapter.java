package com.bw.forwardfinalsample.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.forwardfinalsample.R;
import com.bw.forwardfinalsample.model.bean.OrderformBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单中商品列表适配器
 */
public class OrderformCommodityAdapter extends RecyclerView.Adapter<OrderformCommodityAdapter.OrderformCommodityViewHolder> {

    //商品的集合
    private List<OrderformBean.OrderListBean.DetailListBean> detailList;
    //订单的状态码
    private int orderStatus;

    public OrderformCommodityAdapter(List<OrderformBean.OrderListBean.DetailListBean> detailList, int orderStatus) {

        this.detailList = detailList;
        this.orderStatus = orderStatus;
    }

    @NonNull
    @Override
    public OrderformCommodityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order_form_commodity, viewGroup, false);
        return new OrderformCommodityViewHolder(inflate);
    }

    //绑定数据很简单，  数据在bean中，控件在viewHolder中
    @Override
    public void onBindViewHolder(@NonNull OrderformCommodityViewHolder orderformCommodityViewHolder, int i) {
        //拿到当前商品bean
        OrderformBean.OrderListBean.DetailListBean detailListBean = detailList.get(i);

        //商品名字
        orderformCommodityViewHolder.mProductTitleNameTv.setText(detailListBean.getCommodityName());

        //商品价格
        orderformCommodityViewHolder.mProductPriceTv.setText("￥" + detailListBean.getCommodityPrice());

        //商品的图片  ，是多个图片地址用逗号拼在一起的，需要分割,取第0个图片地址
        String commodityPic = detailListBean.getCommodityPic();
        String[] split = commodityPic.split(",");
        commodityPic = split[0];

        Glide.with(orderformCommodityViewHolder.mProductIconIv)
                .load(commodityPic)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(orderformCommodityViewHolder.mProductIconIv);

        //商品上的待评价按钮
        //如果订单状态为3待评价状态，将商品上的去评价按钮显示出来
        if (orderStatus == 3) {
            orderformCommodityViewHolder.mBtnEvaluate.setVisibility(View.VISIBLE);
        } else {
            orderformCommodityViewHolder.mBtnEvaluate.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    class OrderformCommodityViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_icon_iv)
        ImageView mProductIconIv;
        @BindView(R.id.product_title_name_tv)
        TextView mProductTitleNameTv;
        @BindView(R.id.product_price_tv)
        TextView mProductPriceTv;
        @BindView(R.id.btn_evaluate)
        Button mBtnEvaluate;

        public OrderformCommodityViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
