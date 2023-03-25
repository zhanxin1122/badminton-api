package com.badminton.manage.dto.common;

import java.util.HashMap;

public class BaseResponseResultDTO {

    private String code;
    private String msg;

    public BaseResponseResultDTO(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}