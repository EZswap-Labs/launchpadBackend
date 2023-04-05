package com.ezswap.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDto<T> implements Serializable {
  private static final long serialVersionUID = -3747174532282983770L;

  private boolean success;

  private String msg;

  private T data;

  public ResultDto() {}

  public ResultDto(boolean success) {
    this.success = success;
  }

  public ResultDto(boolean success, String msg) {
    this.success = success;
    this.msg = msg;
  }

  public ResultDto(boolean success, T data) {
    this.success = success;
    this.data = data;
  }

  public ResultDto(boolean success, String msg, T data) {
    this.success = success;
    this.msg = msg;
    this.data = data;
  }
}
