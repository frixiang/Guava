package com.xiang.threadLocal;/**
 * Created by WIN7 on 2019/9/6.
 */

/**
 * @ClasssName Test
 * @Description TODO
 *
 *
 * 使用ThreadLocal隔离的值不能是引用，否则隔离的只是引用，而引用所指向的对象则隔离失败；
 * 本地数据区ThreadLocalMap是挂在Thread对象上的，所以要注意线程复用(线程池)所带来的污染。
 *
 * @Author norris
 * @Date 2019/9/6 16:21
 **/
public class Test {
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();


	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}

	public long getLong() {
		return longLocal.get();
	}

	public String getString() {
		return stringLocal.get();
	}

	public static void main(String[] args) throws InterruptedException {
		final Test test = new Test();


		//test.set();
		//System.out.println(test.getLong());
		//System.out.println(test.getString());


		Thread thread1 = new Thread(){
			public void run() {
				//test.set();
				System.out.println(test.getLong());
				//System.out.println(test.getString());
			};
		};
		//thread1.start();

		String t = test.getString();
		System.out.println(t == null ? 1 : 0);
		//System.out.println(test.getLong());
		//System.out.println(test.getString());
	}
}