package org.example.yandex.interview;

import org.example.leetcode.Task;

/**
 * Задача:
 * Дана последовательность неотрицательных чисел, нужно переставить нули в цонец с сохранением порядка остальных чисел
 * <p>
 * Ввод:  0, 1, 0, 2, 0, 3
 * ВЫвод: 1, 2, 3, 0, 0, 0
 *
 * Суть решения:
 * Запоминаем индект нуля
 * Если не нулевой элемент, то текущий жлемент делаем равным нулю
 * нудевой элемент делаем равным текущему.
 */
public class ZeroToEnd implements Task {

    public void moveZeroes(int[] nums) {
        int indexOfZero = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber != 0) {
                nums[i] = nums[indexOfZero];
                nums[indexOfZero] = currentNumber;
                indexOfZero++;
            }
        }
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/move-zeroes/description/";
    }

    @Override
    public void getMySolution() {
//        LinkedList<Integer> indexesOfZeros = new LinkedList<>();
//
//        for (int i = 0; i < initArray.length; i++) {
//            int currentNumber = initArray[i];
//
//            if (currentNumber == 0) {
//                indexesOfZeros.add(i);
//            } else if (!indexesOfZeros.isEmpty()) {
//                initArray[indexesOfZeros.removeFirst()] = currentNumber;
//                initArray[i] = 0;
//                i--;
//            }
//        }
    }

    @Override
    public void getOptimizeSolution() {
//        int indexOfZero = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                int currentNumber = nums[i];
//                nums[i] = nums[indexOfZero];
//                nums[indexOfZero] = currentNumber;
//                indexOfZero++;
//            }
//        }
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
