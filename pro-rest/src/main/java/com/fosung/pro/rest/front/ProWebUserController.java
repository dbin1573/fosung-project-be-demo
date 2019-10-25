package com.fosung.pro.rest.front;

import com.fosung.pro.entity.User;
import com.fosung.pro.service.IUserService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ProWebUserController {

    @Autowired
    IUserService iUserService;
    @Autowired
    StringRedisTemplate srt;
    @RequestMapping("/add")
    public String add(User user) {
       /* User user = new User();
        user.setUserName("a");
        user.setPassWord("b");
        user.setRealName("c");*/

        iUserService.save(user);
        return "add....";
    }

    @RequestMapping("/del")
    public String del(Long id) {
        iUserService.delete(id);//3375252250560565192L
        return "del....";
    }

    @RequestMapping("/upd")
    public String upd(Long id) {
        User user = new User();

        user.setId(id);
        user.setUserName("aaaaa");

        iUserService.update(user, Arrays.asList("userName"));
        return "upd....";
    }

    @RequestMapping("/list")
    public List<User> sea() {
        Map<String, Object> map = Maps.newHashMap();

        map.put("name", "a");

        List<User> ls = iUserService.queryAll(map);
        return  ls;
    }

    @RequestMapping("/")
    public void fastView(HttpServletResponse resp) throws IOException {
      /*  Cookie cname=new Cookie("name","张洪彬");
        cname.setMaxAge(60*60);
        resp.addCookie(cname);*/


        srt.opsForValue().set("name","张洪彬");
        String s=srt.opsForValue().get("name");
        System.out.println(s);
        resp.sendRedirect("http://localhost:63342/main/pro-rest/templates/vuser.html");
    }

}

