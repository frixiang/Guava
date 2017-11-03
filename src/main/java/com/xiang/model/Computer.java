package com.xiang.model;

import com.google.common.collect.ComparisonChain;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by WIN7 on 2017/11/3.
 */
@Getter
@Setter
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

    public Computer(Integer id, String name, Integer type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Computer() {
    }

    @Override
    public boolean equals(Object o) {
        Computer computer = (Computer) o;
        return computer.getId() == this.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
