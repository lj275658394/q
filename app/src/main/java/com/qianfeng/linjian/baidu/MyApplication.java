package com.qianfeng.linjian.baidu;

import android.app.Application;
import android.util.Log;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;

/**
 * Created by LinJian
 *
 * @date 2016/1/18.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        ApiStoreSDK.init(this,"92b83cfb03f3c88a2062f76b04c77196");
        super.onCreate();
        getData();
    }


    public void getData() {
        Parameters para = new Parameters();
        para.put("city","beijing");
        ApiStoreSDK.execute("http://apis.baidu.com/heweather/weather/free"
        ,ApiStoreSDK.GET,para,new ApiCallBack(){
                    @Override
                    public void onSuccess(int i, String s) {
                        Log.i("sdkdemo","onSuccess");

                    }

                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo","onComplete");
                    }

                    @Override
                    public void onError(int i, String s, Exception e) {
                        Log.i("sdkdemo","onError");
                    }
                });

    }
}
