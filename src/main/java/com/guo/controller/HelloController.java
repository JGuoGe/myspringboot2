package com.guo.controller;

import com.guo.exception.UserNotExistException;
import com.guo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author guo
 * @create 2019-05-20 22:21
 */
@Controller
//@RestController
public class HelloController {

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping("/hello2")
    public  String hello2(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    //查出用户数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

    @GetMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg","你好");
        return "success";
    }

    @RequestMapping("/setString")
    public String setString(String key, String object) {
        redisService.set(key, object, 60l);
        return "success";
    }

    @RequestMapping("/get")
    public String get(String key) {
        return redisService.getString(key);
    }




}
