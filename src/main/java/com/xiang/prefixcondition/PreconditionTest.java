package com.xiang.prefixcondition;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * Created by WIN7 on 2017/11/3.
 * 前置条件
 */
public class PreconditionTest {

    @Test
    public void test(){
        /**
         * 检查参数是否为null,检查失败则抛出NullPointerException异常
         */
        String str = null;
        str = Preconditions.checkNotNull(str,"不能为空");

        /**
         * 检查参数是否大于0，不满足，则抛出异常
         */
        int i = -1;
        Preconditions.checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);

    }
}
