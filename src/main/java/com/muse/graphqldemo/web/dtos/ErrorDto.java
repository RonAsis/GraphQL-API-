package com.muse.graphqldemo.web.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorDto {

    private HttpStatus errorCode;
    private String message;
    private long timestamp;
    private String path;

}
