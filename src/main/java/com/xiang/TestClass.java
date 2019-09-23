package com.xiang;/**
 * Created by WIN7 on 2019/9/23.
 */

/**
 * @ClasssName TestClass
 * @Description TODO
 * @Author norris
 * @Date 2019/9/23 11:16
 **/
public class TestClass {
	private static TestClass singleTon = new TestClass();
	public static int count1;
	public static int count2 = 0;

	private TestClass() {
		count1++;
		count2++;
	}

	public static TestClass getInstance() {
		return singleTon;
	}

	public static void main(String[] args) {
		TestClass singleTon = TestClass.getInstance();
		System.out.println("count1=" + singleTon.count1);
		System.out.println("count2=" + singleTon.count2);
	}
}