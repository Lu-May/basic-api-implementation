package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.dto.RsEvent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class RsController {
  private List<RsEvent> rsList = initList();

  private List<RsEvent> initList() {
    List<RsEvent> list = new ArrayList<>();
    list.add(new RsEvent("第一条事件", "无分类"));
    list.add(new RsEvent("第二条事件", "无分类"));
    list.add(new RsEvent("第三条事件", "无分类"));
    return list;
  }

  @GetMapping("/rs/list/{index}")
  public RsEvent getOneRsEvent(@PathVariable int index) {
    return rsList.get(index - 1);
  }

  @GetMapping("/rs/list")
  public List<RsEvent> getRsEventWithRange(@RequestParam (required = false) Integer start,
                                    @RequestParam (required = false) Integer end) {
    if (start == null || end == null)
      return rsList;
    return rsList.subList(start - 1, end);
  }

  @PostMapping("/rs/event")
  public void addRsEvent(@RequestBody String rsEventString) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    RsEvent rsEvent = objectMapper.readValue(rsEventString, RsEvent.class);
    rsList.add(rsEvent);
  }

  @PutMapping("/rs/rsevent/{index}")
  public void modifyRsEvent(@PathVariable int index, @RequestBody RsEvent rsEventString) {
    if (rsEventString.getEventName() == null)
      rsEventString.setEventName(rsList.get(index - 1).getEventName());
    if (rsEventString.getKeyword() == null)
      rsEventString.setKeyword(rsList.get(index - 1).getKeyword());
    Collections.replaceAll(rsList, rsList.get(index - 1), rsEventString);
  }

  @DeleteMapping("/rs/rmevent/{index}")
  public void deleteRsEvent(@PathVariable int index) {
    rsList.remove(index - 1);
  }
}
