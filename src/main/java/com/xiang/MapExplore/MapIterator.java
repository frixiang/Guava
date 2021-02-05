package com.xiang.MapExplore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fei.xiang
 * @Email:fei.xiang@melot.com
 * @Date: 2021/2/2
 * @Description:
 */
public class MapIterator {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
