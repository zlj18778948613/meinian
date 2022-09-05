package com.atguigu.dao;

import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.TravelItem;

import java.util.List;

/*************************************************
                时间: 2021-09-01
                作者: 刘  辉
                描述: 
  ************************************************/
public interface TravelItemMapper {
    void save(TravelItem travelItem);

    List<TravelItem> getTravelItemList(QueryPageBean queryString);

    void deleteById(Integer id);

    TravelItem findById(Integer id);

    void edit(TravelItem travelItem);

    List<TravelItem> findAll();
}
