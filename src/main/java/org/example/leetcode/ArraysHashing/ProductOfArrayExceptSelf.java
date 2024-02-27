package org.example.leetcode.ArraysHashing;

import org.example.leetcode.Task;

public class ProductOfArrayExceptSelf implements Task {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        //Идем слева на права и заполняем массив
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        //Идем справа налево и изменяем массив
        int rightPartProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rightPartProduct;
            rightPartProduct = rightPartProduct * nums[i];
        }

        return result;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/product-of-array-except-self/";
    }

    @Override
    public void getMySolution() {
        //I used division operator and it's not allowed
//        Set<Integer> indexesOfZero = new HashSet<>();
        //Находим произведение всех чисел, кроме 0
//        int productOfAllNumbers = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                productOfAllNumbers = productOfAllNumbers * nums[i];
//            } else {
//                indexesOfZero.add(i);
//            }
//        }

          //Заполняем результирующий массив
//        int[] result = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0 && indexesOfZero.isEmpty()) {
//                result[i] = productOfAllNumbers / nums[i];
//            } else if (nums[i] == 0 && indexesOfZero.size() == 1) {
//                result[i] = productOfAllNumbers;
//            } else {
//                result[i] = 0;
//            }
//        }
//        return result;
    }

    @Override
    public void getOptimizeSolution() {
//        int[] result = new int[nums.length];
//
//        //Идем слева на права и заполняем массив
//        result[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            result[i] = nums[i - 1] * result[i - 1];
//        }
//
//        //Идем справа налево и изменяем массив
//        int rightPartProduct = 1; (произведение чисел, при прохоже справа налево)
//        for (int i = nums.length - 1; i >= 0; i--) {
//            result[i] = result[i] * rightPartProduct;
//            rightPartProduct = rightPartProduct * nums[i];
//        }
//
//        return result;

        //Объяснение с суффиксом и префиксом:
        //Т.е. результрующие числа получаеются умножением чисел из префикса и постфикса
        // 60 = 2 * 30, а 48 = 8 * 6;
        //input:   [2,   4,   5,  6]
        //prefix:  [2,   8,   40, 240] //Произведение чисел, если мы идем слева на право
        //postfix: [240, 120, 30, 6]   //Произведение числе, если мы идем справа на лево
        //result:  [120, 60,  48, 40]

        //Мы можем обойтись без префикса и постфикса сразу записывая сначала произведения числел при проходе слава на право
        //А потом произведения справа на лево.
        //Т.е. после прохода слева направо: [1  , 2 , 8 , 40]
        //После прохода справа на лево:     [120, 60, 48, 40]
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
