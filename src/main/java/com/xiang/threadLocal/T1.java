package com.xiang.threadLocal;/**
 * Created by WIN7 on 2019/10/27.
 */

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClasssName T1
 * @Description 使用ThreadLocal隔离的值不能是引用，否则隔离的只是引用，而引用所指向的对象则隔离失败
 * @Author norris
 * @Date 2019/10/27 15:48
 **/
public class T1 {
	public static List<String> SHARE_LIST = new CopyOnWriteArrayList<String>();

	public static void main(String[] args) throws Exception {
		SHARE_LIST.add("Int");
		System.out.println("Change before : " + SHARE_LIST);
		new MyThread2("Tom").start();
		new MyThread2("Jack").start();
		System.out.println("Change after :");

		Thread.currentThread().sleep(500);
		System.out.println(Thread.currentThread() + ":" + SHARE_LIST);
	}

	static class MyThread2 extends Thread {
		private ThreadLocal<List<String>> local = new ThreadLocal<List<String>>();
		private String name;

		public MyThread2(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			local.set(SHARE_LIST);
			local.get().add(name);   // Change the parameter locally.
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + ":" + local.get());
		}
	}
}