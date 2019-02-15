package com.maoyan.hi.controller;

import com.maoyan.hi.Entity.JsonResult;
import com.maoyan.hi.Entity.ReqUser;
import com.maoyan.hi.Entity.User;
import com.maoyan.hi.Util.JsonHelper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user/")
@RestController
public class UserController {

    /*
       PathVariable
     */
    @GetMapping(value = "{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId){
        User user=new User();
        user.setsId(userId);
        user.setsName("ok");
        user.setGender("男");
        return  JsonHelper.Success(user);
    }

    @RequestMapping(value = "dicList")
    public Map<Integer,User> dicList(@RequestParam Integer count) {
        Map<Integer,User> map = new HashMap<>();
        while (count>0){
            User user=new User();
            user.setsId(count);
            user.setsName("name"+count.toString());
            user.setGender("男");
            map.put(count,user);
            count--;
        }
        return  map;
    }

    @RequestMapping(value = "list")
    public JsonResult<List<User>> list(@RequestParam Integer count) {
        List<User> list= new ArrayList<>();
        while (count>0){
            User user=new User();
            user.setsId(count);
            user.setsName("name"+count.toString());
            user.setGender("男");
            list.add(user);
            count--;
        }
        return  JsonHelper.Success(list);
    }

    /*
      Request 接收实体参数
     */
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public JsonResult<ReqUser> create(@RequestBody  ReqUser user) {
        System.out.println(user);
        return JsonHelper.Success(user);
    }
}
