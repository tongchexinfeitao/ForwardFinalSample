package com.bw.forwardfinalsample.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.bw.forwardfinalsample.R;
import com.bw.forwardfinalsample.base.BaseActivity;
import com.bw.forwardfinalsample.contract.IRegisterAndLoginContract;
import com.bw.forwardfinalsample.model.bean.LoginBean;
import com.bw.forwardfinalsample.model.bean.RegisterBean;
import com.bw.forwardfinalsample.presenter.RegisterAndLoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 请求 view -> presenter -> model
 * <p>
 * 响应 model -> presenter -> view
 */
public class RegisterAndLoginActivity extends BaseActivity<RegisterAndLoginPresenter> implements IRegisterAndLoginContract.IView {

    @BindView(R.id.edt_phone)
    EditText mEdtPhone;
    @BindView(R.id.edt_pwd)
    EditText mEdtPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_register)
    Button mBtnRegister;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegisterAndLoginPresenter providePresenter() {
        return new RegisterAndLoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        Toast.makeText(RegisterAndLoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRegisterFailure(Throwable throwable) {
        Toast.makeText(RegisterAndLoginActivity.this, "注册失败" + throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(RegisterAndLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        // TODO: 2020/2/14 登录成功，进入新的页面
        startActivity(new Intent(this, OrderformActivity.class));
        finish();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(RegisterAndLoginActivity.this, "登录失败" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String phone = mEdtPhone.getText().toString();
                String pwd = mEdtPwd.getText().toString();
                //密码需要加密
                String encryptPwd = EncryptUtils.encryptMD5ToString(pwd);
                //因为后台规定了密码长度，所以我们处理一下
                encryptPwd = encryptPwd.substring(0, 6);

                // TODO: 2020/2/13 去登录
                mPresenter.login(phone, encryptPwd);
                break;
            case R.id.btn_register:
                String phone1 = mEdtPhone.getText().toString();
                String pwd1 = mEdtPwd.getText().toString();
                //密码需要加密
                String encryptPwd1 = EncryptUtils.encryptMD5ToString(pwd1);
                //因为后台规定了密码长度，所以我们处理一下
                encryptPwd1 = encryptPwd1.substring(0, 6);

                // TODO: 2020/2/13 去注冊
                mPresenter.register(phone1, encryptPwd1);
                break;
        }
    }
}
