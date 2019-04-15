package project.zfbd.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestCon {
    @RequestMapping("/test")
    public String Mycon(HttpServletRequest request, Model model) {
        String type1 = request.getParameter("type1");
        String date = request.getParameter("date");
        int int_year = 0;
        int int_month = 0;
        int int_day = 0;
        if((date!=null)){
            String year = date.split("-")[0];
            String month = date.split("-")[1];
            String day = date.split("-")[2];
            int_year = Integer.parseInt(year);
            int_month = Integer.parseInt(month);
            int_day = Integer.parseInt(day);
        }
        System.out.println(type1+int_year+int_month+int_day);

        List<String> heatmap0 = new ArrayList<String>();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("lon", "100");
        jsonObject2.put("lat", "3");
        jsonObject2.put("value", "46.2");
        String v1 = jsonObject2.toJSONString();
        heatmap0.add(v1);
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("lon", "101");
        jsonObject3.put("lat", "3");
        jsonObject3.put("value", "52.3");
        String v2 = jsonObject3.toJSONString();
        heatmap0.add(v2);
        JSONObject jsonObject20 = new JSONObject();
        jsonObject20.put("lon", "100");
        jsonObject20.put("lat", "0");
        jsonObject20.put("value", "5");
        String v20 = jsonObject20.toJSONString();
        heatmap0.add(v20);
        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("lon", "102");
        jsonObject4.put("lat", "4");
        jsonObject4.put("value", "48.6");
        String v3 = jsonObject4.toJSONString();
        heatmap0.add(v3);

        List<String> heatmap6 = new ArrayList<String>();
        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("lon", "100");
        jsonObject5.put("lat", "3");
        jsonObject5.put("value", "49.2");
        String v5 = jsonObject5.toJSONString();
        heatmap6.add(v5);
        JSONObject jsonObject6 = new JSONObject();
        jsonObject6.put("lon", "101");
        jsonObject6.put("lat", "3");
        jsonObject6.put("value", "58.3");
        String v6 = jsonObject6.toJSONString();
        heatmap6.add(v6);
        JSONObject jsonObject7 = new JSONObject();
        jsonObject7.put("lon", "102");
        jsonObject7.put("lat", "4");
        jsonObject7.put("value", "42.6");
        String v7 = jsonObject7.toJSONString();
        heatmap6.add(v7);

        List<String> heatmap12 = new ArrayList<String>();
        JSONObject jsonObject8 = new JSONObject();
        jsonObject8.put("lon", "100");
        jsonObject8.put("lat", "3");
        jsonObject8.put("value", "40.2");
        String v8 = jsonObject8.toJSONString();
        heatmap12.add(v8);
        JSONObject jsonObject9 = new JSONObject();
        jsonObject9.put("lon", "101");
        jsonObject9.put("lat", "3");
        jsonObject9.put("value", "39.3");
        String v9 = jsonObject9.toJSONString();
        heatmap12.add(v9);
        JSONObject jsonObject10 = new JSONObject();
        jsonObject10.put("lon", "102");
        jsonObject10.put("lat", "4");
        jsonObject10.put("value", "41.6");
        String v10 = jsonObject10.toJSONString();
        heatmap12.add(v10);

        List<String> heatmap18 = new ArrayList<String>();
        JSONObject jsonObject11 = new JSONObject();
        jsonObject11.put("lon", "100");
        jsonObject11.put("lat", "3");
        jsonObject11.put("value", "25.2");
        String v11 = jsonObject11.toJSONString();
        heatmap18.add(v11);
        JSONObject jsonObject12 = new JSONObject();
        jsonObject12.put("lon", "101");
        jsonObject12.put("lat", "3");
        jsonObject12.put("value", "53.3");
        String v12 = jsonObject12.toJSONString();
        heatmap18.add(v12);
        JSONObject jsonObject13 = new JSONObject();
        jsonObject13.put("lon", "102");
        jsonObject13.put("lat", "4");
        jsonObject13.put("value", "44.6");
        String v13 = jsonObject13.toJSONString();
        heatmap18.add(v13);

        String type2 = request.getParameter("type2");
        String lon1 = request.getParameter("longitude1");
        String lat1 = request.getParameter("latitude1");
        int int_lon1 = 0;
        int int_lat1 = 0;
        if ((lon1 != null) && (lat1 != null)) {
            int_lon1 = Integer.parseInt(lon1);
            int_lat1 = Integer.parseInt(lat1);
        }
        System.out.println(type2+int_lon1+int_lat1);

        JSONObject jsonObject1  = new JSONObject();
        jsonObject1.put("2009年","45.2");
        jsonObject1.put("2010年","51.6");
        jsonObject1.put("2011年","46.2");
        jsonObject1.put("2012年","32.9");
        jsonObject1.put("2013年","58.3");
        jsonObject1.put("2014年","38.9");
        jsonObject1.put("2015年","40.5");
        String avg_year=jsonObject1.toJSONString();

        String type3 = request.getParameter("type3");
        String lon2 = request.getParameter("longitude2");
        String lat2 = request.getParameter("latitude2");
        String month2 = request.getParameter("month");
        int int_lon2 = 0;
        int int_lat2 = 0;
        int int_month2 = 0;
        if ((lon2 != null) && (lat2 != null)&&(month2 != null)) {
            int_lon2 = Integer.parseInt(lon2);
            int_lat2 = Integer.parseInt(lat2);
            int_month2 = Integer.parseInt(month2);
        }
        System.out.println(type3+int_lon2+int_lat2+int_month2);
        JSONObject jsonObject  = new JSONObject();
        jsonObject.put("1月","45.2");
        jsonObject.put("2月","51.6");
        jsonObject.put("3月","46.2");
        jsonObject.put("4月","32.9");
        jsonObject.put("5月","58.3");
        jsonObject.put("6月","38.9");
        jsonObject.put("7月","40.5");
        jsonObject.put("8月","40.5");
        jsonObject.put("9月","40.5");
        jsonObject.put("10月","40.5");
        jsonObject.put("11月","40.5");
        jsonObject.put("12月","40.5");
        String avg_month=jsonObject.toJSONString();

        JSONObject jsonObject21;
        jsonObject21 = new JSONObject();
        jsonObject21.put("0","0.62");
        jsonObject21.put("1","0.516");
        jsonObject21.put("2","0.462");
        jsonObject21.put("3","0.329");
        jsonObject21.put("4","0.583");
        jsonObject21.put("5","0.389");
        jsonObject21.put("6","0.405");
        jsonObject21.put("7","0.405");
        String probability_month=jsonObject21.toJSONString();

        model.addAttribute("probability_month",probability_month);
        model.addAttribute("type1",type1);
        model.addAttribute("heatmap0", heatmap0);
        model.addAttribute("heatmap6", heatmap6);
        model.addAttribute("heatmap12", heatmap12);
        model.addAttribute("heatmap18", heatmap18);
        model.addAttribute("avg_year",avg_year);
        model.addAttribute("avg_month",avg_month);


        return "zfbd";
    }



    @RequestMapping("/map")
    public String Mycon1(){
        return "pro_map";
    }

}