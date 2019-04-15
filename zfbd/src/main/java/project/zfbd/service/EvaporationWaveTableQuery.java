package project.zfbd.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import project.zfbd.utils.HBaseUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Konfuse
 * @Date: 2019/4/10 上午8:57
 */
public class EvaporationWaveTableQuery {
    private static String tableName = "evaporation";
    public static enum ValueType {
        BDGD,
        BDQD;
    }

    public List<String> queryByDate(ValueType valueType, int year, int month, int day, int hour) {
        List<String> list = new LinkedList<>();
        String row = null;
        String position, type;
        String value = null;
        JSONObject jsonObject = new JSONObject();

        if (valueType == ValueType.BDGD) {
            type = "bdgd";
        } else {
            type = "bdqd";
        }

        //create regex for querying
        String regex = String.format("%04d", year)
                + "-"
                + String.format("%02d", month)
                + "-"
                + String.format("%02d", day)
                + "-"
                + String.format("%02d", hour)
                + ".*";
        List<Result> resultList = HBaseUtil.getDataByRegex(tableName, regex);

        //travel result sets, convert value to json string, and push into a list
        for (Result result : resultList) {
            for (Cell cell : result.listCells()) {
                //if find the correct type, break and use the value
                row = Bytes.toString(CellUtil.cloneRow(cell));
                if ((Bytes.toString(CellUtil.cloneQualifier(cell))).equals(type)) {
                    value = Bytes.toString(CellUtil.cloneValue(cell));
                    break;
                }
            }
            if (row == null)
                continue;
            //build json object
            position = row.substring(row.indexOf(":") + 1);
            jsonObject.put("lon", position.substring(0, position.indexOf(",")));
            jsonObject.put("lat", position.substring(position.indexOf(",") + 1));
            jsonObject.put(type, value);
            list.add(jsonObject.toJSONString());
            jsonObject.clear();
        }

        return list;
    }

    public String queryMonthAverage(ValueType valueType, int lon, int lat) {
        JSONObject jsonObject = new JSONObject();
        String row = null;
        String type;
        String value = null;
        String[] date;
        HashMap<String, Double> mapSum = new HashMap<>();
        HashMap<String, Integer> mapNum = new HashMap<>();

        //map init
        for (int i = 1; i <= 12; i++) {
            mapSum.put(String.format("%02d", i), 0.0);
            mapNum.put(String.format("%02d", i), 0);
        }


        if (valueType == ValueType.BDGD) {
            type = "bdgd";
        } else {
            type = "bdqd";
        }

        //create regex for querying
        String regex = ".*:"
                + String.format("%03d", lon)
                + ","
                + String.format("%03d", lat);
        List<Result> resultList = HBaseUtil.getDataByRegex(tableName, regex);

        //travel result sets
        for (Result result : resultList) {
            for (Cell cell : result.listCells()) {
                //if find the correct type, break and use the value
                if ((Bytes.toString(CellUtil.cloneQualifier(cell))).equals(type)) {
                    row = Bytes.toString(CellUtil.cloneRow(cell));
                    value = Bytes.toString(CellUtil.cloneValue(cell));
                    break;
                }
            }
            if (row == null)
                continue;
            //compute average
            date = row.substring(0, row.indexOf(":")).split("-");
            mapSum.put(date[1], mapSum.get(date[1]) + Double.parseDouble(value));
            mapNum.put(date[1], mapNum.get(date[1]) + 1);
        }

        //build json object
        for (String key : mapSum.keySet()) {
            jsonObject.put(key, mapSum.get(key) / mapNum.get(key));
        }
        return jsonObject.toJSONString();
    }

    public String queryYearAverage(ValueType valueType, int lon, int lat) {
        JSONObject jsonObject = new JSONObject();
        String type;
        String row = null;
        String value = null;
        String[] date;
        HashMap<String, Double> mapSum = new HashMap<>();
        HashMap<String, Integer> mapNum = new HashMap<>();
        //judge type of value
        if (valueType == ValueType.BDGD) {
            type = "bdgd";
        } else {
            type = "bdqd";
        }

        //create regex for querying
        String regex = ".*:"
                + String.format("%03d", lon)
                + ","
                + String.format("%03d", lat);
        List<Result> resultList = HBaseUtil.getDataByRegex(tableName, regex);

        //travel result sets
        for (Result result : resultList) {
            for (Cell cell : result.listCells()) {
                //if find the correct type, break and use the value
                if ((Bytes.toString(CellUtil.cloneQualifier(cell))).equals(type)) {
                    row = Bytes.toString(CellUtil.cloneRow(cell));
                    value = Bytes.toString(CellUtil.cloneValue(cell));
                    break;
                }
            }
            if (row == null)
                continue;
            date = row.substring(0, row.indexOf(":")).split("-");
            String finalValue = value;
            mapSum.compute(date[0], (k, v) -> {
               if (v == null) return Double.parseDouble(finalValue);
               return v + Double.parseDouble(finalValue);
            });
            mapNum.compute(date[0], (k, v) -> {
                if (v == null) return 1;
                return v + 1;
            });
        }

        //build json object
        for (String key : mapSum.keySet()) {
            jsonObject.put(key, mapSum.get(key) / mapNum.get(key));
        }
        return jsonObject.toJSONString();
    }

    public String queryProbabilityOnMonth(ValueType valueType, int month, int lon, int lat) {
        JSONObject jsonObject = new JSONObject();
        String type;
        String row = null;
        String value = null;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //judge type of value
        if (valueType == ValueType.BDGD) {
            type = "bdgd";
        } else {
            type = "bdqd";
        }

        //create regex for querying
        String regex = "[\\d]{4}"
                + String.format("%02d", month)
                + "[\\d]+:"
                + String.format("%03d", lon)
                + ","
                + String.format("%03d", lat);
        List<Result> resultList = HBaseUtil.getDataByRegex(tableName, regex);

        //travel result sets
        for (Result result : resultList) {
            for (Cell cell : result.listCells()) {
                //if find the correct type, break and use the value
                if ((Bytes.toString(CellUtil.cloneQualifier(cell))).equals(type)) {
                    row = Bytes.toString(CellUtil.cloneRow(cell));
                    value = Bytes.toString(CellUtil.cloneValue(cell));
                    break;
                }
            }
            if (row == null)
                continue;
            double finalValue = Double.parseDouble(value);
            map.compute(((int)finalValue) / 5, (k, v)->{
                if (v == null) return 1;
                return v + 1;
            });
            sum++;
        }
        //build json object
        for (Integer key : map.keySet()) {
            jsonObject.put(String.valueOf(key), map.get(key) * 0.1 / sum);
        }
        return jsonObject.toJSONString();
    }
}
