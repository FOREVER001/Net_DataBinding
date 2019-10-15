package com.tianzhuan.net_databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.tianzhuan.net_databinding.databinding.ActivityMainBinding;
import com.tianzhuan.net_databinding.model.UserInfo;

public class MainActivity extends AppCompatActivity {
    private UserInfo mUserInfo=new UserInfo();
    public static final String TAG="MainActivity >>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        //单向绑定的第一种方式：
//        mUserInfo.setUsername("张三");
//        mUserInfo.setPassword("123");
//        binding.setUser(mUserInfo);
//        //数据的刷新？无效果
//        Log.e(TAG,mUserInfo.getUsername()+"/"+mUserInfo.getPassword());
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mUserInfo.setUsername("王五");
//                mUserInfo.setPassword("456");
//                Log.e(TAG,mUserInfo.getUsername()+"/"+mUserInfo.getPassword());
//            }
//        },3000);
//        //单向绑定的第二种方式：
//            mUserInfo.username.set("李白");
//            mUserInfo.password.set("354");
//             binding.setUser(mUserInfo);
//           Log.e(TAG,mUserInfo.username.get()+"/"+mUserInfo.password.get());
//           new Handler().postDelayed(new Runnable() {
//               @Override
//               public void run() {
//                   mUserInfo.username.set("杜甫");
//                   mUserInfo.password.set("789");
//                   Log.e(TAG,mUserInfo.username.get()+"/"+mUserInfo.password.get());
//               }
//           },3000);

        //双向绑定（Model -- View View -- Model）
        mUserInfo.username.set("柳宗元");
        mUserInfo.password.set("0202");
        binding.setUser(mUserInfo);
        Log.e(TAG,mUserInfo.username.get()+"/"+mUserInfo.password.get());

        new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   Log.e(TAG,mUserInfo.username.get()+"/"+mUserInfo.password.get());
               }
           },30000);
    }
}
