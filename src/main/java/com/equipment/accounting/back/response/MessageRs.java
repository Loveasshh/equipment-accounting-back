package com.equipment.accounting.back.response;

public class MessageRs {

    private String message;

    public MessageRs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}