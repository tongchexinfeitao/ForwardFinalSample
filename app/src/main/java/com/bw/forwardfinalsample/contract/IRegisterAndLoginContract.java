package com.bw.forwardfinalsample.contract;

import com.bw.forwardfinalsample.model.bean.LoginBean;
import com.bw.forwardfinalsample.model.bean.RegisterBean;

/**
 * 登录和注册的锲约
 *
 * 锲约中三个接口
 * IVivew       activity去实现
 * IPresenter   presenter去实现
 * IModel       model去实现
 */
public interface IRegisterAndLoginContract {

    //activity需要接收四种通知  登录成功、登录失败、注册成功、注册失败
    interface IView {
        void onRegisterSuccess(RegisterBean registerBean);

        void onRegisterFailure(Throwable throwable);

        void onLoginSuccess(LoginBean loginBean);

        void onLoginFailure(Throwable throwable);
    }

    //p层要有两种请求，   注册和登录
    interface IPresenter {
        void register(String phone, String pwd);

        void login(String phone, String pwd);
    }

    interface IModel {
        void register(String phone, String pwd, IModelCallBack iModelCallBack);

        void login(String phone, String pwd, IModelCallBack iModelCallBack);

        interface IModelCallBack {
            void onRegisterSuccess(RegisterBean registerBean);

            void onRegisterFailure(Throwable throwable);

            void onLoginSuccess(LoginBean loginBean);

            void onLoginFailure(Throwable throwable);
        }
    }
}
