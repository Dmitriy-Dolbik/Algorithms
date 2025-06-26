package org.example.leetcode.Easy;

import org.example.leetcode.Task;

public class PlusOne implements Task {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/plus-one/description/";
    }

    @Override
    public void getMySolution() {
//        if (digits.length == 0) {
//            return digits;
//        }
//        for (int i = 0; i < digits.length; i++) {
//            int indexOfLastRightElement = digits.length - i - 1;
//            if (digits[indexOfLastRightElement] + 1 <= 9) {
//                digits[indexOfLastRightElement] += 1;
//                return digits;
//            } else {
//                digits[indexOfLastRightElement] = 0;
//            }
//        }
//        int[] newIntArray = new int[digits.length + 1];
//        newIntArray[0] = 1;
//        digits = newIntArray;
//        return digits;
    }

    /**
     * Такое же решение, как и мое, но более короткое
     */
    @Override
    public void getOptimizeSolution() {
//        if (digits.length == 0) {
//            return digits;
//        }
//        for (int i = digits.length - 1; i >= 0 ; i--) {
//            if (digits[i] < 9) {
//                digits[i]++;
//                return digits;
//            }
//            digits[i] = 0;
//        }
//        digits = new int[digits.length + 1];
//        digits[0] = 1;
//        return digits;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n + 1) или O(n)"; //т.к. в худшем случае мы создаем новый массив
    }
}
