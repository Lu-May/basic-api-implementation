package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    public static List<UserDto> userList = new ArrayList<>();

    public static void initUserList() {
        userList.add(new UserDto("Lu", "female", 20, "lu@twu.com", "15228751729"));
        userList.add(new UserDto("Gou", "male", 21, "g@twu.com", "12345678912"));
    }

    @PostMapping("/user/register")
    public static void registerUser(@Valid @RequestBody UserDto userDto) {
        userList.add(userDto);
    }

    @GetMapping("/user/list")
    public List<UserDto> getUserList() {
        return userList;
    }
}
