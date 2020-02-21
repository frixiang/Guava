package com.xiang.model;

import java.io.Serializable;

/**
 * @ClasssName Person
 * @Description TODO
 * @Author WIN7
 * @Date 2018/11/28 13:58
 **/
public class Person implements Serializable,Cloneable{
	public Integer no;
	private String name;
	private Integer age;
	public Person (Integer no, String name,Integer age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}
	public String getName() {
		//System.out.println(name);
		return name;
	}
	public String setName(String name){
		this.name = name;
		return name;
	}
	public Integer getAge(){
		return age;
	}
}