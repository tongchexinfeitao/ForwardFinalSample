package com.bw.forwardfinalsample.model;

import com.bw.forwardfinalsample.contract.IOrderformContract;
import com.bw.forwardfinalsample.model.bean.OrderformBean;
import com.bw.forwardfinalsample.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderformModel implements IOrderformContract.IModel {
    @Override
    public void getOrderformData(int userId, String sessionId, int status, int page, int count, IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi()
                .getOrderformData(userId, sessionId, status, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderformBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderformBean orderformBean) {
                        if ("0000".equals(orderformBean.getStatus())) {
                            iModelCallback.onOrderformSuccess(orderformBean);
                        } else {
                            iModelCallback.onOrderformFailure(new Exception(orderformBean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onOrderformFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
