package com.badminton.manage.dto.common;

import com.badminton.manage.bean.common.ResponseData;

public class CommonQueryResponseDTO extends BaseResponseResultDTO {
    private ResponseData data;

    public CommonQueryResponseDTO(String code, String msg) {
        super(code, msg);
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }
}
