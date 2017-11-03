package com.xiang.stringutil;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by WIN7 on 2017/11/3.
 * 字符串的处理
 */
public class StringTest {

    @Test
    public void test(){
        /**
         * Joiner  kipNulls()方法是直接忽略null
         */
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));

        /**
         *useForNull 会将null替换成指定的内容
         */
        String str = Joiner.on("; ").useForNull("Norris").join("Harry", null, "Ron", "Hermione");
        System.out.println(str);


        /**
         * 拆分器[Splitter]
         JDK内建的字符串拆分工具有一些古怪的特性。比如，String.split悄悄丢弃了尾部的分隔符。 问题：”,a,,b,”.split(“,”)返回？
         ””, “a”, “”, “b”。只有尾部的空字符串被忽略了。

         方法	                                               描述	                            范例
         Splitter.on(char)	                                按单个字符拆分	                    Splitter.on(‘;’)
         Splitter.on(CharMatcher)	                        按字符匹配器拆分	                Splitter.on(CharMatcher.BREAKING_WHITESPACE)
         Splitter.on(String)	                            按字符串拆分	                    Splitter.on(“,   “)
         Splitter.on(Pattern)、Splitter.onPattern(String)	按正则表达式拆分	                Splitter.onPattern(“\r?\n”)
         Splitter.fixedLength(int)	                        按固定长度拆分；最后一段可能比给定长度短，但不会为空。	Splitter.fixedLength(3)

         方法	                描述
         omitEmptyStrings()	从结果中自动忽略空字符串
         trimResults()	    移除结果字符串的前导空白和尾部空白
         trimResults(CharMatcher)	给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
         limit(int)	限制拆分出的字符串数量
         */

        Iterable<String> iterable = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");
        Iterator<String> iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
