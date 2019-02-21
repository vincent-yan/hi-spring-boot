package com.maoyan.hi.controller;

import com.maoyan.hi.Entity.JsonResult;
import com.maoyan.hi.Entity.ReqUser;
import com.maoyan.hi.Entity.User;
import com.maoyan.hi.Util.JsonHelper;
import com.maoyan.hi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user/")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    /*
       PathVariable
     */
    @GetMapping(value = "{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId){
        User user=userMapper.getDetail(userId);
        return  JsonHelper.Success(user);
    }

    @RequestMapping(value = "dicList")
    public Map<Integer,User> dicList(@RequestParam Integer count) {
        Map<Integer,User> map = new HashMap<>();
        while (count>0){
            User user=new User();
            user.setId(count);
            user.setName("name"+count.toString());
            user.setGender("男");
            map.put(count,user);
            count--;
        }
        return  map;
    }

    @RequestMapping(value = "list")
    public JsonResult<List<User>> list(@RequestParam Integer count) {
         List<User> list= userMapper.selectAll();
        return  JsonHelper.Success(list);
    }

    /*
      Request 接收实体参数
     */
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public JsonResult<User> create(@RequestBody  User user) {
       int id= userMapper.addUser(user);
       boolean result=id>0;
        user.setId(id);
        return result? JsonHelper.Success(user):JsonHelper.Fail("创建失败");
    }


    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public JsonResult<User> delete(@RequestParam  int id) {
        boolean result= userMapper.delete(id);
        return  result ? JsonHelper.Success(null):JsonHelper.Fail("删除失败");
    }
}
