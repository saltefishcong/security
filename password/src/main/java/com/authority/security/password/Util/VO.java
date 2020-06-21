package com.authority.security.password.Util;

import com.authority.security.password.enums.VOEnum;

/**
 * @ClassName VO
 * @Description TODO
 * @Author Liuweicong
 * @Date 2020/6/21 , 15:34
 * @Version 1.0
 **/
public class VO<T> {

    private VOEnum voEnum;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public VO() {
        this(VOEnum.OK,null);
    }

    public VOEnum getVoEnum() {
        return voEnum;
    }

    public void setVoEnum(VOEnum voEnum) {
        this.voEnum = voEnum;
    }

    public VO(VOEnum voEnum, T data) {
        this.voEnum = voEnum;
        this.data = data;
    }

    public VO(T data) {
        this(VOEnum.OK,data);
    }
}
