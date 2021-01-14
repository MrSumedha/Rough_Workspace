package main;

import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }

    private static void reversePrint(SinglyLinkedListNode head) {
        SinglyLinkedListNode previous,current,next;
        previous = null;
        current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        date = DateUtils.setDays(date, 4);
        date = DateUtils.setMinutes(date, 10);
        System.out.println(date);

        Queue<Integer> queue = new LinkedList<>();
    }
}


