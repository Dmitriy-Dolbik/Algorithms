package org.example.yandex.interview;

import org.example.leetcode.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * Дана строка, найдите длину самой длинной подстроки без повторяющихся символов
 * Вход: abcabcbb
 * Выход: 3 (длина abs = 3)
 *
 * Суть решения:
 * 1. Заводим hashSet, чтобы хранить последовательность символов
 * 2. Переменную maxLength для хранения максимальной длины последлвательности
 * 3. Переменную subqueryStartIndex для хранения индекса начала последовательности
 * 4. Начинаем идти по каждому символу исходной строки и добавлять символы в set, если такого элемента там еще нет
 * 5. Если такой элемент там уже есть, то удаляем элементы, начиная слева, чтобы в сет остались только уникальные элементы
 * 6. При этом увеличиваем subqueryStartIndex
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstringDeterminer implements Task {

    public static void main(String[] args) {
        String string = "dvdf";
        System.out.println(new LengthOfLongestSubstringDeterminer().find(string));
    }

//    public int find(String string) {
//        Map<Character, Integer> charIndexMap = new HashMap<>();
//        int maxLength = 0;
//        int indexOfSubstringStart = 0;
//        for (int indexOfSubstringEnd = 0; indexOfSubstringEnd < string.length(); indexOfSubstringEnd++) {
//            char currentChar = string.charAt(indexOfSubstringEnd);
//            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= indexOfSubstringStart) {
//                indexOfSubstringStart = charIndexMap.get(currentChar) + 1;
//            }
//            charIndexMap.put(currentChar, indexOfSubstringEnd);
//            int currentSubstringLength = indexOfSubstringEnd - indexOfSubstringStart + 1;
//            maxLength = Math.max(maxLength, currentSubstringLength);
//        }
//        return maxLength;
//    }

    public int find(String string) {
        Map<Character, Integer> characterIndexesMap = new HashMap<>();
        int maxLength = 0;
        int indexOfSubstringStart = 0;

        for (int indexOfSubstringEnd = 0; indexOfSubstringEnd < string.length(); indexOfSubstringEnd++) {
            char currentChar = string.charAt(indexOfSubstringEnd);
            //если такой элемент уже есть в мапе и его индекс больше, чем текущий индекс начала подстроки
            //, то индекс начала полстроки нужно сдвинуть на 1 вправо, чтобы элемент, который уже есть в мапе не учитывался в подстроке
            if (characterIndexesMap.containsKey(currentChar) && characterIndexesMap.get(currentChar) >= indexOfSubstringStart) {
                indexOfSubstringStart = characterIndexesMap.get(currentChar) + 1;
            }
            characterIndexesMap.put(currentChar, indexOfSubstringEnd);
            int currentSubstringLength = indexOfSubstringEnd - indexOfSubstringStart + 1;
            maxLength = Math.max(maxLength, currentSubstringLength);
        }

        return maxLength;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/longest-substring-without-repeating-characters/";
    }

    @Override
    public void getMySolution() {
        //Другое решение через Мапу
//        Map<Character, Integer> charIndexMap = new HashMap<>();
//        int maxLength = 0;
//        int indexOfSubstringStart = 0;
//        for (int indexOfSubstringEnd = 0; indexOfSubstringEnd < string.length(); indexOfSubstringEnd++) {
//            char currentChar = string.charAt(indexOfSubstringEnd);
//            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= indexOfSubstringStart) {
//                indexOfSubstringStart = charIndexMap.get(currentChar) + 1;
//            }
//            charIndexMap.put(currentChar, indexOfSubstringEnd);
//            int currentSubstringLength = indexOfSubstringEnd - indexOfSubstringStart + 1;
//            maxLength = Math.max(maxLength, currentSubstringLength);
//        }
//        return maxLength;
    }

    @Override
    public void getOptimizeSolution() {
//        int maxLength = 0;
//        Set<Character> charSet = new HashSet<>();
//        int indexOfSubstringStart = 0;
//
//        for (int indexOfSubstringEnd = 0; indexOfSubstringEnd < string.length(); indexOfSubstringEnd++) {
//            char currentChar = string.charAt(indexOfSubstringEnd);
//            if (!charSet.contains(currentChar)) {
//                charSet.add(currentChar);
//                int currentSubstringLength = indexOfSubstringEnd - indexOfSubstringStart + 1;
//                maxLength = Math.max(maxLength, currentSubstringLength);
//            } else {
//                //будем удалять элеиенты с начала подстроки до тех пор, пока там не останутся только те
//                //символы, которые не равны текущему элементу
//                while (charSet.contains(currentChar)) {
//                    charSet.remove(string.charAt(indexOfSubstringStart));
//                    indexOfSubstringStart++;
//                }
//                charSet.add(currentChar);
//            }
//        }
//        return maxLength;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }

//    public int find(String s) {
//        int maxLength = 0;
//        Set<Character> hashSet = new HashSet<>();
//        int indexOfSubqueryStart = 0;
//
//        for (int indexOfSubqueryEnd = 0; indexOfSubqueryEnd < s.length(); indexOfSubqueryEnd++) {
//            char currentCharacter = s.charAt(indexOfSubqueryEnd);
//            if (!hashSet.contains(currentCharacter)) {
//                hashSet.add(currentCharacter);
//                int lengthOfCurrentSubstring = indexOfSubqueryEnd - indexOfSubqueryStart + 1;
//                maxLength = Math.max(maxLength, lengthOfCurrentSubstring);
//            } else {
//                while (hashSet.contains(currentCharacter)) {
//                    hashSet.remove(s.charAt(indexOfSubqueryStart));
//                    indexOfSubqueryStart++;
//                }
//                hashSet.add(currentCharacter);
//            }
//        }
//        return maxLength;
//    }
}
