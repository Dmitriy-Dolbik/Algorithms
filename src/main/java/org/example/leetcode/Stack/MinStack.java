package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinStack implements Task {
    private final List<Integer> numberList = new ArrayList<>();
    private final List<Integer> minNumbersList = new ArrayList<>();


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin(); // return -3
//        minStack.pop();
//        minStack.top();    // return 0
//        minStack.getMin(); // return -2
        minStack.push(-1);
        minStack.top();
        minStack.getMin();
    }

    private LinkedList<Integer> valuesList = new LinkedList<>();
    private LinkedList<Integer> minValuesList = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        valuesList.add(val);
        updateMinValue(val);
    }

    private int updateMinValue(int val) {
        int minValue = minValuesList.isEmpty() ? val : Math.min(val, minValuesList.getLast());
        minValuesList.add(minValue);
        return minValue;
    }

    public void pop() {
        valuesList.removeLast();
        minValuesList.removeLast();
    }

    public int top() {
        return valuesList.getLast();
    }

    public int getMin() {
        return minValuesList.getLast();
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/min-stack/description/";
    }

    @Override
    public void getMySolution() {
    }

    @Override
    public void getOptimizeSolution() {
//        private LinkedList<Integer> valuesList = new LinkedList<>();
//        private LinkedList<Integer> minValuesList = new LinkedList<>();
//
//        public MinStack() {
//
//        }
//
//        public void push(int val) {
//            valuesList.add(val);
//            updateMinValue(val);
//        }
//
//        private int updateMinValue(int val) {
//            int minValue = minValuesList.isEmpty() ? val : Math.min(val, minValuesList.getLast());
//            minValuesList.add(minValue);
//            return minValue;
//        }
//
//        public void pop() {
//            valuesList.removeLast();
//            minValuesList.removeLast();
//        }
//
//        public int top() {
//            return valuesList.getLast();
//        }
//
//        public int getMin() {
//            return minValuesList.getLast();
//        }
    }

    @Override
    public String getTimeComplexity() {
        return "O(1)";//each operation of MinStack
    }

    @Override
    public String getSpaceComplexity() {
        return "";
    }
}
