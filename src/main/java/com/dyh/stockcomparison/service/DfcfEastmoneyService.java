package com.dyh.stockcomparison.service;

import com.dyh.stockcomparison.mbg.model.DfcfEastmoney;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @Date:10:35 2020/6/17
 * @Author dyh
 * @Version 1.0
 **/
public interface DfcfEastmoneyService {
    void addDfcf(DfcfEastmoney dfcfEastmoney);
    DfcfEastmoney selectcode(@Param("code") String code);
    void  updateDfcF(DfcfEastmoney dfcfEastmoney);
    Page<DfcfEastmoney> scode(Integer page, Integer rows);
    Page sall(Integer page, Integer rows);

}
