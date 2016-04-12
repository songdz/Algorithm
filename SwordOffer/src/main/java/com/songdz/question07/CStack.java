package com.songdz.question07;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 用两个队列实现一个栈，完成两个函数append和delete，
 * 完成栈的push和pop方法。
 *
 * 思路：定义两个队列，其中一个队列B无操作时一直为空，入栈则添加元素到另一队列A的队尾，
 * 出栈则将非空队列A的元素依次弹出插入空队列B中，直至A队列剩一个元素，此元素弹出操作即为栈的出栈，
 * 此时队列A为空，交换引用，使queueIn一直指向入栈操作队列。
 *
 * Created by SongDz on 2016/4/5.
 *
 * @author SongDz
 */
public class CStack<T> {

    private Queue<T> tempQueue;

    private Queue<T> queueIn;
    private Queue<T> queueOut;

    public CStack() {
        queueIn = new LinkedBlockingQueue<T>();
        queueOut = new LinkedBlockingQueue<T>();
    }

    public void append(T element) {
        queueIn.add(element);
    }

    public T delete() {
        while (queueIn.size() -1 > 0) {
            queueOut.add(queueIn.remove());
        }
        tempQueue = queueIn;
        queueIn = queueOut;
        queueOut = tempQueue;

        return queueOut.remove();
    }

    @Test
    public void testCStack() {

        CStack<String> stringCStack = new CStack<String>();
        stringCStack.append("1");
        stringCStack.append("2");
        System.out.println(stringCStack.delete());
        stringCStack.append("3");
        System.out.println(stringCStack.delete());
        stringCStack.append("4");
        System.out.println(stringCStack.delete());
        System.out.println(stringCStack.delete());
    }

}
