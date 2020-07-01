package com.dyh.stockcomparison.controller;//package com.dyh.stockcomparison.controller;
//
//import com.dyh.stockcomparison.mbg.model.SubKd;
//import com.dyh.stockcomparison.service.SubKService;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//
///**
// * @Date:9:21 2020/6/9
// * @Author dyh
// * @Version 1.0
// **/
//@Controller
//public class test extends Thread{
//
//    @Autowired
////    private StockDfcfFundFlowInfoService stockDfcfFundFlowInfoService;
//    @RequestMapping("/ss")
////    @ResponseBody
////    public StockDfcfFundFlowInfo ss(){
////        List sl=stockDfcfFundFlowInfoService.selectcode();
////        for (int i = 0; i < sl.size(); i++) {
////            StockDfcfFundFlowInfo    st = (StockDfcfFundFlowInfo) sl.get(i);
////            url(st.getStockCode(),st.getId());
////            System.out.println(st.getId()+st.getStockName());
////        }
////
////        return null;
////    }
//
//
//
//
//
//
//
//    /**
//     *@author dyh
//    　　* @Description: 根据code判断属于上交所还是深交所 然后放入url、
//    　　* @param [code]
//    　　* @return java.util.List
//    　　* @throws
//    　　* @date 2020/6/9 13:41
//    　　
//     * @return*/
//    public List<String> url(String code,long id){
//
//        List<String>   strs=new ArrayList<String>();
//        String code1=code;
//        Long date =new Date().getTime();
////        Long date1=date+random_number();
//        String a="6";
//        String  str1 = code1.substring(0,1);
//        if (str1.equals(a)){
//            String sh="1.";
//            String url1="http://"+random_number()+".push2his.eastmoney.com/api/qt/stock/kline/get?cb=" +
//                    "jQuery112408415444410868154_"+date+"&secid="+sh+code1+"&ut=" +
//                    "fa5fd1943c7b386f172d6893dbfba10b&fields1=f1%2Cf2%2Cf3%2Cf4%2" +
//                    "Cf5&fields2=f51%2Cf52%2Cf53%2Cf54%2Cf55%2Cf56%2Cf57%2Cf58&kl" +
//                    "t=101&fqt=0&end=20500101&lmt=120&_="+date ;
//            strs.add(url1);
//        }else {
//            String sz="0.";
//            String url1="http://"+random_number()+".push2his.eastmoney.com/api/qt/stock/kline/get?cb=" +
//                    "jQuery112408415444410868154_"+date+"&secid="+sz+code1+"&ut=" +
//                    "fa5fd1943c7b386f172d6893dbfba10b&fields1=f1%2Cf2%2Cf3%2Cf4%2" +
//                    "Cf5&fields2=f51%2Cf52%2Cf53%2Cf54%2Cf55%2Cf56%2Cf57%2Cf58&kl" +
//                    "t=101&fqt=0&end=20500101&lmt=120&_="+date ;
//            strs.add(url1);
//        }
////       loourl(strs);
//        for (int i=0;i<strs.size();i++){
//            try {
//                craw(strs.get(i),id);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//         return null;
//    }
//    @RequestMapping("/sss")
//    @ResponseBody
//    public String craw(String url,Long id) throws IOException {
//        long startTime = System.currentTimeMillis();
//        //使用OkHttp只需要3步
//        url="http://101.push2his.eastmoney.com/api/qt/stock/kline/get?cb=\n" +
//                "jQuery112408415444410868154_1588902457312&secid=0.002351&ut=\n" +
//                "fa5fd1943c7b386f172d6893dbfba10b&fields1=f1%2Cf2%2Cf3%2Cf4%2\n" +
//                "Cf5&fields2=f51%2Cf52%2Cf53%2Cf54%2Cf55%2Cf56%2Cf57%2Cf58&kl\n" +
//                "t=101&fqt=0&end=20500101&lmt=120&_=1588902457332";
//        id=000221L;
//        //1.创建对象
//        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
//                .readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
//                .writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
//                .build();
//        //2.构建请求
//        Request.Builder builder = new Request.Builder().url(url);
//        //增加请求头
//        builder.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
//        //3.发送请求
//        Request request = builder.build();
//        //3.发送请求,返回响应对象
//        Response response = client.newCall(request).execute();
//        //获取响应数据
//        String retText = response.body().string();
//        List<String> list = extractMessage(retText);
//        for (int i = 0; i < list.size(); i++) {
//            String a =   list.get(i);
//            json(a,id);
//        }
//        String time = String.format("爬虫耗费的时间: %s ", System.currentTimeMillis() - startTime);
//        System.out.println(time);
//        return retText;
//
//    }
//
//    @Autowired
//    private SubKService subKService;
//
//    public  List json(String json,Long id){
//        System.out.println("----");
//        System.out.println(id);
////        System.out.println(json);
//
//        long startTime = System.currentTimeMillis();
//        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd HH:mm:ss的时间格式
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            JSONObject jsonObject =new JSONObject(json);//解析到第一层{}
//            JSONObject JSONObject1 =jsonObject.getJSONObject("data");//解析到第2层data对象
//            JSONArray jsonArray=JSONObject1.getJSONArray("klines");//解析到第3层trends[]
//            List list1 = new ArrayList();
//            for (int i = 0; i < jsonArray.length(); i++){
//                //倒序排列后取最后一个
////                if (i==jsonArray.length()-1){
//                    System.out.println("i:="+(jsonArray.length()-1));
//                    String a=jsonArray.get(i).toString();
//                    list1.add(a);
////                }
//            }
//            List<SubKd> rest =new ArrayList();
//            for (Object o:list1){
//                String[] strarrt=o.toString().split(",");
//                String time = strarrt[0];
//                Date date = null;
//                try {
//                    date = sf.parse(time);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                String vq = strarrt[4];
//                String vqq = strarrt[5];
//                String tivme = strarrt[6];
//                SubKd subKd=new SubKd();
//                subKd.setData(date);
//                subKd.setCurrentAmount(vq);
//                subKd.setVolume(vqq);
//
//                subKd.setTurnover(tivme);
//                subKd.setStId(id);
//                rest.add(subKd);
//
//            }
//            subKService.addsubk(rest);
//            System.out.println(rest);
//            String time = String.format("爬虫耗费的时间: %s ", System.currentTimeMillis() - startTime);
//            System.out.println(time);
//        }catch (Exception e){
//            System.out.println("youbug");
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//
//    /**
//     *@author dyh
//    　　* @Description: 获取100以内的随机数
//    　　* @param []
//    　　* @return int
//    　　* @throws
//    　　* @date 2020/6/9 10:33
//    　　*/
////    public int random_number(){
////        int s =0;
////        Random random=new Random();
////        s=(random.nextInt(99)+1);
////        return s;
////    }
////    /**提取小括号中内容，忽略中括号中的中括号
////     *@author dyh
////    　　* @Description:
////    　　* @param [msg]
////    　　* @return java.util.List<java.lang.String>
////    　　* @throws
////    　　* @date 2020/4/30 10:34
////    　　*/
////    public static List<String> extractMessage(String msg) {
////        List<String> list = new ArrayList<String>();
////        int start = 0;
////        int startFlag = 0;
////        int endFlag = 0;
////        for (int i = 0; i < msg.length(); i++) {
////            if (msg.charAt(i) == '(') {
////                startFlag++;
////                if (startFlag == endFlag + 1) {
////                    start = i;
////                }
////            } else if (msg.charAt(i) == ')') {
////                endFlag++;
////                if (endFlag == startFlag) {
////                    list.add(msg.substring(start + 1, i));
////                }
////            }
////        }
////        return list;
////    }
//
//}