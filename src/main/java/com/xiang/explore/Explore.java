package com.xiang.explore;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.xiang.model.Computer;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by WIN7 on 2017/11/3.
 * 纯属探索
 */
public class Explore {

    @Test
    public  void testForString(){
        List<String> lista = Lists.newArrayList("as","fdf","haha","fdg","srg");
        List<String> listb = Lists.newArrayList("as","fdf","haaha","fdgf","srg");

        /**
         * 并集
         */
        Set<String> unionSet = Sets.union(Sets.newHashSet(lista),Sets.newHashSet(listb));
        Iterator<String> iterator = unionSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }

        System.out.println();
        /**
         * 差集(lista have but listb not)
         */
        Set<String> differenceSet = Sets.difference(Sets.newHashSet(lista),Sets.newHashSet(listb));
        iterator = differenceSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }

        System.out.println();
        /**
         * 交集
         */
        Set<String> intersectionSet = Sets.intersection(Sets.newHashSet(lista),Sets.newHashSet(listb));
        iterator = intersectionSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }

        System.out.println();
        /**
         * 并集-交集
         */
        Set<String> set = Sets.symmetricDifference(Sets.newHashSet(lista),Sets.newHashSet(listb));
        iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }
    }

    /**
     * 根据equals hashCode方法判断
     */
    @Test
    public  void testForObj() {
        Computer computerA = new Computer(1,"a",1);
        Computer computerB = new Computer(1,"b",1);
        List<Computer> lista = Lists.newArrayList(computerA);
        List<Computer> listb = Lists.newArrayList(computerB);

        System.out.println("============== 并集 ============");
        /**
         * 并集
         */
        Set<Computer> unionSet = Sets.union(Sets.newHashSet(lista), Sets.newHashSet(listb));
        Iterator<Computer> iterator = unionSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }

        System.out.println("\n============== 差集 ============");
        /**
         * 差集(lista have but listb not)
         */
        Set<Computer> differenceSet = Sets.difference(Sets.newHashSet(lista), Sets.newHashSet(listb));
        iterator = differenceSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }

        System.out.println("\n============== 交集 ============");
        /**
         * 交集
         */
        Set<Computer> intersectionSet = Sets.intersection(Sets.newHashSet(lista), Sets.newHashSet(listb));
        iterator = intersectionSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }

        System.out.println("\n============== 并集-交集 ============");
        /**
         * 并集-交集
         */
        Set<Computer> set = Sets.symmetricDifference(Sets.newHashSet(lista), Sets.newHashSet(listb));
        iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
    }
}
