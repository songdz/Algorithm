package com.songdz.question04;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路： 使用java正则表达式
 *
 * Created by SongDz on 2016/3/18.
 *
 * @author SongDz
 */
public class ReplaceBlankRegex {

    public String replaceBlank(String s) {

        if (s != null) {
            return s.replaceAll(" ", "%20");
        } else {
            return null;
        }
    }

    public String replaceBlankRegex(String s) {

        if (s != null) {
            Pattern pattern = Pattern.compile(" ");
            Matcher matcher = pattern.matcher(s);
            return matcher.replaceAll("%20");
        } else {
            return null;
        }
    }

    @Test
    public void testReplaceBlank() {
        System.out.println(replaceBlank("We  Are Happy."));
        System.out.println(replaceBlankRegex("We Are Happy."));
    }

}
