package com.songdz.question09;

import org.junit.Test;

/**
 * 斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *
 * 思路：记录上一次计算的结果，避免重复计算。
 * O(n)
 *
 * Created by SongDz on 2016/4/6.
 *
 * @author SongDz
 */
public class Fibonacci {

    public static int fibonacci(int n) {

        if (n < 0) {
            throw new RuntimeException("n is invalid");
        }
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int pre = 1;
        int next = 1;
        int result = 0;
        for (int i = 2; i < n ; i++) {
            result = pre + next;
            pre = next;
            next = result;
        }

        return result;
    }

    @Test
    public void testFibonacci() {
        System.out.println(fibonacci(8));
    }

}
