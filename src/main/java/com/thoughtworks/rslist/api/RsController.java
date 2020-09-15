package com.thoughtworks.rslist.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< HEAD
import com.thoughtworks.rslist.dto.RsEvent;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> master

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class RsController {
<<<<<<< HEAD
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
  public void addRsEvent(@RequestBody RsEvent rsEventString) {
    rsList.add(rsEventString);
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
=======
  private List<String> rsList = Arrays.asList("第一条事件", "第二条事件", "第三条事件");

  @GetMapping("/rs/list/{index}")
  public String getOneRsEvent(@PathVariable int index) {
    return rsList.get(index - 1);
  }

  @GetMapping("/rs/list")
  public String getRsEventWithRange(@RequestParam Integer start, @RequestParam Integer end) {
    return rsList.subList(start - 1, end).toString();
  }

  @GetMapping("/rs/list")
  public String getAllRsEvent() {
    return rsList.toString();
>>>>>>> master
  }
}
