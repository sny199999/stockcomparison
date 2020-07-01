package com.dyh.stockcomparison.utils;

import java.util.Random;

/**
 * @Date:11:31 2020/6/22
 * @Author dyh
 * @Version 1.0
 **/
public class random {
    /**
     *@author dyh
    　　* @Description: 获取100以内的随机数
    　　* @param []
    　　* @return int
    　　* @throws
    　　* @date 2020/6/9 10:33
    　　*/
    public static int random_number(){
        int s =0;
        Random random=new Random();
        s=(random.nextInt(99)+1);
        return s;
    }
}