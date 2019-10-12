package com.xiang.listcopy;/**
 * Created by WIN7 on 2019/10/12.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.xiang.model.Person;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClasssName CopyOfList
 * @Description TODO
 * @Author norris
 * @Date 2019/10/12 11:28
 **/
public class CopyOfList {

	@Test
	public void Test() throws Exception{
		List<Person> personList = Lists.newArrayList();
		Person person = new Person(1,"A",1);
		Person person1 = new Person(2,"B",2);
		Person person2 = new Person(3,"C",3);
		Person person3 = new Person(4,"D",4);
		Person person4 = new Person(5,"E",5);
		personList.add(person);
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		System.out.println(personList);

		/*********************************************** for循环 ****************************************/
		//methodOfFor(personList);

		/********************************************* Stream流 ****************************************/
		//methodOfStream(personList);

		/********************************************** JSON方式 ***************************************/
		//methodOfJSON(personList);

		/********************************************* methodOfConstructor ****************************/
		//methodOfConstructor(personList);


		/******************************************** Serializable ************************************/
		//methodOfSerializable(personList);

		/******************************************** Cloneable接口 ***********************************/
	}

	/**浅复制**/
	private void methodOfFor(List<Person> personList){
		List<Person> personListB = Lists.newArrayList();
		personListB.addAll(personList);
		System.out.println(personListB);

		/****for循环copy元素后，前后的list集合是独立的，改变其中list长度不会对另一产生影响***/
		personList.remove(1);
		System.out.println(JSON.toJSONString(personList));
		System.out.println(JSON.toJSONString(personListB));

		/***for循环的copy元素是浅克隆，即多个list集合中的元素是共用的***/
		System.out.println(personList.get(0).equals(personListB.get(0)));
		personList.get(0).setName("A1");
		System.out.println(personListB.get(0).getName());
	}

	/****
	 * 同for（**浅复制**）
	 * @param personList
	 */
	private void methodOfStream(List<Person> personList){
		List<Person> personListB = personList.stream().collect(Collectors.toList());
		System.out.println(personListB);

		personList.remove(1);
		System.out.println(JSON.toJSONString(personList));
		System.out.println(JSON.toJSONString(personListB));

		System.out.println(personList.get(0).equals(personListB.get(0)));
		personList.get(0).setName("A1");
		System.out.println(JSON.toJSONString(personList));
		System.out.println(personListB.get(0).getName());

	}

	/****
	 * 构造方法复制（浅复制）
	 * @param personList
	 */
	private void methodOfConstructor(List<Person> personList){
		List<Person> personListB=new ArrayList<Person>(personList);
		System.out.println(personListB);

		personList.remove(1);
		System.out.println(JSON.toJSONString(personList));
		System.out.println(JSON.toJSONString(personListB));

		System.out.println(personList.get(0).equals(personListB.get(0)));
		personList.get(0).setName("A1");
		System.out.println(JSON.toJSONString(personList));
		System.out.println(personListB.get(0).getName());

	}

	/**深复制**/
	private void methodOfJSON(List<Person> personList){
		/***json转化后的集合元素与原集合不一致，非同一个引用**/
		List<Person> personListB = JSONArray.parseArray(JSON.toJSONString(personList),Person.class);
		System.out.println(personListB);

		personList.remove(1);
		System.out.println(JSON.toJSONString(personList));
		System.out.println(JSON.toJSONString(personListB));

		System.out.println(personList.get(0).equals(personListB.get(0)));
		personList.get(0).setName("A1");
		System.out.println(JSON.toJSONString(personList));
		System.out.println(personListB.get(0).getName());
	}

	/**深复制**/
	private void methodOfSerializable (List<Person> personList) throws Exception{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(personList);

		ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		ObjectInputStream in = new ObjectInputStream(inputStream);
		List<Person> personListB = (List<Person>) in.readObject();
		System.out.println(personListB);

		personList.remove(1);
		System.out.println(JSON.toJSONString(personList));
		System.out.println(JSON.toJSONString(personListB));

		System.out.println(personList.get(0).equals(personListB.get(0)));
		personList.get(0).setName("A1");
		System.out.println(JSON.toJSONString(personList));
		System.out.println(personListB.get(0).getName());
	}

}