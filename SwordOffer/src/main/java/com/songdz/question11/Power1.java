package com.songdz.question11;

import org.junit.Test;
/**
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 思路：使用递归解决，为了提高递归效率，避免重复计算，对于exponent，可以分成exponent/2两部分来求。
 *
 * Created by SongDz on 2016/4/7.
 *
 * @author SongDz
 */
public class Power1 {

    public static double power(double base, int exponent) {

        double result = 1;
        if (exponent == 0) {
            return result;
        }

        if (equalsDouble(base, 0.0)) {
            if (exponent > 0) {
                return 0;
            } else {
                throw new RuntimeException("0.0的负次数幂无意义");
            }
        }

        if (exponent > 0) {
            result = powerWithUnsignedExponent(base, exponent);
        } else {
            result = 1.0 / powerWithUnsignedExponent(base, -exponent);
        }

        return result;
    }

    private static double powerWithUnsignedExponent(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

    private static boolean equalsDouble(double a, double b) {

        if ((a - b < 0.0000001) && (a - b > -0.0000001)) {
            return true;
        }
        return false;
    }

    @Test
    public void testPower() {

        System.out.println(power(2.0, 0));
        System.out.println(power(2.0, 1));
        System.out.println(power(2.0, -1));
        System.out.println(power(-2.0, 0));
        System.out.println(power(-2.0, 1));
        System.out.println(power(-2.0, -1));
        System.out.println(power(0.0, 0)); //equals 1.0
        System.out.println(power(0.0, 1)); //equals 0.0
        System.out.println(power(0.0, -1)); // Infinity
    }

}
