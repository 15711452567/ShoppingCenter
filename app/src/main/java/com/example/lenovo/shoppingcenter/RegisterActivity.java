package com.example.lenovo.shoppingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.shoppingcenter.bean.RegisterBean;
import com.example.lenovo.shoppingcenter.presenter.IPersenterImpl;
import com.example.lenovo.shoppingcenter.view.IView;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private EditText activity_edittext_register_phonenum;
    private EditText activity_edittext_register_password;
    private ImageView activity_imageview_register_hidepassword;
    private TextView activity_textview_backlogin;
    private Button activity_button_register;
    private boolean ishide=true;
    private int mB=0;
    private IPersenterImpl mIPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mIPersenter = new IPersenterImpl(this);
        initView();
        initData();
    }

    private void initData() {


    }


    private void initView() {
        activity_edittext_register_phonenum = (EditText) findViewById(R.id.activity_edittext_register_phonenum);
        activity_edittext_register_password = (EditText) findViewById(R.id.activity_edittext_register_password);
        activity_imageview_register_hidepassword = (ImageView) findViewById(R.id.activity_imageview_register_hidepassword);
        activity_textview_backlogin = (TextView) findViewById(R.id.activity_textview_backlogin);
        activity_button_register = (Button) findViewById(R.id.activity_button_register);

        activity_button_register.setOnClickListener(this);
        activity_textview_backlogin.setOnClickListener(this);
        activity_imageview_register_hidepassword.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //注册按钮
            case R.id.activity_button_register:
                String phonenum = activity_edittext_register_phonenum.getText().toString().trim();
                String password = activity_edittext_register_password.getText().toString().trim();

                Map<String ,String> map=new HashMap<>();
                map.put("phone",phonenum);
                map.put("pwd",password);
                mIPersenter.setPostRequest(Apis.REGISTER_URL,map,RegisterBean.class);


                break;
                //返回登录
            case R.id.activity_textview_backlogin:
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                break;

                //隐藏密码
            case R.id.activity_imageview_register_hidepassword:
                if (ishide){
                    activity_edittext_register_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    activity_edittext_register_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                ishide = !ishide;
                activity_edittext_register_password.invalidate();
                CharSequence charSequence = activity_edittext_register_password.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
                break;
        }
    }

    @Override
    public void setData(Object Data) {
        RegisterBean registerBean = (RegisterBean) Data;

        if (registerBean.getStatus().equals("0000")){
            mB = 1;
        }

        if (mB==1){
            Intent intent1=new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent1);
        }else{
            Toast.makeText(this, "注册失败，账号已存在", Toast.LENGTH_SHORT).show();
        }

    }
}
