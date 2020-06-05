package com.example.treedemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.treedemo.entity.CustomPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * list to tree
 */
public class App {
    public static void main(String[] args) {
        Map m = new HashMap();
        List list = new ArrayList();
        CustomPO po = new CustomPO(1, 2, "安徽省-1",null);
        list.add(po);
        po = new CustomPO(2, 0, "安徽省",null);
        list.add(po);
        po = new CustomPO(3, 0, "浙江省",null);
        list.add(po);
        po = new CustomPO(4, 3, "浙江省—1",null);
        list.add(po);
        po = new CustomPO(5, 4, "浙江省—1-1",null);
        list.add(po);
        po = new CustomPO(6, 3, "浙江省—2",null);
        list.add(po);
        m.put("data", list);

        String mS = MyTest.toTree(list);
        System.out.println(mS);
//        System.out.println("List结构：" + JSON.toJSONString(m));
//        m.put("data", JsonUtil.listToTree(JSONArray.parseArray(JSON.toJSONString(list)), "id", "pId", "child"));
//        System.out.println("Tree结构：" + JSON.toJSONString(m));
    }
}