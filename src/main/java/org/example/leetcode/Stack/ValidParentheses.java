package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses implements Task {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closedAndOpenedBrackets = new HashMap<>();
        closedAndOpenedBrackets.put(')', '(');
        closedAndOpenedBrackets.put(']', '[');
        closedAndOpenedBrackets.put('}', '{');

        char[] charArray = s.toCharArray();
        for (char character : charArray) {
            //Если открывающая скобка, то кладем её в стек
            if (isOpenedBracket(character, closedAndOpenedBrackets)) {
                stack.add(character);
            } else {
                //Если это закрывающая скобка, то в стеке должна лежать открывающая
                if (stack.empty()) {
                    return false;
                }
                //Если закрывающая скобка, то достаем открывающую скобку из стека
                int openParentheses = stack.pop();
                //Закрывающая скобка должна идти после открывающей того же типа
                char matchedOpenedBracket = closedAndOpenedBrackets.get(character);
                if (openParentheses != matchedOpenedBracket) {
                    return false;
                }
            }
        }
        //Если в стеке что-то осталось, то открывающих скобок больше, чем закрывающих
        return stack.empty();
    }

    private static boolean isOpenedBracket(char character, Map<Character, Character> closedAndOpenedBrackets) {
        return !closedAndOpenedBrackets.containsKey(character);
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-parentheses/";
    }

    @Override
    public void getMySolution() {
//        Stack<Character> stack = new Stack<>();
//        char[] charArray = s.toCharArray();
//        for (char character : charArray) {
//            //Если открывающая скобка, то кладем её в стек
//            if (character == '(' || character == '[' || character == '{') {
//                stack.add(character);
//            } else {
//                //Если это закрывающая скобка, то в стеке должна лежать открывающая
//                if (stack.empty()) {
//                    return false;
//                }
//                //Если закрывающая скобка, то достаем открывающую скобку из стека
//                int openParentheses = stack.pop();
//                //Закрывающая скобка должна идти после открывающей того же типа
//                if (openParentheses == '(' && character != ')'
//                        ||
//                        openParentheses == '[' && character != ']'
//                        ||
//                        openParentheses == '{' && character != '}') {
//                    return false;
//                }
//            }
//        }
//        //Если в стеке что-то осталось, то открывающих скобок больше, чем закрывающих
//        if (!stack.empty()) {
//            return false;
//        }
//        return true;
    }

    @Override
    public void getOptimizeSolution() {
        //Решение такое же, как мое, только через Map
//        Stack<Character> stack = new Stack<>();
//        Map<Character, Character> closedAndOpenedBrackets = new HashMap<>();
//        closedAndOpenedBrackets.put(')', '(');
//        closedAndOpenedBrackets.put(']', '[');
//        closedAndOpenedBrackets.put('}', '{');
//
//        char[] charArray = s.toCharArray();
//        for (char character : charArray) {
//            //Если открывающая скобка, то кладем её в стек
//            if (isOpenedBracket(character, closedAndOpenedBrackets)) {
//                stack.add(character);
//            } else {
//                //Если это закрывающая скобка, то в стеке должна лежать открывающая
//                if (stack.empty()) {
//                    return false;
//                }
//                //Если закрывающая скобка, то достаем открывающую скобку из стека
//                int openParentheses = stack.pop();
//                //Закрывающая скобка должна идти после открывающей того же типа
//                char matchedOpenedBracket = closedAndOpenedBrackets.get(character);
//                if (openParentheses != matchedOpenedBracket) {
//                    return false;
//                }
//            }
//        }
//        //Если в стеке что-то осталось, то открывающих скобок больше, чем закрывающих
//        if (!stack.empty()) {
//            return false;
//        }
//        return true;
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

