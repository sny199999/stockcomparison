package com.dyh.stockcomparison.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dyh.stockcomparison.mbg.model.DfcfEastmoney;
import com.dyh.stockcomparison.mbg.model.SubKd;
import com.dyh.stockcomparison.service.DfcfEastmoneyService;
import com.dyh.stockcomparison.service.SubKService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.dyh.stockcomparison.utils.extractMessage.extractMessage;
import static com.dyh.stockcomparison.utils.random.random_number;

/**
 * @Date:11:35 2020/6/9
 * @Author dyh
 * @Version 1.0
 **/
@Controller
public class DfcfKlineJob {

        @Autowired
        private DfcfEastmoneyService dfcfEastmoneyService;
        @Autowired
        private SubKService subKService;

        @RequestMapping("/wq")
        @ResponseBody
        public String ss(Integer page, Integer limit){
        List sl=dfcfEastmoneyService.scode(1, 50);
        for (int i = 0; i < sl.size(); i++) {
            DfcfEastmoney st = (DfcfEastmoney) sl.get(i);
            System.out.println(st.getF12()+":"+st.getId());
            url(st.getF12(),st.getId());
        }
        System.out.println(random_number()+"-*-*-*-*");
        return null;
    }
        /**
         *@author dyh
        　　* @Description: 根据code判断属于上交所还是深交所 然后放入url、
        　　* @param [code]
        　　* @return java.util.List
        　　* @throws
        　　* @date 2020/6/9 13:41
        　　*/
        public List url(String code,int id){
        List<String>   strs=new ArrayList<String>();
//        String code1=code;
            Long date =new Date().getTime();
            Long date1=date+random_number();
            String token="bd1d9ddb04089700cf9c27f6f7426281";
            String fields2="f51%2Cf53%2Cf56%2Cf57";
//        Long date1=date+random_number();
        String a="6";
        String  str1 = code.substring(0,1);
        List list=subKService.selest_id(145,1,10);
        if (list.size()==0){
            System.out.println("第一次" );
        }else {
            if (str1.equals(a)){
                String sh="1.";
                String url1="http://"+random_number()+".push2his.eastmoney.com/api/qt/stock/kline/get?cb=" +
                        "jQuery112408415444410868154_"+date+"&secid="+sh+code+"&ut=" +
                        token+"&fields1=f1%2Cf2%2Cf3%2Cf4%2Cf5&" +
                        "fields2="+fields2+"&kl" +
                        "t=101&fqt=0&end=20500101&lmt=120&_="+date;
                strs.add(url1);

            }else {
                String sz="0.";
                String url1="http://"+random_number()+".push2his.eastmoney.com/api/qt/stock/kline/get?cb=" +
                        "jQuery112408415444410868154_"+date+"&secid="+sz+code+"&ut=" +
                        token+"&fields1=f1%2Cf2%2Cf3%2Cf4%2Cf5&" +
                        "fields2="+fields2+"&kl" +
                        "t=101&fqt=0&end=20500101&lmt=120&_="+date;
                strs.add(url1);
            }
        }

            System.out.println(strs);
        return strs;
    }
@RequestMapping("/we")
@ResponseBody
    public String craw(String url) throws IOException {
        url="            http://29.push2his.eastmoney.com/api/qt/stock/kline/get?cb=jQuery112408415444410868154_1592797565790&secid=0.002850&ut=fa5fd1943c7b386f172d6893dbfba10b&fields1=f1%2Cf3&fields2=f51%2Cf53%2Cf56%2Cf57&klt=101&fqt=0&end=20500101&lmt=3&_=1592797565790";
        //使用OkHttp只需要3步
        //1.创建对象
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
                .build();

        //2.构建请求
        Request.Builder builder = new Request.Builder().url(url);
        //增加请求头
        builder.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        //3.发送请求
        Request request = builder.build();
        //3.发送请求,返回响应对象
        Response response = client.newCall(request).execute();
        //获取响应数据
        String retText = response.body().string();
        List<String> list = extractMessage(retText);

        for (int i = 0; i < list.size(); i++) {
            String a =   list.get(i);
            //将整理好的数据放入json解析
            json(a);
        }
        return retText;

    }
    public  String json(String json){
        JSONArray arr    = JSON.parseObject(json).getJSONObject("data").getJSONArray("klines");
        List list=new ArrayList();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        for (Object o : arr) {
            String[]            strArr = o.toString().split(",");
            String              time   = strArr[0];
            String              currentAmount = strArr[1];
            String              volume = strArr[2];
            String              turnover = strArr[3];
            SubKd sk=new SubKd();
            try {
                sk.setData(sf.parse(time));
            } catch (ParseException e) {
                e.printStackTrace();
            }
                sk.setCurrentAmount(currentAmount);
                sk.setVolume(volume);
                sk.setTurnover(turnover);
                list.add(sk);

        }
        System.out.println(list);
            return null;
    }



}