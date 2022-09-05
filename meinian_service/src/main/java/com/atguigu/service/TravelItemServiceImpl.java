package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.TravelItemMapper;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.TravelItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*************************************************
                时间: 2021-09-01
                作者: 刘  辉
                描述: 尚硅谷教学团队
  ************************************************/
@Service(interfaceClass = TravelItemService.class)
public class TravelItemServiceImpl implements TravelItemService {

    @Autowired
    private TravelItemMapper travelItemMapper;

    @Override
    public void save(TravelItem travelItem) {
        travelItemMapper.save(travelItem);
    }

    /*************************************************
      PageHelper的具体使用
        1.第一步：导入PageHelper的依赖信息
        2.第二步：在mybatis-config.xml配置文件中配置PageInceptor
        3.第三步: 在service层使用PageHelper进行分页设置
             3.1 在查询List数据之前使用PageHelper.startPage(pageNum,pageSize)
             3.2 进行列表List数据查询
             3.3 使用PageInfo对象封装查询的列表数据
     ************************************************/
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        List<TravelItem> list=travelItemMapper.getTravelItemList(queryPageBean);
        PageInfo<TravelItem> pageInfo = new PageInfo<TravelItem>(list);
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
      在实际开发中，删除数据有关联数据时，一般有这么几种情况：
        1.第一种，如果删除的数据在其它表中有关联数据，直接抛出异常，不让删除
        2.第二种，如果删除的数据在其它表中有关联数据，先删除关联数据，然后再删除当前数据(java代码)
        3.第三种：如果删除的数据在其它表中有关联数据，先删除关联数据，然后再删除当前数据(数据库的方式)
        4.第四种：如果删除的数据在其它表中有关联数据，先将关联数据的外键设置为null，然后再删除当前数据(数据库的方式)
     */
    @Override
    public void deleteById(Integer id) {
        travelItemMapper.deleteById(id);
    }

    @Override
    public TravelItem findById(Integer id) {
        return travelItemMapper.findById(id);
    }

    @Override
    public void edit(TravelItem travelItem) {
        travelItemMapper.edit(travelItem);
    }

    @Override
    public List<TravelItem> findAll() {
        return travelItemMapper.findAll();
    }
}
