package com.badminton.manage.dto.field;

import java.util.List;

public class PayUpdateRequestDTO {
    private List<PayDetailDTO> list;

    public List<PayDetailDTO> getList() {
        return list;
    }

    public void setList(List<PayDetailDTO> list) {
        this.list = list;
    }
}
