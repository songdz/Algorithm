package com.songdz.question05;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 输入一个链表，从尾到头打印链表每个节点的值
 *
 * 思路：使用栈先进后出的方式
 *
 * Created by SongDz on 2016/3/18.
 *
 * @author SongDz
 */
public class PrintListReversely {

    private class LinkNode<T> {

        T data;
        LinkNode<T> next;
    }

    public void printListReversely(LinkedList<String> linkedList) {

        if (linkedList == null)
            return;

        Stack<String> stack = new Stack<String>();
        for (String s : linkedList) {
            stack.push(s);
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    public void printListReversely1(LinkNode<String> head) {

        if (head == null)
            return;

        Stack<String> stack = new Stack<String>();
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }

    @Test
    public void testPrintListReversely() {

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("ab");
        linkedList.add("cd");
        linkedList.add("ef");
        printListReversely(linkedList);

        LinkNode<String> head = new LinkNode<String>();
        head.data = "aa";
        LinkNode<String> node1 = new LinkNode<String>();
        node1.data = "bb";
        LinkNode<String> node2 = new LinkNode<String>();
        node2.data = "cc";

        /*LinkNode<Integer> node3 = new LinkNode<Integer>();
        node3.data = 1024;*/

        head.next = node1;
        node1.next = node2;
        //node2.next =  node3; 不匹配的类型
        node2.next = null;

        printListReversely1(head);

        /*Collections.reverse(linkedList);
        System.out.println(linkedList.getFirst());*/

    }

}
