package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation implements Task {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        Set<String> operatorsSet = new HashSet<>();
        operatorsSet.add("+");
        operatorsSet.add("-");
        operatorsSet.add("*");
        operatorsSet.add("/");

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token, operatorsSet)) {
                stack.add(Integer.valueOf(token));
            } else {
                int secondNumber = stack.pop();
                int firstNumber = stack.pop();
                int result = calculate(firstNumber, token, secondNumber);
                stack.add(result);
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String token, Set<String> operatorsSet) {
        return !operatorsSet.contains(token);
    }

    private static int calculate(int firstNumber, String operator, int secondNumber) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Operation '" + operator + "' is not available");
        }
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/evaluate-reverse-polish-notation/description/";
    }

    @Override
    public void getMySolution() {
    }

    @Override
    public void getOptimizeSolution() {
//        public int evalRPN(String[] tokens) {
//            Set<String> operators = new HashSet<>();
//            operators.add("+");
//            operators.add("-");
//            operators.add("*");
//            operators.add("/");
//
//            Stack<Integer> stack = new Stack<>();
//
//            for (String token : tokens) {
//                if (operators.contains(token)) {
//                    int secondNumber = stack.pop();
//                    int firstNumber = stack.pop();
//                    int result = calculate(firstNumber, token, secondNumber);
//                    stack.add(result);
//                } else {
//                    stack.add(Integer.parseInt(token));
//                }
//            }
//
//            return stack.pop();
//        }
//
//        private int calculate (int firstNumber, String operator,int secondNumber) {
//            switch(operator) {
//                case "+":
//                    return firstNumber + secondNumber;
//                case "-":
//                    return firstNumber - secondNumber;
//                case "*":
//                    return firstNumber * secondNumber;
//                case "/":
//                    return firstNumber / secondNumber;
//                default:
//                    throw new IllegalArgumentException ("Operation '" + operator + "' is not available");
//            }
//        }
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
