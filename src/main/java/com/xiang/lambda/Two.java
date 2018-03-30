package com.xiang.lambda;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by WIN7 on 2018/3/30.
 * @since JDK8之方法引用
 */
public class Two {
    public static void main(String[] args) {
        /**
         * lambda遍历集合
         */
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
        list.forEach((i) -> {
            System.out.println(i);
        });

        list.forEach(System.out::println);

    }
}
