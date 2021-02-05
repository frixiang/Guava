package com.xiang.MapExplore;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by mayn on 2020/2/21.
 * HashMap、hashTable的key、value是否可为null探究
 *
 * 总结：HashMap键值可以都为null、但hashTable键值都不能为null
 *
 * HashMap与Hashtable对比 （JDK7下）
 * 1、线程安全性 Hashtable通过synchronized关键字保证其安全性；HashMap线程不安全，多线程下若要使用，可通过Collections.synchronizedMap创建线程安全的HashMap（其底层也是通过synchronized关键字保证其安全性）
 * 2、HashMap键值可以都为null、但hashTable键值都不能为null（Hashtable在push操作时，会首选检测value是否为null,若是，则直接抛出空指针异常;若key为null,则在取key的哈希值时，抛出异常）（HashMap对null做了特殊处理，将null的hashCode值定为了0）
 * 3、HashMap继承了AbstractMap，HashTable继承Dictionary抽象类，两者均实现Map接口
 * 4、HashMap的初始容量为16，Hashtable初始容量为11，两者的填充因子默认都是0.75。HashMap扩容时是当前容量翻倍即:capacity 2，Hashtable扩容时是容量翻倍+1即:capacity (2+1)
 * 5、底层实现一致   数组 + 链表
 * 6、二者计算hashcode的方式不同
 */
public class HashMapForNull {

    public static void main(String[] args) {
        /*HashMap hashMap = Maps.newHashMap();
        hashMap.put(null, null);
        System.out.println(hashMap.toString());

        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);
        hashtable.put(null,1);
        System.out.println(hashtable.toString());*/

        for (int binCount = 0; binCount < 8; ++binCount) {
            System.out.println(binCount);

            System.out.println("llll");

            System.out.println(binCount);

        }
    }
}
