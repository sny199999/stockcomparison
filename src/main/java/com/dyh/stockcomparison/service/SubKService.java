package com.dyh.stockcomparison.service;

import com.dyh.stockcomparison.mbg.model.SubKd;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Date:14:43 2020/6/11
 * @Author dyh
 * @Version 1.0
 **/
public interface SubKService {
  void   addsubk(List<SubKd> list);
  Page selest_id(@Param("st_id") Integer stId, Integer page, Integer rows);
  String seletsum(@Param("st_id") Integer stId, @Param("da") Integer da);
  SubKd seletor( Integer stId, Date d);
  void  updatesubk(SubKd subKd);


}
