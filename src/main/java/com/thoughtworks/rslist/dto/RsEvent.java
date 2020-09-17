package com.thoughtworks.rslist.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class RsEvent {
    public RsEvent() {

    }

    private @Valid UserDto userDto;

    public RsEvent(String eventName, String keyword, UserDto userDto) {
        this.eventName = eventName;
        this.keyword = keyword;
        this.userDto = userDto;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @NotEmpty
    private String eventName;
    @NotEmpty
    private  String keyword;

    public RsEvent(String eventName, String keyword) {
        this.eventName = eventName;
        this.keyword = keyword;
    }

    @JsonIgnore
    public UserDto getUserDto() {
        return userDto;
    }

    @JsonProperty
    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

}
