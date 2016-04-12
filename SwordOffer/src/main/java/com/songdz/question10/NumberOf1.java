package com.songdz.question10;

import org.junit.Test;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路：位运算左移补0，右移正数补0，负数补1
 * (n - 1) & n使得n最右的一个 1 变为 0
 *
 * Created by SongDz on 2016/4/6.
 *
 * @author SongDz
 */
public class NumberOf1 {


    public static int numberOf1(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }

    @Test
    public void testNumberOf1() {

        System.out.println(numberOf1(1));
    }


}
