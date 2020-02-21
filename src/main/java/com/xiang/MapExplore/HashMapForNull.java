package com.xiang.MapExplore;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by mayn on 2020/2/21.
 * HashMap、hashTable的key、value是否可为null探究
 *
 * 总结：HashMap键值可以都为null、但hashTable键值都不能为null
 */
public class HashMapForNull {

    public static void main(String[] args) {
        HashMap hashMap = Maps.newHashMap();
        hashMap.put(null, null);
        System.out.println(hashMap.toString());

        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);
        hashtable.put(null,1);
        System.out.println(hashtable.toString());


    }
}
