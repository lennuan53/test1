package com.example.demo.dto;

public class Response {
    private String message;
    private boolean success;
    private Object data;

    public Response(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    // getter和setter
    public String getMessage() { return message; }
    public boolean isSuccess() { return success; }
    public Object getData() { return data; }
}
