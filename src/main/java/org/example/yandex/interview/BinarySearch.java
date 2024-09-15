package org.example.yandex.interview;

/**
 * Написать бинарный поиск отсортированного массива
 */
public class BinarySearch {

    public static final int ELEMENT_COUNT = 100;

    public static void main(String[] args) {
        int[] sortedArray = new int[ELEMENT_COUNT];
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            sortedArray[i] = i;
        }
        int indexOfElement = getIndexOfElement(sortedArray, 20);
        System.out.println(indexOfElement);
    }

    /**
     * Главная идея:
     * Определяем индекс самого левого и самого правого элемента.
     * Берем средний элемент и сравниваем его с искомым числом.
     * Если они равны возвращаем индекс этого элемента.
     * Если искомое число больше среднего, то смещаем левую границу на середину + 1
     * Если искомое число меньше среднего, смещаем правую границу на середину - 1
     */
    private static int getIndexOfElement(int[] sortedArray, int numberToFind) {

        int indexOfLeftmostElement = 0;
        int indexOfRightmostElement = sortedArray.length - 1;

        while (indexOfLeftmostElement != indexOfRightmostElement) {

            int indexOfMiddleElement = (indexOfRightmostElement + indexOfLeftmostElement) / 2;
            int middleElement = sortedArray[indexOfMiddleElement];

            if (numberToFind == middleElement) {
                return indexOfMiddleElement;
            }

            if (numberToFind > middleElement) {
                indexOfLeftmostElement = indexOfMiddleElement + 1;
            }

            if (numberToFind < middleElement) {
                indexOfRightmostElement = indexOfMiddleElement - 1;
            }
        }

        return -1;
    }
}
