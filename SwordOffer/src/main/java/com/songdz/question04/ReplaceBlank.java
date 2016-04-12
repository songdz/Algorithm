package com.songdz.question04;

import org.junit.Test;

/**
 *
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路：先遍历一遍数组，得到数组长度和空格个数，计算得到新数组长度；
 *  两个指针指向新旧数组的最后一个元素，从后往前遍历数组，碰到空格即替换。
 *
 * Created by SongDz on 2016/3/18.
 *
 * @author SongDz
 */
public class ReplaceBlank {



    public String replaceBlank(String s) {

        if (s == null || s.length() <= 0)
            return null;

        char[] source = s.toCharArray();
        int source_length = source.length;

        int blankNum = 0;
        for (int i = 0; i < source_length; i++) {
            if (source[i] == ' ') {
                blankNum++;
            }
        }

        int dest_length = source_length + blankNum * 2;
        char[] dest = new char[dest_length];
        System.arraycopy(source, 0, dest, 0, source_length);
        System.out.println("before convert : " + new String(dest));
        for (int i = blankNum, j = source_length - 1, k = dest_length - 1 ; i > 0; j--, k--) {
            if (dest[j] == ' ') {
                dest[k--] = '0';
                dest[k--] = '2';
                dest[k] = '%';
                i--;
            } else {
                dest[k] = dest[j];
            }
        }
        String destination = new String(dest);
        System.out.println("after convert : " + destination);

        return destination;
    }

    @Test
    public void testReplaceBlank() {
        replaceBlank("We Are Happy.");
        replaceBlank("We  Are Happy.");
    }

}
