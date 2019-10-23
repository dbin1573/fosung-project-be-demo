package com.fosung.pro.rest.front;

import com.fosung.pro.entity.User;
import com.fosung.pro.service.IUserService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import fosung-project-be-demo.pro-facade.src.main.java.com.fosung.pro.service.IUserService;
@RestController
@RequestMapping("/user")
public class ProWebUserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("/add")
    public String add(){
        User user=new User();
        user.setUserName("a");
        user.setPassWord("b");
        user.setRealName("c");

        iUserService.save(user);
        return "add....";
    }
    @RequestMapping("/del")
    public String del(){
        iUserService.delete(3375252250560565192L);
        return "del....";
    }
    @RequestMapping("/upd")
    public String upd(Long id){
        User user=new User();
//Long id =Long.parseLong("3375267173659324785");

        user.setId(id);
        user.setUserName("aaaaa");

        iUserService.update(user, Arrays.asList("userName"));
        return "upd....";
    }
    @RequestMapping("/list")
    public String sea(){
        Map<String,Object> map = Maps.newHashMap();

        map.put("name","a");

        List<User> ls = iUserService.queryAll(map);

        return "sea...."+ls.toString()+ls.size();
    }


}

