package com.example.lenovo.shoppingcenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.shoppingcenter.activity.home.HomeActivity;
import com.example.lenovo.shoppingcenter.bean.HeaderBean;
import com.example.lenovo.shoppingcenter.bean.LoginBean;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.example.lenovo.shoppingcenter.view.IView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private EditText activity_edittext_login_phonenum;
    private EditText activity_edittext_login_password;
    private ImageView activity_imageview_login_hidepassword;
    private CheckBox activity_checkbox_rememberpassword;
    private TextView activity_textview_register;
    private Button activity_button_login;
    private boolean ishide=true;
    private IPersenterImpl mIPersenterImpl;
    private LoginBean mLoginBean;
    private String mStatus;
    private int mB=0;
    private SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIPersenterImpl = new IPersenterImpl(this);
        initView();

        //保存账号密码
        mSharedPreferences = getSharedPreferences("zyb", MODE_PRIVATE);
        String trim = mSharedPreferences.getString("trim", "");
        String trim1 = mSharedPreferences.getString("trim1", "");
        boolean ischeck = mSharedPreferences.getBoolean("ischeck", false);
        if (ischeck){
            activity_edittext_login_phonenum.setText(trim);
            activity_edittext_login_password.setText(trim1);
            activity_checkbox_rememberpassword.setChecked(ischeck);
        }
    }


    //初始化视图
    private void initView() {
        activity_edittext_login_phonenum = (EditText) findViewById(R.id.activity_edittext_login_phonenum);
        activity_edittext_login_password = (EditText) findViewById(R.id.activity_edittext_login_password);
        activity_imageview_login_hidepassword = (ImageView) findViewById(R.id.activity_imageview_login_hidepassword);
        activity_checkbox_rememberpassword = (CheckBox) findViewById(R.id.activity_checkbox_rememberpassword);
        activity_textview_register = (TextView) findViewById(R.id.activity_textview_register);
        activity_button_login = (Button) findViewById(R.id.activity_button_login);

        activity_button_login.setOnClickListener(this);
        activity_textview_register.setOnClickListener(this);
        activity_imageview_login_hidepassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            /**
             * 登录按钮
             * */
            case R.id.activity_button_login:

                String trim = activity_edittext_login_phonenum.getText().toString().trim();
                String trim1 = activity_edittext_login_password.getText().toString().trim();

                Map<String,String> map=new HashMap<>();
                map.put("phone",trim);
                map.put("pwd",trim1);
                mIPersenterImpl.setPostRequest(Apis.LOGIN_URL,map,LoginBean.class);


                //判断复选框
                if (activity_checkbox_rememberpassword.isChecked()){
                    SharedPreferences.Editor edit = mSharedPreferences.edit();
                    edit.putString("trim",trim);
                    edit.putString("trim1",trim1);
                    edit.putBoolean("ischeck",true);
                    edit.commit();
                }


                break;
                /**
                 * 跳转到注册页面
                 * */
            case R.id.activity_textview_register:
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;

                /**
                 * 隐藏密码
                 * */
            case R.id.activity_imageview_login_hidepassword:
                if (ishide){
                    activity_edittext_login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    activity_edittext_login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                ishide = !ishide;
                activity_edittext_login_password.invalidate();
                CharSequence charSequence = activity_edittext_login_password.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
                break;
        }
    }

    //实现view接口
    @Override
    public void setData(Object Data) {
        mLoginBean=(LoginBean) Data;

        String sessionId = mLoginBean.getResult().getSessionId();
        int userId = mLoginBean.getResult().getUserId();

        HeaderBean headerBean=new HeaderBean(sessionId,userId);
        EventBus.getDefault().postSticky(headerBean);
        if (mLoginBean.getStatus().equals("0000")){
            mB = 1;
        }

        if (mB==1){
            Intent intent2=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent2);
        }else{
            Toast.makeText(this, "登录失败，账号密码输错误，请重新输入", Toast.LENGTH_SHORT).show();
        }
    }


}
