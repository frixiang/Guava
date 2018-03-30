package com.xiang.lambda;

/**
 * Created by WIN7 on 2018/3/30.
 */
public class One {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("开始执行.....");
            }
        }).start();

        /**
         * 使用lambda后
         */
        new Thread(()-> System.out.println("开始执行...")).start();
    }

}
