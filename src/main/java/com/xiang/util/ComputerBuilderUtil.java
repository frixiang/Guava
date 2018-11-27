package com.xiang.util;

import com.xiang.model.Computer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClasssName ComputerBuilderUtil
 * @Description model初始化创建工具类
 * @Author norris
 * @Date 2018/11/27 14:54
 **/
public class ComputerBuilderUtil {
	public static Computer getInstance(){
		Computer computer = new Computer();
		computer.setId(100);
		computer.setName("KNOW");
		computer.setType(ComputerTypeEnum.LENOVO.getType());
		return computer;
	}


	public static List<Computer> getInstanceList(){
		List<Computer> list = new ArrayList<>();
		Computer computer = new Computer();
		computer.setId(100);
		computer.setName("A");
		computer.setType(ComputerTypeEnum.LENOVO.getType());
		list.add(computer);

		computer = new Computer();
		computer.setId(101);
		computer.setName("C");
		computer.setType(ComputerTypeEnum.HP.getType());
		list.add(computer);

		computer = new Computer();
		computer.setId(102);
		computer.setName("B");
		computer.setType(ComputerTypeEnum.DELL.getType());
		list.add(computer);
		return list;
	}
}