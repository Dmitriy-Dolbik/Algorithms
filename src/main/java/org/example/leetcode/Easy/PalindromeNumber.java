package org.example.leetcode.Easy;

import org.example.leetcode.Task;

public class PalindromeNumber implements Task {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverseNum = 0;
        int num = x;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num = num / 10;
        }
        return reverseNum == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/palindrome-number/?difficulty=EASY&page=1";
    }

    @Override
    public void getMySolution() {
//        char[] numbers = String.valueOf(x).toCharArray();
//        for (int i = 0; i < numbers.length/2; i++) {
//            if (numbers[i] != numbers[numbers.length - 1 - i]) {
//                return false;
//            }
//        }
//        return true;
    }

    @Override
    public void getOptimizeSolution() {
//        if (x < 0) {
//            return false;
//        }
//        int reverseNum = 0;
//        int num = x;
//        while (num > 0) {
//            reverseNum = reverseNum * 10 + num % 10;
//            num = num / 10;
//        }
//        return reverseNum == x;
    }

    @Override
    public String getTimeComplexity() {
        return "O(logn)"; //т.к. количество цифр числа увеличивается логарифмически. Для 0 - 9 - это 1
    }                     //для 10 - 99 - 2, для 100 - 999 - 3, для 1001 - 9999 - 4 и тд.
    @Override
    public String getSpaceComplexity() {
        return "O(1)"; //Т.к. мы не используем дополнительные структуры данных. Только несколько переменных.
    }
}
