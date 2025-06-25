package org.example.YandexContest.TrialTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C_moving_average {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = readInt(br);
            List<Integer> listOfNumbers = readList(br);
            int k = readInt(br);
            String result = movingAverage(n, listOfNumbers, k);
            bw.write(result);
        } catch (Exception exception) {
            System.out.println("Something went wrong: " + exception.getMessage());
        }
    }

    private static String movingAverage(int n, List<Integer> listOfNumbers, int k) {
        List<Double> result = new ArrayList<>(n - k + 1);
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += listOfNumbers.get(i);
        }
        result.add(sum / k);
        for (int i = 0; i < n - k; i++) {
            sum -= listOfNumbers.get(i);
            sum += listOfNumbers.get(i + k);
            result.add(sum / k);
        }
        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static List<Integer> readList(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
