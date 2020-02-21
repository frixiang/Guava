package com.xiang.util;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * @EnumName ComputerTypeEnum
 * @Description TODO
 * @Author WIN7
 * @Date 2018/11/27 15:05
 **/
public enum ComputerTypeEnum {
	LENOVO(0,"Lenovo"),
	DELL(1,"DELL"),
	HP(2,"HP");

	@Getter
	private Integer type;

	@Getter
	private String desc;

	ComputerTypeEnum(Integer type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public static ComputerTypeEnum format(Integer type){
		if(type == null || type < 0){
			return null;
		}
		return Stream.of(ComputerTypeEnum.values()).filter(computerTypeEnum -> computerTypeEnum.type == type.intValue()).findFirst().get();
	}
}