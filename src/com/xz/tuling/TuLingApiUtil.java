package com.xz.tuling;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Package: com.xz.tuling
 * @ClassName: TuLingApiUtil
 * @Author: xz
 * @Date: 2020/2/24 23:19
 * @Version: 1.0
 */
public class TuLingApiUtil {
    //自己的apikey，注意不是密钥
//    public static final String KEY = "d3a63c004e614549a26beaa7fb9c53f5";
    public static final String KEY = "b1964a393aee4d1dbf1e9fd24c9ef35d";
    public static final String USER_ID = "zhe";

    public static String getResult(String content) {
        //图灵api接口
        String apiUrl = "http://openapi.tuling123.com/openapi/api/v2";
        //封装请求头
        HttpPost request = new HttpPost(apiUrl);
        request.setEntity(new StringEntity(JSON.toJSONString(new TuLingRequestBody(new InputText(content),null)), StandardCharsets.UTF_8));
        String result = "";
        try {
            //发送http请求
            HttpResponse response = HttpClients.createDefault().execute(request);
            //获取响应码
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                //获取返回的结果
                result = EntityUtils.toString(response.getEntity());
            } else {
                System.out.println("code=" + code);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }
}
