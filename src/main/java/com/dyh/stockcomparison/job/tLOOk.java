package com.dyh.stockcomparison.job;

import com.alibaba.fastjson.JSON;
import com.dyh.stockcomparison.mbg.model.DfcfEastmoney;
import com.dyh.stockcomparison.service.DfcfEastmoneyService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.dyh.stockcomparison.utils.extractMessage.extractMessage;


/**
 * @Date:11:42 2020/6/15
 * @Author dyh
 * @Version 1.0
 **/
@Controller
public class tLOOk {
    @Autowired
    private DfcfEastmoneyService dfcfEastmoneyService;

    int u=0;
    @RequestMapping("/go")
    @ResponseBody
    public   String go(){
        long startTime = System.currentTimeMillis();
        Long date =new Date().getTime();
        Long date1=date+random_number();
        String token="bd1d9ddb04089700cf9c27f6f7426281";
        String fields="f2,f3,f4,f5,f12,f14";
        int limt=50;
        if (u==0){
            System.out.println("第一次"+u);
            String  url="http://"+random_number()+".push2.eastmoney.com/api/qt/clist/get?cb=jQuery112402944470064721265_"+date+"&pn=1&pz=1&po=1&np=1&ut="+token+"&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields="+fields+"&_="+date1;
            try {
                look_url(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //创建多线程定义数量
            ExecutorService e = Executors.newFixedThreadPool(10);
            int cdls=u/limt;
            CountDownLatch cdl= new CountDownLatch(cdls);
            for (int i=1;i<=u/limt;i++){
                final int inx=i;
                e.execute(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (tLOOk.class){
                            try {
                                String  url="http://"+random_number()+".push2.eastmoney.com/api/qt/clist/get?cb=jQuery112402944470064721265_"+date+"" +
                                        "&pn="+inx+"&pz="+limt+"&po=1&np=1&ut="+token+"&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields="+fields+"&_="+date1;
                                look_url(url);
                                System.out.println(Thread.currentThread().getName()+":"+url);
                            }catch (Exception e){
                                e.printStackTrace();
                            }finally {
                                cdl.countDown();
                                System.out.println("还有"+cdl+"个"+cdls);

                                if (cdl.getCount()==0){
                                    u=0;
                                    String time = String.format("爬虫耗费的时间: %s ", System.currentTimeMillis() - startTime);
                                    int i= Integer.valueOf(time).intValue();;
                                    System.out.println(time+"ms"+(i % (1000 * 60 * 60)) / (1000 * 60)+"min");
                                }
                            }

                        }
                    }
                });
            }
            e.shutdown();//关闭线程
        }
        return  null;
    }
    /**
     *@author dyh
    　　* @Description: 解析数据并放入实体类----->存入数据库
    　　* @param [a]
    　　* @return java.lang.String
    　　* @throws
    　　* @date 2020/6/15 15:55
    　　*/
    public  String json(String a){
        List<DfcfEastmoney> list=null;
        if (a!=null){
            JSONObject jsonObject =new JSONObject(a);//解析到第一层{}
            try {
                JSONObject JSONObject1 =jsonObject.getJSONObject("data");//解析到第2层data对象
                JSONArray jsonArray=JSONObject1.getJSONArray("diff");//解析到第3层trends[]
                String newjson=jsonArray.toString();
                if (u==0){
                    u =JSONObject1.getInt("total");
                    return go();
                }

                list = JSON.parseArray(newjson, DfcfEastmoney.class);//解析到第4层{}
                List hh= new ArrayList();
                Date de=new Date();
                for (int i = 0; i < list.size(); i++) {
                    DfcfEastmoney   dfcfEastmoney = list.get(i);//把数据放入实体类;}

                    DfcfEastmoney s=   dfcfEastmoneyService.selectcode(dfcfEastmoney.getF12());
                    if (s==null){
                        dfcfEastmoney.setDate(de);
                        System.out.println("没有数据");
                        dfcfEastmoneyService.addDfcf(dfcfEastmoney);
                    }else {
                        dfcfEastmoney.setUtdate(de);
                        System.out.println("修改数据");
                        dfcfEastmoneyService.updateDfcF(dfcfEastmoney);

                    }
                    hh.add(dfcfEastmoney);
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("异常");
            }
        }
        return null;
    }

    @RequestMapping("/url")
    @ResponseBody
    public String look_url(String url) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        //2.构建请求
//         url="http://78.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112402944470064721265_1592273706081&pn=1&pz=5&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields=f2,f3,f4,f5,f12,f14&_=1592273706096";
        System.out.println(url);
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
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            json(list.get(i)) ;
        }
        return null;
    }
    /**
     *@author dyh
    　　* @Description: 提取100以内的随机数
    　　* @param []
    　　* @return int
    　　* @throws
    　　* @date 2020/6/15 15:09
    　　*/
    public int random_number(){
        int s =0;
        Random random=new Random();
        s=(random.nextInt(99)+1);
        return s;
    }
    @RequestMapping("/tim")
    @ResponseBody
    public String a(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String[] codes = str.split("");
        int num = 8;
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(52);
            code.append(codes[a]);
        }
        System.out.println(code.toString());
        return code.toString();
    }
//    @RequestMapping("/ssss")
//    @ResponseBody
//    public String ssss(String mss){
//        int i = Integer.valueOf(mss).intValue();
//
//        long days = i / (1000 * 60 * 60 * 24);
//        long hours = (i % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
//        long minutes = (i % (1000 * 60 * 60)) / (1000 * 60);
//        long seconds = (i % (1000 * 60)) / 1000;
//        return days + " days " + hours + " hours " + minutes + " minutes "
//                + seconds + " seconds ";
//    }

}