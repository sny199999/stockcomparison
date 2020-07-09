package com.dyh.stockcomparison.service.impl;

import com.dyh.stockcomparison.mbg.mapper.SubKdMapper;
import com.dyh.stockcomparison.mbg.model.SubKd;
import com.dyh.stockcomparison.service.SubKService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Date:14:45 2020/6/11
 * @Author dyh
 * @Version 1.0
 **/
@Service
public class SubKServiceImpl implements SubKService {

    @Autowired
    private SubKdMapper subKdMapper;

    @Override
    public void addsubk(List<SubKd> list) {
            subKdMapper.addsubk(list);
    }

    @Override
    public Page selest_id(@Param("st_id") Integer stId,Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        Page list=(Page) subKdMapper.selest_id(stId);
        return list;
    }

    @Override
    public String seletsum(Integer stId, Integer da) {
        return subKdMapper.seletsum(stId,da);
    }

    @Override
    public SubKd seletor(Integer stId,  Date d) {
        SubKd list= subKdMapper.seletor(stId,d);
        return list;
    }

    @Override
    public void updatesubk(SubKd subKd) {
        subKdMapper.updatesubk(subKd);
    }


}