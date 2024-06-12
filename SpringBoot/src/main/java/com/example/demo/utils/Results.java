package com.example.demo.utils;


import java.util.HashMap;
import java.util.Map;


public class Results {
    private Boolean success;
    private String message;
    private Integer code;
    private Map<String,Object> data = new HashMap<>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    private Results (){}

    public static Results ok(){
        Results results = new Results();
        results.setCode(Result.SUCCESS);
        results.setSuccess(true);
        results.setMessage("成功");
        return results;
    }
    public static Results error(){
        Results results = new Results();
        results.setCode(Result.ERROR);
        results.setSuccess(false);
        results.setMessage("失败");
        return results;
    }
    public Results success(){
        this.setSuccess(true);
        return this;
    }
    public Results message(String message){
        this.setMessage(message);
        return this;
    }

    public Results code(Integer code){
        this.setCode(code);
        return this;
    }
    public Results data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public Results data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

}
