package com.xiang.objectexplore;

import com.google.common.base.Objects;
import com.xiang.model.Computer;
import org.junit.Test;

/**
 * Created by WIN7 on 2017/11/3.
 * Objects工具
 */
public class ObjectTest {

    @Test
    public  void test(){
        /**
         * 使用Objects.equal方法判断对象是否为null,同样可以使用该方法判断两个对象是否相等，避免抛出NullPointerException异常
         */
        String str = null;
        System.out.println(Objects.equal(str,null));


        /**
         * Objects.hashCode方法会对传入的字段序列计算出合理的、顺序敏感的散列值
         */
        Computer computer = new Computer();
        computer.setName("lenovo");
        computer.setType(1);
        computer.setId(2);
        System.out.println(Objects.hashCode(computer));
        /**
         * 指定计算的field
         */
        System.out.println(Objects.hashCode(computer.getId(),computer.getName()));


        /**
         * toString
         */
        System.out.println(computer.toString());
        System.out.println(java.util.Objects.toString(computer));
        System.out.println(Objects.toStringHelper(computer));

    }
}
