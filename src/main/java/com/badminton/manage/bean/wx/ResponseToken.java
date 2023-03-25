package com.badminton.manage.bean.wx;

public class ResponseToken {
    private String echostr;

    public ResponseToken(String str) {
        this.echostr = str;
    }
    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
