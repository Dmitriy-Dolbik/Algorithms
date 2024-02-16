package org.example.YandexContest.RouteFinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RouteFinder2 {
    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;
    public static final String INPUT_FILE = "input.txt";
    public static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws IOException{
        init();
        run();
        close();
    }

    private static void run()  throws IOException{
        int countOfCities = Integer.parseInt(bufferedReader.readLine().trim());
        if (countOfCities < 2) {
            bufferedWriter.write(String.valueOf(-1));
            return;
        }

        int[][] citiesWithXY = new int[countOfCities + 1][2];
        for (int i = 1; i <= countOfCities; i++) {
            String xyLine = bufferedReader.readLine();
            String[] xy = xyLine.split(" ");
            citiesWithXY[i][0] = Integer.parseInt(xy[0]);
            citiesWithXY[i][1] = Integer.parseInt(xy[1]);
        }
        int maxDistance = Integer.parseInt(bufferedReader.readLine());
        String[] fromAndToCities = bufferedReader.readLine().trim().split(" ");
        int fromCity = Integer.parseInt(fromAndToCities[0]);
        int toCity = Integer.parseInt(fromAndToCities[1]);

        if (fromCity == toCity) {
            bufferedWriter.write(String.valueOf(0));
        }

        bufferedWriter.write(String.valueOf(bfs(fromCity, toCity, countOfCities, citiesWithXY, maxDistance)).trim());
    }

    private static int bfs(int fromCity, int toCity, int countOfCities, int[][] citiesWithXY, int maxDistance) {
        Set<Integer> visitedCities = new HashSet<>();
        Queue<int[]> citiesAndCountOfRoads = new LinkedList<>();
        citiesAndCountOfRoads.add(new int[]{fromCity, 0});
        visitedCities.add(fromCity);

        while(!citiesAndCountOfRoads.isEmpty()) {
            int[] cityAndCountOfRoads = citiesAndCountOfRoads.poll();
            int currentCity = cityAndCountOfRoads[0];
            int countOfRoadsToCurrentCity = cityAndCountOfRoads[1];

            if (currentCity == toCity) {
                return countOfRoadsToCurrentCity;
            }

            for (int i = 1; i <= countOfCities; i++) {
                if (!visitedCities.contains(i) && getDistance(citiesWithXY[currentCity], citiesWithXY[i]) <= maxDistance) {
                    citiesAndCountOfRoads.add(new int[]{i, countOfRoadsToCurrentCity + 1});
                    visitedCities.add(i);
                }
            }
        }
        return -1;
    }

    private static int getDistance(int[] fromCityXY, int[] toCityXY) {
        int fromX = fromCityXY[0];
        int toX = toCityXY[0];
        int fromY = fromCityXY[1];
        int toY = toCityXY[1];

        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }

    private static void init()  throws IOException{
        bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
        bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));
    }

    private static void close() throws IOException {
        bufferedReader.close();
        bufferedWriter.close();
    }

}