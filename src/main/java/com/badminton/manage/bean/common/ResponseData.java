package com.badminton.manage.bean.common;

import java.util.List;

public class ResponseData {
    private List list;
    private PageInfoResponse pageInfo;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public PageInfoResponse getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoResponse pageInfo) {
        this.pageInfo = pageInfo;
    }
}
