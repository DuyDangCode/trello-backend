package com.duydangcode.trello_spring.core;

import java.time.LocalDate;

public class ErrorEntity {
  private String errorCode;
  private String message;
  private LocalDate timestamp;

  public ErrorEntity(String errorCode, String message, LocalDate timestamp) {
    this.errorCode = errorCode;
    this.message = message;
    this.timestamp = timestamp;
  }

  public ErrorEntity(String errorCode, String message) {
    this.errorCode = errorCode;
    this.message = message;
    this.timestamp = LocalDate.now();
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getMessage() {
    return message;
  }

  public LocalDate getTimestamp() {
    return timestamp;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public void setTimestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Error::");
    sb.append(this.errorCode);
    sb.append("::");
    sb.append(this.message);
    sb.append("::");
    sb.append(this.timestamp);
    return sb.toString();
  }
}
