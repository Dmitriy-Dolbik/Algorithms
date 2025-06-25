package org.example.YandexContest.TrialTasks;

import org.example.leetcode.Task;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class D_two_chips implements Task {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = readInt(br);
            List<Integer> numbers = readIntegerList(br);
            int k = readInt(br);
            String result = findChips(numbers, k);
            bw.write(result);
        } catch (IOException exception) {
            System.out.print("Something with wrong: " + exception.getMessage());
        }
    }

    private static String findChips(List<Integer> numbers, int k) {
        Set<Integer> set = new HashSet<>(numbers);
        for (Integer number : set) {
            int secondNumber = k - number;
            if (secondNumber != number && set.contains(secondNumber)) {
                return number + " " + secondNumber;
            }
        }
        return "None";
    }

    private static int readInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static List<Integer> readIntegerList(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public String getLink() {
        return "https://contest.yandex.ru/contest/26365/problems/D/?success=139456650#51450/2021_01_19/3I9jnwYAEg";
    }

    @Override
    public void getMySolution() {
//        Set<Integer> set = new HashSet<>(numbers);
//        for (Integer number : set) {
//            int secondNumber = k - number;
//            if (secondNumber != number && set.contains(secondNumber)) {
//                return number + " " + secondNumber;
//            }
//        }
//        return "None";
    }

    @Override
    public void getOptimizeSolution() {
        //The same as my solution
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";//I think so
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";//I think so
    }
}
