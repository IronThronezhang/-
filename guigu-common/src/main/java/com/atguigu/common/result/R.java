package com.atguigu.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {

    private  Integer code;
    private  String message;
    private Map<String,Object> data = new HashMap<>();


    /**
     *  构造函数私有化
     */
    private  R(){}

    /**
     *  统一返回成功结果
     * @return
     */
    public static  R ok(){
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * 统一返回失败结果
     * @return
     */
    public static R error(){
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    /**
     * 设置特定的结果
     * @param responseEnum
     * @return
     */
    public static R setResult(ResponseEnum responseEnum){
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }

    /**
     *  给Data赋值
     * @param key
     * @param value
     * @return
     */
    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    /**
     * 设置message的值
     * @param msg
     * @return
     */
    public R message(String msg){
        this.message =  msg;
        return this;
    }

    /**
     * 设置code的值
     * @param code
     * @return
     */
    public R code(Integer code){
        this.code =  code;
        return this;
    }
}
