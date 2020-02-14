package com.bw.forwardfinalsample.presenter;

import com.bw.forwardfinalsample.base.BasePresenter;
import com.bw.forwardfinalsample.contract.IOrderformContract;
import com.bw.forwardfinalsample.contract.IRegisterAndLoginContract;
import com.bw.forwardfinalsample.model.OrderformModel;
import com.bw.forwardfinalsample.model.bean.OrderformBean;

public class OrderformPresenter extends BasePresenter<IOrderformContract.IView> implements IOrderformContract.IPresenter {

    private OrderformModel orderformModel;

    @Override
    protected void initModel() {
        orderformModel = new OrderformModel();
    }

    @Override
    public void getOrderformData(int userId, String sessionId, int status, int page, int count) {
        orderformModel.getOrderformData(userId, sessionId, status, page, count, new IOrderformContract.IModel.IModelCallback() {
            @Override
            public void onOrderformSuccess(OrderformBean orderformBean) {
                view.onOrderformSuccess(orderformBean);
            }

            @Override
            public void onOrderformFailure(Throwable throwable) {
                view.onOrderformFailure(throwable);
            }
        });
    }
}
