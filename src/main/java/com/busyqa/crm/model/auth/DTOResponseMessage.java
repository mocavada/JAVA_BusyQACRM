package com.busyqa.crm.model.auth;

public class DTOResponseMessage {
    private String message;

    public DTOResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
