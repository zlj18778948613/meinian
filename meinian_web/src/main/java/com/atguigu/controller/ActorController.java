package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*************************************************
                时间: 2021-08-29
                作者: 刘  辉
                描述: 尚硅谷教学团队
  ************************************************/
@Controller
@RequestMapping("/actor")
public class ActorController {

    @Reference
    private ActorService actorService;

    @RequestMapping("/info")
    @ResponseBody
    public String getActorInfo(String name){
        return actorService.getActorInfo(name);
    }
}
