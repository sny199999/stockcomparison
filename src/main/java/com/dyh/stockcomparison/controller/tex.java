package com.dyh.stockcomparison.controller;

import com.alibaba.fastjson.JSON;
import com.dyh.stockcomparison.mbg.model.DfcfEastmoney;
import com.dyh.stockcomparison.service.DfcfEastmoneyService;
import com.dyh.stockcomparison.service.SubKService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Date:10:24 2020/6/24
 * @Author dyh
 * @Version 1.0
 **/
@Controller
public class tex {
    @Autowired
    private SubKService subKService;
    @Autowired
    private DfcfEastmoneyService dfcfEastmoneyService;
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/sum")
    @ResponseBody
    public Map sssss(Integer page, Integer limit){
        Map result = new HashMap();
        result.put("code", 0);
        result.put("msg", 0);
        Page<DfcfEastmoney> p3=dfcfEastmoneyService.sall(page,limit);
        result.put("count", p3.getTotal());
        result.put("data", p3.getResult());
        System.out.println(p3);

//        List sl=new ArrayList();
//        for (int i=0;i<p3.size();i++){
//            System.out.println();
//            String str = JSON.toJSONString(p3.get(i)); //转化成JSON字符串
//            DfcfEastmoney dd = JSON.parseObject(str,DfcfEastmoney.class); //将JSON转化成对象
////            DfcfEastmoney dd=  p3.get(i);
////            int s=p3.get(i).getId();
//            String a = subKService.seletsum(dd.getId(),10);
//            System.out.println(a+"----------------");
//            dd.setTen(a);
////            for (int x=0;x<a.size();x++){
//////                int f=  a.get(x);
//////                dd.setTen(f); ;
////            }
//
////dd.setTen(lsum10);
//            sl.addAll(Collections.singleton(dd));
////            sl.addAll(Collections.singleton(dd));
////            sl.addAll(lsum10);




        return result;
    }
}