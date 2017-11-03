package com.xiang.charmatcher;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import org.junit.Test;

/**
 * Created by WIN7 on 2017/11/3.
 * <p>
 * collapseFrom(CharSequence, char)	把每组连续的匹配字符替换为特定字符。如WHITESPACE.collapseFrom(string, ‘ ‘)把字符串中的连续空白字符替换为单个空格。
 * matchesAllOf(CharSequence)测试是否字符序列中的所有字符都匹配。
 * removeFrom(CharSequence)	从字符序列中移除所有匹配字符。
 * retainFrom(CharSequence)	在字符序列中保留匹配字符，移除其他字符。
 * trimFrom(CharSequence)	移除字符序列的前导匹配字符和尾部匹配字符。
 * replaceFrom(CharSequence,   CharSequence)	用特定字符序列替代匹配字符。
 */
public class CharMatcherTest {

    @Test
    public void test() {

        String string = " SIajnkdnsfSSSv8979  42snfd23455 ";
        /**
         * 移除control字符
         */
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string);
        System.out.println(noControl);

        /**
         * 只保留数字字符
         */
        String theDigits = CharMatcher.DIGIT.retainFrom(string);
        System.out.println(theDigits);

        /**
         * 去除两端的空格，并把中间的连续空格替换成单个空格
         */
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');
        System.out.println(spaced);

        /**
         * 用*号替换所有数字
         */
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*");
        System.out.println(noDigits);

        /**
         * 只保留数字和小写字母
         */
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);
        System.out.println(lowerAndDigit);

    }
    /**
     * 字符集Charsets
     */
    @Test
    public void charsetsTest(){
        String s = "哈哈";

        byte [] bytes = s.getBytes(Charsets.UTF_8);

        System.out.println(bytes.length);
    }

    /**
     * 大小写格式[CaseFormat]
     CaseFormat被用来方便地在各种ASCII大小写规范间转换字符串——比如，编程语言的命名规范。CaseFormat支持的格式如下：

     格式	范例
     LOWER_CAMEL	lowerCamel
     LOWER_HYPHEN	lower-hyphen
     LOWER_UNDERSCORE	lower_underscore
     UPPER_CAMEL	UpperCamel
     UPPER_UNDERSCORE	UPPER_UNDERSCORE
     CaseFormat的用法很直接：

     1
     CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME")); // returns "constantName"
     我们CaseFormat在某些时候尤其有用，比如编写代码生成器的时候。
     */
    @Test
    public void caseFormatTest(){
        String str = "abc";
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE,str));
    }
}
