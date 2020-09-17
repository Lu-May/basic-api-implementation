package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thoughtworks.rslist.Exception.CommonError;
import com.thoughtworks.rslist.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDto> userList = new ArrayList<>();

    public static List<UserDto> initUserList() {
        userList.add(new UserDto("Lu", "female", 20, "lu@twu.com", "15228751729"));
        userList.add(new UserDto("Gou", "male", 21, "g@twu.com", "12345678912"));
        return userList;
    }

    @PostMapping("/user/register")
    public static ResponseEntity registerUser(@Valid @RequestBody UserDto userDto) throws JsonProcessingException {
        userList.add(userDto);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/user/list")
    public List<UserDto> getUserList() {
        return userList;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CommonError> methoudArgumentNotValidException(Exception exception) {
        CommonError commonError = new CommonError();
        commonError.setError("invalid user");
        return ResponseEntity.badRequest().body(commonError);
    }
}
