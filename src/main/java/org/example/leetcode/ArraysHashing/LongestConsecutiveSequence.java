package org.example.leetcode.ArraysHashing;

import org.example.leetcode.Task;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence implements Task {
    public static void main(String[] args) {
//        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
//        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//        System.out.println(longestConsecutive(new int[]{0,-1}));
//        System.out.println(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
        System.out.println(longestConsecutive(new int[]{0}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestConsecutiveSequenceSize = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int nextNumber = num + 1;
                while (set.contains(nextNumber)) {
                    nextNumber += 1;
                }
                int lengthOfCurrentSequence = nextNumber - num;
                if (longestConsecutiveSequenceSize < lengthOfCurrentSequence) {
                    longestConsecutiveSequenceSize = lengthOfCurrentSequence;
                }
            }
        }
        return longestConsecutiveSequenceSize;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/longest-consecutive-sequence/description/";
    }

    @Override
    public void getMySolution() {
        //После подсказки
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int longestConsecutiveSequenceSize = 1;
//        for (int num : set) {
//            if (!set.contains(num - 1)) {
//                int currentConsecutiveSequenceSize = 1;
//                for (int i = 1; i < nums.length; i++) {
//                    int nextValue = num + i;
//                    if (set.contains(nextValue)) {
//                        currentConsecutiveSequenceSize += 1;
//                        if (longestConsecutiveSequenceSize < currentConsecutiveSequenceSize) {
//                            longestConsecutiveSequenceSize = currentConsecutiveSequenceSize;
//                        }
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        return longestConsecutiveSequenceSize;
    }

    @Override
    public void getOptimizeSolution() {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        int longestConsecutiveSequenceSize = 0;
//        for (int num : set) {
//            if (!set.contains(num - 1)) {
//                int nextNumber = num + 1;
//                while (set.contains(nextNumber)) {
//                    nextNumber += 1;
//                }
//                int lengthOfCurrentSequence = nextNumber - num;
//                if (longestConsecutiveSequenceSize < lengthOfCurrentSequence) {
//                    longestConsecutiveSequenceSize = lengthOfCurrentSequence;
//                }
//            }
//        }
//        return longestConsecutiveSequenceSize;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)"; //n - размер входного массива
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
