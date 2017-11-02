package com.xiang.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

/**
 * Created by WIN7 on 2017/10/31.
 * @author Norris
 * <p>
 * MultiSet可重复添加相同的元素；Multiset元素的顺序是无关紧要的：Multiset {a, a, b}和{a, b, a}是相等的
 * <p>
 * <p>
 * 方法	                            描述
 * count(E)	            给定元素在Multiset中的计数
 * elementSet()	        Multiset中不重复元素的集合，类型为Set<E>
 * entrySet()	            和Map的entrySet类似，返回Set<Multiset.Entry<E>>，其中包含的Entry支持getElement()和getCount()方法
 * add(E, int)	            增加给定元素在Multiset中的计数
 * remove(E, int)	        减少给定元素在Multiset中的计数
 * setCount(E, int)	    设置给定元素在Multiset中的计数，不可以为负数
 * size()	                返回集合元素的总个数（包括重复的元素）
 * <p>
 * Multiset不是Map
 * <p>
 * 请注意，Multiset<E>不是Map<E, Integer>，虽然Map可能是某些Multiset实现的一部分。准确来说Multiset是一种Collection类型，
 * 并履行了Collection接口相关的契约。
 * <p>
 * 关于Multiset和Map的显著区别还包括：
 * <p>
 * Multiset中的元素计数只能是正数。任何元素的计数都不能为负，也不能是0。elementSet()和entrySet()视图中也不会有这样的元素。
 * multiset.size()返回集合的大小，等同于所有元素计数的总和。对于不重复元素的个数，应使用elementSet().size()方法。（因此，add(E)把multiset.size()增加1）
 * multiset.iterator()会迭代重复元素，因此迭代长度等于multiset.size()。
 * Multiset支持直接增加、减少或设置元素的计数。setCount(elem, 0)等同于移除所有elem。
 * 对multiset 中没有的元素，multiset.count(elem)始终返回0。
 * <p>
 * <p>
 * <p>
 * Multiset的各种实现
 * <p>
 * Guava提供了多种Multiset的实现，大致对应JDK中Map的各种实现：
 * <p>
 *      Map	                    对应的Multiset	        是否支持null元素
 *    HashMap	                 HashMultiset	            是
 *    TreeMap	                 TreeMultiset	            是（如果comparator支持的话）
 *    LinkedHashMap	           LinkedHashMultiset	        是
 *    ConcurrentHashMap	       ConcurrentHashMultiset	    否
 *    ImmutableMap	           ImmutableMultiset	        否
 */
public class MutliSetTest {

    @Test
    public void test() {
        Multiset<Integer> set = HashMultiset.create();
        for (int i = 0; i < 20; i++) {
            set.add(new Double(Math.random() * 20).intValue());
        }

        System.out.println("集合总长度--->" + set.size());
        System.out.println("集合非重复元素长度-->" + set.elementSet().size());

        System.out.println("3的个数-->" + set.count(3));

        for (Multiset.Entry entry : set.entrySet()) {
            System.out.println(entry.getElement() + "----" + entry.getCount());
        }
    }

}
