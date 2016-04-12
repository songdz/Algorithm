package com.songdz.question12;

import org.junit.Test;

/**
 * 输入数字n,按顺序打印出从1最大的n位十进制数
 *
 * 思路：全排列， digits[0]为最高位。
 *
 * Created by SongDz on 2016/4/7.
 *
 * @author SongDz
 */
public class PrintToMaxOfNDigits {

    public void printToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        byte[] digits = new byte[n];
        sortDigits(digits, 0);
    }

    private void sortDigits(byte[] digits, int n) {

        for (byte i = 0; i < 10; i++) {
            if (n != digits.length) {
                digits[n] = i;
                sortDigits(digits, n+1);
            } else {
                printDigits(digits);
                return;
            }
        }
    }

    private void printDigits(byte[] digits) {
        boolean isFirstDigitNot0 = false;
        for (int j = 0; j < digits.length; j++) {
            if (digits[j] != 0) {
                System.out.print(digits[j]);
                isFirstDigitNot0 = true;
            } else {
                if (isFirstDigitNot0) {
                    System.out.print(digits[j]);
                }
            }
        }
       System.out.println();
    }

    @Test
    public void testPrintToMaxOfNDigits() {
        new PrintToMaxOfNDigits().printToMaxOfNDigits(2);
    }

}
