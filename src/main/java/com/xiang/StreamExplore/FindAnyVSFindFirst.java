package com.xiang.StreamExplore;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FindAnyVSFindFirst {
    /**
     * findAny非并行下返回的结果是一致的，返回第一个数据
     */
    @Test
    public void createStream_whenFindAnyResultIsPresent_thenCorrect() {
        List<String> list = Arrays.asList("A","B","C","D");

        Optional<String> result = list.stream().findAny();

        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
        System.out.println(result.get());
    }

    /**
     * findAny在并行下返回的结果是不确定的
     */
    @Test
    public void createParallelStream_whenFindAnyResultIsNotFirst_thenCorrect() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list
                .stream().parallel()
                .filter(num -> num < 4).findAny();

        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is(1), is(2), is(3)));
        System.out.println(result.get());
    }

    /**
     * findFirst返回结果始终是第一个
     */
    @Test
    public void createStream_whenFindFirstResultIsPresent_thenCorrect() {

        List<String> list = Arrays.asList("A", "B", "C", "D");

        Optional<String> result = list.stream().findFirst();

        assertTrue(result.isPresent());
        assertThat(result.get(), is("A"));
        System.out.println(result.get());
    }
}