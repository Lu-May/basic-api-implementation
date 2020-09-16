package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_register_user() throws Exception {
        UserDto userDto = new UserDto("Lu", "female", 20, "lu@twu.com", "15228751729");
        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);
        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void name_should_not_empty() throws Exception {
        UserDto userDto = new UserDto("", "female", 20, "lu@twu.com", "15228751729");
        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);
        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void name_length_should_not_more_than_8() throws Exception {
        UserDto userDto = new UserDto("Luaaaaaaa", "female", 20, "lu@twu.com", "15228751729");
        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);
        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_not_register_when_gender_is_empty() throws Exception {
        UserDto userDto = new UserDto("Lu", "", 20, "lu@twu.com", "15228751729");
        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);
        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_not_register_when_age_is_empty() throws Exception {
        UserDto userDto = new UserDto("Lu", "male", null, "lu@twu.com", "15228751729");
        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);
        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}