package com.badminton.manage.dto.common;

import com.badminton.manage.common.GlobalStatic;
import com.badminton.manage.dto.common.BaseResponseResultDTO;

import java.util.HashMap;

public class CommonResponseDTO extends BaseResponseResultDTO {
    private HashMap data;

    public CommonResponseDTO(String code, String msg) {
        super(code, msg);
    }

    //    public CommonResponseDTO(String code, String msg) {
//        this.setCode(code);
//        this.setMsg(msg);
//    }
    public HashMap getData() {
        return data;
    }

    public void setData(HashMap data) {
        this.data = data;
    }
}