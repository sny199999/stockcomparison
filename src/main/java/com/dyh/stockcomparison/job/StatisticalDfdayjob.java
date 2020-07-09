package com.dyh.stockcomparison.job;

import com.dyh.stockcomparison.mbg.model.DfcfEastmoney;
import com.dyh.stockcomparison.mbg.model.StatisticalDfday;
import com.dyh.stockcomparison.service.DfcfEastmoneyService;
import com.dyh.stockcomparison.service.StatisticalDfdayService;
import com.dyh.stockcomparison.service.SubKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static com.dyh.stockcomparison.utils.random.random_number;

/**
 * @author dyh
 * @date 2020/7/1 14:28
 */
@Controller
public class StatisticalDfdayjob {
    @Autowired
    private DfcfEastmoneyService dfcfEastmoneyService;
    @Autowired
    private SubKService subKService;
    @Autowired
    private StatisticalDfdayService statisticalDfdayService;

    public StatisticalDfdayjob() {
    }
    @RequestMapping("/lkk")
    public String select_dfcfid(Integer page, Integer limit){
        List sl=dfcfEastmoneyService.scode(1, 50);
        for (int i = 0; i < sl.size(); i++) {
            DfcfEastmoney st = (DfcfEastmoney) sl.get(i);
            System.out.println(st.getF12()+":"+st.getId());
            s(String.valueOf(st.getId()));

        }
        System.out.println(random_number()+"-*-*-*-*");
        return null;
    }
    @RequestMapping("/lk")
    @ResponseBody
    public  Double s(String id){
        System.out.println(id);
       Double five=Double.parseDouble(String.format("%.2f",(Double.parseDouble(subKService.seletsum(145,5)))/5));
       Double ten=Double.parseDouble(String.format("%.2f",(Double.parseDouble(subKService.seletsum(145,10)))/10));
       Double Fifteen=Double.parseDouble(String.format("%.2f",(Double.parseDouble(subKService.seletsum(145,15)))/15));
       Double Twenty=Double.parseDouble(String.format("%.2f",(Double.parseDouble(subKService.seletsum(145,20)))/20));
        System.out.println(five+"----"+ten+"----"+Fifteen+"----"+Twenty+"----");
        StatisticalDfday st= new StatisticalDfday();
        st.setFive(five);
        st.setTen(ten);
        st.setFifteen(Fifteen);
        st.setTwenty(Twenty);
        st.setDfId(145);
        st.setDate(new Date());
       List s= statisticalDfdayService.selest_id(145);
       if (s.size()==0){
           System.out.println("erro+++++++++++++");
           statisticalDfdayService.addst(st);
       }else {
           System.out.println("gou");
           statisticalDfdayService.updatst(st);
       }
        System.out.println(st);


        return null;
    }

}
