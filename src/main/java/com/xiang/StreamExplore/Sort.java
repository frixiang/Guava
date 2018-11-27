package com.xiang.StreamExplore;

import com.alibaba.fastjson.JSON;
import com.xiang.model.Computer;
import com.xiang.util.ComputerBuilderUtil;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
}