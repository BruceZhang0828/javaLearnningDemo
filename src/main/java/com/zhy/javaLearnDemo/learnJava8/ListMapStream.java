package com.zhy.javaLearnDemo.learnJava8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ListMapStream
 * @Description: 处理ListMap
 * @auther: zhy
 * @Date: 2019/9/20 14:20
 * @Version: 1.0
 **/
public class ListMapStream {
    public static void main(String[] args) {
        Map<String,String> map1 = new HashMap<>();
        map1.put("node","node1");
        map1.put("name","yang1");
        map1.put("id","1");
        Map<String,String> map2 = new HashMap<>();
        map2.put("node","node2");
        map2.put("name","yang2");
        map2.put("id","2");
        Map<String,String> map7 = new HashMap<>();
        map7.put("node","node2");
        map7.put("name","yang2");
        map7.put("id","7");
        Map<String,String> map3 = new HashMap<>();
        map3.put("node","node3");
        map3.put("name","yang3");
        map3.put("id","3");
        Map<String,String> map4 = new HashMap<>();
        map4.put("node","node1");
        map4.put("name","yang1");
        map4.put("id","4");

        Map<String,String> map5 = new HashMap<>();
        map5.put("node","node3");
        map5.put("name","yang3");
        map5.put("id","5");

        Map<String,String> map6 = new HashMap<>();
        map6.put("node","node3");
        map6.put("name","yang3");
        map6.put("id","6");


        List<Map<String,String>> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        mapList.add(map5);
        mapList.add(map6);
        mapList.add(map7);

        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> stringObjectMap = mapList.get(i);
            String s = stringObjectMap.get("node");
            if (stringObjectMap.get("no")==null){
                stringObjectMap.put("no","1");
            }
            for (int j = i+1; j <mapList.size() ; j++) {
                Map<String, String> stringStringMap = mapList.get(j);
                if (s.equals(stringStringMap.get("node"))){
                    stringStringMap.put("no",(Integer.valueOf(stringObjectMap.get("no"))+1)+"");
                }else{
                    continue;
                }
            }
        }

        mapList.stream().forEach(map->System.out.println(map));

    }
}
