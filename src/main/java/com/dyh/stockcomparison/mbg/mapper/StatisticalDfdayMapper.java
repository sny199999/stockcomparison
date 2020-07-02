package com.dyh.stockcomparison.mbg.mapper;

import com.dyh.stockcomparison.mbg.model.StatisticalDfday;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dyh
 * @version 1.0
 * @date 2020/7/1 14:34
 */
public interface StatisticalDfdayMapper {
    void  addst(StatisticalDfday statisticalDfday);
    void  updatst(StatisticalDfday statisticalDfday);
    List selest_id(@Param("df_id") Integer dfId);

}
