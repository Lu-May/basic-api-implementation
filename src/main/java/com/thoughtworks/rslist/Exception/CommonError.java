package com.thoughtworks.rslist.Exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Data
public class CommonError {
    private String error;
}
