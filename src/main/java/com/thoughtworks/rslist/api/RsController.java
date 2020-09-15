package com.thoughtworks.rslist.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RsController {
  private List<String> rsList = initList();

  private List<String> initList() {
    List<String> list = new ArrayList<>();
    list.add("第一条事件");
    list.add("第二条事件");
    list.add("第三条事件");
    return list;
  }

  @GetMapping("/rs/list/{index}")
  public String getOneRsEvent(@PathVariable int index) {
    return rsList.get(index - 1);
  }

  @GetMapping("/rs/list")
  public String getRsEventWithRange(@RequestParam (required = false) Integer start,
                                    @RequestParam (required = false) Integer end) {
    if (start == null || end == null)
      return rsList.toString();
    return rsList.subList(start - 1, end).toString();
  }

  @PostMapping("/rs/event")
  public void addRsEvent(@RequestBody String rsEventString) {
    rsList.add(rsEventString);
  }
}
