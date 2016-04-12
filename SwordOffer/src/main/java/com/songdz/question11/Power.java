package com.songdz.question11;

import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;

/**
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * Created by SongDz on 2016/4/7.
 *
 * @author SongDz
 */
public class Power {

    public static double power(double base, int exponent) {

        double result = 1;
        if (exponent == 0) {
            return result;
        }

        if (Math.abs(base - 0.0) < 0.000001) {
            if (exponent > 0) {
                return 0;
            } else {
                throw new RuntimeException("0.0的负次数幂无意义");
            }
        }

        if (exponent > 0) {
            while (exponent > 0) {
                result *= base;
                exponent--;
            }
        } else {
            exponent = 0 - exponent;
            while (exponent > 0) {
                result /= base;
                exponent --;
            }
        }

        return result;
        //return Math.pow(base, exponent);
    }


    @Test
    public void testPower() {

        System.out.println(power(2.0, 0));
        System.out.println(power(2.0, 1));
        System.out.println(power(2.0, -1));
        System.out.println(power(-2.0, 0));
        System.out.println(power(-2.0, 1));
        System.out.println(power(-2.0, -1));
        System.out.println(Math.pow(0.0, 0));
        System.out.println(Math.pow(0.0, 1));
        System.out.println(Math.pow(0.0, -1));
        System.out.println(power(0.0, 0)); //equals 1.0
        System.out.println(power(0.0, 1)); //equals 0.0
        System.out.println(power(0.0, -1)); // Infinity
    }

}
