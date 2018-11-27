package com.xiang.StreamExplore;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.xiang.model.Computer;
import com.xiang.util.ComputerBuilderUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {
	/**
	 * 使用list.parallelStream()并发模式将速度更快
	 */
	@Test
	public void Test(){
		List<Computer> list = ComputerBuilderUtil.getInstanceList();
		System.out.println("排序前 ===>>" + JSON.toJSONString(list));

		list = list.stream().sorted(Comparator.comparing(Computer::getName).reversed()).collect(Collectors.toList());
		System.out.println("排序后(降序) ==>>" + JSON.toJSONString(list));

		list = list.stream().sorted(Comparator.comparing(Computer::getName)).collect(Collectors.toList());
		System.out.println("排序后(升序) ==>>" + JSON.toJSONString(list));

	}

	@Test
	public void MapTest(){
		List<Integer> list = ComputerBuilderUtil.getInstanceList().stream().map(Computer::getId).collect(Collectors.toList());
		list.stream().forEach(System.out::println);

		ComputerBuilderUtil.getInstanceList().stream().mapToInt(Computer::getId).forEach(System.out::println);
	}

	@Test
	public void floatMap(){
		/**
		 * flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字
		 */
		Stream<List<Integer>> inputStream = Stream.of(
				Arrays.asList(1),
				Arrays.asList(2, 3),
				Arrays.asList(4, 5, 6)
		);
		Stream<Integer> outputStream = inputStream.
				flatMap((childList) -> childList.stream());

		outputStream.forEach(System.out::println);
	}
}