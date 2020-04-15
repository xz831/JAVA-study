package com.xz.mq;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Package: com.xz.mq
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/3/9 14:44
 * @Version: 1.0
 */
public class Demo1 {

    private static final Logger LOGGER = Logger.getLogger("Demo1");
    /**
     * 获得CloseableHttpClient对象，通过basic认证。
     * @param username
     * @param password
     * @return
     */
    private static CloseableHttpClient getBasicHttpClient(String username, String password) {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // 设置BasicAuth
        CredentialsProvider provider = new BasicCredentialsProvider();
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM);
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username,password);
        provider.setCredentials(scope, credentials);
        httpClientBuilder.setDefaultCredentialsProvider(provider);
        return httpClientBuilder.build();
    }

    /**
     * 根据API获得相关的MQ信息
     * @param url
     * @param username
     * @param password
     * @return
     */
    private static JSONArray getMQJSONArray(String url,String username,String password) {
        HttpGet httpPost = new HttpGet(url);
        CloseableHttpClient pClient=getBasicHttpClient(username,password);
        CloseableHttpResponse response = null;
        JSONArray jsonArray =null;
        try {
            response = pClient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                String string = EntityUtils.toString(response.getEntity());
                // 返回来是一个集合，去掉开始的“[”和结尾的“]”;
                jsonArray = JSONArray.parseArray(string);
            } else {
                System.out.println("请求返回:" + state + "(" + url + ")");
            }
        }catch (Exception e){
            LOGGER.info("地址url:"+url+"，异常："+e.toString());
        } finally {
            closeAll(response,pClient);
        }
        return jsonArray;
    }
    private static void closeAll(CloseableHttpResponse response, CloseableHttpClient pClient){
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            pClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String url="http://59.110.215.208:15672/api/exchanges";
        String username="guest";
        String password="guest";
        JSONArray http = getMQJSONArray(url, username, password);
        List<String> nameList = new LinkedList<>();
        http.forEach(item->{
            JSONObject o =(JSONObject)item;
            String name = o.getString("name");
            nameList.add(name);
        });
        System.out.println("name:"+nameList);
    }
}
