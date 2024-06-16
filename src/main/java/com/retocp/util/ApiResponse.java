package com.retocp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private ZonedDateTime timestamp;
    private Integer status;
    private Boolean error;
    private String message;
    private Object data;

    public static ApiResponse ok(String mensaje, Object data) {
        return load(false, mensaje, data, 200);
    }

    public static ApiResponse load(boolean isError, String mensaje, Object data, Integer status) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setTimestamp(ZonedDateTime.now());
        apiResponse.setStatus(status);
        apiResponse.setError(isError);
        apiResponse.setMessage(mensaje);
        apiResponse.setData(data);
        return apiResponse;
    }
}
