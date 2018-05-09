package com.pub;

import com.pub.exception.SCCustomRuntimeException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by quyang on 2018/4/9.
 */
public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
    private static OkHttpClient okHttpClient;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final Object lockObj = new Object();

    public static OkHttpClient getInstance() {
        synchronized (lockObj){
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient().newBuilder()
                        .readTimeout(30, TimeUnit.SECONDS)
                        .connectTimeout(10, TimeUnit.SECONDS).build();
            }
        }
        return okHttpClient;
    }

    public static String doGet(String url, Map<String,String> params){
        if(params != null && params.size() > 0){
            StringBuilder sbUrl = new StringBuilder();
            sbUrl.append(url).append("?");
            params.forEach((k,v)-> sbUrl.append(k).append("=").append(v).append("&"));
            url = sbUrl.substring(0,sbUrl.lastIndexOf("&"));
        }
        Request request = new Request.Builder()
                .url(url)//请求接口。如果需要传参拼接到接口后面。
                .build();//创建Request 对象
        try {
            Response response = getInstance().newCall(request).execute();//得到Response 对象
            if (response.isSuccessful()){
                String respStr = response.body().string();
                response.close();
                return respStr;
            }else{
                log.error("doGet failed, resp: {}", response.body().toString());
            }
            return null;
        } catch (IOException e) {
            throw new SCCustomRuntimeException(String.format("okHttp doGet failed,%s", e.getMessage()));
        }
    }


    public static <T> String doPost(String url, T t) {
        String content = JsonUtil.getJsonFromObject(t);
        RequestBody requestBody = RequestBody.create(JSON, content);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = getInstance().newCall(request).execute();//得到Response 对象
            if (response.isSuccessful()){
                String respStr = response.body().string();
                response.close();
                return respStr;
            }else{
                log.error("doPost failed, resp: {}", response.body().toString());
            }
        } catch (IOException e) {
            throw new SCCustomRuntimeException(String.format("okHttp doGet failed,%s", e.getMessage()));
        }
        return null;
    }




    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("year", "2018");
        System.out.println( HttpUtils.doGet("www.baidu.com", null));
    }

}
