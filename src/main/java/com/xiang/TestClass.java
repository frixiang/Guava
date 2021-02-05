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
		System.out.println("count1=" + count1);
		System.out.println("count2=" + count2);
	}

	public static TestClass getInstance() {
		return singleTon;
	}

	public static void main(String[] args) {
		/**
		 * 初始化顺序依次是（静态变量、静态初始化块）>（变量、初始化块）>构造器
		 * 因此先执行创建singleTon的构造函数，初始化count1 = 1,count2 = 1;再初始化静态成员变量count1、count2,此时count1未赋值，因此不变、count2赋值为为0***/
		TestClass singleTon = TestClass.getInstance();
		System.out.println("count1=" + singleTon.count1);
		System.out.println("count2=" + singleTon.count2);
	}
}