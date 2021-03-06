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
        String type = request.getParameter("type");
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
        String lon = request.getParameter("longitude");
        String lat = request.getParameter("latitude");
        int int_lon = 0;
        int int_lat = 0;
        if ((lon != null) && (lat != null)) {
            int_lon = Integer.parseInt(lon);
            int_lat = Integer.parseInt(lat);
        }
        System.out.println(type+int_year+int_month+int_day+int_lon+int_lat);

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


        JSONObject jsonObject1  = new JSONObject();
        jsonObject1.put("2009年","45.2");
        jsonObject1.put("2010年","51.6");
        jsonObject1.put("2011年","46.2");
        jsonObject1.put("2012年","32.9");
        jsonObject1.put("2013年","58.3");
        jsonObject1.put("2014年","38.9");
        jsonObject1.put("2015年","40.5");
        String avg_year=jsonObject1.toJSONString();


        JSONObject jsonObject  = new JSONObject();
        jsonObject.put("1","45.2");
        jsonObject.put("2","51.6");
        jsonObject.put("3","46.2");
        jsonObject.put("4","32.9");
        jsonObject.put("5","58.3");
        jsonObject.put("6","38.9");
        jsonObject.put("7","40.5");
        jsonObject.put("8","40.5");
        jsonObject.put("9","40.5");
        jsonObject.put("10","40.5");
        jsonObject.put("11","40.5");
        jsonObject.put("12","40.5");
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
        model.addAttribute("type",type);
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