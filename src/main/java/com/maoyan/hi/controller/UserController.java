package com.maoyan.hi.controller;

import com.maoyan.hi.Entity.JsonResult;
import com.maoyan.hi.Entity.User;
import com.maoyan.hi.Util.JsonHelper;
import com.maoyan.hi.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "获取用户", notes = "根据User对象创建用户")
    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public JsonResult<User> getUser(@PathVariable Integer userId){
        User user = userMapper.getDetail(userId);
        return JsonHelper.RESULT(user);
    }

    @RequestMapping(value = "dicList", method = RequestMethod.GET)
    public Map<Integer,User> dicList(@RequestParam Integer count) {
        Map<Integer,User> map = new HashMap<>();
        while (count>0){
            User user=new User();
            user.setId(count);
            user.setName("name"+count.toString());
            user.setGender(1);
            map.put(count,user);
            count--;
        }
        return  map;
    }


    @ApiOperation(value = "获取所有用户", notes = "获取全部用户数据")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public JsonResult<List<User>> list() {
        List<User> list = userMapper.selectAll();
        return JsonHelper.RESULT(list);
    }

    /*
      Request 接收实体参数
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public JsonResult<User> create(@RequestBody  User user) {
        int id = userMapper.addUser(user);
        boolean result = id > 0;

        return JsonHelper.Operate(result);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户Id删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public JsonResult<User> delete(@RequestParam Integer id) {
        boolean result = userMapper.delete(id);
        return JsonHelper.Operate(result);
    }
}
