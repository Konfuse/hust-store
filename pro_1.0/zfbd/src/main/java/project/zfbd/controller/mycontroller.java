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
    public String mycon1(HttpServletRequest request, Model model){
        String type = request.getParameter("type");
        String date = request.getParameter("date");
        String lon = request.getParameter("longitude");
        String lat = request.getParameter("latitude");
        int int_year=0,int_month=0,int_day=0,int_lon=0,int_lat=0;
        if((type!=null)&&(date!=null)){
            String year = date.split("-")[0];
            String month = date.split("-")[1];
            String day = date.split("-")[2];
            int_year = Integer.parseInt(year);
            int_month = Integer.parseInt(month);
            int_day = Integer.parseInt(day);
            int_lon=Integer.parseInt(lon);
            int_lat=Integer.parseInt(lat);
        }
        EvaporationWaveTableQuery.ValueType valueType;
        if ("波导高度".equals(type)) {
            valueType = EvaporationWaveTableQuery.ValueType.valueOf("BDGD");
        } else {
            valueType = EvaporationWaveTableQuery.ValueType.valueOf("BDQD");
        }
        EvaporationWaveTableQuery evaporationWaveTableQuery = new EvaporationWaveTableQuery();
        List<String> heatmap0 = evaporationWaveTableQuery.queryByDate(valueType, int_year, int_month, int_day, 0);
        List<String> heatmap6 = evaporationWaveTableQuery.queryByDate(valueType, int_year, int_month, int_day, 6);
        List<String> heatmap12 = evaporationWaveTableQuery.queryByDate(valueType, int_year, int_month, int_day, 12);
        List<String> heatmap18 = evaporationWaveTableQuery.queryByDate(valueType, int_year, int_month, int_day, 18);
        String avg_year = evaporationWaveTableQuery.queryYearAverage(valueType, int_lon, int_lat);
        String avg_month = evaporationWaveTableQuery.queryMonthAverage(valueType, int_lon, int_lat);
        String probablity_month=evaporationWaveTableQuery.queryProbabilityOnMonth(valueType,int_month,int_lon,int_lat);
        model.addAttribute("heatmap0", heatmap0);
        model.addAttribute("heatmap6", heatmap6);
        model.addAttribute("heatmap12", heatmap12);
        model.addAttribute("heatmap18", heatmap18);
        model.addAttribute("avg_year", avg_year);
        model.addAttribute("avg_month", avg_month);
        model.addAttribute("probablity_month",probablity_month);
        return "zfbd";

    }
}
