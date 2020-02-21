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
		/**先执行创建singleTon构造函数，count1 = 1,count2 = 0;再初始化count1、count2,此时count1不变、count2变为0***/
		TestClass singleTon = TestClass.getInstance();
		System.out.println("count1=" + singleTon.count1);
		System.out.println("count2=" + singleTon.count2);
	}
}