package project.zfbd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.zfbd.service.EvaporationWaveTableQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class mycontroller {
    @RequestMapping("/project")
    public String mycon1(HttpServletRequest request, Model model) {
        String type1 = request.getParameter("type1");
        String date = request.getParameter("date");
        int int_year = 0;
        int int_month = 0;
        int int_day = 0;
        if(date!=null){
            String year = date.split("-")[0];
            String month = date.split("-")[1];
            String day = date.split("-")[2];
            int_year = Integer.parseInt(year);
            int_month = Integer.parseInt(month);
            int_day = Integer.parseInt(day);
        }
        EvaporationWaveTableQuery.ValueType valueType1;
        if ("波导高度".equals(type1)) {
            valueType1 = EvaporationWaveTableQuery.ValueType.valueOf("BDGD");
        } else {
            valueType1 = EvaporationWaveTableQuery.ValueType.valueOf("BDQD");
        }
        EvaporationWaveTableQuery evaporationWaveTableQuery1 = new EvaporationWaveTableQuery();
        List<String> heatmap0 = evaporationWaveTableQuery1.queryByDate(valueType1, int_year, int_month, int_day, 0);
        model.addAttribute("heatmap0", heatmap0);
        List<String> heatmap6 = evaporationWaveTableQuery1.queryByDate(valueType1, int_year, int_month, int_day, 6);
        model.addAttribute("heatmap6", heatmap6);
        List<String> heatmap12 = evaporationWaveTableQuery1.queryByDate(valueType1, int_year, int_month, int_day, 12);
        model.addAttribute("heatmap12", heatmap12);
        List<String> heatmap18 = evaporationWaveTableQuery1.queryByDate(valueType1, int_year, int_month, int_day, 18);
        model.addAttribute("heatmap18", heatmap18);

        String type2 = request.getParameter("type2");
        String lon1 = request.getParameter("longitude1");
        String lat1 = request.getParameter("latitude1");
        int int_lon1 = 0;
        int int_lat1 = 0;
        if ((lon1 != null) && (lat1 != null)) {
            int_lon1 = Integer.parseInt(lon1);
            int_lat1 = Integer.parseInt(lat1);
        }
        EvaporationWaveTableQuery.ValueType valueType2;
        if ("波导高度".equals(type2)) {
            valueType2 = EvaporationWaveTableQuery.ValueType.valueOf("BDGD");
        } else {
            valueType2 = EvaporationWaveTableQuery.ValueType.valueOf("BDQD");
        }
        EvaporationWaveTableQuery evaporationWaveTableQuery2 = new EvaporationWaveTableQuery();
        String avg_year = evaporationWaveTableQuery2.queryYearAverage(valueType2, int_lon1, int_lat1);
        model.addAttribute("avg_year", avg_year);

        String type3 = request.getParameter("type3");
        String lon2 = request.getParameter("longitude2");
        String lat2 = request.getParameter("latitude2");
        int int_lon2 = 0;
        int int_lat2 = 0;
        if ((lon2 != null) && (lat2 != null)) {
            int_lon2 = Integer.parseInt(lon2);
            int_lat2 = Integer.parseInt(lat2);
        }
        EvaporationWaveTableQuery.ValueType valueType3;
        if ("波导高度".equals(type3)) {
            valueType3 = EvaporationWaveTableQuery.ValueType.valueOf("BDGD");
        } else {
            valueType3 = EvaporationWaveTableQuery.ValueType.valueOf("BDQD");
        }
        EvaporationWaveTableQuery evaporationWaveTableQuery3 = new EvaporationWaveTableQuery();
        String avg_month = evaporationWaveTableQuery3.queryMonthAverage(valueType3, int_lon2, int_lat2);
        model.addAttribute("avg_month", avg_month);

        String month=request.getParameter("month");
        int month_pro=0;
        if(month!=null){
            month_pro=Integer.parseInt(month);
        }
        EvaporationWaveTableQuery evaporationWaveTableQuery4=new EvaporationWaveTableQuery();
        String probablity_month=evaporationWaveTableQuery4.queryProbabilityOnMonth(valueType3,month_pro,int_lon2,int_lat2);
        model.addAttribute("probablity_month",probablity_month);

        return "zfbd";
    }
}