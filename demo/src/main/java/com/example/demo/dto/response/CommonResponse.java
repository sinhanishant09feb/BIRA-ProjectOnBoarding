package com.example.demo.dto.response;

import java.time.LocalDateTime;

public class CommonResponse {
    int httpStatus;
    String message;
    String description;
    int affectedId;
    LocalDateTime dateTime;

    public CommonResponse(){}

    public CommonResponse(int httpStatus, String message, String description, int affectedId, LocalDateTime dateTime) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.description = description;
        this.affectedId = affectedId;
        this.dateTime = dateTime;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAffectedId() {
        return affectedId;
    }

    public void setAffectedId(int affectedId) {
        this.affectedId = affectedId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
