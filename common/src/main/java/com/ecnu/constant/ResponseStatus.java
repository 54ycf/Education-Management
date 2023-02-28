package com.ecnu.constant;

import java.util.UUID;
public class ResponseStatus {

    //登录错误
    public static int LOGIN_ERROR = 201;

    //注册错误
    public static int REGISTER_ERROR = 202;

    //服务器内部错误
    public static String uuidGenerator(){
        return UUID.randomUUID().toString().replace("-","").substring(0,6);
    }

}
