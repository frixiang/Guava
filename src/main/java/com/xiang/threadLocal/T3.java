package com.xiang.threadLocal;/**
 * Created by WIN7 on 2019/11/19.
 */

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClasssName T3
 * @Description 线程复用导致threadLocal失效 (线程池里只有5个线程, 而我们开启了8个线程, 这就会导致线程复用,
 * 在调用get()方法时发现当前线程的ThreadLocalMap里有值, 从而导致不会调用setInitialValue()方法)
 * @Author norris
 * @Date 2019/11/19 10:48
 **/
public class T3 {
	public static void main(String[] args) {
		final ThreadLocal<String> dataSourceTypes = new ThreadLocal<String>(){
			@Override
			protected String initialValue(){
				return "master";
			}
		};

		@SuppressWarnings("all")
		Executor executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 8; i++) {
			executor.execute(()-> {
				System.out.println(dataSourceTypes.get());
				dataSourceTypes.set("slave");
			});
		}
	}
}