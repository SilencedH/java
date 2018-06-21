package net.youzule.youzule.common.constant;

/**
 * @title:枚举类
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/15 14:17
 **/

public enum  BaseEnum {
    SUCCESS(0,"SUCCESS"),
    SERVICE_EXCEPTION(500,"服务异常"),
    HTTP_METHOD_NOT_SUPPORT(405,"HttpMethod不支持"),
    /*NO_AUTHORIZATION(401,"没有权限"),*/
    HTTP_MESSAGE_NOT_READABLE(400,"参数解析异常"),
    MISS_REQUEST_PARAM(400,"参数不存在");
    /**
    *code
    **/
    private int code ;
    /**
    *desc
    **/
    private String desc ;



    BaseEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
