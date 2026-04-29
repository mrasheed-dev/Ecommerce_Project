package com.example.demo.exception;


public class ErrorResponse {

    private String message;
    private int status;
    private String time;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, int status, String time) {
        this.message = message;
        this.status = status;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
