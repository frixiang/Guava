package com.xiang.model;

import com.google.common.collect.ComparisonChain;
import lombok.Data;

/**
 * Created by WIN7 on 2017/11/3.
 */
@Data
public class Computer implements Comparable<Computer>{
    private Integer id;

    private Integer type;

    private String name;

    /**
     * ComparisonChain执行一种懒比较：它执行比较操作直至发现非零的结果，在那之后的比较输入将被忽略
     * @param o
     * @return
     */
    public int compareTo(Computer o) {
        return ComparisonChain.start()
                .compare(this.id,o.getId())
                .compare(this.name,o.getName()).result();
    }
}
