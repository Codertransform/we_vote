package com.thinkgem.jeesite.modules.activity.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hww
 * @Date: 2019/5/3 13:33
 */

public class WechatUtil {



    public static final String APPID = "wx85df8feee563342f";

    public static final String APPSECRET = "2300522e79854739e3342f6aeff22ba9";

    public static final String REDIRECT_URL="http://sellhww.nat300.top/mobile/activity/activity/auth";



    /**
     * 获取请求用户信息的access_token
     *
     * @param code
     * @return
     */
    public static  Map<String, String> getUserInfoAccessToken(String code) {
        JsonObject object = null;
        Map<String, String> data = new HashMap();
        try {
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token"
                    +"?appid=wx0cb537c7232a300f"
                    +"&secret=f18f964c9af1db3ce533c0eedf401968"
                    +"&code=" + code
                    +"&grant_type=authorization_code";
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String tokens = EntityUtils.toString(httpEntity, "utf-8");
            Gson token_gson = new Gson();
            object = token_gson.fromJson(tokens, JsonObject.class);
            data.put("openid", object.get("openid").toString().replaceAll("\"", ""));
            data.put("access_token", object.get("access_token").toString().replaceAll("\"", ""));
        } catch (Exception ex) {
        }
        return data;
    }


    /**
     * 获取用户信息
     *
     * @param accessToken
     * @param openId
     * @return
     */
    public static Map<String, String> getUserInfo(String accessToken, String openId) {
        Map<String, String> data = new HashMap();
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId + "&lang=zh_CN";
        JsonObject userInfo = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity, "utf-8");
            Gson token_gson = new Gson();
            userInfo = token_gson.fromJson(response, JsonObject.class);
            data.put("openid", userInfo.get("openid").toString().replaceAll("\"", ""));
            data.put("nickname", userInfo.get("nickname").toString().replaceAll("\"", ""));
            data.put("city", userInfo.get("city").toString().replaceAll("\"", ""));
            data.put("province", userInfo.get("province").toString().replaceAll("\"", ""));
            data.put("country", userInfo.get("country").toString().replaceAll("\"", ""));
            data.put("headimgurl", userInfo.get("headimgurl").toString().replaceAll("\"", ""));
        } catch (Exception ex) {
        }
        return data;
    }

}
