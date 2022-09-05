package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*************************************************
                时间: 2021-09-01
                作者: 刘  辉
                描述: 尚硅谷教学团队
  ************************************************/
@RestController // @Controller+@ResponseBody
@RequestMapping("/travelItem")
public class TravelItemController {

    @Reference
    private TravelItemService travelItemService;


    //所有自由行信息
    @RequestMapping("/list")
    public Result findAll(){
        try {
            List<TravelItem> list= travelItemService.findAll();
            return new Result(true,MessageConstant.QUERY_TRAVELITEM_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_TRAVELITEM_FAIL);
        }

    }

    //修改
    @RequestMapping("/edit")
    public Result edit(@RequestBody TravelItem travelItem){
        try {
            travelItemService.edit(travelItem);
            return new Result(true,MessageConstant.EDIT_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_TRAVELITEM_FAIL);
        }
    }

    //回显
    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
           TravelItem travelItem=  travelItemService.findById(id);;
           return new Result(true,MessageConstant.QUERY_TRAVELITEM_SUCCESS,travelItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_TRAVELITEM_FAIL);
        }
    }


    //删除
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            travelItemService.deleteById(id);
            return new Result(true,MessageConstant.DELETE_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_TRAVELITEM_FAIL);
        }
    }
    //分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return travelItemService.findPage(queryPageBean);
    }

    //添加
    @RequestMapping("/add")
    public Result addTravelItem(@RequestBody TravelItem travelItem){
        try {
            travelItemService.save(travelItem);
            return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELITEM_FAIL);
        }
    }
}
