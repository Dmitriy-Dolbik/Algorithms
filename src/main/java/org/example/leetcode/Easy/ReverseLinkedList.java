package org.example.leetcode.Easy;

import org.example.leetcode.Task;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedList implements Task {

//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode current = head;
//        while (current != null ) {
//            ListNode temp = current.next;
//            current.next = prev;
//            prev = current;
//            current = temp;
//        }
//        return prev;
//    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/reverse-linked-list/description/";
    }

    @Override
    public void getMySolution() {
//        if (head == null) {
//            return head;
//        }
//        ListNode nextNode = head.next;
//        ListNode lastNode = null;
//        if (nextNode != null) {
//            lastNode = reverseList(nextNode);
//            nextNode.next = head;
//            head.next = null;
//            return lastNode;
//        }
//        return head;
    }

    @Override
    public void getOptimizeSolution() {
//        ListNode prev = null;
//        ListNode current = head;
//        while (current != null ) {
//            ListNode temp = current.next;
//            current.next = prev;
//            prev = current;
//            current = temp;
//        }
//        return prev;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)"; //т.к. мы не используем дополнительных структур данных
    }
}
