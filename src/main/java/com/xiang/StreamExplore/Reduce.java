package com.xiang.StreamExplore;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * @ClasssName Reduce
 * @Description TODO
 * @Author WIN7
 * @Date 2018/11/28 11:18
 **/
public class Reduce {
	/**
	 * reduce(xx,xx),第一参数为初始值，若stream为空，则返回初始值(由于返回值不可能为null，因此返回类型不是optional)
	 * reduce(xx),无初始值的方法，返回类型optional
	 */
	@Test
	public void Test(){
		List<Integer> integers = Lists.newArrayList(1,2,3);
		Integer sumA = integers.stream().reduce(1, (a, b) -> a+b);
		System.out.println(sumA);

		Integer sumB = integers.stream().reduce(1, Integer::sum);
		System.out.println(sumB);

		Integer sumC = integers.stream().reduce(Integer::sum).get();
		System.out.println(sumC);

		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
		System.out.println(concat);

		concat = Stream.of("A", "B", "C", "D").reduce("W", String::concat);
		System.out.println(concat);

		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
		System.out.println(minValue);

		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
		System.out.println(concat);
	}
}