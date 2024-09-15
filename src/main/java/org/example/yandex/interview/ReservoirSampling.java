package org.example.yandex.interview;

import java.util.Arrays;
import java.util.Random;

/**
 * Суть: нужно из переданного массива рандомно выбрать n чисел
 * Сложность O(n)
 */
public class ReservoirSampling {

    static void selectKItems(int[] array, int countOfNumbersToSelect) {

        //создаем массив из первых countOfNumbersToSelect эелементов исходного массива
        int[] result = new int[countOfNumbersToSelect];

        int i;
        for (i = 0; i < countOfNumbersToSelect; i++) {
            result[i] = array[i];
        }

        Random random = new Random();

        for (; i < array.length; i++) {
            // находим рандомный индекс элемента, который будем менять
            // от 0 до i + 1
            int indexOfElementToChange = random.nextInt(i + 1);

            //если этот индекс валидный (т.е. меньше, чнм размер массива), то
            //то меняем число под этим индексом на число под индексом i
            if (indexOfElementToChange < countOfNumbersToSelect) {
                result[indexOfElementToChange] = array[i];
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int countOfNumbersToSelect = 2;
        selectKItems(array, countOfNumbersToSelect);
    }
}
