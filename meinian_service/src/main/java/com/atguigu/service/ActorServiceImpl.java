package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/*************************************************
                时间: 2021-08-29
                作者: 刘  辉
                描述: 尚硅谷教学团队
  ************************************************/
@Service(interfaceClass = ActorService.class)
@Transactional
public class ActorServiceImpl implements ActorService {
    @Override
    public String getActorInfo(String name) {
        return "heiheihei "+name;
    }
}
