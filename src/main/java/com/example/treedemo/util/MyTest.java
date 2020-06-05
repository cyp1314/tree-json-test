package com.example.treedemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.treedemo.entity.CustomPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static String toTree(List<CustomPO> data) {
        List<CustomPO> result = new ArrayList<>();
        // 元数据转Map
        Map<Integer,CustomPO> tem = new HashMap<Integer,CustomPO>();
        for (CustomPO d:data) {
            tem.put(d.getId(), d);
        }

        for (int i = 0; i < data.size(); i++) {
            CustomPO mCustomPO = data.get(i);

            int mPId = mCustomPO.getPId();

            if (tem.get(mPId) != null){
                // 存在父亲
                CustomPO p = tem.get(mPId);
                if (p.getChild() != null){
                    // 已经有child
                    p.getChild().add(mCustomPO);
                }else {
                    // 没有child子元素
                    List mObjects = new ArrayList<CustomPO>();
                    mObjects.add(mCustomPO);
                    p.setChild(mObjects);
                }
            }else {
                // 不存在父亲
                result.add(mCustomPO);
            }
        }

        return JSON.toJSONString(result);
    }
}
