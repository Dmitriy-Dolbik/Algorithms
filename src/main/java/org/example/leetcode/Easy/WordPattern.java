package org.example.leetcode.Easy;

import org.example.leetcode.Task;

import java.util.HashMap;
import java.util.Map;

public class WordPattern implements Task {

    public boolean wordPattern(String pattern, String s) {
        char[] charArray = pattern.toCharArray();
        String[] wordArray = s.split(" ");
        if (charArray.length != wordArray.length) {
            return false;
        }

        Map<String, Character> wordCharMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (wordCharMap.containsKey(wordArray[i])) {
                if (wordCharMap.get(wordArray[i]) != charArray[i]) {
                    return false;
                }
            } else if (wordCharMap.containsValue(charArray[i])) {
                return false;
            }
            wordCharMap.put(wordArray[i], charArray[i]);
        }
        return true;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/word-pattern/description/";
    }

    @Override
    public void getMySolution() {
//        public boolean wordPattern(String pattern, String s) {
//            if (s == null || s.equals(" ")) {
//                return false;
//            }
//
//            char[] charArray = pattern.toCharArray();
//            String[] wordArray = s.split(" ");
//            if (charArray.length != wordArray.length) {
//                return false;
//            }
//
//            Map<String, Character> wordCharMap = new HashMap<>();
//            for (int i = 0; i < charArray.length; i++) {
//                wordCharMap.put(wordArray[i], charArray[i]);
//            }
//
//            if (wordCharMap.size() != new HashSet(wordCharMap.values()).size()) {
//                return false;
//            }
//
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < charArray.length; i++) {
//                stringBuilder.append(wordCharMap.get(wordArray[i]));
//            }
//            return stringBuilder.toString().equals(pattern);
//        }
    }

    @Override
    public void getOptimizeSolution() {
//        public boolean wordPattern(String pattern, String s) {
//            char[] charArray = pattern.toCharArray();
//            String[] wordArray = s.split(" ");
//            if (charArray.length != wordArray.length) {
//                return false;
//            }
//
//            Map<String, Character> wordCharMap = new HashMap<>();
//            for (int i = 0; i < charArray.length; i++) {
//                if (wordCharMap.containsKey(wordArray[i])) {
//                    if (wordCharMap.get(wordArray[i]) != charArray[i]) {
//                        return false;
//                    }
//                } else if (wordCharMap.containsValue(charArray[i])) {
//                    return false;
//                }
//                wordCharMap.put(wordArray[i], charArray[i]);
//            }
//            return true;
//        }
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
