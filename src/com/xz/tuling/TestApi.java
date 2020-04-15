package com.xz.tuling;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.Scanner;

/**
 * @Package: com.xz.tuling
 * @ClassName: TestApi
 * @Author: xz
 * @Date: 2020/2/24 23:20
 * @Version: 1.0
 */
public class TestApi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String content = "";
            //控制台输入信息
            content = sc.nextLine();
            //接收返回的结果
            String result = TuLingApiUtil.getResult(content);
            String back = JSON.parseObject(result).getJSONArray("results").getJSONObject(0).getJSONObject("values").getString("text");
            //打印结果
            System.out.println(back);
        }
    }
}
