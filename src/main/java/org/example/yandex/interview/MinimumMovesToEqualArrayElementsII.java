package org.example.yandex.interview;

import org.example.leetcode.Task;

import java.util.Arrays;

/**
 * Задание:
 * Данн массив чисел. Нужно найти минимальное количество итераций уменьшения ли увеличения на 1, чтобы
 * сделать все элементы этого массива одинаковыми.
 *
 * Вввод: 1,2,3
 * Вывод: 2, т.к. 1 нужно увеличит на 1, а 3 нужно уменьшить на 1.
 * Всего 2 интерации
 *
 * Суть решения:
 * Отсортировать массив
 * Найти средний элемент
 * Посчитать все разницы между каждым элементом и средним
 */
public class MinimumMovesToEqualArrayElementsII implements Task {

    public static void main(String[] args) {
//        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(new int[]{1,2,3}));
//        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(new int[]{1,10,2,9}));
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(new int[]{1,0,0,8,6}));
//        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(new int[]{3,0,6,2,4,7,0,0}));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int averageNumber = nums[nums.length / 2];
        int countOfMinimumMoves = 0;
        for (int currentNumber : nums) {
            countOfMinimumMoves += Math.abs(currentNumber - averageNumber);
        }
        return countOfMinimumMoves;
    }

//    2
//    1 2 2 6 4 = 15
//    1
//    1 1 7 5 = 14

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/";
    }

    @Override
    public void getMySolution() {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//
//        int averageNumber = sum / nums.length;
//
//        int countOfMinimumMoves = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int differenceOfNumbers = Math.abs(nums[i] - averageNumber);
//            countOfMinimumMoves += differenceOfNumbers;
//        }
//
//        return countOfMinimumMoves;
        //не работает в каких-то кейсах
    }

    @Override
    public void getOptimizeSolution() {
//        Arrays.sort(nums);
//        int averageNumber = nums[nums.length / 2];
//        int countOfMinimumMoves = 0;
//        for (int currentNumber : nums) {
//            countOfMinimumMoves += Math.abs(currentNumber - averageNumber);
//        }
//        return countOfMinimumMoves;
    }

    @Override
    public String getTimeComplexity() {
        return "O(nlogn)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
