package com.dyh.stockcomparison.service.impl;

import com.dyh.stockcomparison.mbg.mapper.DfcfEastmoneyMapper;
import com.dyh.stockcomparison.mbg.model.DfcfEastmoney;
import com.dyh.stockcomparison.service.DfcfEastmoneyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date:10:36 2020/6/17
 * @Author dyh
 * @Version 1.0
 **/
@Service
public class DfcfEastmoneyServiceImpl implements DfcfEastmoneyService {
    @Autowired
    private DfcfEastmoneyMapper dfcfEastmoneyMapper;
    @Override
    public void addDfcf(DfcfEastmoney dfcfEastmoney) {
            dfcfEastmoneyMapper.addDfcf(dfcfEastmoney);
    }

    @Override
    public DfcfEastmoney selectcode(String code) {
        return dfcfEastmoneyMapper.selectcode(code);
    }

    @Override
    public void updateDfcF(DfcfEastmoney dfcfEastmoney) {
        dfcfEastmoneyMapper.updateDfcF(dfcfEastmoney);
    }

    @Override
    public Page<DfcfEastmoney> scode(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        Page<DfcfEastmoney> list=(Page) dfcfEastmoneyMapper.scode();
        return list;
    }

    @Override
    public Page sall(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        Page list=(Page) dfcfEastmoneyMapper.sall();
        return list;
    }


}