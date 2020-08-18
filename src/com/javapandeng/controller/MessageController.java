package com.javapandeng.controller;

//公告

import com.alibaba.fastjson.JSONObject;
import com.javapandeng.base.BaseController;
import com.javapandeng.po.Message;
import com.javapandeng.service.MessageService;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {


    @Autowired
    private MessageService messageService;
    //留言列表
    @RequestMapping("/findBySql")
    public String findBySql(Message message, Model model){
        String sql = "select * from message where 1=1 ";
        if(!isEmpty(message.getName())){
            sql += " and name like '%"+message.getName()+"%'";
        }
        sql += " order by id desc";
        Pager<Message> pagers = messageService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",message);
        return "message/message";
    }



    /**
     * 删除留言
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        messageService.deleteById(id);
        return "redirect:/message/findBySql";
    }


    //发表留言页面
    @RequestMapping("/add")
    public String add(){
        return  "message/add";
    }

    //发表留言逻辑操作
    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(Message message){
        messageService.insert(message);
        JSONObject js = new JSONObject();
        js.put("message","添加成功");
        return  js.toString();
    }

}
