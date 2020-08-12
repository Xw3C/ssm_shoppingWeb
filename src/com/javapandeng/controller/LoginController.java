package com.javapandeng.controller;


import com.javapandeng.base.BaseController;
import com.javapandeng.po.*;
import com.javapandeng.service.ItemCategoryService;
import com.javapandeng.service.ItemService;
import com.javapandeng.service.ManageService;
import com.javapandeng.service.UserService;
import com.javapandeng.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//登录相关的控制器
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private ManageService manageService;
    @Autowired
    private ItemCategoryService itemCategoryService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;


    /**
     * 管理员登录前
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "/login/mLogin";
    }



    /**
     * 登录验证
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(Manage manage, HttpServletRequest request){
        Manage byEntity = manageService.getByEntity(manage);
        if (byEntity==null){
            return "redirect:/login/mtuichu";
        }
        request.getSession().setAttribute(Consts.MANAGE,byEntity);
        return "/login/mIndex";
    }

    /**
     *管理员退出
     */
    @RequestMapping("mtuichu")
    public String mtuichu(HttpServletRequest request){
        request.getSession().setAttribute(Consts.MANAGE,null);

        return "/login/mLogin";
    }


    //前端首页
    @RequestMapping("/uIndex")
    public String uIndex(Model model, Item item,HttpServletRequest request){
        String sql1 = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fatherList = itemCategoryService.listBySqlReturnEntity(sql1);
        List<CategoryDto> list = new ArrayList<>();
        if(!CollectionUtils.isEmpty(fatherList)){
            for(ItemCategory ic:fatherList){
                CategoryDto dto = new CategoryDto();
                dto.setFather(ic);
                //查询二级类目
                String sql2="select * from item_category where isDelete=0 and pid="+ic.getId();
                List<ItemCategory> childrens = itemCategoryService.listBySqlReturnEntity(sql2);
                dto.setChildrens(childrens);
                list.add(dto);
                model.addAttribute("lbs",list);
            }
        }

        //折扣商品
        List<Item> zks = itemService.listBySqlReturnEntity("select * from item where isDelete=0 and zk is not null order by zk desc limit 0,10");
        model.addAttribute("zks",zks);

        //热销商品
        List<Item> rsx = itemService.listBySqlReturnEntity("select * from item where isDelete=0 order by gmNum desc limit 0,10");
        model.addAttribute("rsx",rsx);
        return "login/uIndex";
    }

    //注册功能 普通用户
    @RequestMapping("/res")
    public String res(){
        return "login/res";
    }

    //执行注册功能 普通用户
    @RequestMapping("/toRes")
    public String toRes(User u){
        userService.insert(u);
        return "login/uLogin";
    }

    //普通用户登录
    @RequestMapping("/uLogin")
    public String uLogin(){
        return "login/uLogin";
    }

    //执行登录功能 普通用户
    @RequestMapping("/utoLogin")
    public String utoLogin(User u,HttpServletRequest request){
        User byEntity = userService.getByEntity(u);
        if (byEntity==null){
            return "redirect:/login/res.action";
        }else {
            request.getSession().setAttribute("role",2);
            request.getSession().setAttribute("username",byEntity.getUserName());
            request.getSession().setAttribute("userId",byEntity.getId());
            return "redirect:/login/uIndex.action";
        }
    }

    //前端用户 退出
    @RequestMapping("/uTui")
    public String uTui(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return "redirect:/login/uIndex.action";
    }
}
