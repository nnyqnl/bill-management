package com.doudou.bill.controller;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import java.util.HashMap;
import java.util.Map;

public class JPushDemo {

    private static String MASTER_SECRET="115c9a30276a2e0461cc0731";
    private static String APP_KEY="b8110c02e31d41d60ba9afe5";

    //极光推送>>Android
    //Map<String, String> parm是我自己传过来的参数,同学们可以自定义参数
    public static void jpushAndroid(Map<String, String> parm) {

        //创建JPushClient(极光推送的实例)
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload
                .newBuilder()
                .setPlatform(Platform.android())//指定android平台的用户
                .setAudience(Audience.all())//你项目中的所有用户
                //.setAudience(Audience.registrationId(parm.get("id")))//registrationId指定用户
                .setNotification(Notification.android(parm.get("msg"), "这是title", parm))
                //发送内容
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                //这里是指定开发环境,不用设置也没关系
                .setMessage(Message.content(parm.get("msg")))//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        //设置推送参数
        //这里同学们就可以自定义推送参数了
        Map<String, String> parm = new HashMap<String, String>();
        //设备id,指定设备推送id
        parm.put("id", "13165ffa4e594a31ed0");
        //设置提示信息,内容是文章标题
        parm.put("msg","测试测试,收到请联系发送人");
        jpushAndroid(parm);

    }

}
