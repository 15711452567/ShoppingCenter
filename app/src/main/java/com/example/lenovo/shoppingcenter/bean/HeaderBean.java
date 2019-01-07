package com.example.lenovo.shoppingcenter.bean;

/**
 * date:2019.1.3
 * author:赵颖冰(lenovo)
 * function:
 */
public class HeaderBean {
    public String sessionId;
    public int userId;

    public HeaderBean(String sessionId, int userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }
}
