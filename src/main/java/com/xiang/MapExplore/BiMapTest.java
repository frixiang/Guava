package com.xiang.MapExplore;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by WIN7 on 2017/11/1.
 *
 * BiMap<K, V>是特殊的Map：
 * 可以用 inverse()反转BiMap<K, V>的键值映射
 * 保证值是唯一的，因此 values()返回Set而不是普通的Collection
 *
 * 注：put方法执行过程
 * 1、根据key查找Map,若找到，且新旧值的值及hashCode一致，则直接返回value
 * 2、若找不到，再根据value查找，若找到，且非强制put,则抛出IllegalArgumentException异常
 * 3、若key存在，value没找到，则删除key,然后新建entity并插入
 *
 * summary:（因可反转，所以必须保证value的唯一性）
 * 1、biMap不能插入已存在的value,除非key，value键值对已存在
 * 2、对于已存在的key,若插入不存在的value，则会更新旧值
 * 3、对于不存在的key,只可插入不存在的value
 */
public class BiMapTest {

    @Test
    public void test(){
        BiMap<Integer,String> biMap = HashBiMap.create();
        biMap.put(1,"2");
        biMap.put(2,"3");
        biMap.put(3,"4");

        for(Map.Entry entity : biMap.entrySet()){
            System.out.println(entity.getKey()+"--->"+entity.getValue());
        }
        System.out.println("-------------------");

        BiMap<String,Integer> map = biMap.inverse();
        for(Map.Entry entity : map.entrySet()){
            System.out.println(entity.getKey()+"--->"+entity.getValue());
        }

        System.out.println("-------------------");

        map.put("5",3);
        for(Map.Entry entity : map.entrySet()){
            System.out.println(entity.getKey()+"--->"+entity.getValue());
        }
    }
}
