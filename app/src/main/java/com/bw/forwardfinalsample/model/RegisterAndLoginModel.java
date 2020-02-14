package com.bw.forwardfinalsample.model;

import com.bw.forwardfinalsample.contract.IRegisterAndLoginContract;
import com.bw.forwardfinalsample.model.bean.LoginBean;
import com.bw.forwardfinalsample.model.bean.RegisterBean;
import com.bw.forwardfinalsample.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * model层
 */
public class RegisterAndLoginModel implements IRegisterAndLoginContract.IModel {
    @Override
    public void register(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi()
                .register(phone, pwd)
                //这里对应的是联网请求所在的线程
                .subscribeOn(Schedulers.io())
                //主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        //只有status 是"0000"才是真正的成功
                        if ("0000".equals(registerBean.getStatus())) {
                            iModelCallBack.onRegisterSuccess(registerBean);
                        } else {
                            iModelCallBack.onRegisterFailure(new Exception(registerBean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void login(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi()
                .login(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if ("0000".equals(loginBean.getStatus())) {
                            iModelCallBack.onLoginSuccess(loginBean);
                        } else {
                            iModelCallBack.onLoginFailure(new Exception(loginBean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
