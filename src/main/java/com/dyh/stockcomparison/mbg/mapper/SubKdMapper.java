package com.dyh.stockcomparison.mbg.mapper;

import com.dyh.stockcomparison.mbg.model.SubKd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Date:11:23 2020/6/11
 * @Author dyh
 * @Version 1.0
 **/
@Mapper
public interface SubKdMapper {
    Integer addsubk(List<SubKd> list);
    List selest_id(@Param("st_id") Integer stId);
    String seletsum(@Param("st_id") Integer stId, @Param("da") Integer da);
}
