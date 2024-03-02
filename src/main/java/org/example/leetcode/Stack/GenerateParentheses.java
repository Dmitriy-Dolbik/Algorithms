package org.example.leetcode.Stack;

import org.example.leetcode.Task;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements Task {
    private static List<String> result;
    private static int countOfPairs;

    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        countOfPairs = n;
        backTrack("", 0, 0);
        return result;
    }

    private static void backTrack(String parenthesesLine, int openedParenthesesCount, int closedParenthesesCount) {
        if (openedParenthesesCount == countOfPairs && closedParenthesesCount == countOfPairs) {
            result.add(parenthesesLine);
        }

        if (openedParenthesesCount < countOfPairs) {
            backTrack(parenthesesLine + "(", openedParenthesesCount + 1, closedParenthesesCount);
        }

        if (closedParenthesesCount < openedParenthesesCount) {
            backTrack(parenthesesLine + ")", openedParenthesesCount, closedParenthesesCount + 1);
        }
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/generate-parentheses/description/";
    }

    @Override
    public void getMySolution() {
        //Смотри объяснение в BracketsGenerator YandexContest
//        public static List<String> generateParenthesis(int n) {
//            List<String> result = new ArrayList<>();
//            char[] array = createSmallestArray(n);
//            result.add(String.valueOf(array));
//            while (true) {
//                int openedParenCount = 0;
//                int closedParenCount = 0;
//
//                int indexOfOpenedBracketToBeModified = 0;
//                for (int i = 2 * n - 1; i >= 0; i--) {
//                    char currentBracket = array[i];
//                    if (currentBracket == ')') {
//                        closedParenCount++;
//
//                    } else if (currentBracket == '(') {
//                        openedParenCount++;
//                    }
//
//                    if (closedParenCount > openedParenCount && currentBracket == '(') {
//                        indexOfOpenedBracketToBeModified = i;
//                        break;
//                    }
//                }
//                if (indexOfOpenedBracketToBeModified == 0) {
//                    break;
//                }
//                array[indexOfOpenedBracketToBeModified] = ')';
//
//                for (int i = indexOfOpenedBracketToBeModified + 1; i < 2 * n; i++) {
//                    if (openedParenCount > 0) {
//                        array[i] = '(';
//                        openedParenCount--;
//                    } else {
//                        array[i] = ')';
//                    }
//                }
//                result.add(String.valueOf(array));
//            }
//            return result;
//        }
//
//        private static char[] createSmallestArray(int n) {
//            char[] array = new char[2 * n];
//
//            for (int i = 0; i < n * 2; i++) {
//                if (i < n) {
//                    array[i] = '(';
//                } else {
//                    array[i] = ')';
//                }
//            }
//            return array;
//        }
    }

    @Override
    public void getOptimizeSolution() {
        //Решение через рекурсию быстрее в написании. Сложность схожа.
//        public static List<String> generateParenthesis(int n) {
//            result = new ArrayList<>();
//            countOfPairs = n;
//            backTrack("", 0, 0);
//            return result;
//        }
//
//        private static void backTrack(String parenthesesLine, int openedParenthesesCount, int closedParenthesesCount) {
//            if (openedParenthesesCount == countOfPairs && closedParenthesesCount == countOfPairs) {
//                result.add(parenthesesLine);
//            }
//
//            if (openedParenthesesCount < countOfPairs) {
//                backTrack(parenthesesLine + "(", openedParenthesesCount + 1, closedParenthesesCount);
//            }
//
//            if (closedParenthesesCount < openedParenthesesCount) {
//                backTrack(parenthesesLine + ")", openedParenthesesCount, closedParenthesesCount + 1);
//            }
//        }

        //Или то же самое через стринг билдер
        //Перед новым циклом рекурсии нужно добавить скобку, а после возврата на прежний цикл убрать, чтобы вернуть исходное состояние прохода.
//        private void fillParenthesisLines(StringBuilder stringBuilder, int openedBracketsCount, int closedBracketsCount) {
//            if (openedBracketsCount + closedBracketsCount == bracketsCount) {
//                result.add(stringBuilder.toString());
//            }
//
//            if (openedBracketsCount < bracketsCount / 2) {
//                stringBuilder.append("(");
//                fillParenthesisLines(stringBuilder, openedBracketsCount + 1, closedBracketsCount);
//                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//            }
//
//            if (closedBracketsCount < openedBracketsCount) {
//                stringBuilder.append(")");
//                fillParenthesisLines(stringBuilder, openedBracketsCount, closedBracketsCount + 1);
//                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//            }
//        }
    }

    @Override
    public String getTimeComplexity() {
        return "O(2^n)";//потому что на каждой шаге мы имеем два рекурсивных выозова
    }

    @Override
    public String getSpaceComplexity() {
        return "O(2^n)";
    }
}
