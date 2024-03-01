package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements Task {

    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] array = createSmallestArray(n);
        result.add(String.valueOf(array));
        while (true) {
            int openedParenCount = 0;
            int closedParenCount = 0;

            int indexOfOpenedBracketToBeModified = 0;
            for (int i = 2 * n - 1; i >= 0; i--) {
                char currentBracket = array[i];
                if (currentBracket == ')') {
                    closedParenCount++;

                } else if (currentBracket == '(') {
                    openedParenCount++;
                }

                if (closedParenCount > openedParenCount && currentBracket == '(') {
                    indexOfOpenedBracketToBeModified = i;
                    break;
                }
            }
            if (indexOfOpenedBracketToBeModified == 0) {
                break;
            }
            array[indexOfOpenedBracketToBeModified] = ')';

            for (int i = indexOfOpenedBracketToBeModified + 1; i < 2 * n; i++) {
                if (openedParenCount > 0) {
                    array[i] = '(';
                    openedParenCount--;
                } else {
                    array[i] = ')';
                }
            }
            result.add(String.valueOf(array));
        }
        return result;
    }

    private static char[] createSmallestArray(int n) {
        char[] array = new char[2 * n];

        for (int i = 0; i < n * 2; i++) {
            if (i < n) {
                array[i] = '(';
            } else {
                array[i] = ')';
            }
        }
        return array;
    }


    @Override
    public String getLink() {
        return "https://leetcode.com/problems/generate-parentheses/description/";
    }

    @Override
    public void getMySolution() {
        //Смотри объяснение в BracketsGenerator YandexContest
//        List<String> result = new ArrayList<>();
//        char[] array = createSmallestArray(n);
//        result.add(String.valueOf(array));
//        while (true) {
//            int openedParenCount = 0;
//            int closedParenCount = 0;
//
//            int indexOfOpenedBracketToBeModified = 0;
//            for (int i = 2 * n - 1; i >= 0; i--) {
//                char currentBracket = array[i];
//                if (currentBracket == ')') {
//                    closedParenCount++;
//
//                } else if (currentBracket == '(') {
//                    openedParenCount++;
//                }
//
//                if (closedParenCount > openedParenCount && currentBracket == '(') {
//                    indexOfOpenedBracketToBeModified = i;
//                    break;
//                }
//            }
//            if (indexOfOpenedBracketToBeModified == 0) {
//                break;
//            }
//            array[indexOfOpenedBracketToBeModified] = ')';
//
//            for (int i = indexOfOpenedBracketToBeModified + 1; i < 2 * n; i++) {
//                if (openedParenCount > 0) {
//                    array[i] = '(';
//                    openedParenCount--;
//                } else {
//                    array[i] = ')';
//                }
//            }
//            result.add(String.valueOf(array));
//        }
//        return result;
    }

    @Override
    public void getOptimizeSolution() {

    }

    @Override
    public String getTimeComplexity() {
        return null;
    }

    @Override
    public String getSpaceComplexity() {
        return null;
    }
}
