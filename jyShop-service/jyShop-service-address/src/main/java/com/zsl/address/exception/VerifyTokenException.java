package com.zsl.address.exception;

public class VerifyTokenException extends Exception {

    private String msg;
    public VerifyTokenException() {
        super();
    }

    public VerifyTokenException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
