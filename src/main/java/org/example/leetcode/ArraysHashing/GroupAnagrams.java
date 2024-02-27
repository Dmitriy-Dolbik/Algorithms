package org.example.leetcode.ArraysHashing;

import org.example.leetcode.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams implements Task {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            String countsOfCharacters = String.valueOf(getCountsOfCharacters(str));
            anagramGroups.computeIfAbsent(countsOfCharacters, ignore -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    private char[] getCountsOfCharacters(String str) {
        char[] countsOfCharactersArray = new char[26];
        for (char currentCharacter : str.toCharArray()) {
            int indexOfCharacterCount = currentCharacter - 'a';
            countsOfCharactersArray[indexOfCharacterCount]++;
        }
        return countsOfCharactersArray;
    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] str1AsCharArray = str1.toCharArray();
        char[] str2AsCharArray = str2.toCharArray();

        Arrays.sort(str1AsCharArray);
        Arrays.sort(str2AsCharArray);

        return Arrays.equals(str1AsCharArray, str2AsCharArray);
    }

    @Override
    public String getLink() {
        return null;
    }

    @Override
    public void getMySolution() {
        //Time complexity m*O(nlogn)
        // m - count of our strings
        // O(nlogn) - complexity of the one string sorting
        // n - average length of each string in our string array

//        List<List<String>> anagramGroups = new ArrayList<>();
//        for (String currentString : strs) {
//            boolean foundGroup = false;
//            for (List<String> anagramGroup : anagramGroups) {
//                if (isAnagram(currentString, anagramGroup.get(0))) {
//                    anagramGroup.add(currentString);
//                    foundGroup = true;
//                    break;
//                }
//            }
//            if (!foundGroup) {
//                List<String> anagrams = new ArrayList<>();
//                anagrams.add(currentString);
//                anagramGroups.add(anagrams);
//            }
//
//        }
//        return anagramGroups;
    }

    @Override
    public void getOptimizeSolution() {
//        public List<List<String>> groupAnagrams(String[] strs) {
//            Map<String, List<String>> anagramGroups = new HashMap<>();
//            for (String str : strs) {
//                String countsOfCharacters = String.valueOf(getCountsOfCharacters(str));
//                anagramGroups.computeIfAbsent(countsOfCharacters, ignore -> new ArrayList<>()).add(str);
//            }
//            return new ArrayList<>(anagramGroups.values());
//        }
//
//        private char[] getCountsOfCharacters(String str) {
//            char[] countsOfCharactersArray = new char[26];
//            for (char currentCharacter : str.toCharArray()) {
//                int indexOfCharacterCount = currentCharacter - 'a';
//                countsOfCharactersArray[indexOfCharacterCount]++;
//            }
//            return countsOfCharactersArray;
//        }
    }

    @Override
    public String getTimeComplexity() {
        //m - count of our strings
        //n - average length of words
        return "O(m * n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(m * n)";
    }
}
