package project.zfbd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.zfbd.Hbase.EvaporationWaveTableQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Mycon {

    @RequestMapping("/project")
    public String Mycon(HttpServletRequest request,Model model){
        int id=Integer.parseInt(request.getParameter("id"));
        if(id==1){
            String type1=request.getParameter("type1");
            int year=Integer.parseInt(request.getParameter("year"));
            int month=Integer.parseInt(request.getParameter("month"));
            int day=Integer.parseInt(request.getParameter("day"));
            EvaporationWaveTableQuery.ValueType valueType;
            if(type1=="波导高度"){
                valueType=EvaporationWaveTableQuery.ValueType.valueOf("BDGD");
            }
            else{
                valueType=EvaporationWaveTableQuery.ValueType.valueOf("BDQD");
            }
            EvaporationWaveTableQuery evaporationWaveTableQuery=new EvaporationWaveTableQuery();
            List<String> heatmap0=evaporationWaveTableQuery.queryByDate(valueType,year,month,day,0);
            model.addAttribute("heatmap0",heatmap0);
            List<String> heatmap6=evaporationWaveTableQuery.queryByDate(valueType,year,month,day,6);
            model.addAttribute("heatmap6",heatmap6);
            List<String> heatmap12=evaporationWaveTableQuery.queryByDate(valueType,year,month,day,12);
            model.addAttribute("heatmap12",heatmap12);
            List<String> heatmap18=evaporationWaveTableQuery.queryByDate(valueType,year,month,day,18);
            model.addAttribute("heatmap18",heatmap18);
        }
        if(id==2){
            String type2=request.getParameter("type2");
            EvaporationWaveTableQuery.ValueType valueType;
            if(type2=="波导高度"){
                valueType=EvaporationWaveTableQuery.ValueType.valueOf("BDGD");
            }
            else{
                valueType=EvaporationWaveTableQuery.ValueType.valueOf("BDQD");
            }
            int longitude2=Integer.parseInt(request.getParameter("longitude2"));
            int latitude2=Integer.parseInt(request.getParameter("latitude2"));
            EvaporationWaveTableQuery evaporationWaveTableQuery=new EvaporationWaveTableQuery();
            String avg_year=evaporationWaveTableQuery.queryYearAverage(valueType,longitude2,latitude2);
            model.addAttribute("avg_year",avg_year);
        }
        if(id==3){
            String type3=request.getParameter("type3");
            int longitude3=Integer.parseInt(request.getParameter("longitude3"));
            int latitude3=Integer.parseInt(request.getParameter("latitude3"));
            EvaporationWaveTableQuery.ValueType valueType;
            if(type3=="波导高度"){
                valueType=EvaporationWaveTableQuery.ValueType.valueOf("BDGD");
            }
            else{
                valueType=EvaporationWaveTableQuery.ValueType.valueOf("BDQD");
            }
            EvaporationWaveTableQuery evaporationWaveTableQuery=new EvaporationWaveTableQuery();
            String avg_month=evaporationWaveTableQuery.queryMonthAverage(valueType,longitude3,latitude3);
            model.addAttribute("avg_month",avg_month);
        }
        return "project";
    }

    @RequestMapping("/map")
    public String Mycon1(HttpServletRequest request){
        return "pro_map";
    }

}