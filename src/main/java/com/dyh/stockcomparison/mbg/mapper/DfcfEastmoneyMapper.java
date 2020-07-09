package com.dyh.stockcomparison.mbg.mapper;

import com.dyh.stockcomparison.mbg.model.DfcfEastmoney;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Date:10:32 2020/6/17
 * @Author dyh
 * @Version 1.0
 **/
@Mapper
public interface DfcfEastmoneyMapper {
    void addDfcf(DfcfEastmoney dfcfEastmoney);
    DfcfEastmoney selectcode(@Param("code") String code);
    void  updateDfcF(DfcfEastmoney dfcfEastmoney);
    List<DfcfEastmoney>  scode();
    List  sall();

}
