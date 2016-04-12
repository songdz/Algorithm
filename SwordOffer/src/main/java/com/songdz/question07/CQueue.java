package com.songdz.question07;

import org.junit.Test;

import java.util.Stack;

/**
 *
 * 用两个栈实现一个队列，完成两个函数appendTail和deletedHead，
 * 分别是在队列尾部插入节点和在队列头部删除节点的功能.
 *
 * 思路：栈A用来插入节点，栈B用来删除节点，
 * 栈A直接入栈push，删除节点则从栈B直接弹出pop，若栈B无元素，则栈A节点出栈pop，插入栈B push，
 *
 *   栈A          栈B
 * |  4   |     |   1   |
 * |  3   |     |   2   |
 * |  2   |     |   3   |
 * |  1   | 底  |   4   |
 *
 *
 * Created by SongDz on 2016/3/22.
 *
 * @author SongDz
 */
public class CQueue<T> {

    private Stack<T> stackIn;
    private Stack<T> stackOut;

    public CQueue() {
        stackIn = new Stack<T>();
        stackOut = new Stack<T>();
    }

    public CQueue<T> appendTail(T element) {

        stackIn.push(element);

        return this;
    }

    public T deleteHead() {

        if (stackOut.empty()) {
            if (stackIn.empty()) {
                throw new RuntimeException("无数据！");
            } else {
                while (!stackIn.empty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }

        return stackOut.pop();
    }


    @Test
    public void testCQueu() {
        CQueue<String> stringCQueue = new CQueue<String>();
        stringCQueue.appendTail("1");
        stringCQueue.appendTail("2");
        stringCQueue.appendTail("3");

        System.out.println(stringCQueue.deleteHead());
        System.out.println(stringCQueue.deleteHead());
        System.out.println(stringCQueue.deleteHead());
        System.out.println(stringCQueue.deleteHead());
    }

}
