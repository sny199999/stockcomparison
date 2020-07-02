package com.dyh.stockcomparison.service.impl;

import com.dyh.stockcomparison.mbg.mapper.StatisticalDfdayMapper;
import com.dyh.stockcomparison.mbg.model.StatisticalDfday;
import com.dyh.stockcomparison.service.StatisticalDfdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dyh
 * @version 1.0
 * @date 2020/7/1 14:36
 */
@Service
public class StatisticalDfdayServiceimpl implements StatisticalDfdayService {
    @Autowired
    private StatisticalDfdayMapper statisticalDfdayMapper;
    @Override
    public void addst(StatisticalDfday statisticalDfday) {
        statisticalDfdayMapper.addst(statisticalDfday);
    }

    @Override
    public void updatst(StatisticalDfday statisticalDfday) {
        statisticalDfdayMapper.updatst(statisticalDfday);
    }

    @Override
    public List selest_id(Integer dfId) {
        return statisticalDfdayMapper.selest_id(dfId);
    }
}
