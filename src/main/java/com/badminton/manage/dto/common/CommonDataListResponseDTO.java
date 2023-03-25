package com.badminton.manage.dto.common;

import java.util.List;

public class CommonDataListResponseDTO extends BaseResponseResultDTO{
    private List data;

    public CommonDataListResponseDTO(String code, String msg) {
        super(code, msg);
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
