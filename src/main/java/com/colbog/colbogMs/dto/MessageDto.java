package com.colbog.colbogMs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
@Setter
@Data
public class MessageDto {
    private HttpStatus status;
    private String message;
}
