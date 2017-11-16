package com.xiang.ordering;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.xiang.model.Computer;
import org.junit.Test;

import java.util.List;

/**
 * Created by WIN7 on 2017/11/16.
 * @author Norris
 * Guava排序器 explore
 */
public class OrderingTest {

    @Test
    public  void test(){
        List<String> stringList = Lists.newArrayList();
        stringList.add("luluyang");
        stringList.add("songyangjia");
        stringList.add("chagnhaha");
        stringList.add("buzhidaohaofanaaaaaaaa");
        stringList.add("wozhedebuzhidaoa");
        

        System.out.println("=====================原List======================");
        System.out.println("striongList:" + stringList);
        System.out.println();

        Ordering<String> natural = Ordering.natural();
        Ordering<Object> usingToString = Ordering.usingToString();
        Ordering<Object> arbitrary = Ordering.arbitrary();

        System.out.println("=====================natural（自然序）======================");
        stringList = natural.sortedCopy(stringList);
        System.out.println("natural:" + stringList);
        System.out.println();
        System.out.println("=====================natural（字典序）======================");
        stringList = usingToString.sortedCopy(stringList);
        System.out.println("usingToString:" + stringList);
        System.out.println();
        System.out.println("=====================natural（无序）======================");
        stringList = arbitrary.sortedCopy(stringList);
        System.out.println("arbirary:" + stringList);
        System.out.println();

        Ordering<Integer> orderingBig = new Ordering<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return left - right;
            }
        };
        List<Integer> integerList = Lists.newArrayList();
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(7);
        integerList.add(2);
        integerList.add(9);
        integerList.add(8);
        integerList.add(1);
        integerList.add(0);
        integerList =  orderingBig.sortedCopy(integerList);
        System.out.println("interList:" + integerList);

        Ordering<Computer> ordering = new Ordering<Computer>() {
            @Override
            public int compare(Computer computer, Computer t1) {
                return t1.getType().compareTo(computer.getType());
            }
        };

        List<Computer> computers = buildParam();
        computers = ordering.sortedCopy(computers);

        for (Computer c:computers
             ) {
            System.out.println(c.getName()+"--"+c.getType());
        }
    }

    public List<Computer> buildParam(){
        Computer computerA = new Computer(1,"haha",2);
        Computer computerB = new Computer(1,"haha",7);
        Computer computerC = new Computer(1,"haha",3);
        Computer computerD = new Computer(1,"haha",23);
        Computer computerE = new Computer(1,"haha",56);
        Computer computerF = new Computer(1,"haha",34);
        Computer computerG = new Computer(1,"haha",27);
        Computer computerH = new Computer(1,"haha",1);

        List<Computer> list = Lists.newArrayList(computerA,computerB,computerC,computerD,computerE,computerF,computerG,computerH);
        return list;
    }

}
