package org.example.leetcode.Easy;

import org.example.leetcode.Task;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays implements Task {

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distance = 0;
        for (int numOfArr1 : arr1) {
            if (notInRange(arr2, numOfArr1 - d, numOfArr1 + d)) {
                distance++;
            }
        }
        return distance;
    }

    private static boolean notInRange(int[] arr2, int from, int to) {
        int start = 0;
        int end = arr2.length - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (arr2[mid] >= from && arr2[mid]<= to) {
                return false;
            } else if (arr2[mid] < from) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[]{1,4,2,3}, new int[]{-4,-3,6,10,20,30}, 3));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/find-the-distance-value-between-two-arrays/description/";
    }

    @Override
    public void getMySolution() {
        // TimeComplexity: "O(n * p)" т.к. есть вложенный цикл
        // SpaceComplexity: "O(1)" т.к. не используются дополнительные структуры данных
//        int distance = 0;
//        for (int numberOfArr1 : arr1) {
//            boolean absLessThenTwo = false;
//            for (int numberOfArray2 : arr2) {
//                if (Math.abs(numberOfArr1 - numberOfArray2) <= d) {
//                    absLessThenTwo = true;
//                    break;
//                }
//            }
//            if (!absLessThenTwo) {
//                distance++;
//            }
//        }
//        return distance;
    }

    @Override
    public void getOptimizeSolution() {
//        public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
//            Arrays.sort(arr2);
//            int distance = 0;
//            for (int numOfArr1 : arr1) {
//                if (notInRange(arr2, numOfArr1 - d, numOfArr1 + d)) {
//                    distance++;
//                }
//            }
//            return distance;
//        }
//
//        private static boolean notInRange(int[] arr2, int from, int to) {
//            int start = 0;
//            int end = arr2.length - 1;
//
//            while (start <= end) {
//                int mid = (end + start) / 2;
//                if (arr2[mid] >= from && arr2[mid]<= to) {
//                    return false;
//                } else if (arr2[mid] < from) {
//                    start = mid + 1;
//                } else {
//                    end = mid - 1;
//                }
//            }
//            return true;
//        }
    }

    @Override
    public String getTimeComplexity() {
        return "O((n + m) logm)"; //O(mlogm) для сортировки arr2, O(nlogm) для бинарного поиска для каждого элемента arr1
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)"; //т.к. не используются дополнительные структуры данных
    }
}
