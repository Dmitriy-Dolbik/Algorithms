package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements implements Task {

    public static void main(String[] args) {
        Arrays.stream(topKFrequent(new int[]{1, 2}, 2)).forEach(System.out::println);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbersAndFrequents = new HashMap<>();
        for (int number : nums) {
            int numberFrequent = numbersAndFrequents.getOrDefault(number, 0);
            numbersAndFrequents.put(number, numberFrequent + 1);
        }

        List<Integer>[] kyesListArray = new ArrayList[nums.length + 1];
        for (Integer key : numbersAndFrequents.keySet()) {
            int numberFrequent = numbersAndFrequents.get(key);
                 if (kyesListArray[numberFrequent] == null) {
                     kyesListArray[numberFrequent] = new ArrayList<>();
            }
            kyesListArray[numberFrequent].add(key);
        }

        int[] resultArray = new int[k];
        int indexOfResultElement = 0;

        for (int i = kyesListArray.length - 1; i > 0; i--) {
            List<Integer> keysList = kyesListArray[i];
            if (keysList != null) {
                for (Integer key : keysList) {
                    resultArray[indexOfResultElement] = key;
                    indexOfResultElement++;
                    if (indexOfResultElement == k) {
                        return resultArray;
                    }
                }
            }
        }
        return resultArray;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/top-k-frequent-elements/description/";
    }

    @Override
    public void getMySolution() {
        //Time complexity O(nlogn)
        //Size complexity O(n)
//        HashMap<Integer, Integer> numbersAndTheirCounts = new HashMap<>();
//        for (int number : nums) {
//            int countOfNumber = numbersAndTheirCounts.getOrDefault(number, 0);
//            numbersAndTheirCounts.put(number, countOfNumber + 1);
//        }
//
//        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(numbersAndTheirCounts.entrySet());
//        entryList.sort(Map.Entry.comparingByValue());
//
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = entryList.get(entryList.size() - 1 - i).getKey();
//        }
//        return result;

            //The same, but using PriorityQueue
//        HashMap<Integer, Integer> numbersAndTheirCounts = new HashMap<>();
//        for (int number : nums) {
//            int countOfNumber = numbersAndTheirCounts.getOrDefault(number, 0);
//            numbersAndTheirCounts.put(number, countOfNumber + 1);
//        }
//        PriorityQueue<Integer> sortedKeysOfMap = new PriorityQueue<>((key1, key2) -> numbersAndTheirCounts.get(key2) - numbersAndTheirCounts.get(key1));
//        sortedKeysOfMap.addAll(numbersAndTheirCounts.keySet());
//
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = sortedKeysOfMap.poll();
//        }
//        return result;

//
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int n: nums){
//            map.put(n, map.getOrDefault(n,0)+1);
//        }
    }

    @Override
    public void getOptimizeSolution() {
        //The explanation of the solution is here https://leetcode.com/problems/top-k-frequent-elements/solutions/4543452/simple-solution-bucket-sort-o-n-time-java/
        // corner case: if there is only one number in nums, we need the bucket has index 1.
//      Map<Integer, Integer> charAndCounts = new HashMap<>();
//        for (int num : nums) {
//            int countOfChar = charAndCounts.getOrDefault(num, 0);
//            charAndCounts.put(num, countOfChar + 1);
//        }
//
//        List<Integer>[] arrayOfKeyLists = new ArrayList[nums.length + 1];
//        for (int number : charAndCounts.keySet()) {
//            int freq = charAndCounts.get(number);
//            if (arrayOfKeyLists[freq] == null) {
//                arrayOfKeyLists[freq] = new ArrayList<>();
//            }
//            arrayOfKeyLists[freq].add(number);
//        }
//
//        int[] result = new int[k];
//        for (int i = arrayOfKeyLists.length - 1; i > 0 && k > 0 ; i--) {
//            List<Integer> keysList = arrayOfKeyLists[i];
//            if (keysList != null) {
//                for (int key : keysList) {
//                    result[--k] = key;
//                }
//            }
//        }
//        return result;
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
