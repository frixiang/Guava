package com.xiang.util;

import java.util.UUID;

/**
 * @ClasssName GeneratorDigtalUtil
 * @Description TODO
 * @Author WIN7
 * @Date 2019/2/13 10:41
 **/
public class GeneratorDigtalUtil {
	public static void random(){
		String str = UUID.randomUUID().toString().replace("-", "");
		System.out.println(str);
	}

	public static void main(String[] args) {
		random();
	}
}