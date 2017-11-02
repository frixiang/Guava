package com.xiang.MapExplore;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by WIN7 on 2017/11/1.
 *
 * @author Norris
 *
 *         Multimap  键值的对应关系是一对多，可以以下两种方式看待
 *         1、a-1、a-2、b-3
 *         2、a-{1,2}、b-{3}
 *
 *         实现	                    键行为类似	    值行为类似
 *         ArrayListMultimap	    HashMap	        ArrayList
 *         HashMultimap         	HashMap	        HashSet
 *         LinkedListMultimap	    LinkedHashMap	LinkedList
*          LinkedHashMultimap	    LinkedHashMap   LinkedHashMap
 *         TreeMultimap	            TreeMap	        TreeSet
 *         ImmutableListMultimap	ImmutableMap	ImmutableList
 *         ImmutableSetMultimap	    ImmutableMap	ImmutableSet
 */
public class MultimapTest {

    @Test
    public void test() {
        /**
         * Multimap中一对多的关系中，同一个键不包含重复的元素
         */
        Multimap map = LinkedHashMultimap.create();
        map.put(1, 2);
        map.put(1, 3);
        map.put(1, 3);

        for (Object i : map.get(1)
                ) {
            System.out.println(i);

        }
        System.out.println("--------------------");
        System.out.println(map.get(1).size());


        System.out.println("--------------------");
        /**
         * 对Multimap的视图的操作会反映到Multimap底层中
         */

        Multimap Map = HashMultimap.create();
        Map.put(1, 2);
        Set set = (Set) Map.get(1);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(Map.get(1).size());

        System.out.println("--------------------");
        Map.remove(1, 4);
        System.out.println(Map.get(1).size());

        System.out.println("--------------------");
        Collection collection = Map.removeAll(1);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------------------");
        System.out.println(Map.get(1).size());
        System.out.println(Map.get(1).isEmpty());

        /**
         * asMap为Multimap<K, V>提供Map<K,Collection<V>>形式的视图。返回的Map支持remove操作，
         * 并且会反映到底层的Multimap，但它不支持put或putAll操作
         */
        System.out.println("--------------------");
        map.asMap().put(1,6);//unsupportedOperationException
        for (Object i : map.get(1)
                ) {
            System.out.println(i);
        }
    }
}
