package com.xiang.immutableexplore;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/**
 * Created by WIN7 on 2017/10/31.
 * Why use?
 * 不可变对象有很多优点，包括：
 * <p>
 * 当对象被不可信的库调用时，不可变形式是安全的；
 * 不可变对象被多个线程调用时，不存在竞态条件问题
 * 不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
 * 不可变对象因为有固定不变，可以作为常量来安全使用。
 * 创建对象的不可变拷贝是一项很好的防御性编程技巧。Guava为所有JDK标准集合类型和Guava新集合类型都提供了简单易用的不可变版本。
 * JDK也提供了Collections.unmodifiableXXX方法把集合包装为不可变形式，但我们认为不够好：
 * <p>
 * 笨重而且累赘：不能舒适地用在所有想做防御性拷贝的场景；
 * 不安全：要保证没人通过原集合的引用进行修改，返回的集合才是事实上不可变的；
 * 低效：包装过的集合仍然保有可变集合的开销，比如并发修改的检查、散列表的额外空间，等等。
 * 如果你没有修改某个集合的需求，或者希望某个集合保持不变时，把它防御性地拷贝到不可变集合是个很好的实践。
 * <p>
 * 重要提示：所有Guava不可变集合的实现都不接受null值。我们对Google内部的代码库做过详细研究，发现只有5%的情况需要在集合中允许null元素，
 * 剩下的95%场景都是遇到null值就快速失败。如果你需要在不可变集合中使用null，请使用JDK中的Collections.unmodifiableXXX方法
 *
 * 创建不可变集合的三种方式
 * 1、copyOf(collection)
 * 2、of(a,b,c...)
 * 3、builder工具
 *
 * 注：对于有序不可变集合，是在构造集合时对元素进行排序的
 */
public class ImmutableTest {

    @Test
    public void SetTest(){
        /**
         * 方式一
         */
        Set<Integer> set = Sets.newHashSet(1,6,3,9,5,0);
        ImmutableSet<Integer> immutableSet = ImmutableSet.copyOf(set);
        for(Integer i : immutableSet.toArray(new Integer[]{})){
            System.out.println(i);
        }

        System.out.println("---------------------------------------------------");

        /**
         * 方式二
         */
        ImmutableSet<String> immutableString = ImmutableSet.of("a","c","b","d","f");
        for(String str : immutableString.asList()){
            System.out.println(str);
        }

        System.out.println("---------------------------------------------------");

        /**
         * 方式三
         */
        ImmutableSet<Integer> immutableObj = ImmutableSet.<Integer>builder().build();
        System.out.println(immutableObj.size());

        immutableObj = ImmutableSet.<Integer>builder().add(1).add(2).add(3).build();
        System.out.println(immutableObj.size());

        System.out.println("---------------------------------------------------");

        /**
         * 有序的不可变集合
         */
        ImmutableSortedSet<String> immutableSortedSet = ImmutableSortedSet.copyOf(immutableString);
        for(String str : immutableSortedSet.asList()){
            System.out.println(str);
        }
    }

}
