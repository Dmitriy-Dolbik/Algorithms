package org.example.leetcode.Easy;

import org.example.leetcode.Task;

public class ValidPalindrome implements Task {

    public static boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            char leftChar = s.charAt(leftIndex);
            char rightChar = s.charAt(rightIndex);

            if (!Character.isLetterOrDigit(leftChar)) {
                leftIndex++;
                continue;
            }

            if (!Character.isLetterOrDigit(rightChar)) {
                rightIndex--;
                continue;
            }

            leftChar = toLowerCaseIfLetter(leftChar);
            rightChar = toLowerCaseIfLetter(rightChar);

            if (leftChar != rightChar) return false;

            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    private static char toLowerCaseIfLetter(char character) {
        if (Character.isLetter(character)) {
            return Character.toLowerCase(character);
        }
        return character;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-palindrome/description/";
    }

    @Override
    public void getMySolution() {
//        char[] charArray = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] != charArray[charArray.length - 1 - i]) {
//                return false;
//            }
//        }
//        return true;
    }

    @Override
    public void getOptimizeSolution() {
//        int leftIndex = 0;
//        int rightIndex = s.length() - 1;
//
//        while (leftIndex < rightIndex) {
//            char leftChar = s.charAt(leftIndex);
//            char rightChar = s.charAt(rightIndex);
//
//            if (!Character.isLetterOrDigit(leftChar)) {
//                leftIndex++;
//                continue;
//            }
//
//            if (!Character.isLetterOrDigit(rightChar)) {
//                rightIndex--;
//                continue;
//            }
//
//            leftChar = toLowerCaseIfLetter(leftChar);
//            rightChar = toLowerCaseIfLetter(rightChar);
//
//            if (leftChar != rightChar) return false;
//
//            leftIndex++;
//            rightIndex--;
//        }
//        return true;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)"; //поскольку мы не используем дополнительной структуры данных
    }                  //только два указателя
}
