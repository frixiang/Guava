package com.xiang.threadLocal;/**
 * Created by WIN7 on 2019/10/27.
 */

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClasssName T2
 * @Description ThreadLocal赋初始值的时候，需要在线程运行中，即run()中，否则ThreadLocalMap会挂错线程
 * @Author norris
 * @Date 2019/10/27 15:51
 **/
public class T2 {
	public static List<String> SHARE_LIST = new CopyOnWriteArrayList<String>();

	public static void main(String[]args) throws InterruptedException {
		SHARE_LIST.add("Int");
		System.out.println("Change before : " + SHARE_LIST);
		new MyThread3("Tom", SHARE_LIST).start();
		new MyThread3("Jack", SHARE_LIST).start();
		System.out.println("Change after :");

		Thread.currentThread().sleep(500);
		System.out.println(Thread.currentThread() + ":" + SHARE_LIST);
	}

	static class MyThread3 extends Thread {
		private ThreadLocal<List<String>> local = new ThreadLocal<List<String>>();
		private String name;

		public MyThread3(String name, List<String> list) {
			this.name = name;
			local.set(list);
			/**此处可看出在该线程创建时，是在主线程main之下的，那么此时向ThreadLocal存值，存在了主线程下，并非在当前线程下，
			 * 而在run方法中获取此线程的副本并添加数据时，由于当前线程的threadLocalMap没有初始化过，因此会先初始化数据（未set，先get则易报空指针异常,cause:initialValue默认返回null）
			 * 因此在获取时报空指针**/
			System.out.println("name - " + Thread.currentThread().getName());
		}

		@Override
		public void run() {
			System.out.println("name - " + Thread.currentThread().getName());
			local.get().add(name); // Change the parameter locally.
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println(Thread.currentThread() + ":" + local.get());
		}
	}
}