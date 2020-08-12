package com.javapandeng.controller;

import com.javapandeng.base.BaseController;
import com.javapandeng.po.Item;
import com.javapandeng.po.ItemCategory;
import com.javapandeng.po.User;
import com.javapandeng.service.UserService;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model,User user){
        String sql="select * from user where 1=1 ";
        if (!isEmpty(user.getUserName())){
            sql += " and userName like '%"+user.getUserName()+"%' ";
        }
        sql+=" order by id";
        Pager<User> pagers = userService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",user);
        return "user/user";

    }

    /**
     * 转向修改功能
     */
    @RequestMapping(value = "/update")
    public String update(Integer id,Model model){
        User obj=userService.load(id);
        model.addAttribute("obj",obj);
        return "user/update";
    }



    /**
     * 修改一级分类
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(User user){
        userService.updateById(user);
        return "redirect:/user/findBySql.action";
    }


}
