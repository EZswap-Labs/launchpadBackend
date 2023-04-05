package com.ezswap.common.tool;

import com.ezswap.common.dto.ResultDto;

public class ResultTool {

  public static ResultDto success(Object data) {
    return new ResultDto(true, data);
  }

  public static ResultDto success(Object data, String msg) {
    return new ResultDto(true, msg, data);
  }

  public static ResultDto success(String msg) {
    return new ResultDto(true, msg);
  }

  public static ResultDto fail(String msg) {
    return new ResultDto(false, msg);
  }

  public static ResultDto fail(Object data) {
    return new ResultDto(false, data);
  }

  public static ResultDto fail(Object data, String msg) {
    return new ResultDto(false, msg, data);
  }
}
