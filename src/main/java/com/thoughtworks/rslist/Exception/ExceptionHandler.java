package com.thoughtworks.rslist.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
   @org.springframework.web.bind.annotation.ExceptionHandler({IndexOutOfBoundsException.class,
           NullPointerException.class,
           MyException.class,
           MethodArgumentNotValidException.class})
    public ResponseEntity<CommonError> handlerIndexOutOfBoundsException(Exception exception) {
       if (exception instanceof IndexOutOfBoundsException) {
           CommonError commonError = new CommonError();
           commonError.setError("invalid request param");
           return ResponseEntity.status(400).body(commonError);
       }
       if (exception instanceof MethodArgumentNotValidException) {
           CommonError commonError = new CommonError();
           commonError.setError("invalid param");
           return ResponseEntity.status(400).body(commonError);
       }
       CommonError commonError = new CommonError();
       commonError.setError("invalid index");
       return ResponseEntity.status(400).body(commonError);
   }

}
