package com.dyh.stockcomparison.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date:11:19 2020/6/22
 * @Author dyh
 * @Version 1.0
 **/
public class extractMessage {
    /**提取小括号中内容，忽略中括号中的中括号
     *@author dyh
    　　* @Description:
    　　* @param [msg]
    　　* @return java.util.List<java.lang.String>
    　　* @throws
    　　* @date 2020/4/30 10:34
    　　*/
    public static List<String> extractMessage(String msg) {
        List<String> list = new ArrayList<String>();
        int start = 0;
        int startFlag = 0;
        int endFlag = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '(') {
                startFlag++;
                if (startFlag == endFlag + 1) {
                    start = i;
                }
            } else if (msg.charAt(i) == ')') {
                endFlag++;
                if (endFlag == startFlag) {
                    list.add(msg.substring(start + 1, i));
                }
            }
        }
        return list;
    }
}