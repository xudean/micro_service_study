package org.virtue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.virtue.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class IndexController {

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public String index(Model model, HttpSession session){
        model.addAttribute("name","张三");
        User user = new User();
        user.setAge(23);
        user.setId(1);
        user.setUsername("testUser");
        session.setAttribute("user",user);

        //循环
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("李四");
        user2.setAge(16);
        //循环
        User user3 = new User();
        user3.setId(3);
        user3.setUsername("王五");
        user3.setAge(16);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        model.addAttribute("users",users);
        return "test";
    }

    @RequestMapping(value = "/detail", method = {RequestMethod.GET})
    public String detail(String id){
        System.out.println(id);
        return "detail";
    }

    @RequestMapping(value = "/beautiful", method = {RequestMethod.GET})
    public String beatiful(Model model){
        User user = new User();
        user.setAge(23);
        user.setId(1);
        user.setUsername("张三");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("李四");
        user2.setAge(16);
        User user3 = new User();
        user3.setId(3);
        user3.setUsername("王五");
        user3.setAge(16);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        model.addAttribute("users",users);
        return "beautiful";
    }
}
