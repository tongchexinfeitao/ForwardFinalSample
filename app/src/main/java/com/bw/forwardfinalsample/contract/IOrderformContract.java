package com.bw.forwardfinalsample.contract;

import com.bw.forwardfinalsample.model.bean.OrderformBean;

public interface IOrderformContract {
    interface IView {
        void onOrderformSuccess(OrderformBean orderformBean);

        void onOrderformFailure(Throwable throwable);
    }

    interface IPresenter {
        void getOrderformData(int userId, String sessionId, int status, int page, int count);
    }

    interface IModel {
        void getOrderformData(int userId, String sessionId, int status, int page, int count, IModelCallback iModelCallback);

        interface IModelCallback {
            void onOrderformSuccess(OrderformBean orderformBean);

            void onOrderformFailure(Throwable throwable);
        }
    }
}
