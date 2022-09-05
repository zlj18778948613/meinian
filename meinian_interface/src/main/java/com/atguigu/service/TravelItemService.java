package com.atguigu.service;

import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.TravelItem;

import java.util.List;

/*************************************************
                时间: 2021-09-01
                作者: 刘  辉
                描述: 
  ************************************************/
public interface TravelItemService {
    void save(TravelItem travelItem);

    PageResult findPage(QueryPageBean queryPageBean);

    void deleteById(Integer id);

    TravelItem findById(Integer id);

    void edit(TravelItem travelItem);

    List<TravelItem> findAll();
}
