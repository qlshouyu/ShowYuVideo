package com.qlshouyu.vshop.common.tools;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 19-5-28下午12:50
 */
public enum RESPONSE_STATUS {


    SUCCESS(200,"成功"),
    ERROR(500,"服务器错误"),
    NOT_FOUND(404,"资源不存在"),
    NO_AUTH(401,"未登录或者无权限"),
    NO_AUTH_ERROR_PWD_NAME(402,"用户名或者密码错误"),
    ERROR_PARM(501,"参数错误");

    private int value;
    private String name;


    RESPONSE_STATUS(int value, String name){
        this.name=name;
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
