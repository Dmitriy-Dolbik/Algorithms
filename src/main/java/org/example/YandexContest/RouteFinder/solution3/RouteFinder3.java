package org.example.YandexContest.RouteFinder.solution3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Источник
 * https://www.youtube.com/watch?v=pyDS_sTSsFo&t=547s
 */
public class RouteFinder3 {
    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;
    public static final String INPUT_FILE = "input.txt";
    public static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws IOException {
        init();
        run();
        close();
    }

    private static void run() throws IOException {
        int citiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        Graph graph = new Graph();
        for (int i = 0; i < citiesCount; i++) {
            String[] cityXY = bufferedReader.readLine().trim().split(" ");
            int x = Integer.parseInt(cityXY[0]);
            int y = Integer.parseInt(cityXY[1]);
            graph.addCity(new City(x, y));
        }

        int maxDistance = Integer.parseInt(bufferedReader.readLine().trim());
        String[] fromCityToCityIndexes = bufferedReader.readLine().trim().split(" ");
        int fromCityIndex = Integer.parseInt(fromCityToCityIndexes[0]);
        int toCityIndex = Integer.parseInt(fromCityToCityIndexes[1]);

        if (fromCityIndex == toCityIndex) {
            bufferedWriter.write(String.valueOf(-1));
        }

        int countOfRoads = graph.passInWidth(fromCityIndex, toCityIndex, maxDistance);

        bufferedWriter.write(String.valueOf(countOfRoads));


    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
        bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }
}
